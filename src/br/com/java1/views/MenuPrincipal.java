package br.com.java1.views;

import java.util.Scanner;

public class MenuPrincipal {
	
	public void menu() {
		boolean menuAtivo = true;
		int opcaoEscolhida;
		UI ui = new UI();
		
		do {
			System.out.println("Bem-Vindo ao Gerenciamento de Lojas Veiculares. "
					+ "\n Escolha uma das opções abaixo: "
					+ "\n *1- Frente da Loja "
					+ "\n *2- Manutenção no Cadastro "
					+ "\n *3- Sair ");
			
			
			Scanner scan = new Scanner(System.in);
			
			opcaoEscolhida = scan.nextInt();
			
			switch(opcaoEscolhida) {
				case 1:
					ui.frenteLoja();
					break;
				
				case 2:
					ui.manutencaoCadastro();
					break;
				
				default:
					menuAtivo = false;
			}
		}while(menuAtivo == true);
		
	}

}
