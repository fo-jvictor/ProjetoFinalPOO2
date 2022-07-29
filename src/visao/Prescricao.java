package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Prescricao extends JPanel {
	private JTextField tfCPF;
	private JTextField tfNome;
	private JTextField tfDataNasc;
	private JTextField tfMedicamento;
	private JTextField tfMedicamentoProtegido;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JRadioButton rdbtnPenicilina;
	private ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public Prescricao() {
		setLayout(new MigLayout("", "[110.00][226.00,grow][113.00,grow][grow]", "[][][][][][][][][][][][][][][][][][]"));
		
		JLabel painelPrescricao = new JLabel("Prescricao");
		painelPrescricao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(painelPrescricao, "cell 0 0");
		
		JLabel lblDadosPaciente = new JLabel("Dados do Paciente:");
		lblDadosPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDadosPaciente, "cell 0 2");
		
		JLabel lblAlergia = new JLabel("Alergias:");
		lblAlergia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblAlergia, "cell 2 2");
		
		JRadioButton rdbtnGluten = new JRadioButton("Gluten");
		rdbtnGluten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(rdbtnGluten, "cell 2 4");
		
		JRadioButton rdbtnDipirona = new JRadioButton("Dipirona");
		rdbtnDipirona.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(rdbtnDipirona, "cell 3 4");
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblCPF, "cell 0 5,alignx trailing");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(tfCPF, "cell 1 5,growx");
		tfCPF.setColumns(10);
		
		JRadioButton rdbtnFrutosDoMar = new JRadioButton("Frutos Do Mar");
		rdbtnFrutosDoMar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(rdbtnFrutosDoMar, "cell 2 5");
		
		rdbtnPenicilina = new JRadioButton("Penicilina");
		rdbtnPenicilina.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(rdbtnPenicilina, "cell 3 5");
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblNome, "cell 0 7,alignx trailing");
		
		tfNome = new JTextField();
		add(tfNome, "cell 1 7,growx");
		tfNome.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data Nasc.:");
		lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblDataNasc, "cell 0 9,alignx trailing");
		
		tfDataNasc = new JTextField();
		add(tfDataNasc, "cell 1 9,growx");
		tfDataNasc.setColumns(10);
		
		JLabel lblPrescricao = new JLabel("Prescricao");
		lblPrescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblPrescricao, "cell 0 12");
		
		JLabel lblMedicamentos = new JLabel("Medicamentos:");
		lblMedicamentos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblMedicamentos, "cell 0 14,alignx trailing");
		
		tfMedicamento = new JTextField();
		add(tfMedicamento, "cell 1 14,growx");
		tfMedicamento.setColumns(10);
		
		tfMedicamentoProtegido = new JTextField();
		add(tfMedicamentoProtegido, "cell 2 14 2 1,growx");
		tfMedicamentoProtegido.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setHorizontalAlignment(SwingConstants.RIGHT);
		add(btnSalvar, "flowx,cell 0 17");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnCancelar, "cell 1 17");
	}

	public JTextField getTfCPF() {
		return tfCPF;
	}

	public void setTfCPF(JTextField tfCPF) {
		this.tfCPF = tfCPF;
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JTextField getTfDataNasc() {
		return tfDataNasc;
	}

	public void setTfDataNasc(JTextField tfDataNasc) {
		this.tfDataNasc = tfDataNasc;
	}

	public JTextField getTfMedicamento() {
		return tfMedicamento;
	}

	public void setTfMedicamento(JTextField tfMedicamento) {
		this.tfMedicamento = tfMedicamento;
	}

	public JTextField getTfMedicamentoProtegido() {
		return tfMedicamentoProtegido;
	}

	public void setTfMedicamentoProtegido(JTextField tfMedicamentoProtegido) {
		this.tfMedicamentoProtegido = tfMedicamentoProtegido;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
	
	
}