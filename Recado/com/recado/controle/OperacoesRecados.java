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
        String linha = new String();
        String nomeArquivo=System.getProperty("user.dir");
        nomeArquivo=nomeArquivo+"//recado.txt";
        
        File arq=new File(nomeArquivo);
        ArrayList <Recado> recados=new ArrayList<Recado>();
        if(arq.exists()){
            try{
                FileReader leitor = new FileReader(nomeArquivo);
                BufferedReader bufferDeArquivo = new BufferedReader(leitor);
                
                while(true){
                    linha=bufferDeArquivo.readLine();
                    if(linha == null){
                        break;
                    }
                    String [] atributos=linha.split("#");
                    Recado r=new Recado();
                    r.setID(atributos[0]);
                    r.setDe(atributos[1]);
                    r.setPara(atributos[2]);
                    r.setData_hora(atributos[3]);
                    r.setDescricao(atributos[5]);
                    if(atributos[4].equals("true")){
                        r.setAtivo(true);
                    } else {
                        r.setAtivo(false);
                    }
                    recados.add(r);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return recados;
        }else{
            JOptionPane.showMessageDialog(null,"O arquivo não existe");
            return recados;
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
        String texto=r.getID()+"#"+
            r.getDe()+"#"+
            r.getPara()+"#"+
            r.getData_hora()+"#"+
            r.getAtivo()+"#"+
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
