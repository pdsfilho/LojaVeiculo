package br.com.java1.utils;

import java.util.Scanner;

public class MetodosDeAlteracao {

	public static String alterarRG() {
			Scanner sc = new Scanner(System.in);
			System.out.println("NOVO RG");
			String rg = sc.nextLine();
			return rg;
		}
		
		public static String alterarNome() {
			Scanner sc = new Scanner(System.in);
			System.out.println("NOVO NOME");
			String nome = sc.nextLine();
			return nome;
		}
		
		public static String alterarCPF() {
			Scanner sc = new Scanner(System.in);
			System.out.println("NOVO CPF");
			String cpf = sc.nextLine();
			return cpf;
		}
		
		public static String alterarTelefone() {
			Scanner sc = new Scanner(System.in);
			System.out.println("NOVO NÚMERO");
			String telefone = sc.nextLine();
			return telefone;
		}

}
