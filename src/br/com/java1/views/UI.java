package br.com.java1.views;

import java.util.Scanner;

import br.com.java1.controllers.LojaController;

public class UI {
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
				MenuPrincipal menuPrincipal = new MenuPrincipal();
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
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.menu();
		}
		
	}
	
	public void gerenciarVeiculo() {
		
	}
	
	public void gerenciarVendedor() {
		
	}
	
	public void gerenciarCliente() {
		
	}
	
	public void gerenciarLoja() {
		int opcaoEscolhida;
		//LojaController lojaController = new LojaController();
		
		System.out.println(
				"\n *1- Listar Todas as Lojas. "
				+ "\n *2- Voltar ao Menu Superior. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				//lojaController.buscarLojas();
				break;
			
			default:
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.menu();
	
		}
	}
	
	public void gerenciarVenda() {
		
	}
	
	public void manutencaoVeiculo() {
		
	}
	public void manutencaoLoja() {
		int opcaoEscolhida;
		//LojaController lojaController = new LojaController();
		
		System.out.println(
				"\n *1- Cadastrar Loja. "
				+ "\n *2- Excluir Loja. "
				+ "\n *3- Alterar Dados Loja. "
				+ "\n *4- Voltar. ");
		
		Scanner scan = new Scanner(System.in);
		
		opcaoEscolhida = scan.nextInt();
		
		switch (opcaoEscolhida) {
			case 1:
				//lojaController.cadastrarLoja();
				break;
			
			case 2:
				//lojaController.excluirLoja();
				break;
			
			case 3:
				//lojaController.alterarLoja();
				break;
			
			default:
				MenuPrincipal menuPrincipal = new MenuPrincipal();
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
