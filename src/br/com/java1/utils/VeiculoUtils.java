package br.com.java1.utils;

import java.util.List;
import java.util.Scanner;

import br.com.java1.models.Veiculo;
import br.com.java1.views.MenuPrincipal;

public class VeiculoUtils {
	public static void opcoesVeiculo(Veiculo veiculo) {
		Scanner scan = new Scanner(System.in);
		int o = 0;
		while (o != 8) {
			System.out.println("ESCOLHA UMA OPÇÃO PARA MODIFICAR: ");

			System.out.println("\n1 - MARCA: " + veiculo.getMarca());
			System.out.println("\n2 - MODELO: " + veiculo.getModelo());
			System.out.println("\n3 - ANO: " + veiculo.getAno());
			System.out.println("\n4 - PLACA: " + veiculo.getPlaca());
			System.out.println("\n5 - PRECO: " + veiculo.getPreco());
			System.out.println("\n6 - CATEGORIA: " + veiculo.getTipoVeiculo().getCategoria());
			System.out.println("\n7 - DESCRICAO: " + veiculo.getTipoVeiculo().getDescricao());
			System.out.println("\n\n8 - SAIR");

			System.out.println("________________________________\n");
			o = scan.nextInt();
			scan.nextLine();
			switch (o) {
			case 1:
				System.out.println("MARCA");
				String marca = scan.nextLine();
				veiculo.setMarca(marca);
				break;

			case 2:
				System.out.println("MODELO");
				String modelo = scan.nextLine();
				veiculo.setModelo(modelo);
				break;

			case 3:
				System.out.println("ANO");
				int ano = scan.nextInt();
				veiculo.setAno(ano);
				break;

			case 4:
				System.out.println("PLACA");
				String placa = scan.nextLine();
				veiculo.setPlaca(placa);
				break;

			case 5:
				System.out.println("PREÇO");
				double preco = scan.nextDouble();
				veiculo.setPreco(preco);
				break;

			case 6:
				System.out.println("CATEGORIA");
				String categoria = scan.nextLine();
				veiculo.getTipoVeiculo().setCategoria(categoria);
				break;

			case 7:
				System.out.println("DESCRIÇÃO");
				String descricao = scan.nextLine();
				veiculo.getTipoVeiculo().setDescricao(descricao);
				break;

			case 8:
				System.out.println("Voltando ao Menu Principal...");
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA. VOLTANDO AO MENU PRINCIPAL.");
				MenuPrincipal.menu();
			}
		}

	}

	public static boolean validaMarca(String marca) {
		if (marca.length() <= 20 && marca.matches("[a^-zA-Z\\s]+") == true) {
			return true;
		} else {
			System.out.println("MARCA INVÁLIDA, DIGITE NOVAMENTE \n");
			return false;
		}
	}

	public static boolean validaModelo(String modelo) {
		if (modelo.length() <= 20 && modelo.matches("[a^-zA-Z\\s]+") == true) {
			return true;
		} else {
			System.out.println("MODELO INVÁLIDO, DIGITE NOVAMENTE \n");
			return false;
		}
	}
	
	public static boolean validaPlaca(String placa) {
		if (placa.length()==7) {
			return true;
		}
		return false;
	}
	
	public static boolean verificaPlaca(String placa, List<Veiculo>list) {
		for (Veiculo xVeiculo : list) {
			if (placa.equalsIgnoreCase(xVeiculo.getPlaca())) {
				return false;
			}
		}
		return true;
	}
}
