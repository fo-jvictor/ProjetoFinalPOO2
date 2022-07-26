package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import dao.MedicamentoDAO;
import dao.PacienteDAO;
import dao.PrescricaoMedicamentoDAO;
import model.Medicamento;
import model.Paciente;
import model.PrescricaoMedicamento;
import visao.JanelaPrincipal;

public class PrescricaoController implements ActionListener{
	
	private JanelaPrincipal janelaPrincipal;
	private PacienteDAO pacienteDAO;
	private MedicamentoDAO medicamentoDAO;
	private PrescricaoMedicamentoDAO prescricaoMedicamentoDAO;
	
	public PrescricaoController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;		
		//ADD OS LISTENERS PROS BOTOES DOS PANELS E INSTANCIAR ELES AQUI
		pacienteDAO = new PacienteDAO();
		medicamentoDAO = new MedicamentoDAO();
		prescricaoMedicamentoDAO = new PrescricaoMedicamentoDAO();
		this.janelaPrincipal.getPrescricao().getBtnSalvar().addActionListener(this);
		this.janelaPrincipal.getPrescricao().getBtnCancelar().addActionListener(this);
	}
	
	public void consultaPaciente()
	{
		
	    DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		String cpf = this.janelaPrincipal.getPrescricao().getTfCPF().getText();
		Paciente paciente = new Paciente(cpf, null, null, null, null);
		
		pacienteDAO.consultaPaciente(paciente);			
		
		this.janelaPrincipal.getPrescricao().getTfNome().setText(paciente.getNome());		
		
		this.janelaPrincipal.getPrescricao().getTfDataNasc().setText(sdf.format(paciente.getDataNascimento()));		
		
		String codigoBarra = this.janelaPrincipal.getPrescricao().getTfMedicamento().getText();
		Medicamento medicamento = new Medicamento(codigoBarra,null,null);		
		medicamentoDAO.consultaMedicamento(medicamento);	
		
		this.janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().setText(medicamento.getNome());
		
		PrescricaoMedicamento prescricaoM = new PrescricaoMedicamento(cpf, codigoBarra);		
		prescricaoMedicamentoDAO.cadastraPrescricao(prescricaoM);
		
	}
	
	public void limpaTela()
	{		
		this.janelaPrincipal.getPrescricao().getTfCPF().setText("");
		this.janelaPrincipal.getPrescricao().getTfDataNasc().setText("");
		this.janelaPrincipal.getPrescricao().getTfMedicamento().setText("");
		this.janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().setText("");
		this.janelaPrincipal.getPrescricao().getTfNome().setText("");		
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
			limpaTela();
			this.janelaPrincipal.getCard().show(this.janelaPrincipal.getContentPane(), "panel");			
		}
	}
	
	


}
