package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String sql = "insert into Medicamento (codigobara,nome,alergia) values (?,?,?)";
			PreparedStatement prepS;

			try {
				
				prepS = con.prepareStatement(sql);
				prepS.setString(1, medicamento.getCodigoBarra());
				prepS.setString(2, medicamento.getNome());
				prepS.setInt(3, medicamento.getAlergia());
				
				int result = prepS.executeUpdate();
				
				if (result>0)
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

}
