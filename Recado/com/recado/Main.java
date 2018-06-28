package com.recado;
import javax.swing.*;
import com.recado.view.*;
import java.awt.event.*;
import com.recado.view.*;
/**
 * Esta é a classe que irá chamar/executar todas as outras nos pacotes
 * 
 * @author Rodrigo Régio
 * @version 15/06/2018
 */
public class Main extends JFrame implements ActionListener{
    /**
     * Componentes a serem usados na janela
     */
    JLabel Criar=new JLabel("Criar Recado");
    JLabel Ler=new JLabel("Ler Recado");
    JButton c=new JButton("Iniciar criação");
    JButton l=new JButton("Iniciar leitura");
    public Main(){
        //Adicionando titulo á barra de títulos
        super("Opções - Recdo");
        //Alterando o layout para nulo (não utilizar nenhum e eu crio o meu próprio layout)
        this.setLayout(null);
        //Quando clicar em fechar o sistema todo será encerrado
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Definindo posicionamento e tamanho do jlabel criar
        Criar.setBounds(10,10,150,25);
        //Definindo posicionamento e tamanho do jbutton c
        c.setBounds(170,10,150,25);
        c.addActionListener(this);
        //Definindo posicionamento e tamanho do jlabel ler
        Ler.setBounds(10,45,150,25);
        //Definindo posicionamento e tamanho do botaão l
        l.setBounds(170,45,150,25);
        l.addActionListener(this);
        //Chama o método para montar a janela
        this.montaTela();
    }
    /**
     * Métodos para realizar ações quando os botões forem clicados
     */
    @Override
    public void actionPerformed(ActionEvent e){
        //Se a fonte do evento for do botão c
        if(e.getSource() == c){
            //Cria-se a janela de criação de recados
            CriaRecados cr=new CriaRecados();
            //Ajusta-se o tamanho da janela
            cr.setSize(400,800);
            //coloca-se a tela para ser exibida
            cr.setVisible(true);
            //some a tela
            this.dispose();
        }else
        //senão se a fonte do evento for do botão l
        if(e.getSource() == l){
            LerRecados ler=new LerRecados();
            ler.setSize(400,800);
            ler.setVisible(true);
            this.dispose();
        }
    }
    /**
     * Método para montar a tela (adicionando os itens á janela)
     */
    public void montaTela(){
        getContentPane().add(Criar);
        getContentPane().add(c);
        getContentPane().add(Ler);
        getContentPane().add(l);
    }
    /**
     * Método principal executavel
     */
    public static void main(String[] args){
        //Cria-se a janela
        Main janela=new Main();
        //Ajusta-se o tamanho da janela
        janela.setSize(400,800);
        //Exibe a janela
        janela.setVisible(true);
    }
}