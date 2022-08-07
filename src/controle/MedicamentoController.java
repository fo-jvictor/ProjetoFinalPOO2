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
	}
	
	public void cadastraMedicamento()
	{
		String codigoBarra = this.janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
		String nome = this.janelaPrincipal.getMedicamentos().getFieldNome().getText();
		String alergia = this.janelaPrincipal.getMedicamentos().getButtonGroup().getSelection().getActionCommand();
		Medicamento medicamento = new Medicamento(codigoBarra,nome,alergia);
		if(medicamentoDAO.cadastraMedicamento(medicamento))
		{
			limpaTela();
		}
	}
	
	public void atualizaMedicamento()
	{
		String codigoBarra = this.janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
		String nome = this.janelaPrincipal.getMedicamentos().getFieldNome().getText();
		String alergia = this.janelaPrincipal.getMedicamentos().getButtonGroup().getSelection().getActionCommand();
		Medicamento medicamento = new Medicamento(codigoBarra,nome,alergia);
		medicamentoDAO.atualizaMedicamento(medicamento);		
	}
	
	public void removeMedicamento()
	{
		String codigoBarra = this.janelaPrincipal.getMedicamentos().getFieldCodigodebarra().getText();
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
	
	public void limpaTela()
	{
		this.janelaPrincipal.getMedicamentos().getFieldCodigodebarra().setText("");
		this.janelaPrincipal.getMedicamentos().getFieldNome().setText("");
		this.janelaPrincipal.getMedicamentos().getButtonGroup().clearSelection();
	}
	
}
