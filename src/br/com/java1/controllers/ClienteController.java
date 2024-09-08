package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.java1.models.Cliente;
import br.com.java1.utils.Formatadores;
import br.com.java1.utils.MetodosDeAlteracao;
import br.com.java1.utils.Validadores;
import br.com.java1.utils.Verificadores;

public class ClienteController {
	List<Cliente> clientes = new ArrayList<Cliente>();
	private int id = 1;

	public void cadastrar() {
		Cliente cliente = new Cliente();
		Scanner sc = new Scanner(System.in);
		cliente.setId(id);

		System.out.println("RG COM 7 DIGITOS");
		String rg = sc.nextLine();
		// Método que verifica se o preenchimento do RG não contém letras
		while (Validadores.validadorDeRegistros(rg) == false) {
			System.out.println("RG");
			rg = sc.nextLine();
		}
		// Método que verifica se ja existe um RG igual cadastrado
		if (Verificadores.verificarRGcliente(rg, clientes)) {
			return;
		}
		cliente.setRg(rg);

		System.out.print("NOME: ");
		String nome = sc.nextLine().toUpperCase();
		// Impede que o nome tenha menos que 5 caracteres e números
		while (Validadores.validaNome(nome) == false) {
			nome = sc.nextLine();
		}
		cliente.setNome(nome);

		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		// Método para verificar se o CPF tem 11 digitos e não contém letras
		while (Validadores.validadorCpf(cpf) == false) {
			cpf = sc.nextLine();
		}
		// Método que verifica se já existe um CPF igual cadastrado
		if (Verificadores.verificarCPF(cpf, clientes) == true) {
			return;
		}
		cliente.setCpf(cpf);

		System.out.print("TELEFONE: ");
		String telefone = sc.nextLine();
		// Método para verificar se o telefone tem 11 digitos e não contém letras
		while (Validadores.validadorTelefone(telefone) == false) {
			telefone = sc.nextLine();
		}
		cliente.setTelefone(telefone);

		clientes.add(new Cliente(id, nome, cpf, telefone, rg));
		System.out.println("\nCadastro realizado\n");
		// Utilização de auto incremento para o ID
		id++;
	}

	public void excluir(String rg) {
		Scanner sc = new Scanner(System.in);

		// Consulta um cliente na lista e retorna esse cliente
		Cliente cliente = consultar(rg);
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
		System.out.println("DADOS CADASTRADOS\n");

		for (Cliente xCliente : clientes) {
			System.out.println("\nDADOS\n" + "\nID: " + xCliente.getId() + "\nNOME: " + xCliente.getNome()
			+ "\nRG: " + Formatadores.formatarRG(xCliente.getRg()) + "\nCPF: "
			+ Formatadores.formatarCpf(xCliente.getCpf()) + "\nTELEFONE: "
			+ Formatadores.formatarTelefone(xCliente.getTelefone())+"\n");
		}
	}

	public Cliente consultar(String rg) {

		for (Cliente xCliente : clientes) {
			if (rg.equals(xCliente.getRg())) {
				System.out.println("\nDADOS\n" + "\nID: " + xCliente.getId() + "\nNOME: " + xCliente.getNome()
						+ "\nRG: " + Formatadores.formatarRG(xCliente.getRg()) + "\nCPF: "
						+ Formatadores.formatarCpf(xCliente.getCpf()) + "\nTELEFONE: "
						+ Formatadores.formatarTelefone(xCliente.getTelefone()));
				System.out.println("________________________________\n");
				return xCliente;
			}
		}
		System.out.println("\nNENHUM CLIENTE ENCONTRADO\n");
		return null;
	}

	public void alterarDados(String rg) {
		Scanner sc = new Scanner(System.in);

		int resposta = 0;
		Cliente cliente = consultar(rg);
		if (cliente != null) {
			MetodosDeAlteracao.alteracaoCliente(resposta, cliente, clientes);
		}
	}
}