package controle;

import model.PrescricaoMedicamento;
import visao.JanelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		janelaPrincipal.setVisible(true);		
		
		PacienteController pacienteController = new PacienteController(janelaPrincipal);
		MedicamentoController medicamentoController = new MedicamentoController(janelaPrincipal);
		AltaController altaController = new AltaController(janelaPrincipal);
		PrescricaoController prescricaoController = new PrescricaoController(janelaPrincipal);
		ListaInternadosController listaInternadosController = new ListaInternadosController(janelaPrincipal);
		UsuarioController usuarioController = new UsuarioController(janelaPrincipal);
		
	}
	
}
