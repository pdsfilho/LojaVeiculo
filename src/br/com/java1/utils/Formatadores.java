package br.com.java1.utils;

public class Formatadores {
	public static String formatarCpf(String cpf) {
		return cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}
	
	public static String formatarRG(String rg) {
		return rg.replaceFirst("(\\d{1})(\\d{3})(\\d{3})", "$1.$2.$3");
	}
	
	public static String formatarTelefone(String telefone) {
		return telefone.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1)$2-$3");
	}
	
	public static String formatarCEP(String cep) {
		return cep.replaceFirst("(\\d{2})(\\d{3})(\\d{3})", "$1.$2-$3");
	}

}
