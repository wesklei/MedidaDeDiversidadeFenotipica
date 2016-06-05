package br.com.ldrson.otimizacao.diversidade.fenotipica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leanderson on 05/06/16.
 */
public class ImportadorGeracao {


    public ImportadorGeracao(){
    }

    public List<Double> obterFitnessDaGeracao(String nomeDoArquivo, int generation_offset){
        List<Double> lista = new ArrayList<>();

        try {
            FileReader arq = new FileReader(nomeDoArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            
            int offset = 0;
            while(offset < generation_offset){
                String buffer = lerArq.readLine();
                buffer = lerArq.readLine();
                buffer = lerArq.readLine();

                for(int j=0; j<50; j++){
                    buffer = lerArq.readLine();
                }
                offset++;
            }
            String buffer = lerArq.readLine();
            buffer = lerArq.readLine();
            buffer = lerArq.readLine();
            for (int j = 0; j < 50; j++) {
                buffer = lerArq.readLine();
                String[] temp = buffer.split(" ");
                lista.add(Double.parseDouble(temp[0]));
            }
        }catch (Exception e){
            System.out.println("Erro ao realizar leitura do arquivo :" +e.getMessage());
        }

        return lista;
    }
}
