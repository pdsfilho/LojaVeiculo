package br.com.java1.views;

import java.util.Scanner;

import br.com.java1.controllers.ClienteController;
import br.com.java1.controllers.LojaController;
import br.com.java1.controllers.VeiculoController;
import br.com.java1.controllers.VendaController;
import br.com.java1.controllers.VendedorController;
import br.com.java1.models.Cliente;
import br.com.java1.models.Veiculo;
import br.com.java1.models.Vendedor;
import br.com.java1.utils.Validadores;

public class UI {

	LojaController lojaController = new LojaController();
	ClienteController clienteController = new ClienteController();
	VendedorController vendedorController = new VendedorController();
	VendaController vendaController = new VendaController();
	VeiculoController veiculoController = new VeiculoController();

	public void frenteLoja() {

		int opcaoEscolhida;

		System.out.println("Frente da Loja. " + "\n Escolha Entre as Opções Abaixo: " + "\n *1- Gerenciar Veículo. "
				+ "\n *2- Gerenciar Loja. " + "\n *3- Gerenciar Vendedor. " + "\n *4- Gerenciar Cliente."
				+ "\n *5- Gerenciar Venda. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			gerenciarVeiculo();
			break;

		case 2:
			gerenciarLoja();
			break;

		case 3:
			gerenciarVendedor();
			break;

		case 4:
			gerenciarCliente();
			break;

		case 5:
			gerenciarVenda();
			break;

		default:
			MenuPrincipal.menu();
		}
	}

	public void manutencaoCadastro() {
		int opcaoEscolhida;

		System.out.println("Manutenção de Cadastros. " + "\n *1- Manutenção Veículo. " + "\n *2- Manutenção Loja. "
				+ "\n *3- Manutenção Vendedor. " + "\n *4- Manutenção Cliente. " + "\n *5- Manutenção Venda. "
				+ "\n *6- Voltar.");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			manutencaoVeiculo();
			break;

		case 2:
			manutencaoLoja();
			break;

		case 3:
			manutencaoVendedor();
			break;

		case 4:
			manutencaoCliente();
			break;

		case 5:
			manutencaoVenda();
			break;

		default:
			MenuPrincipal.menu();
		}

	}

	public void gerenciarVeiculo() {
		int opcaoEscolhida;
		String placa;
		System.out.println("\n *1- CONSULTAR VEÍCULO POR PLACA. " + "\n *2- VOLTAR AO MENU ANTERIOR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			System.out.println("INFORME A PLACA: ");
			placa = scan.nextLine();

			veiculoController.buscarPorPlaca(placa);
			break;

		default:
			MenuPrincipal.menu();

		}
	}

	public void gerenciarVendedor() {
		int opcaoEscolhida;
		String numRegistro;

		System.out.println("\n *1- MOSTRAR LISTA DE VENDEDORES. " + "\n *2- CONSULTAR VENDEDOR POR NÚMERO DE REGISTRO. "
				+ "\n *3- VOLTAR AO MENU ANTERIOR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1: 
			vendedorController.mostrarTudo();
			break;
		case 2:
			System.out.println("Informe o número de registro do vendedor: ");
			numRegistro = scan.nextLine();
			vendedorController.consultar(numRegistro);
			break;
		case 3:
			MenuPrincipal.menu();
			break;
		default:
			System.out.println("Opção inválida, voltando ao Menu Principal \n");
			break;
		}
	}

	public void gerenciarCliente() {
		int opcaoEscolhida;
		String rg;

		System.out.println("\n *1- MOSTRAR LISTA DE CLIENTES" + "\n *2- CONSULTAR CLIENTE POR RG" + "\n *2- VOLTAR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			clienteController.mostrarTudo();
			break;

		case 2:
			System.out.println("Informe o RG do cliente: ");
			rg = scan.nextLine();
			clienteController.consultar(rg);
			break;

		default:
			MenuPrincipal.menu();
		}
	}

	public void gerenciarLoja() {
		int opcaoEscolhida;
		int id;

		System.out.println("\n *1- LISTAR TODAS AS LOJAS. " + "\n *2- BUSCAR LOJA POR ID." + "\n *3- Voltar.");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			lojaController.buscarTudo();
			break;

		case 2:
			System.out.println("Informe o ID: ");
			id = scan.nextInt();
			lojaController.buscarPorId(id);

		default:
			MenuPrincipal.menu();
		}
	}

	public void gerenciarVenda() {
		int opcaoEscolhida;
		String placa;
		String numRegistro;
		String rg;

		System.out.println("\n *1- BUSCAR VENDA POR ID " + "\n *2- VOLTAR AO MENU SUPERIOR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			System.out.println("Digite o ID da venda\n");
			int id = scan.nextInt();
			scan.nextLine();
			vendaController.buscarPorId(id);
			// Pegar os objetos retornados das buscas.
//			System.out.println("Informe a placa do veículo: ");
//			placa = scan.nextLine();
//			Veiculo veiculo = veiculoController.buscarPorPlaca(placa);
//
//			System.out.println("Informe o número de registro do vendedor: ");
//			numRegistro = scan.nextLine();
//			Vendedor vendedor = vendedorController.consultar(numRegistro);
//
//			System.out.println("Informe o RG do cliente: ");
//			rg = scan.nextLine();
//			Cliente cliente = clienteController.consultar(rg);

			// Passar os objetos para a Venda.
//			vendaController.cadastrar(veiculo, vendedor, cliente);

			break;

		default:

			MenuPrincipal.menu();

		}
	}

	public void manutencaoVeiculo() {
		int opcaoEscolhida;
		String placa;

		System.out.println("\n *1- CADASTRAR VEÍCULO. " + "\n *2- EXCLUIR VEÍCULO. "
				+ "\n *3- ALTERAR DADOS DO VEÍCULO. " + "\n *4- VOLTAR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			veiculoController.cadastrar();
			break;

		case 2:
			System.out.println("INFORME A PLACA: ");
			placa = scan.nextLine();

			veiculoController.excluir(placa);
			break;

		case 3:
			System.out.println("INFORME A PLACA: ");
			placa = scan.nextLine();

			veiculoController.alterar(placa);
			break;

		default:
			MenuPrincipal.menu();
		}
	}

	public void manutencaoLoja() {
		int opcaoEscolhida;
		int id;
		System.out.println("\n *1- CADASTRAR LOJA. " + "\n *2- EXCLUIR LOJA. " + "\n *3- ALTERAR DADOS DA LOJA. "
				+ "\n *4- VOLTAR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			lojaController.cadastrar();
			break;

		case 2:
			System.out.println("INFORME O ID: ");
			id = scan.nextInt();
			lojaController.excluir(id);
			break;

		case 3:
			System.out.println("INFORME O ID: ");
			id = scan.nextInt();
			lojaController.alterar(id);
			break;

		default:
			MenuPrincipal.menu();
		}
	}

	public void manutencaoVendedor() {
		int opcaoEscolhida;
		int id;
		String numRegistro;

		System.out.println("\n *1- CADASTRAR VENDEDOR. " + "\n *2- EXCLUIR VENDEDOR. "
				+ "\n *3- ALTERAR DADOS DO VENDEDOR. " + "\n *4- VOLTAR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			vendedorController.cadastrar();
			break;

		case 2:
			System.out.println("Informe o número de registro do vendedor: ");
			numRegistro = scan.nextLine();
			vendedorController.excluir(numRegistro);
			break;

		case 3:
			System.out.println("Informe o número de registro do vendedor: ");
			numRegistro = scan.nextLine();
			vendedorController.alterarDados(numRegistro);
			break;

		default:
			MenuPrincipal.menu();
		}
	}

	public void manutencaoCliente() {
		int opcaoEscolhida;
		int id;
		String rg;

		System.out.println("\n *1- CADASTRAR CLIENTE. " + "\n *2- EXCLUIR CLIENTE. "
				+ "\n *3- ALTERAR DADOS DO CLIENTE. " + "\n *4- VOLTAR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			clienteController.cadastrar();
			break;

		case 2:
			System.out.println("Informe o RG do cliente: ");
			rg = scan.nextLine();
			clienteController.excluir(rg);
			break;

		case 3:
			System.out.println("Informe o RG do cliente: ");
			rg = scan.nextLine();
			clienteController.alterarDados(rg);
			break;

		default:
			MenuPrincipal.menu();
		}
	}

	public void manutencaoVenda() {
		int opcaoEscolhida;
		int id;

		String placa;
		String numRegistro;
		String rg;

		System.out.println(
				"\n *1- CADASTRAR VENDA. " + "\n *2- EXCLUIR VENDA. " + "\n *3- LISTAR VENDAS. " + "\n *4- VOLTAR. ");

		Scanner scan = new Scanner(System.in);

		opcaoEscolhida = Validadores.validadorDeMenu();

		switch (opcaoEscolhida) {
		case 1:
			// Pegar os objetos retornados das buscas.
			System.out.println("Informe a placa do veículo: ");
			placa = scan.nextLine();
			Veiculo veiculo = veiculoController.buscarPorPlaca(placa);

			System.out.println("Informe o número de registro do vendedor: ");
			numRegistro = scan.nextLine();
			Vendedor vendedor = vendedorController.consultar(numRegistro);

			System.out.println("Informe o RG do cliente: ");
			rg = scan.nextLine();
			Cliente cliente = clienteController.consultar(rg);

			// Passar os objetos para a Venda.
			vendaController.cadastrar(veiculo, vendedor, cliente);
			break;

		case 2:
			System.out.println("INFORME O ID DA VENDA: ");
			id = scan.nextInt();

			vendaController.excluir(id);
			break;

		case 3:
			vendaController.buscarTudo();

		default:
			MenuPrincipal.menu();
		}
	}
}
