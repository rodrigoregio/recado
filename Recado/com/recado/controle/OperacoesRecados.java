package com.recado.controle;
import java.io.*;
import com.recado.beam.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * Classe para realizar operações (leitura e gravação) com a classe Recado.
 * 
 * @author Rodrigo Régio
 * @version 14/06/2018
 */
public class OperacoesRecados{
    /**
     * Método para ler o arquivo e armazenar
     * Estou com dificuldades neste método,ele dá vários erros diferentes desde Array out of bounds a Null Pointer Exception (ou dá um erro ou da outro
     * e não sei porque
     */
    public ArrayList<Recado> lerArquivo() throws java.io.IOException{
        try{
            ArrayList <Recado> recados=new ArrayList<Recado>();
            String linha ="a#b#c#d#e#f";
            String caminhoArq=System.getProperty("user.dir");
            FileReader arq= new FileReader(caminhoArq+"//recado.txt");
            BufferedReader lerArq=new BufferedReader(arq);
            int ind=0;
            do{
                try{
                    /**
                     * O erro geralmente dá neste pedaco de codigo
                     */
                    Recado rec=new Recado();
                    String [] atributos=linha.split("#");
                    rec.setID(atributos[0]);
                    rec.setDe(atributos[1]);
                    rec.setPara(atributos[2]);
                    rec.setData_hora(atributos[3]);
                    if(atributos[4].equalsIgnoreCase("false")){
                        rec.setAtivo(true);
                    }else{
                        rec.setAtivo(false);
                    }
                    rec.setDescricao(atributos[5]);
                    recados.add(rec);
                    ind++;
                    linha=lerArq.readLine();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }while(linha != null);
            /**
             * fim do pedaço de codigo que tenho problema
             */
            lerArq.close();
            arq.close();
            return recados;
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Arquivo não encontrado", "File Not Found Exception"
            , JOptionPane.ERROR_MESSAGE);
            return null;
        }
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

        //Aqui pega o recado e o torna em String
        String texto=r.getID()+"|"+
            r.getDe()+"|"+
            r.getPara()+"|"+
            r.getData_hora()+"|"+
            r.getAtivo()+"|"+
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
