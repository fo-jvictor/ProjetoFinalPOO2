package dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Paciente;

public class PacienteDAO {

	private static Connection con;
	//private List<Paciente> pacientes = new ArrayList<>();

	public PacienteDAO() {
	}

	public static boolean cadastraPaciente(Paciente paciente) throws IOException {

		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "insert into Paciente (cpf,nome,dataNascimento,alergia,unidade) values (?,?,?,?,?)";
			PreparedStatement prepS;

			try {				
				prepS = con.prepareStatement(sql);
				prepS.setString(1, paciente.getCpf());
				prepS.setString(2, paciente.getNome());				
				prepS.setDate(3, new java.sql.Date(paciente.getDataNascimento().getTime()));
				byte[] bytes = serialize(paciente.getAlergias());;
				prepS.setBytes(4, bytes);
				prepS.setString(5, paciente.getUnidade());
				
				int result = prepS.executeUpdate();

				if (result == 1) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Paciente cadastrado com sucesso!");
					return true;
				}

				ClasseConexaoMySQL.fecharConexao();
				return false;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch(IOException e) {
				e.printStackTrace();
			}

		}
		return true;
	}

	public static boolean altaPaciente(Paciente paciente) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {

			String sql = "delete from Paciente where cpf = ? ";

			PreparedStatement prepS;

			try {

				prepS = con.prepareStatement(sql);
				prepS.setString(1, paciente.getCpf());
				int result = prepS.executeUpdate();

				if (result > 0) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Paciente recebeu alta com sucesso!");
					return true;
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

	public static Paciente consultaPaciente(String cpf) throws ClassNotFoundException, IOException {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		String sql = "select * from Paciente where cpf like ?";

		PreparedStatement prepS;

		try {
			prepS = con.prepareStatement(sql);
			prepS.setString(1, cpf);
			ResultSet resultSet = prepS.executeQuery();
			//NA HORA DE PRESCREVER UM MEDICAMENTO NA TELA DE PRESCRIÇÃO
			//O RESULTSET.NEXT() É FALSE E NÃO SETTA AS INFOS PRA JOGAR NA TELA DE VOLTA
			//RESULTANDO NUMA EXCEÇÃO PQ A DATA DE NASCIMENTO FICA NULL
			while (resultSet.next()) {
				
				String nome = resultSet.getString(2);
				Date dataNascimento = resultSet.getDate(3);
				byte [] bytes = resultSet.getBytes(4);
				List<String> alergias = deserialize(bytes);
				//
				String unidade = resultSet.getString(5);
				Paciente p = new Paciente(cpf,nome,dataNascimento,alergias,unidade);
				return p;
				
			}
			
			con.close();
//			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ARRUMAR ISSO AQUIII
		return null;

	}
	
	public boolean consultaTodosPacientes() throws ClassNotFoundException, IOException
	{
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();
		
		
		if (con!=null)
		{
			String sql = "select * from Paciente";
			PreparedStatement prepS;
			
			try {
				prepS = con.prepareStatement(sql);
				ResultSet resultSet = prepS.executeQuery();
				
				while(resultSet.next())
				{

					String cpf=null;
					String nome = resultSet.getString(2);
					Date datanascimento = resultSet.getDate(3);
					
					byte [] bytes = resultSet.getBytes(4);
					List<String> alergias = deserialize(bytes);
					
					String unidade = resultSet.getString(5);
					Paciente paciente = new Paciente(cpf,nome,datanascimento,alergias,unidade);					
				}
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return false;
		
	}	
	
	private static byte[] serialize(List<String> object) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos =  new ObjectOutputStream(bos);
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
