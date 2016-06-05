package br.ldrson.otimizacao.diversidade.fenotipica;

import java.util.List;

/**
 * Created by leanderson on 05/06/16.
 */
public class Main {

    public static void main(String args[]){

        //--
        // Caminho do arquivo
        //--
        String nomeDoArquivo = "MDF/resources/geracao.txt";

        //--
        // Importa os valores de fitness
        //--
        ImportadorGeracao importador = new ImportadorGeracao();
        List<Double> listaDeFitness = importador.obterFitnessDaGeracao(nomeDoArquivo);

        //--
        // Calcula a diversidade para a população
        //--
        MedidaDeDiversidadeFenotipica mdf = new MedidaDeDiversidadeFenotipica();
        double diversidade = mdf.calcular(listaDeFitness);

        System.out.println("Diversidade = "+diversidade);

    }

}
