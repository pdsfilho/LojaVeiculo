package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.java1.models.Cliente;
import br.com.java1.models.Vendedor;

public class ClienteController {
	List<Cliente> clientes = new ArrayList<Cliente>();

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void cadastrar() {
		Cliente cliente = new Cliente();
		Scanner sc = new Scanner(System.in);

		System.out.println("ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		cliente.setId(id);

		for (Cliente xCliente : getClientes()) {
			if (id == xCliente.getId()) {
				System.out.println("\nID já cadastrado, tente novamente\n");
				return;
			}
		}

		System.out.println("NÚMERO DE REGISTRO");
		String rg = sc.nextLine();
		cliente.setRg(rg);
		for (Cliente xCliente : getClientes()) {
			if (rg.equals(xCliente.getRg())) {
				System.out.println("\nRG já cadastrado, tente novamente\n");
				return;
			}
		}

		System.out.print("NOME: ");
		String nome = sc.nextLine().toUpperCase();
		cliente.setNome(nome);
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		while (ValidadorCPFeTelefone.validadorCpf(cpf) == false) {
			System.out.println("CPF inválido, digite novamente");
			cpf = sc.nextLine();
		}
		cliente.setCpf(cpf);

		for (Cliente xCliente : getClientes()) {
			if (cpf.equals(xCliente.getCpf())) {
				System.out.println("\nCPF já cadastrado, tente novamente\n");
				return;
			}
		}

		System.out.print("TELEFONE: ");
		String telefone = sc.nextLine();
		while (ValidadorCPFeTelefone.validadorTelefone(telefone) == false) {
			System.out.println("Telefone inválido, digite novamente");
			telefone = sc.nextLine();
		}
		cliente.setTelefone(telefone);
		getClientes().add(cliente);
		System.out.println("\nCadastro realizado\n");
	}

	public void excluir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente");
		String cpf = sc.nextLine();
		int i = -1;

		for (Cliente xCliente : getClientes()) {
			if (xCliente.getCpf().equals(cpf)) {
				i = getClientes().indexOf(xCliente);
				System.out.println("\nDADOS DO CLIENTE\n" + "\nID: " + xCliente.getId() + "\nRG: " + xCliente.getRg()
						+ "\nNOME: " + xCliente.getNome() + "\nCPF: " + xCliente.getCpf() + "\nTELEFONE: "
						+ xCliente.getTelefone());
			}
		}

		if (i > -1) {
			System.out.println("\nDigite 'S' para excluir ou 'N' para cancelar\n");
			String resposta = sc.nextLine();
			while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
				System.out.println("\nOpção inválida, tente novamente\n");
				resposta = sc.nextLine();
			}
			if (resposta.equalsIgnoreCase("s")) {
				getClientes().remove(i);
				System.out.println("Cliente excluído com sucesso\n");
			} else {
				System.out.println("\nVoltando ao menu principal\n");
				return;
			}
		}

	}

	public void consultar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o CPF: ");
		String cpf = sc.nextLine();
		boolean validador = false;

		for (Cliente xCliente : clientes) {
			if (cpf.equals(xCliente.getCpf())) {
				System.out.println("\nDADOS DO CLIENTE\n" + "\nID: " + xCliente.getId() + "\nRG: " + xCliente.getRg()
						+ "\nNOME: " + xCliente.getNome() + "\nCPF: " + xCliente.getCpf() + "\nTELEFONE: "
						+ xCliente.getTelefone());
				System.out.println("________________________________\n");
				validador = true;
			}
		}

		if (validador == false) {
			System.out.println("\nCliente não encontrado\n");
		}
	}

	public void alterarDados() {
		Scanner sc = new Scanner(System.in);
		System.out.println("CPF: ");
		String cpf = sc.nextLine();

		for (Cliente xCliente : getClientes()) {
			if (cpf.equals(xCliente.getCpf())) {
				System.out.println("\nDADOS DO CLIENTE\n" + "\nID: " + xCliente.getId() + "\nRG: " + xCliente.getRg()
						+ "\nNOME: " + xCliente.getNome() + "\nCPF: " + xCliente.getCpf() + "\nTELEFONE: "
						+ xCliente.getTelefone() + "\n");

				System.out.println("ALTERAÇÃO DE DADOS\n");
				boolean validador = true;
				while (validador) {
					System.out.println("1 - ALTERAR ID\n" + "2 - RG\n" + "3 - NOME\n" + "4 - CPF\n" + "5 - TELEFONE\n"
							+ "6 - SAIR");
					int resposta = sc.nextInt();
					sc.nextLine();

					switch (resposta) {
					case 1:
						System.out.println("NOVO ID");
						int novoId = sc.nextInt();
						xCliente.setId(novoId);
						System.out.println("\nID alterado com sucesso\n");
						break;

					case 2:
						System.out.println("NOVO RG");
						String novoRg = sc.nextLine();
						xCliente.setRg(novoRg);
						System.out.println("\nRG alterado com sucesso\n");
						break;

					case 3:
						System.out.println("NOVO NOME");
						String novoNome = sc.nextLine().toUpperCase();
						xCliente.setNome(novoNome);
						System.out.println("\nNome alterado com sucesso\n");
						break;

					case 4:
						System.out.println("NOVO CPF");
						String novoCPF = sc.nextLine();
						xCliente.setCpf(novoCPF);
						System.out.println("\nCPF alterado com sucesso\n");
						break;

					case 5:
						System.out.println("NOVO TELEFONE");
						String novoTelefone = sc.nextLine();
						xCliente.setTelefone(novoTelefone);
						System.out.println("\nTelefone alterado com sucesso\n");
						break;

					case 6:
						System.out.println("Saindo...\n");
						validador = false;
						return;

					default:
						System.out.println("Opção inválida, tente novamente");
					}

				}

			} else {
				System.out.println("Cliente não encontrado");
				return;
			}
		}
	}
}
