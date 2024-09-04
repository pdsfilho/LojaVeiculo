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
	int id = 1;

	public void cadastrar() {
		Vendedor vendedor = new Vendedor();
		Scanner sc = new Scanner(System.in);

		vendedor.setId(id);

		System.out.println("NÚMERO DE REGISTRO");
		String numRegistro = sc.nextLine();
		//Método que verifica se o preenchimento do Número de registro não contém letras
		while (Validadores.validadorDeRegistros(numRegistro) == false) {
			System.out.println("NÚMERO DE REGISTRO");
			numRegistro = sc.nextLine();
		}
		//Método que verifica se ja existe um Número de registro igual cadastrado
		if (Verificadores.verificarNumeroRegistroVendedor(numRegistro, vendedores)) {
			return;
		}
		vendedor.setNumeroRegistro(numRegistro);

		System.out.print("NOME: ");
		String nome = sc.nextLine().toUpperCase();
		vendedor.setNome(nome);

		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		//Método para verificar se o CPF tem 11 digitos e não contém letras
		while (Validadores.validadorCpf(cpf) == false) {
			cpf = sc.nextLine();
		}
		//Método que verifica se já existe um CPF igual cadastrado
		if (Verificadores.verificarCPF(cpf, vendedores) == true) {
			return;
		}
		vendedor.setCpf(cpf);

		System.out.print("TELEFONE: ");
		String telefone = sc.nextLine();
		//Método para verificar se o telefone tem 11 digitos e não contém letras
		while (Validadores.validadorTelefone(telefone) == false) {
			telefone = sc.nextLine();
		}
		vendedor.setTelefone(telefone);

		vendedores.add(new Vendedor(id, nome, cpf, telefone, numRegistro));
		System.out.println("\nCadastro realizado\n");
		//Utilização de auto incremento para o ID
		id++;
	}

	public void excluir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o Nº REGISTRO do vendedor");
		String numRegistro = sc.nextLine();
		//Consulta um vendedor na lista e retorna esse vendedor
		Vendedor vendedor = Verificadores.consultarNumeroRegistro(numRegistro, vendedores);

		if (vendedor != null) {
			System.out.println("\nDigite 'S' para excluir ou 'N' para cancelar\n");
			String resposta = sc.nextLine();
			while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
				System.out.println("\nOpção inválida, tente novamente\n");
				resposta = sc.nextLine();
			}
			if (resposta.equalsIgnoreCase("s")) {
				vendedores.remove(vendedor);
				System.out.println("Vendedor excluído com sucesso\n");
			}
		} else {
			System.out.println("\nVoltando ao menu principal\n");
			return;
		}
	}
	
	public void mostrarTudo() {
		//Exibe a lista de todos os vendedores cadastrados
		Verificadores.mostrarTudoVendedor(vendedores);
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
			MetodosDeAlteracao.alteracaoVendedor(resposta, vendedor, vendedores);
		}
	}
}