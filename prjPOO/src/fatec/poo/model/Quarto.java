package fatec.poo.model;

/**
 *
 * Nomes: Bianca, Jeniffer e Julia rodrigues
 */
public class Quarto {
    
    private int numero;
    private String tipo;
    private boolean situacao;
    private double valorDiaria;
    private double totalFaturado;

    public Quarto(int numero, String tipo, double valorDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
    } 
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getTotalFaturado() {
        return totalFaturado;
    }

    public void resevar() {
        this.situacao = true;
    }
    
    public double liberar(int quantDias) {
        double valorHospedagem;
        this.situacao = false;
        valorHospedagem = quantDias * this.valorDiaria;
        this.totalFaturado += valorHospedagem;
        return valorHospedagem;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
}
