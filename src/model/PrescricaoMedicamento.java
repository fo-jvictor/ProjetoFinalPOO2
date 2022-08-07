package model;

import java.util.Date;

public class PrescricaoMedicamento {
	
	private String cpfpaciente;
	private String codbarraMedicamento;
	
	
	public PrescricaoMedicamento(String cpfpaciente, String codbarraMedicamento) {
		this.cpfpaciente = cpfpaciente;
		this.codbarraMedicamento = codbarraMedicamento;
	}		

	public String getCpfpaciente() {
		return cpfpaciente;
	}


	public void setCpfpaciente(String cpfpaciente) {
		this.cpfpaciente = cpfpaciente;
	}


	public String getCodbarraMedicamento() {
		return codbarraMedicamento;
	}


	public void setCodbarraMedicamento(String codbarraMedicamento) {
		this.codbarraMedicamento = codbarraMedicamento;
	}
	
	
	

}
