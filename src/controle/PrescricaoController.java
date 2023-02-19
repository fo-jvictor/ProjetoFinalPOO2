package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import dao.MedicamentoDAO;
import dao.PacienteDAO;
import dao.PrescricaoMedicamentoDAO;
import model.Medicamento;
import model.Paciente;
import model.PrescricaoMedicamento;
import visao.JanelaPrincipal;

public class PrescricaoController implements ActionListener, KeyListener{
	
	private JanelaPrincipal janelaPrincipal;
	private PacienteDAO pacienteDAO;
	private MedicamentoDAO medicamentoDAO;
	private PrescricaoMedicamentoDAO prescricaoMedicamentoDAO;
	
	String cpf = null;
	String codigoBarra = null;
	
	public PrescricaoController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;		
		//ADD OS LISTENERS PROS BOTOES DOS PANELS E INSTANCIAR ELES AQUI
		pacienteDAO = new PacienteDAO();
		medicamentoDAO = new MedicamentoDAO();
		prescricaoMedicamentoDAO = new PrescricaoMedicamentoDAO();
		this.janelaPrincipal.getPrescricao().getBtnSalvar().addActionListener(this);
		this.janelaPrincipal.getPrescricao().getBtnCancelar().addActionListener(this);
		this.janelaPrincipal.getPrescricao().getTfCPF().addKeyListener(this);
		this.janelaPrincipal.getPrescricao().getTfMedicamento().addKeyListener(this);
		this.janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().addKeyListener(this);
	}
	
	public void consultaPaciente()
	{
		
		List<JCheckBox> checkboxes = new ArrayList<>();
		
		checkboxes.add(this.janelaPrincipal.getPrescricao().getCheckBoxGluten());
		checkboxes.add(this.janelaPrincipal.getPrescricao().getCheckBoxDipirona());
		checkboxes.add(this.janelaPrincipal.getPrescricao().getCheckBoxFrutosMar());
		checkboxes.add(this.janelaPrincipal.getPrescricao().getCheckBoxPenicilina());
		
	    DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		cpf = this.janelaPrincipal.getPrescricao().getTfCPF().getText();
		
		Paciente paciente = pacienteDAO.consultaPaciente(cpf);			
		
		this.janelaPrincipal.getPrescricao().getTfNome().setText(paciente.getNome());		
		
		this.janelaPrincipal.getPrescricao().getTfDataNasc().setText(sdf.format(paciente.getDataNascimento()));
		
		List<String> alergiasPaciente = paciente.getAlergias().stream().collect(Collectors.toList());
		
		for (JCheckBox cb : checkboxes) {
			for (String alergia : alergiasPaciente) {
				if (alergia.equals(cb.getText())) {
					cb.setSelected(true);
				}				
			}
		}
		
	}
	
	public void consultaMedicamento() {
		
		codigoBarra = this.janelaPrincipal.getPrescricao().getTfMedicamento().getText();
		var medicamento = medicamentoDAO.consultaMedicamento(codigoBarra);	
		
		this.janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().setText(medicamento.getNome());
		
	}
	
	public void prescreveMedicamento() {
		
		if (cpf.isEmpty() || cpf.isBlank() && codigoBarra.isEmpty() || codigoBarra.isBlank()) {
			System.out.println("Enter with cpf and codigo de barra");
		} else {
			PrescricaoMedicamento prescricaoMedicamento = new PrescricaoMedicamento(cpf, codigoBarra);
			prescricaoMedicamentoDAO.cadastraPrescricao(prescricaoMedicamento);
		}

	}
	
	public void limpaTela()
	{		
		this.janelaPrincipal.getPrescricao().getTfCPF().setText("");
		this.janelaPrincipal.getPrescricao().getTfDataNasc().setText("");
		this.janelaPrincipal.getPrescricao().getTfMedicamento().setText("");
		this.janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().setText("");
		this.janelaPrincipal.getPrescricao().getTfNome().setText("");
		
		this.janelaPrincipal.getPrescricao().getCheckBoxFrutosMar().setSelected(false);
		this.janelaPrincipal.getPrescricao().getCheckBoxDipirona().setSelected(false);
		this.janelaPrincipal.getPrescricao().getCheckBoxGluten().setSelected(false);
		this.janelaPrincipal.getPrescricao().getCheckBoxPenicilina().setSelected(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
			prescreveMedicamento();
		}
		if(e.getActionCommand().equals("Cancelar"))
		{
			limpaTela();
			this.janelaPrincipal.getCard().show(this.janelaPrincipal.getContentPane(), "panel");			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource().equals(janelaPrincipal.getPrescricao().getTfMedicamento()))
			{
				consultaMedicamento();
			}
			
			if (e.getSource().equals(janelaPrincipal.getPrescricao().getTfCPF())) {
				consultaPaciente();
			}
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	


}
