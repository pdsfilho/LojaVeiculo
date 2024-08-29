package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.java1.models.Cliente;
import br.com.java1.models.Vendedor;

public class VendedorController {
	List<Vendedor> vendedores = new ArrayList<Vendedor>();

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public void cadastrar() {
		Vendedor vendedor = new Vendedor();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ID: ");
		int id = sc.nextInt();
		vendedor.setId(id);
		sc.nextLine();

		for (Vendedor xVendedor : getVendedores()) {
			if (id == xVendedor.getId()) {
				System.out.println("\nID já cadastrado, tente novamente\n");
				return;
			}
		}

		System.out.println("NÚMERO DE REGISTRO");
		String numRegistro = sc.nextLine();
		vendedor.setNumeroRegistro(numRegistro);
		
		for (Vendedor xVendedor : getVendedores()) {
			if (numRegistro.equals(xVendedor.getNumeroRegistro())) {
				System.out.println("\nNúmero de registro já cadastrado, tente novamente\n");
				return;
			}
		}

		System.out.print("NOME: ");
		String nome = sc.nextLine().toUpperCase();
		vendedor.setNome(nome);
		
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		while (ValidadorCPFeTelefone.validadorCpf(cpf)==false) {
			System.out.println("CPF inválido, digite novamente");
			cpf = sc.nextLine();
		}
		vendedor.setCpf(cpf);

		for (Vendedor xVendedor : getVendedores()) {
			if (cpf.equals(xVendedor.getCpf())) {
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
		vendedor.setTelefone(telefone);
		
		getVendedores().add(vendedor);
		System.out.println("\nCadastro realizado\n");
	}

	public void excluir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o CPF do vendedor");
		String cpf = sc.nextLine();
		int i = -1;

		for (Vendedor xVendedor : getVendedores()) {
			if (xVendedor.getCpf().equals(cpf)) {
				i = getVendedores().indexOf(xVendedor);
				System.out.println("\nDADOS DO VENDEDOR\n" + "ID: " + xVendedor.getId() + "\nREGISTRO: "
						+ xVendedor.getNumeroRegistro() + "\nNOME: " + xVendedor.getNome() + "\nCPF: "
						+ xVendedor.getCpf() + "\nTELEFONE: " + xVendedor.getTelefone());
				System.out.println("________________________________\n");
			}
		}

		if (i > -1) {
			System.out.println("\nDigite s/n para excluir");
			String resposta = sc.nextLine();
			while(!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
				System.out.println("\nOpção inválida, tente novamente\n");
				resposta = sc.nextLine();
			}
			if (resposta.equalsIgnoreCase("s")) {
				getVendedores().remove(i);
				System.out.println("\nVendedor excluído\n");
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

		for (Vendedor xVendedor : vendedores) {
			if (xVendedor.getCpf().equals(cpf)) {
				System.out.println("\nDADOS DO VENDEDOR\n" + "ID: " + xVendedor.getId() + "\nREGISTRO: "
						+ xVendedor.getNumeroRegistro() + "\nNOME: " + xVendedor.getNome() + "\nCPF: "
						+ xVendedor.getCpf() + "\nTELEFONE: " + xVendedor.getTelefone());
				System.out.println("________________________________\n");
				validador = true;
			}
		}
		if (validador == false) {
			System.out.println("\nVendedor não encontrado\n");
		}
	}

	public void alterarDados() {
		Scanner sc = new Scanner(System.in);
		System.out.println("CPF: ");
		String cpf = sc.nextLine();

		for (Vendedor xVendedor : getVendedores()) {
			if (cpf.equals(xVendedor.getCpf())) {
				System.out.println("\nDADOS DO VENDEDOR\n" + "\nID: " + xVendedor.getId() + "\nNÚMERO DE REGISTRO: "
						+ xVendedor.getNumeroRegistro() + "\nNOME: " + xVendedor.getNome() + "\nCPF: "
						+ xVendedor.getCpf() + "\nTELEFONE: " + xVendedor.getTelefone() + "\n");

				System.out.println("ALTERAÇÃO DE DADOS\n");
				boolean validador = true;
				while (validador) {
					System.out.println("1 - ALTERAR ID\n" + "2 - NÚMERO DE REGISTRO\n" + "3 - NOME\n" + "4 - CPF\n"
							+ "5 - TELEFONE\n" + "6 - SAIR");
					int resposta = sc.nextInt();
					sc.nextLine();

					switch (resposta) {
					case 1:
						System.out.println("NOVO ID");
						int novoId = sc.nextInt();
						xVendedor.setId(novoId);
						System.out.println("\nID alterado com sucesso\n");
						break;

					case 2:
						System.out.println("NOVO NUMERO DE REGISTRO");
						String novoNumRegistro = sc.nextLine();
						xVendedor.setNumeroRegistro(novoNumRegistro);
						break;

					case 3:
						System.out.println("NOVO NOME");
						String novoNome = sc.nextLine().toUpperCase();
						xVendedor.setNome(novoNome);
						System.out.println("\nNome alterado com sucesso\n");
						break;

					case 4:
						System.out.println("NOVO CPF");
						String novoCPF = sc.nextLine();
						xVendedor.setCpf(novoCPF);
						System.out.println("\nCPF alterado com sucesso\n");
						break;

					case 5:
						System.out.println("NOVO TELEFONE");
						String novoTelefone = sc.nextLine();
						xVendedor.setTelefone(novoTelefone);
						System.out.println("\nTelefone alterado com sucesso\n");
						break;

					case 6:
						System.out.println("Saindo...\n");
						validador = false;
						return;

					default:
						System.out.println("Opção inválida");
						break;
					}
				}
			}
		}
	}
}
