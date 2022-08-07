package model;

public class Medicamento {

	private String codigoBarra;
	private String nome;
	private String alergia;
	
	public Medicamento() {
		
	}

	public Medicamento(String codigoBarra, String nome, String alergia) {
		super();
		this.codigoBarra = codigoBarra;
		this.nome = nome;
		this.alergia = alergia;
	}

	@Override
	public String toString() {
		return "Medicamento [codigoBarra=" + codigoBarra + ", nome=" + nome + ", alergia=" + alergia + "]";
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	
	
	
	
}
