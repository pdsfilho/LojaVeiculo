package br.com.java1.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.java1.controllers.VeiculoController;
import br.com.java1.controllers.VendaController;
import br.com.java1.models.TipoVeiculo;
import br.com.java1.models.Veiculo;


public class Testes {
	public static void testeVeiculo() {
		Veiculo veiculo = new Veiculo();
		TipoVeiculo tpVeiculo = new TipoVeiculo();
		
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		VeiculoController veiculoController = new VeiculoController();
		VendaController vendaController = new VendaController();
		
		//Cadastrar
		 int idVeiculo = 1;
		 String marca = "Fiat";
		 String modelo = "Uno";
		 int ano = 2005;
		 String placa = "SQL2025";
		 double preco = 10000;
		 
		 TipoVeiculo tipoVeiculo;
		 int idTipoVeiculo = 99;
		 String categoria = "Hatch";
		 String descricao = "Escada em cima e adesivo da firma";
		 
		 veiculo.setId(idVeiculo);
		 veiculo.setMarca(marca);
		 veiculo.setModelo(modelo);
		 veiculo.setAno(ano);
		 veiculo.setPlaca(placa);
		 veiculo.setPreco(preco);
		 tpVeiculo.setCategoria(categoria);
		 tpVeiculo.setDescricao(descricao);
		 
		veiculos.add(new Veiculo(veiculo.getId(), veiculo.getMarca(), veiculo.getModelo(), 
				veiculo.getAno(), veiculo.getPlaca(), veiculo.getPreco(),
				new TipoVeiculo(tpVeiculo.getId(), tpVeiculo.getCategoria(), tpVeiculo.getDescricao())));
		
		//Imprimir
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
				}
			}
		}	
}
