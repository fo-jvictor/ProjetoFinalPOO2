package model;

import java.util.List;

public class Medicamento {

	private String codigoBarra;
	private String nome;
	private List<String> alergias;
	
	public Medicamento() {
		
	}

	public Medicamento(String codigoBarra, String nome, List<String> alergias) {
		super();
		this.codigoBarra = codigoBarra;
		this.nome = nome;
		this.alergias = alergias;
	}

	@Override
	public String toString() {
		return "Medicamento [codigoBarra=" + codigoBarra + ", nome=" + nome + ", alergia=" + alergias + "]";
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

	public List<String> getAlergias() {
		return alergias;
	}
		
}
