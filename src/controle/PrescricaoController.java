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

public class PrescricaoController implements ActionListener, KeyListener {

	private JanelaPrincipal janelaPrincipal;
	private PacienteDAO pacienteDAO;
	private MedicamentoDAO medicamentoDAO;
	private PrescricaoMedicamentoDAO prescricaoMedicamentoDAO;

	String cpf = null;
	String codigoBarra = null;

	public PrescricaoController(JanelaPrincipal janelaPrincipal) {
		this.janelaPrincipal = janelaPrincipal;
		pacienteDAO = new PacienteDAO();
		medicamentoDAO = new MedicamentoDAO();
		prescricaoMedicamentoDAO = new PrescricaoMedicamentoDAO();
		janelaPrincipal.getPrescricao().getBtnSalvar().addActionListener(this);
		janelaPrincipal.getPrescricao().getBtnCancelar().addActionListener(this);
		janelaPrincipal.getPrescricao().getTfCPF().addKeyListener(this);
		janelaPrincipal.getPrescricao().getTfMedicamento().addKeyListener(this);
		janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().addKeyListener(this);
	}

	public void consultaPaciente() {

		List<JCheckBox> checkboxes = new ArrayList<>();

		checkboxes.add(janelaPrincipal.getPrescricao().getCheckBoxGluten());
		checkboxes.add(janelaPrincipal.getPrescricao().getCheckBoxDipirona());
		checkboxes.add(janelaPrincipal.getPrescricao().getCheckBoxFrutosMar());
		checkboxes.add(janelaPrincipal.getPrescricao().getCheckBoxPenicilina());

		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		cpf = janelaPrincipal.getPrescricao().getTfCPF().getText();

		if (!validateIfEmptyOrBlankField(cpf)) {
			
		}

		Paciente paciente = pacienteDAO.consultaPaciente(cpf);

		janelaPrincipal.getPrescricao().getTfNome().setText(paciente.getNome());

		janelaPrincipal.getPrescricao().getTfDataNasc().setText(sdf.format(paciente.getDataNascimento()));

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

		codigoBarra = janelaPrincipal.getPrescricao().getTfMedicamento().getText();
		var medicamento = medicamentoDAO.consultaMedicamento(codigoBarra);

		janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().setText(medicamento.getNome());

	}

	public void prescreveMedicamento() {

		cpf = janelaPrincipal.getPrescricao().getTfCPF().getText();
		codigoBarra = janelaPrincipal.getPrescricao().getTfMedicamento().getText();

		if (!validateIfEmptyOrBlankField(codigoBarra) && !validateIfEmptyOrBlankField(cpf)) {

		}

		var medicamento = medicamentoDAO.consultaMedicamento(codigoBarra);
		var paciente = pacienteDAO.consultaPaciente(cpf);

		var alergiasMedicamento = medicamento.getAlergias();

		var alergiasPaciente = paciente.getAlergias();

		boolean hasCommonElement = 
				alergiasMedicamento.stream()
				.filter(alergiasPaciente::contains).findAny().isPresent();

		if (!hasCommonElement) {
			PrescricaoMedicamento prescricaoMedicamento = new PrescricaoMedicamento(cpf, codigoBarra);
			prescricaoMedicamentoDAO.cadastraPrescricao(prescricaoMedicamento);
		} else {
			System.out.println("Medicamento contra indicado para o paciente");
		}

	}

	public void limpaTela() {
		janelaPrincipal.getPrescricao().getTfCPF().setText("");
		janelaPrincipal.getPrescricao().getTfDataNasc().setText("");
		janelaPrincipal.getPrescricao().getTfMedicamento().setText("");
		janelaPrincipal.getPrescricao().getTfMedicamentoProtegido().setText("");
		janelaPrincipal.getPrescricao().getTfNome().setText("");

		janelaPrincipal.getPrescricao().getCheckBoxFrutosMar().setSelected(false);
		janelaPrincipal.getPrescricao().getCheckBoxDipirona().setSelected(false);
		janelaPrincipal.getPrescricao().getCheckBoxGluten().setSelected(false);
		janelaPrincipal.getPrescricao().getCheckBoxPenicilina().setSelected(false);

	}

	public Boolean validateIfEmptyOrBlankField(String field) {
		if (field.isEmpty() || field.isBlank()) {
			System.out.println("Enter with a valid" + field + "!");
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar")) {
			prescreveMedicamento();
		}
		if (e.getActionCommand().equals("Cancelar")) {
			limpaTela();
			janelaPrincipal.getCard().show(janelaPrincipal.getContentPane(), "panel");
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
			if (e.getSource().equals(janelaPrincipal.getPrescricao().getTfMedicamento())) {
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
