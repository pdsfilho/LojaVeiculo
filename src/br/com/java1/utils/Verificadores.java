package br.com.java1.utils;

import java.util.List;

import br.com.java1.models.Cliente;
import br.com.java1.models.Pessoa;
import br.com.java1.models.Vendedor;

public class Verificadores {
//	public static <T> boolean verificarID(int id, List<T> list) {
//
//		for (T xT : list) {
//			if (id == ((Pessoa) xT).getId()) {
//				System.out.println("\nID já cadastrado, tente novamente\n");
//				return true;
//			}
//		}
//		return false;
//	}

	public static <T> boolean verificarCPF(String cpf, List<T> list) {

		for (T xT : list) {
			if (cpf.equals(((Pessoa) xT).getCpf())) {
				System.out.println("\nCPF já cadastrado, tente novamente\n");
				return true;
			}
		}
		return false;
	}
	
	public static boolean verificarRGcliente(String rg, List<Cliente> list) {

		for (Cliente xCliente : list) {
			if (rg.equals(xCliente.getRg())) {
				System.out.println("\nRG já cadastrado, tente novamente\n");
				return true;
			}
		}
		return false;
	}
	
	public static boolean verificarNumeroRegistroVendedor(String numRegistro, List<Vendedor> list) {

		for (Vendedor xVendedor : list) {
			if (numRegistro.equals(xVendedor.getNumeroRegistro())) {
				System.out.println("\nNúmero de registro já cadastrado, tente novamente\n");
				return true;
			}
		}
		return false;
	}


	public static Cliente consultarRG(String rg, List<Cliente> list) {
		for (Cliente xCliente : list) {
			if (rg.equals(xCliente.getRg())) {
				System.out.println("\nDADOS\n" + "\nID: " + xCliente.getId() + "\nNOME: " + xCliente.getNome()
						+ "\nRG: " + xCliente.getRg() + "\nCPF: " + xCliente.getCpf() + "\nTELEFONE: "
						+ xCliente.getTelefone());
				System.out.println("________________________________\n");
				return xCliente;
			}
		}
		System.out.println("\nNENHUM CLIENTE ENCONTRADO\n");
		return null;
	}
	
	public static Vendedor consultarNumeroRegistro(String numRegistro, List<Vendedor> list) {
		for (Vendedor xVendedor : list) {
			if (numRegistro.equals(xVendedor.getNumeroRegistro())) {
				System.out.println("\nDADOS\n" + "\nID: " + xVendedor.getId() + "\nNOME: " + xVendedor.getNome()
						+ "\nNÚMERO DE REGISTRO: " + xVendedor.getNumeroRegistro() + "\nCPF: " + xVendedor.getCpf() + "\nTELEFONE: "
						+ xVendedor.getTelefone());
				System.out.println("________________________________\n");
				return xVendedor;
			}
		}
		System.out.println("\nNENHUM VENDEDOR ENCONTRADO\n");
		return null;
	}
}
