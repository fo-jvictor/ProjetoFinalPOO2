package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Caret;

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
		this.janelaPrincipal.getListainternados().getButtonListaDeInternadosSalvar().addActionListener(this);
		this.janelaPrincipal.getListainternados().getButtonListaDeInternadosCancelar().addActionListener(this);
		mostraPacientes();
	}
	
	public void mostraPacientes()
	{
		var pacientes = pacienteDAO.consultaTodosPacientes();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		for (Paciente pac : pacientes) {
			janelaPrincipal.getListainternados().getTextAreaListaDeInternadosNome().append(pac.getNome() + "\n");
			janelaPrincipal.getListainternados().getTextAreaListaDeInternadosUnidade().append(pac.getUnidade()+"\n");
			janelaPrincipal.getListainternados().getTextAreaListaDeInternadosDataNasc().append(pac.getDataNascimento().toString()+"\n");			
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
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
