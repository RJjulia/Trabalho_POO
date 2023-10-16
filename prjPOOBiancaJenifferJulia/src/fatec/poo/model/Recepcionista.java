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
public class Recepcionista extends Pessoa{
    //atributos
    private int regFunc;
    private String turno;
    
    //construtor
    public Recepcionista(int regFunc, String nome) {
        super(nome);
        this.regFunc = regFunc;
    }
    
    //set and get
    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getRegFunc() {
        return regFunc;
    }

    public String getTurno() {
        return turno;
    }
    
    
    
    
}
