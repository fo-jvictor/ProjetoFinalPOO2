package model;

public class Alta {
	
	private String cpfPaciente;
	private String motivoAlta;
	
	public Alta(String cpfPaciente, String motivoAlta) {
		super();
		this.cpfPaciente = cpfPaciente;
		this.motivoAlta = motivoAlta;
	}
	
	public String getCpfPaciente() {
		return cpfPaciente;
	}
	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}
	public String getMotivoAlta() {
		return motivoAlta;
	}
	public void setMotivoAlta(String motivoAlta) {
		this.motivoAlta = motivoAlta;
	}

	
	
}
