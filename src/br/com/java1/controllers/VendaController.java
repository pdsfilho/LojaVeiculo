package br.com.java1.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.java1.models.Cliente;
import br.com.java1.models.Veiculo;
import br.com.java1.models.Venda;
import br.com.java1.models.Vendedor;

public class VendaController {
	List<Venda> vendas = new ArrayList<Venda>();
	
	Venda venda = new Venda();
	Cliente cliente = new Cliente();
	Vendedor vendedor = new Vendedor();
	Veiculo veiculo = new Veiculo();
	
	VeiculoController veiculoController = new VeiculoController();
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	//Id da Venda começa com 1 para simular o auto incremento do SGBD.
	int idVenda = 1;
	
	public void cadastrar(Veiculo veiculo, Vendedor vendedor, Cliente cliente) {

		boolean aprovado = false;
		
		venda.setId(idVenda);
		venda.setVeiculo(veiculo);
		venda.setVendedor(vendedor);
		venda.setCliente(cliente);
		LocalDateTime dataVenda = LocalDateTime.now();
		venda.setDataVenda(dataVenda);
		
		vendas.add(new Venda(venda.getId(), venda.getVeiculo(), venda.getVendedor(), 
				venda.getCliente(), venda.getDataVenda()));
		System.out.println("VENDA CADASTRADA COM SUCESSO\n");
	}
	
	public void buscarTudo() {
		
		for(Venda v : vendas) {
			System.out.println("\n ID DA VENDA: " + v.getId());
			System.out.println("\n VEÍCULO VENDIDO: " + Veiculo.exibirDadosVeiculo(v.getVeiculo()));
			System.out.println("\n VENDEDOR: " + Vendedor.exibirDadosVendedor(v.getVendedor()));
			System.out.println("\n CLIENTE: " + Cliente.exibirDadosCliente(v.getCliente()));
			System.out.println("\n DATA/HORA: " + v.getDataVenda().format(formatador));
			
			System.out.println("________________________________\n");
		}
	}
	
	public Venda buscarPorId(int id) {

		for(Venda v : vendas) {
			if (id == v.getId()) {
				System.out.println("\n ID DA VENDA: " + v.getId());
				System.out.println("\n VEÍCULO VENDIDO: " + Veiculo.exibirDadosVeiculo(v.getVeiculo()));
				System.out.println("\n VENDEDOR: " + Vendedor.exibirDadosVendedor(v.getVendedor()));
				System.out.println("\n CLIENTE: " + Cliente.exibirDadosCliente(v.getCliente()));
				System.out.println("\n DATA/HORA: " + v.getDataVenda().format(formatador));
				
				System.out.println("________________________________\n");
				return v;
			}
		}
		System.out.println("VENDA NÃO ENCONTRADA.");
		return null;
	}
	
	public void excluir(int id) {
		
		try {
			vendas.remove(buscarPorId(id));
			System.out.println("VENDA "+ id + " DELETADA COM SUCESSO.");
		}
		catch (Exception e){
			System.out.println("ERRO AO EXCLUIR VENDA.");
		}
	}
}

