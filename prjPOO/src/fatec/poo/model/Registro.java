package fatec.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * Nomes: Bianca, Jeniffer e Julia rodrigues
 */
public class Registro {
    
    private int codigo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorHospedagem;
    private Recepcionista recepcionista; //multiplicidade 1
    private Hospede hospede; //multiplicidade 1
    private Quarto quarto;
    private ArrayList<ServicoQuarto> servicos;

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista) {
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;
        servicos = new ArrayList<ServicoQuarto> ();
    }
    
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
    
    public Recepcionista getRecepcionista() {
        return recepcionista;
    }
    
    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    
     public void addServico (ServicoQuarto s) {
        servicos.add(s);
    } 
    
    public void reservarQuarto(Hospede hospede, Quarto quarto) {
        quarto.resevar();
        setQuarto(quarto);
        setHospede(hospede);
    }
    
    public double liberarQuarto() {
        long dias = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        double valPagar;
        valorHospedagem = quarto.liberar(Math.toIntExact(dias));
        double valorServicos = 0;
        for(ServicoQuarto s : servicos){
            valorServicos += s.getValor();
        }
        valPagar = valorHospedagem + valorServicos;
        if (hospede.getTaxaDesconto() > 0){
            return valPagar * (1 - (hospede.getTaxaDesconto()/100));
        }
        return valPagar;
    }
    
}
