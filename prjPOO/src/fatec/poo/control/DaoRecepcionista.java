package fatec.poo.control;

import fatec.poo.model.Recepcionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bianca, Jeniffer e Julia Rodriguee
 */
public class DaoRecepcionista {
    private Connection conn;
    
    public DaoRecepcionista (Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Recepcionista recepcionista) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbRecepcionista (regFunc, nome, endereco, telefone, turno) VALUES (?, ?, ?, ? ?)");
            ps.setInt(1, recepcionista.getRegFunc());
            ps.setString(2, recepcionista.getNome());
            ps.setString(3, recepcionista.getEndereco());
            ps.setString(4,recepcionista.getTelefone());
            ps.setString(5, recepcionista.getTurno());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Recepcionista recepcionista) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbRecepcionista set regFunc = ?, nome = ?, endereco = ?, telefone = ?, turno = ?");
            
            ps.setInt(1, recepcionista.getRegFunc());
            ps.setString(2, recepcionista.getNome());
            ps.setString(3, recepcionista.getEndereco());
            ps.setString(4,recepcionista.getTelefone());
            ps.setString(5, recepcionista.getTurno());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Recepcionista consultar(int regFunc) {
        Recepcionista r = null;
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM tbRecepcionista where" + "regFunc = ?");
        
            ps.setInt(1, regFunc);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true) {
               r = new Recepcionista(regFunc, rs.getString("nome"));  
               r.setEndereco(rs.getString("Endereco"));
               r.setTelefone(rs.getString("Telefone"));
               r.setTurno(rs.getString("Turno"));
            }
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return (r);
    }
    
    public void excluir(Recepcionista recepcionista){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbRecepcionista where regFunc = ?");
            
            ps.setInt(1, recepcionista.getRegFunc());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
    
        }
    }
        
    
}
