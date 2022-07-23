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
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 2 6 2 1,growx");
		
		JButton btnNewButton = new JButton("Salvar");
		add(btnNewButton, "cell 0 15,growx");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		add(btnNewButton_1, "cell 1 15,growx");

	}

}
