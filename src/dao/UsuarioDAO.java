package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	public UsuarioDAO() {
		
	}
	
	public boolean autenticar(Usuario u)
	{
		PreparedStatement prepS;
		ResultSet res;
		Connection con= ClasseConexaoMySQL.abrirConexaoMySQL();
		
		String sql="select * from usuario where usuario like ? and senha like ?";
		
		try {
			prepS=con.prepareStatement(sql);
			prepS.setString(1, u.getUsuario());
			prepS.setString(2, u.getSenha());
			
			res=prepS.executeQuery();
			
			while(res.next())
			{
				return true;
			}
			
			return false;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ClasseConexaoMySQL.fecharConexao();
			return false;
		}
		finally {
			ClasseConexaoMySQL.fecharConexao();
		}		
				
	}

}
