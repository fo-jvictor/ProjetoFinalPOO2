package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.PrescricaoMedicamento;

public class PrescricaoMedicamentoDAO {
	
	private Connection con;

	public PrescricaoMedicamentoDAO() {
		
	}

	public boolean cadastraPrescricao(PrescricaoMedicamento prescricaoM)
	{
		
		ClasseConexaoMySQL.abrirConexaoMySQL();
		con = ClasseConexaoMySQL.getCon();
		
		if (con!=null)
		{
			String sql = "insert into PrescricaoMedicamento (dataprescricao,cpfpaciente,codbarramedicamento) values (?,?,?)";
			PreparedStatement prepS;
			
			try {
				prepS = con.prepareStatement(sql);
				prepS.setDate(1, new java.sql.Date(new Date().getTime()));
				prepS.setString(2, prescricaoM.getCpfpaciente());
				prepS.setString(3, prescricaoM.getCodbarraMedicamento());
				
				int result = prepS.executeUpdate();
				
				if (result==1)
				{
					ClasseConexaoMySQL.fecharConexao();
					System.out.println("Prescricao cadastrada com sucesso!");
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
