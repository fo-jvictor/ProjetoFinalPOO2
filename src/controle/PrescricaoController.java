package controle;

import dao.MedicamentoDAO;
import dao.PacienteDAO;
import model.Paciente;
import visao.JanelaPrincipal;

public class PrescricaoController {
	
	private JanelaPrincipal janelaPrincipal;
	private PacienteDAO pacienteDAO;
	private MedicamentoDAO medicamentoDAO;
	
	public PrescricaoController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;		
		//ADD OS LISTENERS PROS BOTOES DOS PANELS E INSTANCIAR ELES AQUI
		pacienteDAO = new PacienteDAO();
		medicamentoDAO = new MedicamentoDAO();
	}
	
	public void consultaPaciente()
	{
		int cpf; //pega dos fields na tela;
		Paciente paciente = new Paciente(cpf, null, null, 0, 0);
		pacienteDAO.consultaPaciente(paciente);
		
		//set Nome do paciente que agora voltou populado do banco de dados no FIELD nome;
		//set DataNascimento do paciente no field Data Nasc;
		
	}


}
