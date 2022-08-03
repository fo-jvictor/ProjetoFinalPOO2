package model;

import java.util.Date;
import java.util.InputMismatchException;

public class Paciente {

	private String cpf;
	private String nome;
	private Date dataNascimento;
	private int alergia;
	private int unidade;
	// private list<Medicamento> Medicamentos;

	public Paciente() {
	}

	public Paciente(String cpf, String nome, Date dataNascimento, int alergia, int unidade) {

		if (isCPF(cpf)) {
			this.cpf = cpf;
		}
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

	public static boolean isCPF(String CPF) // valida as entradas de CPF
	{
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return true;
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

}
