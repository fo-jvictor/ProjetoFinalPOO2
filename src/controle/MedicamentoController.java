package controle;

import dao.MedicamentoDAO;
import model.Medicamento;
import visao.JanelaPrincipal;

public class MedicamentoController {

	private MedicamentoDAO medicamentoDAO;
	private JanelaPrincipal janelaPrincipal;
	
	public MedicamentoController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;
		medicamentoDAO = new MedicamentoDAO();
		//ADD OS LISTENERS PROS BOTOES DOS PANELS E INSTANCIAR ELES AQUI
	}
	
	public void cadastraMedicamento()
	{
		String codigoBarra;
		String nome;
		int alergia;
		Medicamento medicamento = new Medicamento(codigoBarra,nome,alergia);
		medicamentoDAO.cadastraMedicamento(medicamento);
	}
	
	
	
}
