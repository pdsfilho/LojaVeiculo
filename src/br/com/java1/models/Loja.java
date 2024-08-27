package br.com.java1.models;

import java.util.Objects;

public class Loja {
	private int id;
	private String nome;
	private String telefone;
	private Endereco endereco;
	
	public Loja() {}

	public Loja(int id, String nome, String telefone, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(endereco, other.endereco) && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	
	
	
}
