package com.recado.view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.*;
import java.io.IOException;
import java.util.Date;
import com.recado.beam.*;
import com.recado.controle.*;
import com.recado.Main;
/**
 * Classe responsável por criar e exibir a tela de cadastro de Recados.
 * 
 * @author Rodrigo Régio
 * @version 14/06/2018
 */
public class CriaRecados extends JFrame implements ActionListener{
    //Aqui ficam os itens que a janela terá que exibir
    JLabel id=new JLabel("ID");
    JLabel de=new JLabel("Recado de quem?");
    JLabel para=new JLabel("Recado para quem?");
    JLabel data_hora=new JLabel("Data e hora");
    JLabel descricao=new JLabel("Descrição do recado:");
    JTextField tid=new JTextField();
    JTextField tde=new JTextField();
    JTextField tpara=new JTextField();
    JTextField tdata_hora=new JTextField();
    JTextArea tdescricao=new JTextArea();
    JCheckBox atv=new JCheckBox("Recado ativo?");
    JButton limpar=new JButton("Limpar");
    JButton enviar=new JButton("Enviar");
    /**
     * Método para setar as configurações de tamanho, posicionamento, texto e eventos dos itens
     */
    public CriaRecados(){
        //Adicionando o título na barra de títulos
        super("Criando Recados - Recdo");
        //Aqui define o layout para não utilizar nenhum layout (ou seja, eu defino o meu layout)
        this.setLayout(null);
        //Quando clicar no botão de fechar no canto superior direito não fazer nada
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //Adicionando um evento para quando o usuário clicar no botão fechar 
        this.addWindowListener(new WindowAdapter()
        {
                @Override
                public void windowClosing(WindowEvent e){
                    //Quando clicar no botão fechar do canto superior direito ele desabilita a parte gráfica (fecha a janela) mas continua executando o programa
                    dispose();
                    //criar outra janela da classe principal do projeto 
                    Main janela=new Main();
                    //Ajusta o tamanho da janela
                    janela.setSize(350,100);
                    //deixe a janela visivel
                    janela.setVisible(true);
                }
            });
        //Setando o posicionamento e tamanho do Label ID
        id.setBounds(10,10,150,25);
        //Textfield ID (setando posicionamento e tamanho)
        tid.setBounds(170,10,200,25);
        //Desabilitando a edição do campo
        tid.setEnabled(false);
        //Setando o campo ID para um numero aleatorio entre 0 e 999.999 (quase 1 milhao para dificultar itens repetidose mesmo assim pode ser que ocorra)
        tid.setText((int) (Math.random()*999999)+"");
        //Label de (setando posicionamento e tamanho)
        de.setBounds(10,45,150,25);
        //JTextfield de (setando posicionamento e tamanho)
        tde.setBounds(170,45,200,25);
        //Jlabel para (setando posicionamento e tamanho)
        para.setBounds(10,80,150,25);
        //JTextField para (setando posicionamento e tamanho)
        tpara.setBounds(170,80,200,25);
        //label data_hora (setando posicionamento e tamanho)
        data_hora.setBounds(10,115,150,25);
        //textfield data_hora (setando posicionamento e tamanho)
        tdata_hora.setBounds(170,115,200,25);
        //Setando o texto do campo data_hora para pegar o a data e a hora e colocar esse dado no próprio campo (o método pegarDataEHora(é para pegar a data e hora do sistema)
        tdata_hora.setText(pegarDataEHora());
        //Desabilitando o campo de data e hora para o usuario não editar
        tdata_hora.setEnabled(false);
        //JLabel Descrição (setando posicionamento e tamanho)
        descricao.setBounds(10,150,350,25);
        //TextArea da descrição (setando posicionamento e tamanho)
        tdescricao.setBounds(10,185,350,350);
        //Definindo o campo para quebrar a linha automaticamente enquanto o usuario digita (fica somente na exibição da tela no arquivo texto fica sem quebras)
        tdescricao.setLineWrap(true);
        //btn limpar (setando posicionamento e tamanho)
        limpar.setBounds(10,545,150,25);
        //Adicionando evento para limpar os campos
        limpar.addActionListener(this);
        //btn Enviar (setando posicionamento e tamanho)
        enviar.setBounds(170,545,200,25);
        //Adicionando o evento no botão para enviar os dados ao arquivo
        enviar.addActionListener(this);
        //chamando método para adicionar e montar a tela
        this.montaTela();
    }

    /**
     * Evento para pegar a data e hora do sistema
     */
    public String pegarDataEHora(){
        //Definindo que o formato da data é o de baixo
        DateFormat formatoDataHora=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //Criando nova data
        Date data=new Date();
        //Retornando a data no formato desejado como string
        return formatoDataHora.format(data);
    }

    /**
     * Evento para limpar os campos
     */
    @Override
    public void actionPerformed(ActionEvent evento){
        //Se a fonte do evento for o botão limpar
        if(evento.getSource() == limpar){
            //altera o id para outro numero
            tid.setText((int) (Math.random()*999999)+"");
            //alterando os textos para texto em branco
            tde.setText("");
            tpara.setText("");
            //Alterando a hora para a hora atualizada
            tdata_hora.setText(pegarDataEHora());
            tdescricao.setText("");
            //Se a fonte do evento for do botão enviar
        }else if(evento.getSource() == enviar){
            //Armazena os dados do recado digitado na variavel r
            Recado r=new Recado();
            r.setID(Integer.parseInt(tid.getText()));
            r.setDe(tde.getText());
            r.setPara(tpara.getText());
            r.setData_hora(tdata_hora.getText());
            r.setAtivo(false);
            r.setDescricao(tdescricao.getText());
            String passou;
            /*
             * Se o recado está ativo a pessoa não passou o recado senão (caso o getAtivo estiver
             * false) a pessoa passou o recado
             */
            if(r.getAtivo()){
                passou="Não";
            }else{
                passou="Sim";
            }
            //Informando ao usuario que tudo ocorreu conforme planejado
            JOptionPane.showMessageDialog(null,"Dados do recado gravados com sucesso!",
                "Informações do recado - Recdo",JOptionPane.INFORMATION_MESSAGE);
            //criando objeto para realizar as operações no arquivo
            OperacoesRecados op=new OperacoesRecados();
            try{
                //tentar adicionar o recado no arquivo
                op.adicionarNoArquivo(r);
                //pegar o erro que ocorrer e exibir no JOptionPane abaixo
            }catch(IOException ioex){
                JOptionPane.showMessageDialog(null,ioex.getStackTrace(),
                    "Ocorreu um erro - Recdo",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Comando para adicionar os itens da tela ao getContentPane (painel)
     */
    public void montaTela(){
        getContentPane().add(id);
        getContentPane().add(tid);
        getContentPane().add(de);
        getContentPane().add(tde);
        getContentPane().add(para);
        getContentPane().add(tpara);
        getContentPane().add(data_hora);
        getContentPane().add(tdata_hora);
        getContentPane().add(limpar);
        getContentPane().add(enviar);
        getContentPane().add(descricao);
        getContentPane().add(tdescricao);
    }

    /**
     * Comando para iniciar a janela, dar o tamanho e ficar visivel
     */
    public static void main(String [] args){
        CriaRecados janela=new CriaRecados();
        janela.setSize(800,600);
        janela.setVisible(true);
    }
}
