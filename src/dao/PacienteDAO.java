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
	// private List<Paciente> pacientes = new ArrayList<>();

	public PacienteDAO() {
	}

	public static boolean cadastraPaciente(Paciente paciente) {

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

				byte[] bytes = serialize(paciente.getAlergias());
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

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return true;
	}

	public static void altaPaciente(String cpf) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {

			String sql = "delete from Paciente where cpf = ? ";

			PreparedStatement prepS;

			try {

				prepS = con.prepareStatement(sql);
				prepS.setString(1, cpf);
				int result = prepS.executeUpdate();

				if (result > 0) {
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Paciente recebeu alta com sucesso!");
				}
				ClasseConexaoMySQL.fecharConexao();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static Paciente consultaPaciente(String cpf) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		String sql = "select * from Paciente where cpf like ?";

		PreparedStatement prepS;

		try {
			prepS = con.prepareStatement(sql);
			prepS.setString(1, cpf);
			ResultSet resultSet = prepS.executeQuery();

			while (resultSet.next()) {

				String nome = resultSet.getString(2);
				Date dataNascimento = resultSet.getDate(3);
				List<String> alergias = deserialize(resultSet.getBytes(4));

				String unidade = resultSet.getString(5);
				return new Paciente(cpf, nome, dataNascimento, alergias, unidade);

			}

			con.close();
//			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// ARRUMAR ISSO AQUIII
		return null;

	}

	public List<Paciente> consultaTodosPacientes() {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();
		List<Paciente> pacientes = new ArrayList<>();

		if (con != null) {
			String sql = "select * from Paciente";
			PreparedStatement prepS;

			try {
				prepS = con.prepareStatement(sql);
				ResultSet resultSet = prepS.executeQuery();

				while (resultSet.next()) {

					String cpf = resultSet.getString(1);
					String nome = resultSet.getString(2);
					Date datanascimento = resultSet.getDate(3);

					byte[] bytes = resultSet.getBytes(4);
					List<String> alergias = deserialize(bytes);

					String unidade = resultSet.getString(5);
					pacientes.add(new Paciente(cpf, nome, datanascimento, alergias, unidade));
				}
				
				return pacientes;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return List.of();

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
