/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author AmTechGuy
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Fault;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FaultDao {

    public static void save(Fault fault) {
        String query = "insert into FaultTB(name,price)values('" + fault.getName() + "', '" + fault.getPrice() + "')";
        DbOperation.setDataOrDelete(query, "Successfully!!");
    }

    public static void update(int id, String name, String price) {
        String query = "update FaultTB set name = '" + name + "', price = '" + price + "' where id = '" + id + "'";
        DbOperation.setDataOrDelete(query, "Successfully Updated!!");

    }

    public static ArrayList<Fault> getAllRecords() {
        ArrayList<Fault> faultsList = new ArrayList<>();
        try {
            ResultSet rs = DbOperation.getData("Select * from FaultTB");
            while (rs.next()) {
                Fault fault = new Fault();
                fault.setId(rs.getInt("id"));
                fault.setName(rs.getString("name"));
                fault.setPrice(rs.getString("price"));
                faultsList.add(fault);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching record!");
        }
        return faultsList;
    }
}
