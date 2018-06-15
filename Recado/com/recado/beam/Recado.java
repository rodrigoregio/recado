package com.recado.beam;

/**
 * Esta é a classe Beam que corresponde a um recado (podem ser criados ou lidos os recados com ela)
 * 
 * @author Rodrigo Régio
 * @version 14/06/2018
 */
public class Recado{
    /**
     * Atributos da classe 
     * id (para localização de um recado(), 
     * de (corresponde a quem ligou ou deixou o recado),
     * para (corresponde a quem o recado é destinado),
     * data_hora (corresponde á data e hora que o recado
     *      é inserido no sistema)
     * descrição (é o recado em si
     */
    private int id;
    private String de;
    private String para;
    private String data_hora;
    private String descricao;
    private boolean ativo;
    /**
     * Getter da descrição do recado
     */
    public String getDescricao(){
        return descricao;
    }

    /**
     * setter da descrição do recado
     */
    public void setDescricao(String desc){
        this.descricao=desc;
    }

    /**
     * getter do status do recado
     */
    public boolean getAtivo(){
        return ativo;
    }

    /**
     * setter do status do recado
     */
    public void setAtivo(boolean at){
        this.ativo=at;
    }

    /**
     * getter do id do recado
     */
    public int getID(){
        return id;
    }

    /**
     * setter do id do recado
     */
    public void setID(int ident){
        this.id=ident;
    }

    /**
     * getter do De (de quem é o recado)
     */
    public String getDe(){
        return de;
    }

    /**
     * setter do De (de quem é o recado)
     */
    public void setDe(String de_who){
        this.de=de_who;
    }

    /**
     * getter do Para (para quem é o recado)
     */
    public String getPara(){
        return para;
    }

    /**
     * setter do Para (para quem é o recado)
     */
    public void setPara(String pa){
        this.para=pa;
    }

    /**
     * getter da hora (
     */
    public String getData_hora(){
        return data_hora;
    }

    /**
     * e setter da hora
     */
    public void setData_hora(String now){
        this.data_hora=now;
    }
}
