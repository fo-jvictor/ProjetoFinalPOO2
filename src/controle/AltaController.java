package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.PacienteDAO;import model.Paciente;
import visao.JanelaPrincipal;

public class AltaController implements ActionListener {

	private PacienteDAO pacienteDAO;
	private JanelaPrincipal janelaPrincipal;
	
	public AltaController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;
		pacienteDAO = new PacienteDAO();
		this.janelaPrincipal.getAlta().getButtonSalvar().addActionListener(this);
		this.janelaPrincipal.getAlta().getButtonCancelar().addActionListener(this);
		//this.janelaPrincipal.getAlta().getComboBox().addActionListener(this);
	}
	
	public void altaPaciente()
	{
		String cpf = this.janelaPrincipal.getAlta().getTextField().getText();
		Paciente paciente = new Paciente(cpf,null,null,0,0);
		pacienteDAO.altaPaciente(paciente);
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
