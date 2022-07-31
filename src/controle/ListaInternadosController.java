package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import dao.PacienteDAO;
import model.Paciente;
import visao.JanelaPrincipal;

public class ListaInternadosController implements ActionListener {
	
	private PacienteDAO pacienteDAO;
	private JanelaPrincipal janelaPrincipal;
	private List<Paciente> pacientes = new ArrayList<>();

	public ListaInternadosController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;
		pacienteDAO = new PacienteDAO();
		//implementar os listeners
		this.janelaPrincipal.getListainternados().getButtonListaDeInternadosSalvar().addActionListener(this);
		this.janelaPrincipal.getListainternados().getButtonListaDeInternadosCancelar().addActionListener(this);
	}
	
	public void mostraPacientes()
	{
		for(Paciente paciente : pacientes)
		{
			pacienteDAO.consultaPaciente(paciente);
			this.janelaPrincipal.getListainternados().getTextAreaListaDeInternadosNome().setText(paciente.getNome());			
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
			mostraPacientes();
		}
		
		if (e.getActionCommand().equals("Cancelar"))
		{
			this.janelaPrincipal.getListainternados().getTextAreaListaDeInternadosNome().setText("");
			this.janelaPrincipal.getListainternados().getTextAreaListaDeInternadosDataNasc().setText("");
			this.janelaPrincipal.getListainternados().getTextAreaListaDeInternadosUnidade().setText("");
			this.janelaPrincipal.getListainternados().getTextAreaListaDeInternadosAlergias().setText("");
			this.janelaPrincipal.getCard().show(this.janelaPrincipal.getContentPane(), "panel");
		}
		
	}
	
	
	
}
