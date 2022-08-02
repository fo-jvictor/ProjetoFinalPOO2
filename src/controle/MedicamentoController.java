package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		//ADD OS LISTENERS PROS BOTOES DOS PANELS E INSTANCIAR ELES AQUI
		this.janelaPrincipal.getMedicamentos().getBtnSalvar().addActionListener(this);
		this.janelaPrincipal.getMedicamentos().getBtnCancelar().addActionListener(this);
		this.janelaPrincipal.getMedicamentos().getBtnAtualizar().addActionListener(this);
		this.janelaPrincipal.getMedicamentos().getBtnRemover().addActionListener(this);
		this.janelaPrincipal.getMedicamentos().getCheckboxDipirona().setActionCommand("Dipirona");
		this.janelaPrincipal.getMedicamentos().getCheckboxFrutosdomar().setActionCommand("Frutos do Mar");
		this.janelaPrincipal.getMedicamentos().getCheckboxGluten().setActionCommand("Gluten");
		this.janelaPrincipal.getMedicamentos().getCheckboxPenicilina().setActionCommand("Penicilina");
	}
	
	public void cadastraMedicamento()
	{
		String codigoBarra = this.janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
		String nome = this.janelaPrincipal.getMedicamentos().getFieldNome().getText();
		int alergia2=0;
		String alergia = this.janelaPrincipal.getMedicamentos().getButtonGroup().getSelection().getActionCommand();
		Medicamento medicamento = new Medicamento(codigoBarra,nome,alergia2);
		medicamentoDAO.cadastraMedicamento(medicamento);
	}
	
	public void atualizaMedicamento()
	{
		String codigoBarra = this.janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
		String nome = this.janelaPrincipal.getMedicamentos().getFieldNome().getText();
		int alergia2=0;
		Medicamento medicamento = new Medicamento(codigoBarra,nome,alergia2);
		medicamentoDAO.atualizaMedicamento(medicamento);		
	}
	
	public void removeMedicamento()
	{
		String codigoBarra = this.janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
		Medicamento medicamento = new Medicamento(codigoBarra,null,0);
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
			this.janelaPrincipal.getMedicamentos().getFieldCodigodebarra().setText("");
			this.janelaPrincipal.getMedicamentos().getFieldNome().setText("");
			this.janelaPrincipal.getMedicamentos().getButtonGroup().clearSelection();
			this.janelaPrincipal.getCard().show(this.janelaPrincipal.getContentPane(), "panel");
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
	
	
	
}
