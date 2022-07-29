package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import dao.MedicamentoDAO;
import dao.PacienteDAO;
import model.Medicamento;
import model.Paciente;
import visao.JanelaPrincipal;

public class PrescricaoController implements ActionListener{
	
	private JanelaPrincipal janelaPrincipal;
	private PacienteDAO pacienteDAO;
	private MedicamentoDAO medicamentoDAO;
	
	public PrescricaoController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;		
		//ADD OS LISTENERS PROS BOTOES DOS PANELS E INSTANCIAR ELES AQUI
		pacienteDAO = new PacienteDAO();
		medicamentoDAO = new MedicamentoDAO();
		this.janelaPrincipal.getPrescricao().getBtnSalvar().addActionListener(this);
		this.janelaPrincipal.getPrescricao().getBtnCancelar().addActionListener(this);
	}
	
	public void consultaPaciente()
	{
		
	   DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		int cpf = Integer.parseInt(janelaPrincipal.getPrescricao().getTfCPF().getText());
		Paciente paciente = new Paciente(cpf, null, null, 0, 0);
		pacienteDAO.consultaPaciente(paciente);		
		//set Nome do paciente que agora voltou populado do banco de dados no FIELD nome;
		//set DataNascimento do paciente no field Data Nasc;		
		this.janelaPrincipal.getPrescricao().getTfNome().setText(paciente.getNome());
		
		//this.janelaPrincipal.getPrescricao().getTfDataNasc().setText(""+paciente.getDataNascimento());
		
		this.janelaPrincipal.getPrescricao().getTfDataNasc().setText(sdf.format(paciente.getDataNascimento()));
		
		String codigoBarra = this.janelaPrincipal.getPrescricao().getTfMedicamento().getText();
		Medicamento medicamento = new Medicamento(codigoBarra,null,0);		
		medicamentoDAO.consultaMedicamento(medicamento);		
		this.janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().setText(medicamento.getNome());
		//implementar verificação de nomes na entidade Medicamento
		//implementar entidade medicamento na entidade paciente
		//this.janelaPrincipal.getPrescricao().getTfMedicamento().setText(paciente.getMedicamento());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
			consultaPaciente();
		}
		if(e.getActionCommand().equals("Cancelar"))
		{
			//funcaoCancelar();
		}
	}
	
	


}
