package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * Nomes: Bianca, Jeniffer e Julia rodrigues
 */

public class Recepcionista extends Pessoa{
    
    private int regFunc;
    private String turno;
    private ArrayList<Registro> registros;

    public Recepcionista(int regFunc, String nome) {
        super(nome);
        this.regFunc = regFunc;
        registros = new ArrayList<Registro> ();
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getRegFunc() {
        return regFunc;
    }

    public String getTurno() {
        return turno;
    }
    
     public void addRegistro (Registro r) {
        registros.add(r);
        r.setRecepcionista(this);
    } 
    
}
