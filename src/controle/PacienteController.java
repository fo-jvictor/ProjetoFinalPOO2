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
	//private CardLayout card;

	
	//manda os dados dessa classe para PacienteDAO
	
	public PacienteController(JanelaPrincipal janelaPrincipal)
	{
		//Vou precisar acessar a janelaPrincipal para acessar o Panel referente ao cadastro
		//de paciente. Então através dos getters dos campos do Panel de cadastro de Paciente eu pego os dados
		//insiro eles em variaveis e declaro um novo objeto de paciente, passando para o PacienteDAO realizar
		//as operações de persistencia no banco de dados;		
		this.janelaPrincipal=janelaPrincipal;
		pacienteDAO = new PacienteDAO();
		this.janelaPrincipal.getPanelAdmissaoPaciente().getBtnSalvar().addActionListener(this);
		this.janelaPrincipal.getPanelAdmissaoPaciente().getBtnCancelar().addActionListener(this);
		this.janelaPrincipal.getPanelAdmissaoPaciente().getComboBox().addActionListener(this);	
		
	}
	
	public void cadastraPaciente() throws IOException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<String> alergias = new ArrayList<>();
		List<JCheckBox> checkboxes = new ArrayList<>();
		
		checkboxes.add(this.janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxFrutosdoMar());
		checkboxes.add(this.janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxPenicilina());
		checkboxes.add(this.janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxGluten());
		checkboxes.add(this.janelaPrincipal.getPanelAdmissaoPaciente().getCheckboxDipirona());
		
		try {	
			
			String cpf = this.janelaPrincipal.getPanelAdmissaoPaciente().getTfCPF().getText();
			String nome = this.janelaPrincipal.getPanelAdmissaoPaciente().getTfNome().getText();
			Date dataNascimento = sdf.parse(this.janelaPrincipal.getPanelAdmissaoPaciente().getTfDataNasc().getText());
			
			for(JCheckBox checkbox : checkboxes) {
				if (checkbox.isSelected()) {
					alergias.add(checkbox.getText());
				}
			}
						
			String unidade = this.janelaPrincipal.getPanelAdmissaoPaciente().getComboBox().getSelectedItem().toString();
			
		
			Paciente paciente = new Paciente(cpf,nome,dataNascimento,alergias,unidade);
			pacienteDAO.cadastraPaciente(paciente);
			
			System.out.println(paciente);
			
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
			try {
				cadastraPaciente();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getActionCommand().equals("Cancelar"))
		{
			this.janelaPrincipal.getPanelAdmissaoPaciente().getTfNome().setText("");
			this.janelaPrincipal.getPanelAdmissaoPaciente().getTfCPF().setText("");
			this.janelaPrincipal.getPanelAdmissaoPaciente().getTfDataNasc().setText("");
			this.janelaPrincipal.getPanelAdmissaoPaciente().getComboBox().setSelectedIndex(0);
			this.janelaPrincipal.getPanelAdmissaoPaciente().getButtonGroup().clearSelection();	
			this.janelaPrincipal.getCard().show(this.janelaPrincipal.getContentPane(), "panel");

		}
		
	}
	
	
}
