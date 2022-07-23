package controle;

import java.util.Date;

import dao.PacienteDAO;
import model.Paciente;
import visao.JanelaPrincipal;

public class PacienteController implements ActionListener {

	private PacienteDAO pacienteDAO;
	private JanelaPrincipal janelaPrincipal;
	//manda os dados dessa classe para PacienteDAO
	
	public PacienteController(JanelaPrincipal janelaPrincipal)
	{
		//provavelmente vou precisar acessar a janelaPrincipal para acessar o Panel referente ao cadastro
		//de paciente. Então através dos getters dos campos do Panel de cadastro de Paciente eu pego os dados
		//insiro eles em variaveis e declaro um novo objeto de paciente, passando para o PacienteDAO realizar
		//as operações de persistencia no banco de dados;		
		this.janelaPrincipal=janelaPrincipal;
		//ADD OS LISTENERS PROS BOTOES DOS PANELS E INSTANCIAR ELES AQUI
		pacienteDAO = new PacienteDAO();		
	}
	
	public void cadastraPaciente()
	{
		int cpf;
		String nome;
		Date dataNascimento; //USAR O PARSE DE DATAS QUE TEM NO MEU GITHUB
		int alergia;
		int unidade;
		Paciente paciente = new Paciente(cpf,nome,dataNascimento,alergia,unidade);
		pacienteDAO.cadastraPaciente(paciente);	
	}
	
	//REMOVE PACIENTE ? 
	public void altaPaciente()
	{
		int cpf;
		Paciente paciente = new Paciente(cpf,null,null,null,null);
		//chama metodo de consulta para efetuar a exclusão do paciente do banco
		//consulta é implementada na classe DAO		
		pacienteDAO.altaPaciente(paciente);
	}
	
	
	
	
	
}
