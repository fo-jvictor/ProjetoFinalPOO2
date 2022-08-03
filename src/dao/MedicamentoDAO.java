package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Medicamento;

public class MedicamentoDAO {
	
	private static Connection con;

	public MedicamentoDAO() {
		
	}
	
	public boolean cadastraMedicamento(Medicamento medicamento)
	{
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();

		if(con!=null)
		{
			String sql = "insert into Medicamento (codigobarra,nome,alergia) values (?,?,?)";
			PreparedStatement prepS;

			try {				
				prepS = con.prepareStatement(sql);
				prepS.setString(1, medicamento.getCodigoBarra());
				prepS.setString(2, medicamento.getNome());
				prepS.setInt(3, medicamento.getAlergia());
				
				int result = prepS.executeUpdate();
				
				if (result==1)
				{
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Medicamento cadastrado com sucesso!");
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
	
	public boolean consultaMedicamento(Medicamento medicamento)
	{
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();
		
		String nome = null;
		int alergia = 0;
		
		if(con!=null)
		{
			String sql = "select * from Medicamento where codigobarra like ?";
			PreparedStatement prepS;
			
			try {
				prepS = con.prepareStatement(sql);
				prepS.setString(1, medicamento.getCodigoBarra());
				ResultSet resultSet = prepS.executeQuery();
				
				while(resultSet.next())
				{
					nome = resultSet.getString(2);
					alergia = resultSet.getInt(3);					
				}
				
				medicamento.setNome(nome);
				medicamento.setAlergia(alergia);
				con.close();
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}			
			
		}
		
		return false;
	}
	
	public boolean atualizaMedicamento(Medicamento medicamento)
	{
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();
		
		if(con!=null)
		{
			String sql = "update Medicamento set codigobarra = ?, nome = ?, alergia = ?";
			PreparedStatement prepS;
			
			try {
				prepS = con.prepareStatement(sql);
				prepS.setString(1, medicamento.getCodigoBarra());
				prepS.setString(2, medicamento.getNome());
				prepS.setInt(3, medicamento.getAlergia());
				int result = prepS.executeUpdate();
				
				if(result==1)
				{
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
			}

		}
		
		return false;		
	}
	
	public boolean removeMedicamento(Medicamento medicamento)
	{
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();
		
		if (con!=null)
		{
			String sql = "delete from Medicamento where codigobarra like ?";
			PreparedStatement prepS;
			
			try {
				prepS = con.prepareStatement(sql);
				prepS.setString(1, medicamento.getCodigoBarra());
				int result = prepS.executeUpdate();
				
				if (result==1)
				{
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

}
