package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.java1.models.TipoVeiculo;
import br.com.java1.models.Veiculo;
import br.com.java1.utils.VeiculoUtils;

public class VeiculoController {
	List<Veiculo> veiculos = new ArrayList<Veiculo>();
	Veiculo veiculo = new Veiculo();
	
	int idVeiculo = 1;
	
	public void cadastrar() {
		
		boolean continuar = true;
		String opcao = "S";
		int idVeiculo = 1;
		
		do {
			Veiculo veiculo = new Veiculo();
			TipoVeiculo tipoveiculo = new TipoVeiculo();
			
			Scanner scan = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
		
			Random r = new Random();
			int idTipoVeiculo = r.nextInt(99)+1;
			
			System.out.println("ID: " + idVeiculo);
			veiculo.setId(idVeiculo);
			
			System.out.println("\n INFORME A MARCA DO VEICULO: ");
			String marca = scan.nextLine();
			veiculo.setMarca(marca);
			
			System.out.println("\n INFORME O MODELO DO VEICULO: ");
			String modelo = scan.nextLine();
			veiculo.setModelo(modelo);
			
			System.out.println("\n INFORME O ANO DO VEÍCULO: ");
			int ano = 0;
			boolean validador = false;
			while (validador == false) {
				try {
					ano = scan.nextInt();
					scan.nextLine();
					validador = true;
				} catch (java.util.InputMismatchException e) {
					scan.nextLine();
					System.out.println("Digite apenas números");
				}
			}
			
			veiculo.setAno(ano);
			
			System.out.println("\n A PLACA DO VEÍCULO: ");
			String placa = scan.nextLine();
			placa.toUpperCase();
			while (VeiculoUtils.validaPlaca(placa)==false) {
				placa = scan.nextLine();
			}
			while (VeiculoUtils.verificaPlaca(placa, veiculos) == false) {
				System.out.println("Placa já cadastrada, digite uma placa diferente\n");
				placa = scan.nextLine();
			}
			veiculo.setPlaca(placa);
			
			System.out.println("\n INFORME O PREÇO DO VEICULO: ");
			double preco = 0;
			validador = false;
			while (validador == false) {
				try {
					preco = scan.nextDouble();
					scan.nextLine();
					validador = true;
				} catch (java.util.InputMismatchException e) {
					System.out.println("Digite apenas números");
					scan.nextLine();
				}
			}
			veiculo.setPreco(preco);
			
			tipoveiculo.setId(idTipoVeiculo);
			
			System.out.println("\n INFORME A CATEGORIA DO VEICULO: ");
			String categoria = scan.nextLine();
			tipoveiculo.setCategoria(categoria);
			
			System.out.println("\n INFORME A DESCRIÇÃO DO VEICULO: ");
			String descricao = scan.nextLine();
			tipoveiculo.setDescricao(descricao);
			
			System.out.println("\n");
			
			veiculos.add(new Veiculo(idVeiculo, marca, modelo, ano, placa, preco,
					new TipoVeiculo(idTipoVeiculo, categoria, descricao)));
			idVeiculo ++;
			
			System.out.println("\n DESEJA ADICIONAR OUTRO VEICULO (S/N)? ");
			opcao = scan.nextLine();
		} while(opcao.equalsIgnoreCase("s"));
	}
	
	public void buscarTudo() {
		
		for(Veiculo l : veiculos) {
			System.out.println("\n ID DO VEICULO: " + l.getId());
			System.out.println("\n MARCA: " +l.getMarca());
			System.out.println("\n MODELO: " + l.getModelo());
			System.out.println("\n ANO: " + l.getAno());
			System.out.println("\n PLACA: "+ l.getPlaca());
			System.out.println("\n PRECO: "+ l.getPreco());
			System.out.println("\n TIPO DE VEICULO: " + l.getTipoVeiculo());
			System.out.println("\n CATEGORIA: " + l.getTipoVeiculo().getCategoria());
			System.out.println("\n DESCRICAO: " + l.getTipoVeiculo().getDescricao());
						
			System.out.println("________________________________\n");
		}
	}
	
	public Veiculo buscarPorPlaca(String placa) {

		for(Veiculo l : veiculos) {
			if (placa.equals(l.getPlaca())) {
				System.out.println("\n ID DO VEICULO: " + l.getId());
				System.out.println("\n MARCA: " +l.getMarca());
				System.out.println("\n MODELO: " + l.getModelo());
				System.out.println("\n ANO: " + l.getAno());
				System.out.println("\n PLACA: "+ l.getPlaca());
				System.out.println("\n PRECO: "+ l.getPreco());
				System.out.println("\n CATEGORIA: " + l.getTipoVeiculo().getCategoria());
				System.out.println("\n DESCRICAO: " + l.getTipoVeiculo().getDescricao());
							
				System.out.println("________________________________\n");
				return l;
			}
		}
		System.out.println("VEICULO NÃO ENCONTRADO.");
		return null;
	}
	
	public void excluir(String placa) {
		
		try {
			veiculos.remove(buscarPorPlaca(placa));
		}
		catch (Exception e){
			System.out.println("ERRO AO EXCLUIR VEICULO. ");
		}
	}
	
	public void alterar(String placa) {
		try {
			//NÃO ENTENDI AINDA MUITO BEM A VARIAVEL VAR MAS DEIXEI PQ SE FUNCIONOU NO LOJA DEVE FUNCIONAR NO VEICULO
			var veiculo = buscarPorPlaca(placa);
			
			//PELO QUE ENTENDI A VARIAVEL VAR VEICULO PRECISARIA DE UMA CLASSE VEICULO NO PACOTE UTILS PARA FUNCIONAR CRIEI UMA NA SEQUENCIA
			VeiculoUtils.opcoesVeiculo(veiculo);
			
			buscarPorPlaca(placa);
		}
		catch (Exception e){
			System.out.println("ERRO AO ALTERAR VEICULO. ");
		}
	}
	}


