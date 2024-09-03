package br.com.java1.utils;

import java.util.Scanner;

import br.com.java1.models.Veiculo;
import br.com.java1.views.MenuPrincipal;

public class VeiculoUtils {
	public static void opcoesVeiculo(Veiculo veiculo, int o) {
		Scanner scan = new Scanner(System.in);
		
		switch (o) {
		case 1:
			String marca = scan.nextLine();
			veiculo.setMarca(marca);
			break;
		
		case 2:
			String modelo = scan.nextLine();
			veiculo.setModelo(modelo);
			break;
		
		case 3:
			int ano = scan.nextInt();
			veiculo.setAno(ano);
			break;
		
		case 4:
			String placa = scan.nextLine();
			veiculo.setPlaca(placa);
			break;
		
		case 5:
			double preco = scan.nextDouble();
			veiculo.setPreco(preco);
			break;
			
//		case 6:
//			String tipoVeiculo = scan.nextLine();
//			veiculo.setTipoVeiculo(tipoVeiculo);
//			
		case 6:
			String categoria = scan.nextLine();
			veiculo.getTipoVeiculo().setCategoria(categoria);
			break;
		
		case 7:
			String descricao = scan.nextLine();
			veiculo.getTipoVeiculo().setDescricao(descricao);
			break;
		
		default:
			System.out.println("OPÇÃO INVÁLIDA. VOLTANDO AO MENU PRINCIPAL.");
			MenuPrincipal.menu();
		}
	}
}





