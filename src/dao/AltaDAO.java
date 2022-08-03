package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Alta;

public class AltaDAO {
	
	private static Connection con;

	public AltaDAO()
	{		
	}
	
	public boolean altaPaciente(Alta alta)
	{
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();
		
		if(con!=null)
		{
			String sql = "insert into Alta (cpfpaciente,motivoalta) values (?,?)";
			PreparedStatement prepS;
			
			try {
				prepS = con.prepareStatement(sql);
				prepS.setString(1, alta.getCpfPaciente());
				prepS.setString(2, alta.getMotivoAlta());
				int result = prepS.executeUpdate();
				
				if(result==1)
				{
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("AltaDAO teste");
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

}
