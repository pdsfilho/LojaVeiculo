package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.java1.models.Endereco;
import br.com.java1.models.Loja;

public class LojaController {
	List<Loja> lojas = new ArrayList<Loja>();
	Loja loja = new Loja();

	public void cadastrar() {
		boolean continuar = true;
		String opcao = "S";
		
		do {
			Loja loja = new Loja();
			Endereco endereco = new Endereco();
			
			Scanner scan = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
		
			Random r = new Random();
			int idLoja = r.nextInt(10)+1;
			
			Random r2 = new Random();
			int idEndereco = r.nextInt(99)+1;
			
			//Loja
			System.out.println("ID DA NOVA LOJA: " + idLoja);
			loja.setId(idLoja);
			
			System.out.println("\n INFORME O NOME DA LOJA: ");
			String nome = scan.nextLine();
			loja.setNome(nome);
			
			System.out.println("\n INFORME O TELEFONE DA LOJA: ");
			String telefone = scan.nextLine();
			loja.setTelefone(telefone);
			
			//Endereço
			System.out.println("ID DO ENDEREÇO: " + idEndereco);
			endereco.setId(idEndereco);
			
			System.out.println("\n INFORME EM QUAL PAÍS A LOJA SE LOCALIZA: ");
			String pais = scan.nextLine();
			endereco.setPais(pais);
			
			System.out.println("\n INFORME O ESTADO: ");
			String estado = scan.nextLine();
			endereco.setEstado(estado);
			
			System.out.println("\n INFORME A CIDADE: ");
			String cidade = scan.nextLine();
			endereco.setCidade(cidade);
			
			System.out.println("\n INFORME O CEP: ");
			String cep = scan.nextLine();
			endereco.setCep(cep);
			
			System.out.println("\n INFORME O BAIRRO: ");
			String bairro = scan.nextLine();
			endereco.setBairro(bairro);
			
			System.out.println("\n INFORME A RUA: ");
			String rua = scan.nextLine();
			endereco.setRua(rua);
			
			System.out.println("\n INFORME O NÚMERO: ");
			int numero = scan2.nextInt();
			endereco.setNumero(numero);
			
			System.out.println("\n");
			
			lojas.add(new Loja(loja.getId(), loja.getNome(), loja.getTelefone(),
					new Endereco(endereco.getId(), endereco.getPais(), 
							endereco.getEstado(), endereco.getCidade(), endereco.getCep(),
							endereco.getBairro(), endereco.getRua(), endereco.getNumero())));
			
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
			return l;
		}
		return null;
	}
	
	public void excluir(int id) {
		
		try {
			lojas.remove(buscarPorId(id));
		}
		catch (Exception e){
			System.out.println("LOJA NÃO ENCONTRADA. ");
		}
	}
	
	public void alterar(int id) {
		
	}
}
