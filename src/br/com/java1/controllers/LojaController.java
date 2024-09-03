package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.java1.models.Endereco;
import br.com.java1.models.Loja;
import br.com.java1.utils.LojaUtils;

public class LojaController {
	List<Loja> lojas = new ArrayList<Loja>();
	Loja loja = new Loja();
	
	//Id da Loja começa com 1 para simular o auto incremento do SGBD.
	int idLoja = 1;
	
	public void cadastrar() {
		String opcao = "S";
		
		do {
			Loja loja = new Loja();
			Endereco endereco = new Endereco();
			
			boolean aprovado = false;
			
			Scanner scan = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
			
			//Endereço está com ID só para fazer uma suposta ligação com a Loja
			Random r = new Random();
			int idEndereco = r.nextInt(99)+1;
			
			//Loja
			//ID da Loja inserido automaticamente.
			System.out.println("ID DA NOVA LOJA: " + idLoja);
			loja.setId(idLoja);
			
			while (!aprovado) {
				System.out.println("\n INFORME O NOME DA LOJA: ");
				String nome = scan.nextLine();
				if (LojaUtils.validaNome(nome)) {
					loja.setNome(nome);
					aprovado = true;
				} 
			}
			
			aprovado = false;
			while(!aprovado) {
				System.out.println("\n INFORME O TELEFONE DA LOJA: ");
				String telefone = scan.nextLine();
				
				if (LojaUtils.validaTelefone(telefone)) {
					loja.setTelefone(telefone);
					aprovado = true;
				}
			}
			
			//Endereço
			//ID do Endereço inserido automaticamente.
			endereco.setId(idEndereco);
			
			aprovado = false;
			while (!aprovado) {
				System.out.println("\n INFORME EM QUAL PAÍS A LOJA SE LOCALIZA: ");
				String pais = scan.nextLine();
				
				if(LojaUtils.validaTexto(pais)) {
					endereco.setPais(pais);
					aprovado = true;
				}
			}
			
			aprovado = false;
			while (!aprovado) {
				System.out.println("\n INFORME O ESTADO: ");
				String estado = scan.nextLine();
				
				if(LojaUtils.validaTexto(estado)) {
					endereco.setEstado(estado);
					aprovado = true;
				}		
			}
			
			aprovado = false;
			while (!aprovado) {
				System.out.println("\n INFORME A CIDADE: ");
				String cidade = scan.nextLine();
				
				if(LojaUtils.validaTexto(cidade)) {
					endereco.setCidade(cidade);
					aprovado = true;
				}
			}
			
			aprovado = false;
			while(!aprovado) {
				System.out.println("\n INFORME O CEP: ");
				String cep = scan.nextLine();
				
				if(LojaUtils.validaCep(cep)) {
					endereco.setCep(cep);
					aprovado = true;
				}
			}
			
			aprovado = false;
			while (!aprovado) {
				System.out.println("\n INFORME O BAIRRO: ");
				String bairro = scan.nextLine();
				
				if(LojaUtils.validaTexto(bairro)) {
					endereco.setBairro(bairro);
					aprovado = true;
				}
			}
			
			aprovado = false;
			while (!aprovado) {
				System.out.println("\n INFORME A RUA: ");
				String rua = scan.nextLine();
				
				if(LojaUtils.validaTexto(rua)) {
					endereco.setRua(rua);
					aprovado = true;
				}
			}
			
			aprovado = false;
			while (!aprovado) {
				System.out.println("\n INFORME O NÚMERO: ");
				int numero = scan2.nextInt();
				
				if(LojaUtils.validaNumero(numero)) {
					endereco.setNumero(numero);
					aprovado = true;
				}
				
			}
			
			System.out.println("\n");
			
			lojas.add(new Loja(loja.getId(), loja.getNome(), loja.getTelefone(),
					new Endereco(endereco.getId(), endereco.getPais(), 
							endereco.getEstado(), endereco.getCidade(), endereco.getCep(),
							endereco.getBairro(), endereco.getRua(), endereco.getNumero())));
			idLoja ++;
			
			System.out.println("\n DESEJA ADICIONAR OUTRA LOJA (S/N)? ");
			opcao = scan.nextLine();
		} while(opcao.equalsIgnoreCase("s"));
	}
	
	public void buscarTudo() {
		
		for(Loja l : lojas) {
			System.out.println("\n ID DA LOJA: " + l.getId());
			System.out.println("\n NOME DA LOJA: " +l.getNome());
			System.out.println("\n TELEFONE: " + l.getTelefone());
			System.out.println("\n ID DO ENDEREÇO: " + l.getEndereco().getId());
			System.out.println("\n PAÍS: "+ l.getEndereco().getPais());
			System.out.println("\n ESTADO: "+ l.getEndereco().getEstado());
			System.out.println("\n CIDADE: " + l.getEndereco().getCidade());
			System.out.println("\n CEP DA LOJA: " + l.getEndereco().getCep());
			System.out.println("\n BAIRRO: " + l.getEndereco().getBairro());
			System.out.println("\n RUA: " + l.getEndereco().getRua());
			System.out.println("\n NÚMERO: " + l.getEndereco().getNumero());;
			
			System.out.println("________________________________\n");
		}
	}
	
	public Loja buscarPorId(int id) {

		for(Loja l : lojas) {
			if (id == l.getId()) {
				System.out.println("\n ID DA LOJA: " + l.getId());
				System.out.println("\n NOME DA LOJA: " +l.getNome());
				System.out.println("\n TELEFONE: " + l.getTelefone());
				System.out.println("\n PAÍS: "+ l.getEndereco().getPais());
				System.out.println("\n ESTADO: "+ l.getEndereco().getEstado());
				System.out.println("\n CIDADE: " + l.getEndereco().getCidade());
				System.out.println("\n CEP DA LOJA: " + l.getEndereco().getCep());
				System.out.println("\n BAIRRO: " + l.getEndereco().getBairro());
				System.out.println("\n RUA: " + l.getEndereco().getRua());
				System.out.println("\n NÚMERO: " + l.getEndereco().getNumero());;
				
				System.out.println("________________________________\n");
				return l;
			}
		}
		System.out.println("LOJA NÃO ENCONTRADA.");
		return null;
	}
	
	public void excluir(int id) {
		
		try {
			lojas.remove(buscarPorId(id));
			System.out.println("LOJA "+ id + " DELETADA COM SUCESSO.");
		}
		catch (Exception e){
			System.out.println("ERRO AO EXCLUIR LOJA.");
		}
	}
	
	public void alterar(int id) {
		try {
			var loja = buscarPorId(id);
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("ESCOLHA UMA OPÇÃO DA LOJA " + id + " PARA MODIFICAR: ");
			
			System.out.println("\n *1- NOME DA LOJA: " +loja.getNome());
			System.out.println("\n *2- TELEFONE: " + loja.getTelefone());
			System.out.println("\n *3- PAÍS: "+ loja.getEndereco().getPais());
			System.out.println("\n *4- ESTADO: "+ loja.getEndereco().getEstado());
			System.out.println("\n *5- CIDADE: " + loja.getEndereco().getCidade());
			System.out.println("\n *6- CEP DA LOJA: " + loja.getEndereco().getCep());
			System.out.println("\n *7- BAIRRO: " + loja.getEndereco().getBairro());
			System.out.println("\n *8- RUA: " + loja.getEndereco().getRua());
			System.out.println("\n *9- NÚMERO: " + loja.getEndereco().getNumero());;
			
			System.out.println("________________________________\n");
			
			int opcao = scan.nextInt();
			LojaUtils.opcoesLoja(loja, opcao);
			
			//Mostrar Resultado.
			buscarPorId(id);
		}
		catch (Exception e){
			System.out.println("ERRO AO ALTERAR LOJA. ");
		}
	}
}
