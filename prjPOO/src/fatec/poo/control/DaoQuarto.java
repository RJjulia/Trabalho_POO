
package fatec.poo.control;

import fatec.poo.model.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bianca, Jeniffer e Julia Rodrigues
 */
public class DaoQuarto {
     private Connection conn;
    
    public DaoQuarto(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Quarto quarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbQuarto(Numero_Quarto, Tipo_Quarto, ValorDiaria_Quarto) VALUES(?,?,?)");
            ps.setInt(1, quarto.getNumero());
            ps.setString(2, quarto.getTipo());
            ps.setDouble(3, quarto.getValorDiaria());
            
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Quarto quarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbQuarto set ValorDiaria_Quarto = ?, Tipo_Quarto = ? " +
                                                 "where Numero_Quarto = ?");
            
            ps.setDouble(1, quarto.getValorDiaria());
            ps.setString(2, quarto.getTipo());
            ps.setInt(3, quarto.getNumero());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public Quarto consultar (int numero) {
        Quarto q = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbQuarto where " +
                                                 "Numero_Quarto = ?");
            
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                q = new Quarto (numero, rs.getString("Tipo_Quarto"), rs.getDouble("ValorDiaria_Quarto"));
            }
        }
        catch (SQLException ex) { 
                System.out.println(ex.toString());   
            }
        return (q);
    }    
     
     public void excluir(Quarto quarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbQuarto where Numero_Quarto = ?");
            
            ps.setInt(1, quarto.getNumero());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
}
