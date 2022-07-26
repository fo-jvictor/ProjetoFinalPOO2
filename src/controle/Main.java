package controle;

import visao.JanelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		janelaPrincipal.setVisible(true);
		
		PacienteController pacienteController = new PacienteController(janelaPrincipal);
		MedicamentoController medicamentoController = new MedicamentoController(janelaPrincipal);
		AltaController altaController = new AltaController(janelaPrincipal);
		
		
	}
	
}
