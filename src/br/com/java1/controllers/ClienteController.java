package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.java1.models.Cliente;
import br.com.java1.utils.MetodosDeAlteracao;
import br.com.java1.utils.Validadores;
import br.com.java1.utils.Verificadores;

public class ClienteController {
	List<Cliente> clientes = new ArrayList<Cliente>();
	int id = 0;

	public void cadastrar() {
		Cliente cliente = new Cliente();
		Scanner sc = new Scanner(System.in);

		id++;
//		boolean entradaValida = false;
//
//		while (entradaValida == false) {
//			try {
//				System.out.println("ID: ");
//				id = sc.nextInt();
//				entradaValida = true;
//			} catch (java.util.InputMismatchException e) {
//				sc.nextLine();
//				System.out.println("Digite apenas números\n");
//			}
//		}
//		sc.nextLine();
//		if (Verificadores.verificarID(id, clientes) == true) {
//			return;
//		}
		cliente.setId(id);

		System.out.println("RG");
		String rg = sc.nextLine();
		while (Validadores.validadorDeRegistros(rg) == false) {
			System.out.println("RG");
			rg = sc.nextLine();
		}

		if (Verificadores.verificarRGcliente(rg, clientes)) {
			return;
		}
		cliente.setRg(rg);

		System.out.print("NOME: ");
		String nome = sc.nextLine().toUpperCase();
		cliente.setNome(nome);

		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		while (Validadores.validadorCpf(cpf) == false) {
			cpf = sc.nextLine();
		}

		if (Verificadores.verificarCPF(cpf, clientes) == true) {
			return;
		}
		cliente.setCpf(cpf);

		System.out.print("TELEFONE: ");
		String telefone = sc.nextLine();
		while (Validadores.validadorTelefone(telefone) == false) {
			telefone = sc.nextLine();
		}
		cliente.setTelefone(telefone);

		clientes.add(new Cliente(id, nome, cpf, telefone, rg));
		System.out.println("\nCadastro realizado\n");
	}

	public void excluir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o RG do cliente");
		String rg = sc.nextLine();
		Cliente cliente = Verificadores.consultarRG(rg, clientes);
		if (cliente != null) {
			System.out.println("\nDigite 'S' para excluir ou 'N' para cancelar\n");
			String resposta = sc.nextLine();
			while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
				System.out.println("\nOpção inválida, tente novamente\n");
				resposta = sc.nextLine();
			}
			if (resposta.equalsIgnoreCase("s")) {
				clientes.remove(cliente);
				System.out.println("Cliente excluído com sucesso\n");
			}
		} else {
			System.out.println("\nVoltando ao menu principal\n");
			return;
		}
	}

	public void consultar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o RG: ");
		String rg = sc.nextLine();

		Verificadores.consultarRG(rg, clientes);
	}

	public void alterarDados() {
		Scanner sc = new Scanner(System.in);
		System.out.println("RG: ");
		String rg = sc.nextLine();
		int resposta = 0;
		Cliente cliente = Verificadores.consultarRG(rg, clientes);
		if (cliente != null) {
			MetodosDeAlteracao.alteracaoCliente(resposta, cliente, clientes);
//			while (resposta != 5) {
//				System.out.println("1 - RG\n2 - NOME\n3 - CPF\n4 - TELEFONE\n5 - SAIR\n");
//				resposta = sc.nextInt();
//
//				switch (resposta) {
//				case 1:
//					String novoRG = MetodosDeAlteracao.alterarRG();
//					if (Validadores.validadorDeRegistros(novoRG) == false) {
//						break;
//					} else if (Verificadores.verificarRGcliente(novoRG, clientes) == true) {
//						break;
//					} else {
//						cliente.setRg(novoRG);
//						System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
//					}
//					break;
//				case 2:
//					String novoNome = MetodosDeAlteracao.alterarNome();
//					cliente.setNome(novoNome);
//					System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
//					break;
//				case 3:
//					String novoCPF = MetodosDeAlteracao.alterarCPF();
//					if (Validadores.validadorCpf(novoCPF) == false) {
//						break;
//					} else if (Verificadores.verificarCPF(novoCPF, clientes) == true) {
//						break;
//					} else {
//						cliente.setCpf(novoCPF);
//						System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
//					}
//					break;
//				case 4:
//					String novoTelefone = MetodosDeAlteracao.alterarTelefone();
//					if (Validadores.validadorTelefone(novoTelefone) == false) {
//						break;
//					} else {
//						cliente.setTelefone(novoTelefone);
//						System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO\n");
//					}
//					break;
//				case 5:
//					System.out.println("Saindo...");
//					break;
//				default:
//					System.out.println("Opção inválida, digite novamente\n");
//					break;
//				}
//			}
		}
	}
}