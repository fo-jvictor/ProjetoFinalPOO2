package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class admissaoPaciente extends JPanel {
	private JTextField tfCPF;
	private JTextField tfNome;
	private JTextField tfDataNasc;
	private JCheckBox checkboxFrutosdoMar;
	private JCheckBox checkboxPenicilina;
	private JCheckBox checkboxGluten;
	private JCheckBox checkboxDipirona;	
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public admissaoPaciente() {
		setLayout(new MigLayout("", "[][216.00,grow][75.00][grow]", "[][][][][][][][][][][][][][][][]"));
		
		JLabel lblAdmissao = new JLabel("Admissao");
		lblAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblAdmissao, "cell 0 0");
		
		JLabel lblDadosDoPaciente = new JLabel("Dados do Paciente:");
		lblDadosDoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDadosDoPaciente, "cell 0 2,alignx trailing");
		
		JLabel lblAlergias = new JLabel("Alergias:");
		lblAlergias.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblAlergias, "cell 2 2");
		
		checkboxGluten = new JCheckBox("Gluten");
		add(checkboxGluten, "cell 2 3");
		
		checkboxDipirona = new JCheckBox("Dipirona");
		add(checkboxDipirona, "cell 3 3");
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblCPF, "cell 0 4,alignx trailing");
		
		tfCPF = new JTextField();
		add(tfCPF, "cell 1 4,growx");
		tfCPF.setColumns(10);
		
		checkboxFrutosdoMar = new JCheckBox("Frutos do Mar");
		add(checkboxFrutosdoMar, "cell 2 4");
		
		checkboxPenicilina = new JCheckBox("Penicilina");
		add(checkboxPenicilina, "cell 3 4");
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNome, "cell 0 6,alignx trailing");
		
		tfNome = new JTextField();
		add(tfNome, "cell 1 6,growx");
		tfNome.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data Nasc:");
		lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDataNasc, "cell 0 8,alignx trailing");
		
		tfDataNasc = new JTextField();
		add(tfDataNasc, "cell 1 8,growx");
		tfDataNasc.setColumns(10);
		
		JLabel lblDadosDaAdmissao = new JLabel("Dados Da Admissao");
		lblDadosDaAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDadosDaAdmissao, "cell 0 11,alignx trailing");
		
		comboBox = new JComboBox();
		add(comboBox, "cell 1 11,growx");
		comboBox.addItem("Selecione a unidade");
		comboBox.addItem("Ambulatorio");
		comboBox.addItem("Emergencia");
		comboBox.addItem("UTI");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnSalvar, "cell 0 15");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(btnCancelar, "cell 1 15");
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

	public JCheckBox getCheckboxFrutosdoMar() {
		return checkboxFrutosdoMar;
	}

	public void setCheckboxFrutosdoMar(JCheckBox checkboxFrutosdoMar) {
		this.checkboxFrutosdoMar = checkboxFrutosdoMar;
	}

	public JCheckBox getCheckboxPenicilina() {
		return checkboxPenicilina;
	}

	public void setCheckboxPenicilina(JCheckBox checkboxPenicilina) {
		this.checkboxPenicilina = checkboxPenicilina;
	}

	public JCheckBox getCheckboxGluten() {
		return checkboxGluten;
	}

	public void setCheckboxGluten(JCheckBox checkboxGluten) {
		this.checkboxGluten = checkboxGluten;
	}

	public JCheckBox getCheckboxDipirona() {
		return checkboxDipirona;
	}

	public void setCheckboxDipirona(JCheckBox checkboxDipirona) {
		this.checkboxDipirona = checkboxDipirona;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	
	
	

}