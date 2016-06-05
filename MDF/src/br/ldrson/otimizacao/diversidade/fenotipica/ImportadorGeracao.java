package br.ldrson.otimizacao.diversidade.fenotipica;

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

    public List<Double> obterFitnessDaGeracao(String nomeDoArquivo){
        List<Double> lista = new ArrayList<>();

        try {
            FileReader arq = new FileReader(nomeDoArquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            // ignora a primeira linha do arquivo.
            String buffer = lerArq.readLine();

            while ((buffer = lerArq.readLine()) != null) {
                String[] temp = buffer.split(" ");

                lista.add(Double.parseDouble(temp[0]));

            }
        }catch (Exception e){
            System.out.println("Erro ao realizar leitura do arquivo :" +e.getMessage());
        }

        return lista;
    }
}
