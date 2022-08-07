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
				prepS = con.prepareStatement(sql);
				prepS.setString(1, paciente.getCpf());
				prepS.setString(2, paciente.getNome());				
				prepS.setDate(3, new java.sql.Date(paciente.getDataNascimento().getTime()));
				prepS.setString(4, paciente.getAlergia());
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

		String nome = null;
		Date dataNascimento = null;
		String alergia = null;
		String unidade = null;

		String sql = "select * from Paciente where cpf like ?";

		PreparedStatement prepS;

		try {
			prepS = con.prepareStatement(sql);
			prepS.setString(1, paciente.getCpf());
			ResultSet resultSet = prepS.executeQuery();
			//NA HORA DE PRESCREVER UM MEDICAMENTO NA TELA DE PRESCRIÇÃO
			//O RESULTSET.NEXT() É FALSE E NÃO SETTA AS INFOS PRA JOGAR NA TELA DE VOLTA
			//RESULTANDO NUMA EXCEÇÃO PQ A DATA DE NASCIMENTO FICA NULL
			while (resultSet.next()) {

				nome = resultSet.getString(2);
				dataNascimento = resultSet.getDate(3);
				alergia = resultSet.getString(4);
				unidade = resultSet.getString(5);
			}
			
			paciente.setNome(nome);
			paciente.setDataNascimento(dataNascimento);
			paciente.setAlergia(alergia);
			paciente.setUnidade(unidade);
			con.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
