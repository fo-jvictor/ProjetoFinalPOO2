package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Medicamentos extends JPanel {
	private JTextField fieldCodigodebarra;
	private JTextField fieldNome;
	private JButton btnCancelar;
	private JButton btnSalvar;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox checkboxGluten;
	private JCheckBox checkboxFrutosdomar;
	private JCheckBox checkboxPenicilina;
	private JCheckBox checkboxDipirona;

	/**
	 * Create the panel.
	 */
	public Medicamentos() {
		setLayout(new MigLayout("", "[96.00][][grow][grow][grow][grow]", "[][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Dados do Medicamento:");
		add(lblNewLabel, "cell 0 1 2 1");
		
		JLabel lblNewLabel_1 = new JLabel("Cod Barras:");
		add(lblNewLabel_1, "flowx,cell 0 3 2 1,alignx left");
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		add(lblNewLabel_2, "flowx,cell 0 4 2 1,alignx left");
		
		JLabel lblNewLabel_4 = new JLabel("Contraindicado para as alergias:");
		add(lblNewLabel_4, "cell 0 8 2 1");
		
		checkboxGluten = new JCheckBox("Glúten");
		add(checkboxGluten, "flowx,cell 0 10,alignx center");
		
		checkboxFrutosdomar = new JCheckBox("Frutos do Mar");
		add(checkboxFrutosdomar, "cell 1 10 3 1,alignx center");
		
		checkboxPenicilina = new JCheckBox("Penicilina");
		add(checkboxPenicilina, "flowx,cell 4 10,alignx left");
		
		checkboxDipirona = new JCheckBox("Dipirona");
		add(checkboxDipirona, "cell 5 10,alignx center");
		
		buttonGroup.add(checkboxDipirona);
		buttonGroup.add(checkboxFrutosdomar);
		buttonGroup.add(checkboxGluten);
		buttonGroup.add(checkboxPenicilina);
		
		btnSalvar = new JButton("Salvar");
		add(btnSalvar, "flowx,cell 0 16 2 1,growx");
		
		fieldCodigodebarra = new JTextField();
		add(fieldCodigodebarra, "cell 1 3 3 1,growx");
		fieldCodigodebarra.setColumns(10);
		
		fieldNome = new JTextField();
		add(fieldNome, "cell 1 4 5 1,growx");
		fieldNome.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		add(btnCancelar, "cell 2 16,growx");
	}

	public JTextField getFieldCodigodebarra() {
		return fieldCodigodebarra;
	}

	public void setFieldCodigodebarra(JTextField fieldCodigodebarra) {
		this.fieldCodigodebarra = fieldCodigodebarra;
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public void setFieldNome(JTextField fieldNome) {
		this.fieldNome = fieldNome;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

	public JCheckBox getCheckboxGluten() {
		return checkboxGluten;
	}

	public void setCheckboxGluten(JCheckBox checkboxGluten) {
		this.checkboxGluten = checkboxGluten;
	}

	public JCheckBox getCheckboxFrutosdomar() {
		return checkboxFrutosdomar;
	}

	public void setCheckboxFrutosdomar(JCheckBox checkboxFrutosdomar) {
		this.checkboxFrutosdomar = checkboxFrutosdomar;
	}

	public JCheckBox getCheckboxPenicilina() {
		return checkboxPenicilina;
	}

	public void setCheckboxPenicilina(JCheckBox checkboxPenicilina) {
		this.checkboxPenicilina = checkboxPenicilina;
	}

	public JCheckBox getCheckboxDipirona() {
		return checkboxDipirona;
	}

	public void setCheckboxDipirona(JCheckBox checkboxDipirona) {
		this.checkboxDipirona = checkboxDipirona;
	}
	
	

}
