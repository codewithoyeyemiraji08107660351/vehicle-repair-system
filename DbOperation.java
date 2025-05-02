
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author AmTechGuy
 */
public class DbOperation {
    
    public static void setDataOrDelete(String query, String message){
        
        try{
           Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            if(!message.equals("")){
                JOptionPane.showMessageDialog(null, message);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static ResultSet getData(String query){        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
            
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error connecting to database");
           return null;
        }
    }
    
}
