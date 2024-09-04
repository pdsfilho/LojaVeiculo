package br.com.java1.utils;

import java.util.Scanner;

import br.com.java1.models.Loja;
import br.com.java1.views.MenuPrincipal;

public class LojaUtils {
	public static void opcoesLoja(Loja loja, int o) {
		Scanner scan = new Scanner(System.in);
		
		switch (o) {
		case 1:
			String nome = scan.nextLine();
			loja.setNome(nome);
			break;
		
		case 2:
			String telefone = scan.nextLine();
			loja.setTelefone(telefone);
			break;
		
		case 3:
			String pais = scan.nextLine();
			loja.getEndereco().setPais(pais);
			break;
		
		case 4:
			String estado = scan.nextLine();
			loja.getEndereco().setEstado(estado);
			break;
		
		case 5:
			String cidade = scan.nextLine();
			loja.getEndereco().setCidade(cidade);
			break;
			
		case 6:
			String cep = scan.nextLine();
			loja.getEndereco().setCep(cep);
			
		case 7:
			String bairro = scan.nextLine();
			loja.getEndereco().setBairro(bairro);
			break;
		
		case 8:
			String rua = scan.nextLine();
			loja.getEndereco().setRua(rua);
			break;
		
		case 9:
			int numero = scan.nextInt();
			loja.getEndereco().setNumero(numero);
			break;
		
		default:
			System.out.println("OPÇÃO INVÁLIDA. VOLTANDO AO MENU PRINCIPAL.");
			MenuPrincipal.menu();
		}
	}
	
	public static boolean validaTelefone(String telefone) {
		if (telefone.length() == 11 && telefone.matches("[0-9]+")) {
			return true;
		}
		else {
			System.out.println("Telefone inválido, digite novamente\n");
			return false;
		}
			
	}

	public static boolean validaNome(String nome) {
		if (nome.length() <= 50) {
			return true;
		}
		else {
			System.out.println("Nome inválido, tente novamente.");
			return false;
		}
	}

	public static boolean validaTexto(String texto) {
		
		if (texto.length() <= 50 && texto.matches("[a-zA-Z\\s]+") == true){
			return true;
//			for (int i = 0; i < texto.length(); i++) {
//	            // Verifica se o caractere específico
//	            // não é uma letra e então
//	            // return false,
//	            // else return true
//	            if (!Character
//	                .isLetter(texto.charAt(i))) {
//	            	System.out.println("Dados inválidos, tente novamente.");
//	                return false;
	            }
		System.out.println("Dados inválidos, tente novamente.");
		return false;
	}

	public static boolean validaCep(String cep) {
		if (cep.length() == 8 && cep.matches("[0-9]+")) {
			return true;
		}
		else {
			System.out.println("CEP inválido, tente novamente.");
			return false;
		}
		
	}

	public static boolean validaNumero(Integer numero) {
		String numAux = numero.toString();
		if (numAux.length() <= 5 && numAux.matches("[0-9]+")) {
			return true;
		}
		return false;
	}
}
