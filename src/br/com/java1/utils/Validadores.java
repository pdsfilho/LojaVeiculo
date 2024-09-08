package br.com.java1.utils;

import java.util.Scanner;

public class Validadores {
	
	public static int validadorDeMenu() {
		Scanner scan = new Scanner(System.in);
		int opcaoEscolhida = 0;
		boolean validador = false;
		while (validador == false) {
			try {
				opcaoEscolhida = scan.nextInt();
				scan.nextLine();
				validador = true;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Opção inválida, digite apenas números\nDigite a opção novamente");
				scan.nextLine();
			}
		}
		return opcaoEscolhida;
	}
	
	public static boolean validaNome(String nome) {
		if (nome.length()<5 && nome.matches("[a^-zA-Z\\s]+")) {
			System.out.println("Nome inválido");
			return false;
		}
		return true;
	}
	//Verifica se o CPF contém 11 digitos e não contém letras
	public static boolean validadorCpf(String cpf) {
		if (cpf.length()!=11 || cpf.matches("[^a-zA-Z]+")==false) {
			System.out.println("CPF inválido, digite novamente\n");
			return false;
		}
		return true;
	}
	//Verifica se o telefone contém 11 digitos e não contém letras
	public static boolean validadorTelefone(String telefone) {
		if (telefone.length()!=11 || telefone.matches("[^a-zA-Z]+")==false) {
			System.out.println("Telefone inválido, digite novamente\n");
			return false;
		}
		return true;
	}
	//Verifica se o RG e Número de registro não contém letras
	public static boolean validadorDeRegistros(String registros) {
		if (registros.matches("[^a-zA-Z]+")==false && registros.length()!=7) {
			System.out.println("Dado inválido, digite novamente\n");
			return false;
		}
		return true;
	}
}
