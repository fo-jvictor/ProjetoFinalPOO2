package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClasseConexaoMySQL {

	private static Connection con;
	private static String status;
	
	public ClasseConexaoMySQL()
	{		
	}
	
	public static Connection abrirConexaoMySQL()
	{
		
		//mudar as informacoes de acordo com a configuração local do mySQL
		String servidor="localhost";
		String banco="projetofinalPOO";
		String usuario="root";
		String senha="Password12";
		String url="jdbc:mysql://"+servidor+":3306/"+banco;
		//jdbc:mysql://localhost:3306/db
		
		try {
			con=DriverManager.getConnection(url,usuario,senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return con;
		}
		
		if(con != null)
			
			status="STATUS--> Conexão com o banco realizada com sucesso!";
		else
			status="STATUS--> Falha na conexão com o banco!";
		
		return con;
		
	}
	
	public static void obterStatusConexao()
	{
		System.out.println(status);
	}
	
	public static void fecharConexao()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ClasseConexaoMySQL.con = con;
	}

	public static void main(String[] args) {
		
		ClasseConexaoMySQL.abrirConexaoMySQL();
		ClasseConexaoMySQL.obterStatusConexao();	
	}
	
}
