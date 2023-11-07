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
public class Hospede extends Pessoa{
    //atributos
    private String cpf;
    private double taxaDesconto;
    
    //construtor
    public Hospede(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
    }
    
    //get and set
    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public String getCpf() {
        return cpf;
    }

    public double getTaxaDesconto() {
        return taxaDesconto;
    }
    
}
