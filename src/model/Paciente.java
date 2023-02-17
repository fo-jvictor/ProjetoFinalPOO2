package model;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class Paciente {

	private String cpf;
	private String nome;
	private Date dataNascimento;
	private String alergia;
	private String unidade;
	private List<String> alergias;
	// private list<Medicamento> Medicamentos;

	public Paciente() {
	}

	public Paciente(String cpf, String nome, Date dataNascimento, String alergia, String unidade) {

		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.alergia = alergia;
		this.unidade = unidade;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", alergia=" + alergia
				+ "]";
	}

}
