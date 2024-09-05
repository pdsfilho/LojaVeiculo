package br.com.java1.utils;

import java.util.List;

import br.com.java1.models.Cliente;
import br.com.java1.models.Pessoa;
import br.com.java1.models.Vendedor;

public class Verificadores {
	
	//Método genérico utilizado nas classes cliente e vendedor para impedir duplicidade de CPFs
	public static <T> boolean verificarCPF(String cpf, List<T> list) {

		for (T xT : list) {
			if (cpf.equals(((Pessoa) xT).getCpf())) {
				System.out.println("\nCPF já cadastrado, tente novamente\n");
				return true;
			}
		}
		return false;
	}
	//Método que verifica se ja existe um RG igual cadastrado
	public static boolean verificarRGcliente(String rg, List<Cliente> list) {

		for (Cliente xCliente : list) {
			if (rg.equals(xCliente.getRg())) {
				System.out.println("\nRG já cadastrado, tente novamente\n");
				return true;
			}
		}
		return false;
	}
	//Método que verifica se ja existe um Número de registro igual cadastrado
	public static boolean verificarNumeroRegistroVendedor(String numRegistro, List<Vendedor> list) {

		for (Vendedor xVendedor : list) {
			if (numRegistro.equals(xVendedor.getNumeroRegistro())) {
				System.out.println("\nNúmero de registro já cadastrado, tente novamente\n");
				return true;
			}
		}
		return false;
	}
}
