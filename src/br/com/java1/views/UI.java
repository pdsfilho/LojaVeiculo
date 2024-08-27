package br.com.java1.views;

import java.util.Scanner;

import br.com.java1.controllers.ClienteController;
import br.com.java1.controllers.LojaController;
import br.com.java1.controllers.VendedorController;

public class UI {
	
	MenuPrincipal menuPrincipal = new MenuPrincipal();
	LojaController lojaController = new LojaController();
	ClienteController clienteController = new ClienteController();
	VendedorController vendedorController = new VendedorController();
	//VendaController vendaController = new VendaController();
	//VeiculoController veiculoController = new VeiculoController();
	
	public void frenteLoja() {

		int opcaoEscolhida;
		
		System.out.println("Frente da Loja. "
				+ "\n Escolha Entre as Opções Abaixo: "
				+ "\n *1- Gerenciar Veículo. "
				+ "\n *2- Gerenciar Loja. "
				+ "\n *3- Gerenciar Vendedor. "
				+ "\n *4- Gerenciar Cliente."
				+ "\n *5- Gerenciar Venda. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch(opcaoEscolhida) {
			case 1:
				gerenciarVeiculo();
				break;
			
			case 2:
				gerenciarLoja();
				break;
			
			case 3:
				gerenciarVendedor();
				break;
			
			case 4:
				gerenciarCliente();
				break;
			
			case 5:
				gerenciarVenda();
				break;
				
			default:
				menuPrincipal.menu();
		}
	}
	
	public void manutencaoCadastro() {
		int opcaoEscolhida;
		
		System.out.println("Manutenção de Cadastros. "
				+ "\n *1- Manutenção Veículo. "
				+ "\n *2- Manutenção Loja. "
				+ "\n *3- Manutenção Vendedor. "
				+ "\n *4- Manutenção Cliente. "
				+ "\n *5- Manutenção Venda. "
				+ "\n *6- Voltar.");
		
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch(opcaoEscolhida) {
			case 1:
				manutencaoVeiculo();
				break;
			
			case 2:
				manutencaoLoja();
				break;
			
			case 3:
				manutencaoVendedor();
				break;
			
			case 4:
				manutencaoCliente();
				break;
			
			case 5:
				manutencaoVenda();
				break;
				
			default:
				menuPrincipal.menu();
		}
		
	}
	
	public void gerenciarVeiculo() {
		int opcaoEscolhida;
		//VeiculoController veiculoController = new VeiculoController();
		
		System.out.println(
				"\n *1- CONSULTAR VEÍCULO POR PLACA. "
				+ "\n *2- VOLTAR AO MENU ANTERIOR. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				//veiculoController.buscar();
				break;
			
			default:
				menuPrincipal.menu();
	
		}
	}
	
	public void gerenciarVendedor() {
		int opcaoEscolhida;
		
		
		System.out.println(
				"\n *1- CONSULTAR VENDEDOR POR NOME. "
				+ "\n *2- VOLTAR AO MENU ANTERIOR. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				vendedorController.buscar();
				break;
			
			default:
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.menu();
	
		}
	}
	
	public void gerenciarCliente() {
		int opcaoEscolhida;
		
		System.out.println(
				"\n *1- LISTAR TODOS OS CLIENTES. "
				+ "\n *2- VOLTAR. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				clienteController.consultar();
				break;
			
			default:
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.menu();
	
		}
	}
	
	public void gerenciarLoja() {
		int opcaoEscolhida;
		int id;
		
		System.out.println(
				"\n *1- LISTAR TODAS AS LOJAS. "
				+ "\n *2- BUSCAR LOJA POR ID."
				+ "\n *3- Voltar.");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				lojaController.buscarTudo();
				break;
			
			case 2:
				System.out.println("Informe o ID: ");
				id = scan.nextInt();
				lojaController.buscarPorId(id);
			
			default:
				menuPrincipal.menu();
		}
	}
	
	public void gerenciarVenda() {
		int opcaoEscolhida;
		
		
		System.out.println(
				"\n *1- CADASTRAR VENDA. "
				+ "\n *2- VOLTAR AO MENU SUPERIOR. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				//vendaController.buscarVendas();
				break;
			
			default:
				
				menuPrincipal.menu();
	
		}
	}
	
	public void manutencaoVeiculo() {
		
	}
	public void manutencaoLoja() {
		int opcaoEscolhida;
		int id;
		System.out.println(
				"\n *1- CADASTRAR LOJA. "
				+ "\n *2- EXCLUIR LOJA. "
				+ "\n *3- ALTERAR DADOS DA LOJA. "
				+ "\n *4- VOLTAR. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				lojaController.cadastrar();
				break;
			
			case 2:
				System.out.println("INFORME O ID: ");
				id = scan.nextInt();
				lojaController.excluir(id);
				break;
			
			case 3:
				System.out.println("INFORME O ID: ");
				id = scan.nextInt();
				lojaController.alterar(id);
				break;
			
			default:
				menuPrincipal.menu();
		}
	}

	public void manutencaoVendedor() {
		int opcaoEscolhida;
		int id;
		System.out.println(
				"\n *1- CADASTRAR VENDEDOR. "
				+ "\n *2- EXCLUIR VENDEDOR. "
				+ "\n *3- ALTERAR DADOS DO VENDEDOR. "
				+ "\n *4- VOLTAR. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				clienteController.cadastrar();
				break;
			
			case 2:
				clienteController.excluir();
				break;
			
			case 3:
				clienteController.alterarDados();
				break;
			
			default:
				menuPrincipal.menu();
		}
	}
	public void manutencaoCliente() {
		int opcaoEscolhida;
		int id;
		System.out.println(
				"\n *1- CADASTRAR CLIENTE. "
				+ "\n *2- EXCLUIR CLIENTE. "
				+ "\n *3- ALTERAR DADOS DO CLIENTE. "
				+ "\n *4- VOLTAR. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				clienteController.cadastrar();
				break;
			
			case 2:
				clienteController.excluir();
				break;
			
			case 3:
				clienteController.alterarDados();
				break;
			
			default:
				menuPrincipal.menu();
		}
	}
	public void manutencaoVenda() {
		
	}
}
