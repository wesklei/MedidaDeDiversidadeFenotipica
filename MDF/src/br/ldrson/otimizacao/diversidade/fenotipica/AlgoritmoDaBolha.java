package br.ldrson.otimizacao.diversidade.fenotipica;

import java.util.List;

/**
 * Created by leanderson on 05/06/16.
 */
public class AlgoritmoDaBolha {

    public  void ordenar(List<Double> sorted) {
        int i=sorted.size();
        boolean changed = true;
        while(changed && i>0) {
            changed = false;
            for(int j=1; j<i; j++) {
                if(sorted.get(j) < sorted.get(j-1)) {
                    double s= sorted.get(j);
                    sorted.set(j,sorted.get(j-1));
                    sorted.set(j-1, s);
                    changed = true;
                }
            }
            i--;
        }
    }

}
