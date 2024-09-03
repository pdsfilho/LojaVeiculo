package br.com.java1.utils;

import java.util.List;
import java.util.Scanner;

import br.com.java1.models.Cliente;
import br.com.java1.models.Vendedor;

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

	public static void alteracaoCliente(int resposta, Cliente cliente, List<Cliente> clientes) {
		Scanner sc = new Scanner(System.in);
		while (resposta != 5) {
			System.out.println("1 - RG\n2 - NOME\n3 - CPF\n4 - TELEFONE\n5 - SAIR\n");
			resposta = sc.nextInt();

			switch (resposta) {
			case 1:
				String novoRG = MetodosDeAlteracao.alterarRG();
				if (Validadores.validadorDeRegistros(novoRG) == false) {
					break;
				} else if (Verificadores.verificarRGcliente(novoRG, clientes) == true) {
					break;
				} else {
					cliente.setRg(novoRG);
					System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
				}
				break;
			case 2:
				String novoNome = MetodosDeAlteracao.alterarNome();
				cliente.setNome(novoNome);
				System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
				break;
			case 3:
				String novoCPF = MetodosDeAlteracao.alterarCPF();
				if (Validadores.validadorCpf(novoCPF) == false) {
					break;
				} else if (Verificadores.verificarCPF(novoCPF, clientes) == true) {
					break;
				} else {
					cliente.setCpf(novoCPF);
					System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
				}
				break;
			case 4:
				String novoTelefone = MetodosDeAlteracao.alterarTelefone();
				if (Validadores.validadorTelefone(novoTelefone) == false) {
					break;
				} else {
					cliente.setTelefone(novoTelefone);
					System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
				}
				break;
			case 5:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida, digite novamente\n");
				break;
			}
		}
	}

	public static void alteracaoVendedor(int resposta, Vendedor vendedor, List<Vendedor> vendedores) {
		Scanner sc = new Scanner(System.in);
		while (resposta != 5) {
			System.out.println("1 - Nº REGISTRO\n2 - NOME\n3 - CPF\n4 - TELEFONE\n5 - SAIR\n");
			resposta = sc.nextInt();

			switch (resposta) {
			case 1:
				String novoNRegistro = MetodosDeAlteracao.alterarRG();
				if (Validadores.validadorDeRegistros(novoNRegistro) == false) {
					break;
				} else if (Verificadores.verificarNumeroRegistroVendedor(novoNRegistro, vendedores) == true) {
					return;
				} else {
					vendedor.setNumeroRegistro(novoNRegistro);
					System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
				}
				break;
			case 2:
				String novoNome = MetodosDeAlteracao.alterarNome();
				vendedor.setNome(novoNome);
				System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
				break;
			case 3:
				String novoCPF = MetodosDeAlteracao.alterarCPF();
				if (Validadores.validadorCpf(novoCPF) == false) {
					break;
				} else if (Verificadores.verificarCPF(novoCPF, vendedores) == true) {
					break;
				} else {
					vendedor.setCpf(novoCPF);
					System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
				}
				break;
			case 4:
				String novoTelefone = MetodosDeAlteracao.alterarTelefone();
				if (Validadores.validadorTelefone(novoTelefone) == false) {
					break;
				} else {
					vendedor.setTelefone(novoTelefone);
					System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
				}
				break;
			case 5:
				System.out.println("Saindo...\n");
				break;
			default:
				System.out.println("Opção inválida, digite novamente\n");
				break;
			}
		}
	}
}
