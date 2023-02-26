package controle;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;

import dao.PacienteDAO;
import model.Paciente;
import visao.JanelaPrincipal;

public class PacienteController implements ActionListener {

	private PacienteDAO pacienteDAO;
	private JanelaPrincipal janelaPrincipal;
	
	public PacienteController(JanelaPrincipal janelaPrincipal)
	{
	
		this.janelaPrincipal=janelaPrincipal;
		pacienteDAO = new PacienteDAO();
		janelaPrincipal.getPanelAdmissaoPaciente().getBtnSalvar().addActionListener(this);
		janelaPrincipal.getPanelAdmissaoPaciente().getBtnCancelar().addActionListener(this);
		janelaPrincipal.getPanelAdmissaoPaciente().getComboBox().addActionListener(this);	
		
	}
	
	public void cadastraPaciente()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<String> alergias = new ArrayList<>();
		List<JCheckBox> checkboxes = new ArrayList<>();
		
		checkboxes.add(janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxFrutosdoMar());
		checkboxes.add(janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxPenicilina());
		checkboxes.add(janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxGluten());
		checkboxes.add(janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxDipirona());
		
		try {	
			
			String cpf = janelaPrincipal.getPanelAdmissaoPaciente().getTfCPF().getText();
			String nome = janelaPrincipal.getPanelAdmissaoPaciente().getTfNome().getText();
			Date dataNascimento = sdf.parse(janelaPrincipal.getPanelAdmissaoPaciente().getTfDataNasc().getText());
			
			for(JCheckBox checkbox : checkboxes) {
				if (checkbox.isSelected()) {
					alergias.add(checkbox.getText());
				}
			}	
						
			String unidade = janelaPrincipal.getPanelAdmissaoPaciente().getComboBox().getSelectedItem().toString();
			
		
			Paciente paciente = new Paciente(cpf,nome,dataNascimento,alergias,unidade);
			pacienteDAO.cadastraPaciente(paciente);
			
		}catch(ParseException e)
			{
				e.printStackTrace();
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
			cadastraPaciente();
		}
		
		if(e.getActionCommand().equals("Cancelar"))
		{
			janelaPrincipal.getPanelAdmissaoPaciente().getTfNome().setText("");
			janelaPrincipal.getPanelAdmissaoPaciente().getTfCPF().setText("");
			janelaPrincipal.getPanelAdmissaoPaciente().getTfDataNasc().setText("");
			janelaPrincipal.getPanelAdmissaoPaciente().getComboBox().setSelectedIndex(0);
			janelaPrincipal.getPanelAdmissaoPaciente().getButtonGroup().clearSelection();	
			janelaPrincipal.getCard().show(janelaPrincipal.getContentPane(), "panel");

		}
		
	}
	
	
}
