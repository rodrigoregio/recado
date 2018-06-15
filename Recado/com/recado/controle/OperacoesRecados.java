package com.recado.controle;
import java.io.*;
import com.recado.beam.*;
import java.util.*;
/**
 * Classe para realizar operações (leitura e gravação) com a classe Recado.
 * 
 * @author Rodrigo Régio
 * @version 14/06/2018
 */
public class OperacoesRecados{
    /**
     * Método para ler o arquivo e armazenar
     */
    public ArrayList<Recado> lerArquivo(Recado r){
        return null;
    }

    /**
     * Método para adicionar o recado no arquivo.
     */
    public void adicionarNoArquivo(Recado r) throws IOException{
        //Aqui o método pega o diretório corrente
        String home=System.getProperty("user.dir");
        //Aqui grava o arquivo com append
        FileWriter arq=new FileWriter(home+"//recado.txt",true);
        //Aqui cria um buffer para salvar os dados
        BufferedWriter gravandoArquivo=new BufferedWriter(arq);
        //String para verificar o status do recado
        String passou;
        /*
         * pegar a variavel ativo do recado e se verdadeiro a pessoa
         * não passou o recado caso contrario passou o recado
         */
        if(r.getAtivo()){
            passou="Não";
        }else{
            passou="Sim";
        }
        //Aqui pega o recado e o torna em String
        String texto=r.getID()+"|"+
            r.getDe()+"|"+
            r.getPara()+"|"+
            r.getData_hora()+"|"+
            passou+"|"+
            r.getDescricao();
        //Aqui grava o texto no arquivo
        gravandoArquivo.write(texto);
        //Aqui o buffer inclui uma nova linha
        gravandoArquivo.newLine();
        //Aqui o buffer é fechado
        gravandoArquivo.close();
        //Aqui o arquivo é fechado
        arq.close();
    }
}
