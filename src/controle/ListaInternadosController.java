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
			
		}
		
	}
	
	
	
}
