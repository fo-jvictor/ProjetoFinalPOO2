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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salvar"))
		{
			cadastraMedicamento();
		}
		
	}
	
	
	
}
