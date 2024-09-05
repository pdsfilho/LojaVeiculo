package br.com.java1.views;

import java.util.Scanner;

public class MenuPrincipal {
	static UI ui = new UI();
	public static void menu() {
		boolean menuAtivo = true;
		int opcaoEscolhida;
		
		
		do {
			System.out.println("Bem-Vindo ao Gerenciamento de Lojas Veiculares. "
					+ "\n Escolha uma das opções abaixo: "
					+ "\n *1- FRENTE DA LOJA. "
					+ "\n *2- MANUTENÇÃO DE CADASTROS. "
					+ "\n *3- PARA SAIR, PRESSIONE QUALQUER OUTRA TECLA. ");
			
			
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
					System.out.println("\n Até logo!");
					scan.close();
					menuAtivo = false;
			}
		}while(menuAtivo == true);
		
	}

}
