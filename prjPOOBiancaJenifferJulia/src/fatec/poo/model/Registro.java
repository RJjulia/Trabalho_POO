/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.time.LocalDate;

/**
 *
 * @author 0030482211021
 */
public class Registro {
    //atributos
    private int codigo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorHospedagem;
    
    //set and get
    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public double getValorHospedagem() {
        return valorHospedagem;
    }
    
    //construtor
    public Registro(int codigo, LocalDate dataEntrada) {
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        //faltando coisa
    }
    
    //demais metodos
    /*public void reservarQuarto(Hospede , Quarto) { 
        implementar
    }
    
    public double liberarQuarto() {
        implementar
    }*/
    
}
