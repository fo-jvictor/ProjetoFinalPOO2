package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		this.janelaPrincipal.getPanelAdmissaoPaciente().getBtnSalvar().addActionListener( this);
		this.janelaPrincipal.getPanelAdmissaoPaciente().getBtnCancelar().addActionListener(this);
		this.janelaPrincipal.getPanelAdmissaoPaciente().getComboBox().addActionListener(this);
		this.janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxDipirona().setActionCommand("Dipirona");
		this.janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxFrutosdoMar().setActionCommand("Frutos do Mar");
		this.janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxGluten().setActionCommand("Gluten");
		this.janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxPenicilina().setActionCommand("Penicilina");
		//falta o Button Group;
		
	}
	
	public void cadastraPaciente()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
		int cpf = Integer.parseInt(this.janelaPrincipal.getPanelAdmissaoPaciente().getTfCPF().getText());
		String nome = this.janelaPrincipal.getPanelAdmissaoPaciente().getTfNome().getText();
		Date dataNascimento = sdf.parse(this.janelaPrincipal.getPanelAdmissaoPaciente().getTfDataNasc().getText());
		String alergia2 = this.janelaPrincipal.getPanelAdmissaoPaciente().getButtonGroup().getSelection().getActionCommand();
		int alergia=0;
		int unidade = this.janelaPrincipal.getPanelAdmissaoPaciente().getComboBox().getSelectedIndex();
		Paciente paciente = new Paciente(cpf,nome,dataNascimento,alergia,unidade);
		System.out.println("ALERGIA DOS CHECKBOX: "+alergia2);
		pacienteDAO.cadastraPaciente(paciente);	
		System.out.println("PACIENTE CADASTRADO COM SUCESSO!\n");
		}catch(ParseException e)
			{
				e.printStackTrace();
			}
	}
	
	//REMOVE PACIENTE ? 
	public void altaPaciente()
	{
		int cpf = Integer.parseInt(this.janelaPrincipal.getPanelAdmissaoPaciente().getTfCPF().getText());
		Paciente paciente = new Paciente(cpf,null,null,0,0);
		//chama metodo de consulta para efetuar a exclusão do paciente do banco
		//consulta é implementada na classe DAO		
		pacienteDAO.altaPaciente(paciente);
	}	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
			cadastraPaciente();
		}
	}
	
	
}
