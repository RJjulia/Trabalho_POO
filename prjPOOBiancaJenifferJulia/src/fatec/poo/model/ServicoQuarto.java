/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author 0030482211021
 */
public class ServicoQuarto {
    //atributos
    private int codigo;
    private String Descricao;
    private double valor;
    
    //construtor
    public ServicoQuarto(int codigo, String Descricao) {
        this.codigo = codigo;
        this.Descricao = Descricao;
    }
    
    //get and set
    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public double getValor() {
        return valor;
    }
    
    
}
