package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.AltaDAO;
import dao.PacienteDAO;
import model.Alta;
import model.Paciente;
import visao.JanelaPrincipal;

public class AltaController implements ActionListener {

	private PacienteDAO pacienteDAO;
	private JanelaPrincipal janelaPrincipal;
	private AltaDAO altaDAO;
	
	public AltaController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;
		pacienteDAO = new PacienteDAO();
		altaDAO = new AltaDAO();
		this.janelaPrincipal.getAlta().getButtonSalvar().addActionListener(this);
		this.janelaPrincipal.getAlta().getButtonCancelar().addActionListener(this);
		//this.janelaPrincipal.getAlta().getComboBox().addActionListener(this);
	}
	
	public void altaPaciente()
	{		
		
		String cpf = this.janelaPrincipal.getAlta().getTextField().getText();
		String motivoAlta = String.valueOf(this.janelaPrincipal.getAlta().getComboBox().getSelectedItem());
				
		Alta alta = new Alta(cpf,motivoAlta);
		altaDAO.altaPaciente(alta);
		pacienteDAO.altaPaciente(cpf);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
			altaPaciente();
		}
		if (e.getActionCommand().equals("Cancelar"))
		{
			this.janelaPrincipal.getAlta().getTextField().setText("");
			this.janelaPrincipal.getAlta().getComboBox().getItemAt(0);
			this.janelaPrincipal.getCard().show(this.janelaPrincipal.getContentPane(), "panel");
		}
	}

	
}
