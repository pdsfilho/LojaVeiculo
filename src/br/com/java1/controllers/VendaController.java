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
	List<Vendedor> vendedores = new ArrayList<Vendedor>();
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	Venda venda = new Venda();
	Cliente cliente = new Cliente();
	Vendedor vendedor = new Vendedor();
	Veiculo veiculo = new Veiculo();
	
	VeiculoController veiculoController = new VeiculoController();
	
	//Id da Venda começa com 1 para simular o auto incremento do SGBD.
	int idVenda = 1;
	
	public void cadastrar() {
		String opcao = "S";
		boolean aprovado = false;
	
		do {
			
			Scanner scan = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
			
			LocalDateTime data = java.time.LocalDateTime.now();
			
			//Venda
			//ID da Venda inserido automaticamente.
			System.out.println("ID DA NOVA VENDA: " + idVenda);
			venda.setId(idVenda);
			
			while (!aprovado) {
				System.out.println("\n INFORME O Nº DO REGISTRO DO VENDEDOR: ");
				String numeroRegistro = scan.nextLine();
				
				vendedor = Verificadores.consultarNumeroRegistro(numeroRegistro, vendedores);
				if (vendedor != null){
					venda.setVendedor(vendedor);
					aprovado = true;
				} 
			}
			
			aprovado = false;
			while (!aprovado) {
				System.out.println("\n INFORME A PLACA DO VEICULO: ");
				String placa = scan.nextLine();
				veiculo = veiculoController.buscarPorPlaca(placa);
				
				if (cliente != null) {
					venda.setVeiculo(veiculo);
					aprovado = true;
				} 
			}
			
			aprovado = false;
			while (!aprovado) {
				System.out.println("\n INFORME O RG DO CLIENTE: ");
				String rg = scan.nextLine();
				cliente = Verificadores.consultarRG(rg, clientes);
				if (cliente != null) {
					venda.setCliente(cliente);
					venda.setDataVenda(data);
					aprovado = true;
				} 
			}
			
			System.out.println("\n");
				
			vendas.add(new Venda(venda.getId(), venda.getVeiculo(), venda.getVendedor(),
					venda.getCliente(), venda.getDataVenda()));
			idVenda ++;
			
			System.out.println("\n DESEJA ADICIONAR OUTRA VENDA (S/N)? ");
			opcao = scan.nextLine();
		} while(opcao.equalsIgnoreCase("s"));
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
				
				System.out.println("________________________________\n");
				return v;
			}
		}
		System.out.println("LOJA NÃO ENCONTRADA.");
		return null;
	}
	
	public void excluir(int id) {
		
		try {
			vendas.remove(buscarPorId(id));
			System.out.println("LOJA "+ id + " DELETADA COM SUCESSO.");
		}
		catch (Exception e){
			System.out.println("ERRO AO EXCLUIR LOJA.");
		}
	}
}

