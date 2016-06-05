package br.com.ldrson.otimizacao.diversidade.fenotipica;

import java.util.List;

/**
 * Created by leanderson on 05/06/16.
 */
public class Main {

    public static void main(String args[]){

        //--
        // Caminho do arquivo
        //--
        String nomeDoArquivo = "resources/geracao.txt";

        //--
        // Importa os valores de fitness
        //--
        ImportadorGeracao importador = new ImportadorGeracao();
        
        for(int i=0;i<1000;i++){
            List<Double> listaDeFitness = importador.obterFitnessDaGeracao(nomeDoArquivo,i);

            /*for(int j = 0; j<50; j++){
                System.out.println(j + ": " + listaDeFitness.get(j));
            }*/
            //--
            // Calcula a diversidade para a população
            //--
            MedidaDeDiversidadeFenotipica mdf = new MedidaDeDiversidadeFenotipica();
            double diversidade = mdf.calcular(listaDeFitness);

            System.out.println("Diversidade = "+diversidade);
            
            //System.out.println();
        }

    }

}
