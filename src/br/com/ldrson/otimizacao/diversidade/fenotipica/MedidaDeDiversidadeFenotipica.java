package br.com.ldrson.otimizacao.diversidade.fenotipica;

import java.util.List;

/**
 * Created by leanderson on 05/06/16.
 */
public class MedidaDeDiversidadeFenotipica {

    private double mPiorFitness;
    private double mMelhorFitness;
    private boolean mLimitesInicializados;

    public MedidaDeDiversidadeFenotipica(){
        mLimitesInicializados = false;
    }


    public double calcular(List<Double> listaDeFitness){
        double aux_1 = 0.0, aux_2 = 0.0;

        //--
        // Inicializa as variaveis
        //--
        if(!mLimitesInicializados){
            mPiorFitness = listaDeFitness.get(0);
            mMelhorFitness = listaDeFitness.get(0);
            mLimitesInicializados = true;
        }

        //--
        // Verifica se existe fitness melhor ou piores que os valores conhecidos anteriormente.
        //--
        for(Double fitness : listaDeFitness){
            if(fitness > mPiorFitness){
                mPiorFitness = fitness;
            }
            if(fitness < mMelhorFitness){
                mMelhorFitness = fitness;
            }
        }

        //--
        // Calcula a diversidade da população virtual
        // distribuida uniformemente entre o melhor e pior valor de fitness conhecido
        //--
        double vmd = mPiorFitness - mMelhorFitness;

        if(vmd < 0.0)
        {
            vmd = vmd * -1.0;
        }

        double virtual_fit[] = new double[listaDeFitness.size()];
        for(int k = 0; k < virtual_fit.length; k++)
        {
            virtual_fit[k] = mMelhorFitness + (vmd * (k));
        }
        vmd = 0.0;

        for(int k = 0; k < (virtual_fit.length-1); k++)
        {
            aux_1 = (virtual_fit[k] -virtual_fit[k+1]);
            if(aux_1 < 0.0)
            {
                aux_1 = (aux_1 * -1.0);
            }
            vmd += Math.log(1.0 + aux_1);
        }

        //--
        // Clona a lista;
        //--
        List<Double> listaOrdenada = listaDeFitness.subList(0,listaDeFitness.size());


        //--
        // Ordenar a lista com o Algoritmo da Bolha
        // Pessima escolha em consideração de performance
        //--
        AlgoritmoDaBolha bolha = new AlgoritmoDaBolha();
        bolha.ordenar(listaOrdenada);

        //--
        // Calcular a diversidade da população ordenada
        //--
        for( int k = 0; k < (listaOrdenada.size() - 1) ; k++)
        {
            aux_1 = (listaOrdenada.get(k) -  listaOrdenada.get(k+1));
            if(aux_1 < 0.0)
            {
                aux_1 = aux_1 * -1.0;
            }
            aux_2 += Math.log(1.0 + aux_1);
        }

        //--
        // Retorna a diversidade
        //--
        if(Double.isNaN(aux_2 / vmd)){
            System.out.println("is NaN! " + aux_2 + " / " + vmd);
        }
        return ( aux_2 / vmd);
    }

}
