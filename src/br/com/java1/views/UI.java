package br.com.java1.views;

import java.util.Scanner;

import br.com.java1.controllers.LojaController;

public class UI {
	
	MenuPrincipal menuPrincipal = new MenuPrincipal();
	LojaController lojaController = new LojaController();
	//VendedorController vendedorController = new VendedorController();
	//VendaController vendaController = new VendaController();
	
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
				//vendedorController.buscar();
				break;
			
			default:
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.menu();
	
		}
	}
	
	public void gerenciarCliente() {
		int opcaoEscolhida;
		
		System.out.println(
				"\n *1- Listar Todas as Lojas. "
				+ "\n *2- Voltar ao Menu Superior. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				//clienteController.buscar();
				break;
			
			default:
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.menu();
	
		}
	}
	
	public void gerenciarLoja() {
		int opcaoEscolhida;
		
		System.out.println(
				"\n *1- Listar Todas as Lojas. "
				+ "\n *2- Voltar ao Menu Superior. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				lojaController.buscarTudo();
				break;
			
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
		
		System.out.println(
				"\n *1- Cadastrar Loja. "
				+ "\n *2- Excluir Loja. "
				+ "\n *3- Alterar Dados Loja. "
				+ "\n *4- Voltar. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				lojaController.cadastrar();
				break;
			
			case 2:
				lojaController.excluir();
				break;
			
			case 3:
				lojaController.alterar();
				break;
			
			default:
				menuPrincipal.menu();
		}
	}

	
	public void manutencaoVendedor() {
		
	}
	public void manutencaoCliente() {
		
	}
	public void manutencaoVenda() {
		
	}
}
