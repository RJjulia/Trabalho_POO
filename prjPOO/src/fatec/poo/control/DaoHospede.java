package fatec.poo.control;

import fatec.poo.model.Hospede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bianca, Jeniffer e Julia Rodrigues
 */
public class DaoHospede {
    private Connection conn;
    
    public DaoHospede(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Hospede hospede) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbHospede(Cpf_Hospede, Nome_Hospede, Endereco_Hospede, Telefone_Hospede, TaxaDesconto_Hospede) VALUES(?,?,?,?,?)");
            ps.setString(1, hospede.getCpf());
            ps.setString(2, hospede.getNome());
            ps.setString(3, hospede.getEndereco());
            ps.setString(4, hospede.getTelefone());
            ps.setDouble(5, hospede.getTaxaDesconto());
            
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Hospede hospede) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbHospede set Nome_Hospede = ?, Endereco_Hospede = ?, Telefone_Hospede = ?, TaxaDesconto_Hospede = ? " +
                                                 "where Cpf_Hospede = ?");
            
            ps.setString(1, hospede.getNome());
            ps.setString(2, hospede.getEndereco());
            ps.setString(3, hospede.getTelefone());
            ps.setDouble(4, hospede.getTaxaDesconto());
            ps.setString(5, hospede.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public Hospede consultar (String cpf) {
        Hospede h = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbHospede where " +
                                                 "Cpf_Hospede = ?");
            
            ps.setString(1,cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                h = new Hospede (rs.getString("Nome_Hospede"), cpf);
                h.setEndereco(rs.getString("Endereco_Hospede"));
                h.setTelefone(rs.getString("Telefone_Hospede"));
                h.setTaxaDesconto(rs.getDouble("TaxaDesconto_Hospede"));
            }
        }
        catch (SQLException ex) { 
                System.out.println(ex.toString());   
            }
        return (h);
    }    
     
     public void excluir(Hospede hospede) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbHospede where Cpf_Hospede = ?");
            
            ps.setString(1,hospede.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}


