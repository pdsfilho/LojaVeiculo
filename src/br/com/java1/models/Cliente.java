package br.com.java1.models;

import java.util.Objects;

import br.com.java1.utils.Formatadores;

public class Cliente extends Pessoa{
	
	private String rg;

	public Cliente(int id, String nome, String cpf, String telefone, String rg) {
		super(id, nome, cpf, telefone);
		this.rg = rg;
	}

	public Cliente() {
		super();
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public static String exibirDadosCliente(Cliente cliente) {
		return "\nID: " + cliente.getId() + "\nNOME: " + cliente.getNome()
		+ "\nRG: " + Formatadores.formatarRG(cliente.getRg()) + "\nCPF: "
		+ Formatadores.formatarCpf(cliente.getCpf()) + "\nTELEFONE: "
		+ Formatadores.formatarTelefone(cliente.getTelefone());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(rg);
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
		Cliente other = (Cliente) obj;
		return Objects.equals(rg, other.rg);
	}
	
	
}
