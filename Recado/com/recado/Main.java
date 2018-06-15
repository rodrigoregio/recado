package com.recado;
import javax.swing.*;
import com.recado.view.*;

/**
 * Esta é a classe que irá chamar/executar todas as outras nos pacotes
 * 
 * @author Rodrigo Régio
 * @version 14/06/2018
 */
public class Main{
    //Métodos para realizar as perguntas
    /**
     * método para realizar as perguntas antes de iniciar as janelas (em outra versão irei colocar uma janela específica)
     */
    public static void pergunta(){
        //opção
        int opcao;
        //faça isso
        do{
            //solicitar um numero ao usuario
            opcao=Integer.parseInt(JOptionPane.showInputDialog(null,
                "Digite a opção desejada:\n\n"+
                "1 - Criar Recados\n"+
                "2 - Ler Recados","Escolha uma opção",JOptionPane.QUESTION_MESSAGE));
            //Se a opção for 1
            if(opcao == 1){
                //Cria a janela de criação de recados
                CriaRecados janela=new CriaRecados();
                //altera o tamanho da janela
                janela.setSize(800,600);
                //deixa a janela visivel
                janela.setVisible(true);
                //se a opção for 2 exiba a mensagem informando que ainda não está desenvolvido
            } else if(opcao == 2){
                //exibindo a mensagem
                JOptionPane.showMessageDialog(null,"Opção ainda não implementada!\n\nAguarde o "+
                    "desenvolvimento", "Em desenvolvimento",JOptionPane.INFORMATION_MESSAGE);
                //opção recebe 1 para voltar a entrar no loop
                opcao=1;
            }else{
                //Se a opção for diferente das duas informa que não é uma opção válida
                JOptionPane.showMessageDialog(null,opcao+" não é uma opção válida!", "Em desenvolvimento"
                    ,JOptionPane.INFORMATION_MESSAGE);
                //pergunta se o usuario quer escolher outra opção ou sair
                String volta=JOptionPane.showInputDialog(null,"Deseja voltar e escolher outra opção?","Voltar?",JOptionPane.YES_NO_OPTION);
                //se a opção for igual a 's' ou 'S'
                if(volta.equalsIgnoreCase("s")){
                    //a opção recebe 1
                    opcao=1;
                }else{
                    //senão sai do sistema
                    System.exit(0);
                }
            }
            //enquanto a opção for entre 0 e 10 volta até o do e refaz os passos seguintes
        }while((opcao > 0) && (opcao < 10));
    }
    //método principal executável
    /**
     * Classe para executar o método de perguntas
     */
    public static void main(String[] args){
        //executa a pergunta
        pergunta();
    }
}