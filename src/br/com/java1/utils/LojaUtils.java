package br.com.java1.utils;

import java.util.Scanner;

import br.com.java1.models.Loja;
import br.com.java1.views.MenuPrincipal;

public class LojaUtils {
	public static void opcoesLoja(Loja loja, int o) {
		Scanner scan = new Scanner(System.in);
		
		switch (o) {
		case 1:
			String nome = scan.nextLine();
			loja.setNome(nome);
			break;
		
		case 2:
			String telefone = scan.nextLine();
			loja.setTelefone(telefone);
			break;
		
		case 3:
			String pais = scan.nextLine();
			loja.getEndereco().setPais(pais);
			break;
		
		case 4:
			String estado = scan.nextLine();
			loja.getEndereco().setEstado(estado);
			break;
		
		case 5:
			String cidade = scan.nextLine();
			loja.getEndereco().setCidade(cidade);
			break;
			
		case 6:
			String cep = scan.nextLine();
			loja.getEndereco().setCep(cep);
			
		case 7:
			String bairro = scan.nextLine();
			loja.getEndereco().setBairro(bairro);
			break;
		
		case 8:
			String rua = scan.nextLine();
			loja.getEndereco().setRua(rua);
			break;
		
		case 9:
			int numero = scan.nextInt();
			loja.getEndereco().setNumero(numero);
			break;
		
		default:
			System.out.println("OPÇÃO INVÁLIDA. VOLTANDO AO MENU PRINCIPAL.");
			MenuPrincipal.menu();
		}
	}
}
