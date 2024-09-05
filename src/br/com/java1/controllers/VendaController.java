package br.com.java1.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.java1.models.Cliente;
import br.com.java1.models.Veiculo;
import br.com.java1.models.Venda;
import br.com.java1.models.Vendedor;
import br.com.java1.utils.Verificadores;

public class VendaController {
	List<Venda> vendas = new ArrayList<Venda>();
	
	Venda venda = new Venda();
	Cliente cliente = new Cliente();
	Vendedor vendedor = new Vendedor();
	Veiculo veiculo = new Veiculo();
	
	VeiculoController veiculoController = new VeiculoController();
	
	//Id da Venda começa com 1 para simular o auto incremento do SGBD.
	int idVenda = 1;
	
	public void cadastrar(Veiculo veiculo) {

		boolean aprovado = false;
		
		venda.setId(idVenda);
		venda.setVeiculo(veiculo);
		
	}
	
	public void buscarTudo() {
		
		for(Venda v : vendas) {
			System.out.println("\n ID DA VENDA: " + v.getId());
			System.out.println("\n VEÍCULO VENDIDO: " + v.getVeiculo());
			System.out.println("\n VENDEDOR: " + v.getVendedor());
			System.out.println("\n CLIENTE: " + v.getCliente());
			System.out.println("\n DATA/HORA: " + v.getDataVenda());
			
			System.out.println("________________________________\n");
		}
	}
	
	public Venda buscarPorId(int id) {

		for(Venda v : vendas) {
			if (id == v.getId()) {
				System.out.println("\n ID DA VENDA: " + v.getId());
				System.out.println("\n VEÍCULO VENDIDO: " + v.getVeiculo());
				System.out.println("\n VENDEDOR: " + v.getVendedor());
				System.out.println("\n CLIENTE: " + v.getCliente());
				System.out.println("\n DATA/HORA: " + v.getDataVenda());
				
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

