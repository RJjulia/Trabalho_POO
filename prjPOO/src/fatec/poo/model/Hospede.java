
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * Nomes: Bianca, Jeniffer e Julia rodrigues
 */
public class Hospede extends Pessoa {
    
    private String cpf;
    private double taxaDesconto;
    private ArrayList<Registro> registros;

    public Hospede(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
        registros = new ArrayList<Registro> ();
    }

    public double getTaxaDesconto() {
        return taxaDesconto;
    }
    
    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public String getCpf() {
        return cpf;
    }

    public void addRegistro (Registro r) {
        registros.add(r);
        r.setHospede(this);
    } 
    
    public static boolean validarCPF(String cpf){
        
        cpf = cpf.replace(".", "").replace("-", "");
        System.out.println("["+ cpf);
        
        if(cpf == null || cpf.length() != 11){
            return false;
        }
        
        boolean iguais = true;
        for(int i = 0; i < cpf.length(); i++){
            if(cpf.charAt(i) != cpf.charAt(0)){
                iguais = false;
                break;
            }
        }
        if(iguais){
            return false;
        }
        
        int digito1 = 0;
        for(int i = 0; i< 9; i++){
            digito1 += (i + 1) * Character.getNumericValue(cpf.charAt(i)); 
        }
        digito1 = digito1 % 11;
        if(digito1 == 10){
            digito1=0;
        }
        
        
        int digito2 = 0;
        for(int i = 0; i< 10; i++){
            digito2 += (11 - i) * Character.getNumericValue(cpf.charAt(i)); 
        }
        digito2 = digito2 * 10;
        digito2 = digito2 % 11;
        if(digito2 == 10){
            digito2=0;
        }
        
        return cpf.endsWith(Integer.toString(digito1) + Integer.toString(digito2));
    }
        
}
