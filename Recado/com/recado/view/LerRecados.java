package com.recado.view;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import com.recado.*;
import com.recado.controle.*;
import com.recado.beam.*;
/**
 * Classe criada para realizar a leitura de do arquivo recado.txt da pasta corrente do projeto
 * 
 * @author Rodrigo Régio
 * @version 15/06/2018
 */
public class LerRecados extends JFrame implements ActionListener{
    /*
     * Componentes que a janela usará que serão basicamente todos os da classe de criação e os dois 
     * botões de limpar campos e enviar os dados serão substituidos por próximo e anterior
     */
    int ind=0;
    JLabel id=new JLabel("ID");
    JLabel de=new JLabel("Recado de quem?");
    JLabel para=new JLabel("Recado para quem?");
    JLabel data_hora=new JLabel("Data e hora");
    JLabel descricao=new JLabel("Descrição do recado:");
    JLabel indice=new JLabel("Indice: ");
    JTextField tid=new JTextField();
    JTextField tde=new JTextField();
    JTextField tpara=new JTextField();
    JTextField tdata_hora=new JTextField();
    JTextArea tdescricao=new JTextArea();
    JCheckBox atv=new JCheckBox("Recado lido?");
    JButton prox=new JButton("Próximo recado");
    JButton ant=new JButton("Recado anterior");
    JButton loadRecados=new JButton("Carregar recados");
    /**
     * Método para setar as configurações de tamanho, posicionamento, texto e eventos da janela
     */
    public LerRecados(){
        //Adicionando Titulo na barra de titulos
        super("Lendo Recados - Recdo");
        //Aqui defino o layout para não utilizar nenhum layout (ou seja, eu defino meu próprio layout)
        this.setLayout(null);
        //Adicionando um evento para quando clicarem para fechar (no canto superior direito) não fazer nada
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //Aqui adiciono um ouvinte na janela
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e){
                //feche a janela (porém o programa ainda executa)
                dispose();
                //criar outra janela da classe principal do projeto 
                Main janela=new Main();
                //Ajusta o tamanho da janela
                janela.setSize(350,100);
                //deixe a janela visivel
                janela.setVisible(true);
            }
        }
        );
        
        //setando o posicionamento e tamanho do label ID
        id.setBounds(10,10,150,25);
        //setando o posicionamento e tamanho do textfield ID
        tid.setBounds(170,10,150,25);
        //tornando o campo desabilitado
        tid.setEnabled(false);
        //setando o posicionamento e tamanho do label de
        de.setBounds(10,45,150,25);
        //Setando o posicionamento e tamanho do JTextField de
        tde.setBounds(170,45,150,25);
        tde.setEnabled(false);
        //Setando o posicionamento e tamanho do JLabel para
        para.setBounds(10,80,150,25);
        //Setando o posicionamento e tamanho do JTextField para
        tpara.setBounds(170,80,150,25);
        tpara.setEnabled(false);
        //setando o posicionamento e tamanho do label data_hora
        data_hora.setBounds(10,115,150,25);
        //setando o posicionamento e tamanho do textfield data_hora
        tdata_hora.setBounds(170,115,150,25);
        tdata_hora.setEnabled(false);
        //setando o posicionamento e tamanho do label descrição
        descricao.setBounds(10,150,310,25);
        //setando o posicionamento e tamanho do TextArea Descricao
        tdescricao.setBounds(10,185,310,350);
        //dizendo que o textarea quando encher uma linha de caracteres o
        //textarea mesmo muda para a próxima linha
        tdescricao.setLineWrap(true);
        //desabilitando o textarea descrição para não ser editavel
        tdescricao.setEnabled(false);
        //setando o posicionamento e tamanho do jcheckbox ativo
        atv.setBounds(10,540,150,25);
        //Setando o tamanho e posicionamento do JButton ant
        ant.setBounds(10,575,150,25);
        ant.addActionListener(this);
        //setando o posicionamento e tamanho do JButton prox
        prox.setBounds(170,575,150,25);
        prox.addActionListener(this);
        //setando tamanho e posicionamento do JButton carregarContatos
        loadRecados.setBounds(10,610,310,25);
        loadRecados.addActionListener(this);
        //setando tamanho e posicionamento do JLabel indice
        indice.setBounds(10,645,310,25);
        this.montaTela();
    }
    @Override
    public void actionPerformed(ActionEvent evento){
        try{
            OperacoesRecados op=new OperacoesRecados();
            ArrayList <Recado> recados=op.lerArquivo();
            
            if(evento.getSource() == loadRecados){
            
                //JOptionPane.showMessageDialog(null,"Dados carregados com sucesso","Dados carregados",JOptionPane.INFORMATION_MESSAGE);
                Recado r=recados.get(ind);
            
                tid.setText(r.getID()+"");
                tde.setText(r.getDe());
                tpara.setText(r.getPara());
                tdata_hora.setText(r.getData_hora());
                tdescricao.setText(r.getDescricao());
                atv.setSelected(true);
                indice.setText("Indice = "+ind);
            }
            if(evento.getSource() == ant){
                ind=ind - 1;
                indice.setText("Indice = "+ind);
                Recado r=recados.get(ind);
            
                tid.setText(r.getID()+"");
                tde.setText(r.getDe());
                tpara.setText(r.getPara());
                tdata_hora.setText(r.getData_hora());
                tdescricao.setText(r.getDescricao());
                atv.setSelected(true);
            }
            if(evento.getSource() == prox){
                ind=ind+1;
                indice.setText("Indice = "+ind);
                Recado r=recados.get(ind);
            
                tid.setText(r.getID()+"");
                tde.setText(r.getDe());
                tpara.setText(r.getPara());
                tdata_hora.setText(r.getData_hora());
                tdescricao.setText(r.getDescricao());
                atv.setSelected(true);
                
            }
        }catch(java.io.IOException e){
            e.printStackTrace();
        }catch(java.lang.IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    public void montaTela(){
        getContentPane().add(id);
        getContentPane().add(tid);
        getContentPane().add(de);
        getContentPane().add(tde);
        getContentPane().add(para);
        getContentPane().add(tpara);
        getContentPane().add(tdata_hora);
        getContentPane().add(data_hora);
        getContentPane().add(descricao);
        getContentPane().add(tdescricao);
        getContentPane().add(atv);
        getContentPane().add(ant);
        getContentPane().add(prox);
        getContentPane().add(loadRecados);
        getContentPane().add(indice);
    }
    public static void main(String [] args){
        LerRecados ler=new LerRecados();
        ler.setSize(800,800);
        ler.setVisible(true);
    }
}
