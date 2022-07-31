package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaDeLogin extends JPanel {
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JLabel lblSenha;
	private JLabel lblTelaDeLogin;
	private JButton btnLogar;
	private JButton btnCancelarLogin;

	/**
	 * Create the panel.
	 */
	public TelaDeLogin() {
		setLayout(new MigLayout("", "[192.00][168.00,grow][186.00]", "[][][][][][][][][22.00][][][][]"));
		
		lblTelaDeLogin = new JLabel("Tela de Login");
		lblTelaDeLogin.setFont(new Font("Tahoma", Font.BOLD, 26));
		add(lblTelaDeLogin, "cell 1 2");
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblUsuario, "cell 0 6,alignx trailing");
		
		tfUsuario = new JTextField();
		add(tfUsuario, "cell 1 6,growx");
		tfUsuario.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblSenha, "cell 0 8,alignx trailing");
		
		tfSenha = new JTextField();
		add(tfSenha, "cell 1 8,growx");
		tfSenha.setColumns(10);
		
		btnLogar = new JButton("Logar");
		//btnLogar.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/imagens/ok1.png")));
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnLogar, "flowx,cell 1 12");
		
		btnCancelarLogin = new JButton("Cancelar");
		//btnCancelarLogin.setIcon(new ImageIcon(TelaDeLogin.class.getResource("/imagens/clean.png")));
		btnCancelarLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnCancelarLogin, "cell 1 12");

	}

	public JTextField getTfUsuario() {
		return tfUsuario;
	}

	public void setTfUsuario(JTextField tfUsuario) {
		this.tfUsuario = tfUsuario;
	}

	public JTextField getTfSenha() {
		return tfSenha;
	}

	public void setTfSenha(JTextField tfSenha) {
		this.tfSenha = tfSenha;
	}

	public JButton getBtnLogar() {
		return btnLogar;
	}

	public void setBtnLogar(JButton btnLogar) {
		this.btnLogar = btnLogar;
	}

	public JButton getBtnCancelarLogin() {
		return btnCancelarLogin;
	}

	public void setBtnCancelarLogin(JButton btnCancelarLogin) {
		this.btnCancelarLogin = btnCancelarLogin;
	}
	
	

}
