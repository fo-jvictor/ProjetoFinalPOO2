package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.UsuarioDAO;
import model.Usuario;
import visao.JanelaPrincipal;

public class UsuarioController implements ActionListener{
	
	private JanelaPrincipal janelaPrincipal;
	//private Usuario usuario;
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;
		this.janelaPrincipal.getTelaLogin().getBtnLogar().addActionListener(this);
		this.janelaPrincipal.getTelaLogin().getBtnCancelarLogin().addActionListener(this);
		usuarioDAO = new UsuarioDAO();
		
	}
	
	public void Logar()
	{
		String usuario = this.janelaPrincipal.getTelaLogin().getTfUsuario().getText();
		String senha = this.janelaPrincipal.getTelaLogin().getTfSenha().getText();
		Usuario user = new Usuario(usuario,senha);
		if (usuarioDAO.autenticar(user))
		{
			System.out.println("Usuário autenticado com sucesso");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Logar"))
		{
			Logar();
		}
		
		if (e.getActionCommand().equals("Cancelar"))
		{
			this.janelaPrincipal.getCard().show(this.janelaPrincipal.getContentPane(), "panel");
		}
	}
	
	

}
