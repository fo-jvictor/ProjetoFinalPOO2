package dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Medicamento;

public class MedicamentoDAO {

	private static Connection con;

	public MedicamentoDAO() {

	}

	public boolean cadastraMedicamento(Medicamento medicamento) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "insert into Medicamento (codigobarra,nome,alergia) values (?,?,?)";
			PreparedStatement prepS;

			try {
				prepS = con.prepareStatement(sql);
				prepS.setString(1, medicamento.getCodigoBarra());
				prepS.setString(2, medicamento.getNome());

				byte[] bytes = serialize(medicamento.getAlergias());

				prepS.setBytes(3, bytes);

				int result = prepS.executeUpdate();

				if (result == 1) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Medicamento cadastrado com sucesso!");
					return true;
				}
				ClasseConexaoMySQL.fecharConexao();
				return false;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public Medicamento consultaMedicamento(String codigoBarra)
	{
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();
		
		if(con!=null)
		{
			String sql = "select * from Medicamento where codigobarra like ?";
			PreparedStatement prepS;
			
			try {
				prepS = con.prepareStatement(sql);
				prepS.setString(1, codigoBarra);
				ResultSet resultSet = prepS.executeQuery();
				
				while(resultSet.next())
				{
					String nome = resultSet.getString(2);					
					List<String> alergias = deserialize(resultSet.getBytes(3));
					return new Medicamento(codigoBarra, nome, alergias);
				}
				
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		return null;
		
	}
	
	public List<Medicamento> consultaMedicamentos() {
		return List.of();
	}

	public boolean atualizaMedicamento(Medicamento medicamento) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "update Medicamento set codigobarra = ?, nome = ?, alergia = ?";
			PreparedStatement prepS;

			try {
				prepS = con.prepareStatement(sql);
				prepS.setString(1, medicamento.getCodigoBarra());
				prepS.setString(2, medicamento.getNome());
				
				prepS.setBytes(3, serialize(medicamento.getAlergias()));
				int result = prepS.executeUpdate();

				if (result == 1) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Medicamento atualizado com sucesso!");
					return true;
				}
				ClasseConexaoMySQL.fecharConexao();
				System.out.println("Falha ao cadastrar medicamento, informe os dados corretos!");
				return false;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return false;
	}

	public boolean removeMedicamento(Medicamento medicamento) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "delete from Medicamento where codigobarra like ?";
			PreparedStatement prepS;

			try {
				prepS = con.prepareStatement(sql);
				prepS.setString(1, medicamento.getCodigoBarra());
				int result = prepS.executeUpdate();

				if (result == 1) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Medicamento removido com sucesso!");
				}

				ClasseConexaoMySQL.fecharConexao();
				return false;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

	private static byte[] serialize(List<String> object) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(object);
		oos.flush();
		return bos.toByteArray();
	}

	private static List<String> deserialize(byte[] bytes) throws ClassNotFoundException, IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (List<String>) ois.readObject();
	}

}
