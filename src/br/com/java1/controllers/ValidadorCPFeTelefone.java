package br.com.java1.controllers;

public class ValidadorCPFeTelefone {
	
	public static boolean validadorCpf(String cpf) {
		if (cpf.length()!=11) {
			return false;
		}
		return true;
	}
	
	public static boolean validadorTelefone(String telefone) {
		if (telefone.length()!=11) {
			return false;
		}
		return true;
	}

}
