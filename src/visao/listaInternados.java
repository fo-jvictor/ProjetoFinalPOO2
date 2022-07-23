package visao;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class listaInternados extends JPanel {
	private JButton buttonListaDeInternadosCancelar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTextArea textAreaListaDeInternadosNome;
	private JTextArea textAreaListaDeInternadosUnidade;
	private JTextArea textAreaListaDeInternadosDataNasc;
	private JTextArea textAreaListaDeInternadosAlergias;
	private JButton buttonListaDeInternadosSalvar;
	
	public listaInternados() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][grow 5][grow][][grow 5]"));
		setBounds(100, 100, 640, 480);
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,aligny top");
		
		JLabel lableTituloListaDeInternados = new JLabel("Lista de Internados");
		lableTituloListaDeInternados.setHorizontalAlignment(SwingConstants.CENTER);
		lableTituloListaDeInternados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lableTituloListaDeInternados);
		
		JLabel lableListaDeInternadosNome = new JLabel("Nome:");
		lableListaDeInternadosNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lableListaDeInternadosNome, "cell 0 1");
		
		JLabel lableListaDeInternadosUnidade = new JLabel("Unidade:");
		lableListaDeInternadosUnidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lableListaDeInternadosUnidade, "cell 1 1,grow");
		
		JLabel lableListaDeInternadosDataNasc = new JLabel("Data Nasc:");
		lableListaDeInternadosDataNasc.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lableListaDeInternadosDataNasc, "cell 2 1");
		
		JLabel lableListaDeInternadosAlergias = new JLabel("Alergias:");
		lableListaDeInternadosAlergias.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lableListaDeInternadosAlergias, "cell 3 1");
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 2,grow");
		
		textAreaListaDeInternadosNome = new JTextArea();
		scrollPane.setViewportView(textAreaListaDeInternadosNome);
		
		scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 2,grow");
		
		textAreaListaDeInternadosUnidade = new JTextArea();
		scrollPane_1.setViewportView(textAreaListaDeInternadosUnidade);
		
		scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 2 2,grow");
		
		textAreaListaDeInternadosDataNasc = new JTextArea();
		scrollPane_2.setViewportView(textAreaListaDeInternadosDataNasc);
		
		scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "cell 3 2,grow");
		
		textAreaListaDeInternadosAlergias = new JTextArea();
		scrollPane_3.setViewportView(textAreaListaDeInternadosAlergias);
		
		buttonListaDeInternadosCancelar = new JButton("Cancelar");			
		;
		
		buttonListaDeInternadosSalvar = new JButton("Salvar");
		buttonListaDeInternadosSalvar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(buttonListaDeInternadosSalvar, "flowx,cell 0 4,growx");
		buttonListaDeInternadosCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(buttonListaDeInternadosCancelar, "cell 0 4,growx");
	}	
	
	public JButton getButtonListaDeInternadosCancelar() {
		return buttonListaDeInternadosCancelar;
	}

	public void setButtonListaDeInternadosCancelar(JButton buttonListaDeInternadosCancelar) {
		this.buttonListaDeInternadosCancelar = buttonListaDeInternadosCancelar;
	}

	public JTextArea getTextAreaListaDeInternadosNome() {
		return textAreaListaDeInternadosNome;
	}

	public void setTextAreaListaDeInternadosNome(JTextArea textAreaListaDeInternadosNome) {
		this.textAreaListaDeInternadosNome = textAreaListaDeInternadosNome;
	}

	public JTextArea getTextAreaListaDeInternadosUnidade() {
		return textAreaListaDeInternadosUnidade;
	}

	public void setTextAreaListaDeInternadosUnidade(JTextArea textAreaListaDeInternadosUnidade) {
		this.textAreaListaDeInternadosUnidade = textAreaListaDeInternadosUnidade;
	}

	public JTextArea getTextAreaListaDeInternadosDataNasc() {
		return textAreaListaDeInternadosDataNasc;
	}

	public void setTextAreaListaDeInternadosDataNasc(JTextArea textAreaListaDeInternadosDataNasc) {
		this.textAreaListaDeInternadosDataNasc = textAreaListaDeInternadosDataNasc;
	}

	public JTextArea getTextAreaListaDeInternadosAlergias() {
		return textAreaListaDeInternadosAlergias;
	}

	public void setTextAreaListaDeInternadosAlergias(JTextArea textAreaListaDeInternadosAlergias) {
		this.textAreaListaDeInternadosAlergias = textAreaListaDeInternadosAlergias;
	}

	public JButton getButtonListaDeInternadosSalvar() {
		return buttonListaDeInternadosSalvar;
	}

	public void setButtonListaDeInternadosSalvar(JButton buttonListaDeInternadosSalvar) {
		this.buttonListaDeInternadosSalvar = buttonListaDeInternadosSalvar;
	}

	public void cancelaListaDeInternados() {//criar metodo
		
		textAreaListaDeInternadosNome.setText("");
		textAreaListaDeInternadosUnidade.setText("");
		textAreaListaDeInternadosAlergias.setText("");
		textAreaListaDeInternadosDataNasc.setText("");
	}

}