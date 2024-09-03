package br.com.java1.models;

import java.util.Objects;

public class TipoVeiculo {
	private int id;
	private String categoria;
	private String descricao;
	
	
	
	public TipoVeiculo(int id, String categoria, String descricao) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public TipoVeiculo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descricao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoVeiculo other = (TipoVeiculo) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricao, other.descricao)
				&& id == other.id;
	}
	
	
}
