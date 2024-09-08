package br.com.java1.models;

import java.util.Objects;

import br.com.java1.utils.Formatadores;

public class Vendedor extends Pessoa {
	
	private String numeroRegistro;
	
	public Vendedor(int id, String nome, String cpf, String telefone, String numeroRegistro) {
		super(id, nome, cpf, telefone);
		this.numeroRegistro = numeroRegistro;
	}

	public Vendedor() {}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
	public static String exibirDadosVendedor(Vendedor vendedor) {
		return "\nDADOS\n" + "\nID: " + vendedor.getId() + "\nNOME: " + vendedor.getNome()
		+ "\nNÚMERO DE REGISTRO: " + vendedor.getNumeroRegistro() + "\nCPF: " + Formatadores.formatarCpf(vendedor.getCpf())
		+ "\nTELEFONE: " + Formatadores.formatarTelefone(vendedor.getTelefone());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroRegistro);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(numeroRegistro, other.numeroRegistro);
	}
	
	
}
