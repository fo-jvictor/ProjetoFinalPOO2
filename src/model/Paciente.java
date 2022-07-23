package model;

import java.util.Date;

public class Paciente {

	private int cpf;
	private String nome;
	private Date dataNascimento;
	private int alergia;
	private int unidade;
	//private list<Medicamento> Medicamentos;
	
	public Paciente() {		
	}

	public Paciente(int cpf, String nome, Date dataNascimento, int alergia, int unidade) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.alergia = alergia;
		this.unidade=unidade;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getAlergia() {
		return alergia;
	}

	public void setAlergia(int alergia) {
		this.alergia = alergia;
	}	

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", alergia=" + alergia
				+ "]";
	}
	
	
	
}
