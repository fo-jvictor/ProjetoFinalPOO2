package controle;

import visao.JanelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		var janelaPrincipal = new JanelaPrincipal();
		janelaPrincipal.setVisible(true);		
		
		var pacienteController = new PacienteController(janelaPrincipal);
		var medicamentoController = new MedicamentoController(janelaPrincipal);
		var altaController = new AltaController(janelaPrincipal);
		var prescricaoController = new PrescricaoController(janelaPrincipal);
		var listaInternadosController = new ListaInternadosController(janelaPrincipal);
		var usuarioController = new UsuarioController(janelaPrincipal);
		
	}
	
}
