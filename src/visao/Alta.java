package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Alta extends JPanel {
	private JTextField textField;
	private JComboBox comboBox;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	
	/**
	 * Create the panel.
	 */
	public Alta() {
		setLayout(new MigLayout("", "[632.00][632.00][632.00][632.00][632.00][632.00,grow]", "[][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("CPF:");
		add(lblNewLabel, "flowx,cell 1 5,alignx right");
		
		textField = new JTextField();
		add(textField, "cell 2 5 2 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Motivo");
		add(lblNewLabel_1, "flowx,cell 1 6,alignx right");
		
		comboBox = new JComboBox();
		add(comboBox, "cell 2 6 2 1,growx");
		comboBox.addItem("Selecione o motivo de alta");
		comboBox.addItem("Cura");
		comboBox.addItem("Transferencia");
		comboBox.addItem("Obito");
		
		buttonSalvar = new JButton("Salvar");
		add(buttonSalvar, "cell 0 15,growx");
		
		buttonCancelar = new JButton("Cancelar");
		add(buttonCancelar, "cell 1 15,growx");

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}

	public void setButtonSalvar(JButton buttonSalvar) {
		this.buttonSalvar = buttonSalvar;
	}

	public JButton getButtonCancelar() {
		return buttonCancelar;
	}

	public void setButtonCancelar(JButton buttonCancelar) {
		this.buttonCancelar = buttonCancelar;
	}
	
	

}
