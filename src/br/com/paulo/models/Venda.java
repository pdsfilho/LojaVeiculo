package br.com.paulo.models;

import java.util.Date;
import java.util.Objects;

public class Venda {
	
	private int id;
	private Veiculo veiculo;
	private Vendedor vendedor;
	private Cliente cliente;
	private Date dataVenda;
	
	public Venda() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dataVenda, id, veiculo, vendedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dataVenda, other.dataVenda) && id == other.id
				&& Objects.equals(veiculo, other.veiculo) && Objects.equals(vendedor, other.vendedor);
	}
	
	
}
