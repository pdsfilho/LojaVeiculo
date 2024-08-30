package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.java1.models.Vendedor;
import br.com.java1.utils.MetodosDeAlteracao;
import br.com.java1.utils.Validadores;
import br.com.java1.utils.Verificadores;

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

		int id = 0;
		boolean entradaValida = false;
		while (entradaValida == false) {
			try {
				System.out.println("ID: ");
				id = sc.nextInt();
				entradaValida = true;
			} catch (java.util.InputMismatchException e) {
				sc.nextLine();
				System.out.println("Digite apenas números\n");
			}
		}
		sc.nextLine();
		if (Verificadores.verificarID(id, vendedores) == true) {
			return;
		}
		vendedor.setId(id);

		System.out.println("NÚMERO DE REGISTRO");
		String numRegistro = sc.nextLine();
		while (Validadores.validadorDeRegistros(numRegistro) == false) {
			System.out.println("NÚMERO DE REGISTRO");
			numRegistro = sc.nextLine();
		}
		if (Verificadores.verificarNºRegistroVendedor(numRegistro, vendedores)) {
			return;
		}
		vendedor.setNumeroRegistro(numRegistro);

		System.out.print("NOME: ");
		String nome = sc.nextLine().toUpperCase();
		vendedor.setNome(nome);

		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		while (Validadores.validadorCpf(cpf) == false) {
			cpf = sc.nextLine();
		}
		if (Verificadores.verificarCPF(cpf, vendedores) == true) {
			return;
		}
		vendedor.setCpf(cpf);

		System.out.print("TELEFONE: ");
		String telefone = sc.nextLine();
		while (Validadores.validadorTelefone(telefone) == false) {
			telefone = sc.nextLine();
		}
		vendedor.setTelefone(telefone);

		getVendedores().add(vendedor);
		System.out.println("\nCadastro realizado\n");
	}

	public void excluir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o Nº REGISTRO do vendedor");
		String numRegistro = sc.nextLine();
		Vendedor vendedor = Verificadores.consultarNumeroRegistro(numRegistro, vendedores);

		if (vendedor != null) {
			System.out.println("\nDigite 'S' para excluir ou 'N' para cancelar\n");
			String resposta = sc.nextLine();
			while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
				System.out.println("\nOpção inválida, tente novamente\n");
				resposta = sc.nextLine();
			}
			if (resposta.equalsIgnoreCase("s")) {
				getVendedores().remove(vendedor);
				System.out.println("Vendedor excluído com sucesso\n");
			}
		} else {
			System.out.println("\nVoltando ao menu principal\n");
			return;
		}
	}

	public void consultar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("DIGITE O Nº DE REGISTRO: ");
		String numRegistro = sc.nextLine();

		Verificadores.consultarNumeroRegistro(numRegistro, vendedores);
	}

	public void alterarDados() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nº REGISTRO: ");
		String numRegistro = sc.nextLine();

		int resposta = 0;
		Vendedor vendedor = Verificadores.consultarNumeroRegistro(numRegistro, vendedores);
		if (vendedor != null) {
			while (resposta != 5) {
				System.out.println("1 - Nº REGISTRO\n2 - NOME\n3 - CPF\n4 - TELEFONE\n5 - SAIR\n");
				resposta = sc.nextInt();

				switch (resposta) {
				case 1:
					String novoNºRegistro = MetodosDeAlteracao.alterarRG();
					if (Validadores.validadorDeRegistros(novoNºRegistro) == false) {
						break;
					} else if (Verificadores.verificarNºRegistroVendedor(novoNºRegistro, vendedores) == true) {
						return;
					} else {
						vendedor.setNumeroRegistro(novoNºRegistro);
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
}