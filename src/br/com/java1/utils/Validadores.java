package br.com.java1.utils;

public class Validadores {
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
		if (registros.matches("[^a-zA-Z]+")==false) {
			System.out.println("Dado inválido, digite novamente\n");
			return false;
		}
		return true;
	}
}
