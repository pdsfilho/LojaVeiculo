package br.com.java1.views;

import java.util.Scanner;

import br.com.java1.utils.Validadores;

public class MenuPrincipal {
	static UI ui = new UI();
	public static void menu() {
		boolean menuAtivo = true;
		int opcaoEscolhida;
		
		
		do {
			System.out.println("Bem-Vindo ao Gerenciamento de Lojas Veiculares. \n"
					+ "\n Escolha uma das opções abaixo: "
					+ "\n *1- FRENTE DA LOJA. "
					+ "\n *2- MANUTENÇÃO DE CADASTROS. "
					+ "\n *3- PARA SAIR, PRESSIONE QUALQUER OUTRA TECLA. ");
			
			
			Scanner scan = new Scanner(System.in);
			
			opcaoEscolhida = Validadores.validadorDeMenu();
			
			switch(opcaoEscolhida) {
				case 1:
					ui.frenteLoja();
					break;
				
				case 2:
					ui.manutencaoCadastro();
					break;
				
				case 3:
					System.out.println("\n Até logo!");
					menuAtivo = false;
					scan.close();
					menuAtivo = false;
					break;
				default:
					System.out.println("Opção inválida \n");
					break;
			}
		}while(menuAtivo == true);
		
	}

}
