package br.com.java1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.java1.models.TipoVeiculo;
import br.com.java1.models.Veiculo;

public class VeiculoController {
	List<Veiculo> veiculos = new ArrayList<Veiculo>();
	Veiculo veiculo = new Veiculo();
	
	int idVeiculo = 1;
	
	public void cadastrar() {
		
		boolean continuar = true;
		String opcao = "S";
		
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
			int ano = scan2.nextInt();
			veiculo.setAno(ano);
			
			System.out.println("\n A PLACA DO VEÍCULO: ");
			String placa = scan.nextLine();
			veiculo.setPlaca(placa);
			
			System.out.println("\n INFORME O PREÇO DO VEICULO: ");
			double preco = scan2.nextDouble();
			veiculo.setPreco(preco);
			
			
			
			tipoveiculo.setId(idTipoVeiculo);
			
			System.out.println("\n INFORME A CATEGORIA DO VEICULO: ");
			String categoria = scan.nextLine();
			tipoveiculo.setCategoria(categoria);
			
			System.out.println("\n INFORME A DESCRIÇÃO DO VEICULO: ");
			String descricao = scan.nextLine();
			tipoveiculo.setDescricao(descricao);
			
			System.out.println("\n");
			
			veiculos.add(new Veiculo(idTipoVeiculo, marca, modelo, ano, placa, preco,
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
				System.out.println("\n TIPO DE VEICULO: " + l.getTipoVeiculo());
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
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("ESCOLHA UMA OPÇÃO PARA MODIFICAR: ");
			
			System.out.println("\n ID DO VEICULO: " + veiculo.getId());
			System.out.println("\n MARCA: " +veiculo.getMarca());
			System.out.println("\n MODELO: " + veiculo.getModelo());
			System.out.println("\n ANO: " + veiculo.getAno());
			System.out.println("\n PLACA: "+ veiculo.getPlaca());
			System.out.println("\n PRECO: "+ veiculo.getPreco());
			System.out.println("\n TIPO DE VEICULO: " + veiculo.getTipoVeiculo());
			System.out.println("\n CATEGORIA: " + veiculo.getTipoVeiculo().getCategoria());
			System.out.println("\n DESCRICAO: " + veiculo.getTipoVeiculo().getDescricao());
			
			System.out.println("________________________________\n");
			
			
			//PELO QUE ENTENDI A VARIAVEL VAR VEICULO PRECISARIA DE UMA CLASSE VEICULO NO PACOTE UTILS PARA FUNCIONAR CRIEI UMA NA SEQUENCIA
			

			int opcao = scan.nextInt();
			//VeiculoUtils.opcoesVeiculo(veiculo, opcao);
			
			buscarPorPlaca(placa);
		}
		catch (Exception e){
			System.out.println("ERRO AO ALTERAR VEICULO. ");
		}
	}
	}


