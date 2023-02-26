package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import dao.MedicamentoDAO;
import model.Medicamento;
import visao.JanelaPrincipal;

public class MedicamentoController implements ActionListener{

	private MedicamentoDAO medicamentoDAO;
	private JanelaPrincipal janelaPrincipal;
	
	public MedicamentoController(JanelaPrincipal janelaPrincipal)
	{
		this.janelaPrincipal=janelaPrincipal;
		medicamentoDAO = new MedicamentoDAO();
		janelaPrincipal.getMedicamentos().getBtnSalvar().addActionListener(this);
		janelaPrincipal.getMedicamentos().getBtnCancelar().addActionListener(this);
		janelaPrincipal.getMedicamentos().getBtnAtualizar().addActionListener(this);
		janelaPrincipal.getMedicamentos().getBtnRemover().addActionListener(this);	
	}
	
	public void cadastraMedicamento()
	{
		
		List<String> alergias = new ArrayList<>();
		List<JCheckBox> checkboxes = new ArrayList<>();
		
		checkboxes.add(this.janelaPrincipal.getMedicamentos().getCheckboxFrutosdomar());
		checkboxes.add(this.janelaPrincipal.getMedicamentos().getCheckboxPenicilina());
		checkboxes.add(this.janelaPrincipal.getMedicamentos().getCheckboxGluten());
		checkboxes.add(this.janelaPrincipal.getMedicamentos().getCheckboxDipirona());
				
		String codigoBarra = janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
		String nome = janelaPrincipal.getMedicamentos().getFieldNome().getText();

		for(JCheckBox checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				alergias.add(checkbox.getText());
			}
		}
		
		Medicamento medicamento = new Medicamento(codigoBarra,nome,alergias);
		
		if(medicamentoDAO.cadastraMedicamento(medicamento))
		{
			limpaTela();
		}
	}
	
	public void atualizaMedicamento()
	{
		List<String> alergias = new ArrayList<>();
		
		String codigoBarra = janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
		String nome = janelaPrincipal.getMedicamentos().getFieldNome().getText();
		String alergia = janelaPrincipal.getMedicamentos().getButtonGroup().getSelection().getActionCommand();
		Medicamento medicamento = new Medicamento(codigoBarra,nome,alergias);
		medicamentoDAO.atualizaMedicamento(medicamento);		
	}
	
	public void removeMedicamento()
	{
		String codigoBarra = janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
		Medicamento medicamento = new Medicamento(codigoBarra,null,null);
		medicamentoDAO.removeMedicamento(medicamento);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
			cadastraMedicamento();
		}
		
		if (e.getActionCommand().equals("Cancelar"))
		{
			limpaTela();
			janelaPrincipal.getCard().show(janelaPrincipal.getContentPane(), "panel");
		}
		
		if(e.getActionCommand().equals("Atualizar"))
		{
			atualizaMedicamento();
		}
		
		if(e.getActionCommand().equals("Remover"))
		{
			removeMedicamento();
		}
		
	}
	
	public void limpaTela()
	{
		janelaPrincipal.getMedicamentos().getFieldCodigodebarra().setText("");
		janelaPrincipal.getMedicamentos().getFieldNome().setText("");
		janelaPrincipal.getMedicamentos().getButtonGroup().clearSelection();
	}
	
}
