package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.Paciente;

public class PacienteDAO {

	private static Connection con;

	public PacienteDAO() {
	}

	// metodos crud
	// recebe os dados da classe controller

	public static boolean cadastraPaciente(Paciente paciente) {

		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if (con != null) {
			String sql = "insert into Paciente (cpf,nome,dataNascimento,alergia,unidade) values (?,?,?,?,?)";
			PreparedStatement prepS;

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				//String data = sdf.format(paciente.getDataNascimento());
				prepS = con.prepareStatement(sql);
				prepS.setString(1, paciente.getCpf());
				prepS.setString(2, paciente.getNome());				
				prepS.setDate(3, new java.sql.Date(paciente.getDataNascimento().getTime()));
				prepS.setInt(4, paciente.getAlergia());
				// alterar metodo getAlergia
				// prepS.setInt(4, paciente.getAlergia());
				prepS.setInt(5, paciente.getUnidade());

				// coloquei unidade como inteiro p depois fazer uma verificação, com base no
				// numero de 1 a 3 corresponde
				// a uma unidade diferente. Exemplo: 1 para ambulatorio, 2 para emergencia e 3
				// para UTI.

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
			}

		}
		return false;
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

	public static boolean consultaPaciente(Paciente paciente) {
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		// nome,datanascimento,alergia e unidade
		String nome = null;
		Date dataNascimento = null;
		int alergia = 0;
		int unidade = 0;

		String sql = "select * from Paciente where cpf like ?";

		PreparedStatement prepS;

		try {
			prepS = con.prepareStatement(sql);
			prepS.setString(1, paciente.getCpf());
			ResultSet resultSet = prepS.executeQuery();

			while (resultSet.next()) {

				nome = resultSet.getString(2);
				dataNascimento = resultSet.getDate(3);
				alergia = resultSet.getInt(4);
				unidade = resultSet.getInt(5);
			}
			
			paciente.setNome(nome);
			paciente.setDataNascimento(dataNascimento);
			paciente.setAlergia(alergia);
			paciente.setUnidade(unidade);
			//TESTAR PQ ISSO AQUI PODE RETORNAR VALORES NULL OU 0 CASO O while(resultSet.next()) NÃO FOR TRUE
			con.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
