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
	int id = 1;

	public void cadastrar() {
		Cliente cliente = new Cliente();
		Scanner sc = new Scanner(System.in);
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
		id++;
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
	
	public void mostrarTudo() {
		Verificadores.mostrarTudoCliente(clientes);
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
		}
	}
}