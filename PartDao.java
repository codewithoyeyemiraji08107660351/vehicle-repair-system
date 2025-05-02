/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Part;

/**
 *
 * @author AmTechGuy
 */
public class PartDao {

    public static void save(Part part) {
        String savePart = "insert into part(name,manufacturer,purchase,price,suppliers,quantity)"
                + "values('" + part.getName() + "', '" + part.getManafacturer() + "', '" + part.getPruchase() + "',"
                + "'" + part.getPrice() + "', '" + part.getSuppliiers() + "', '" + part.getQuantity() + "')";
        DbOperation.setDataOrDelete(savePart, "Successfully Added!!!");
    }

    public static void delete(String id) {
        String deletePart = "delete from part where id = '" + id + "'";
        DbOperation.setDataOrDelete(deletePart, "Deleted Successfully!");
    }

    public static ArrayList<Part> getAllRecords() {
        ArrayList<Part> partList = new ArrayList<>();
        try {
            ResultSet rs = DbOperation.getData("Select * from part");
            while (rs.next()) {
                Part part = new Part();
                part.setId(rs.getString("id"));
                part.setName(rs.getString("name"));
                part.setManafacturer(rs.getString("manufacturer"));
                part.setPruchase(rs.getString("purchase"));
                part.setPrice(rs.getString("price"));
                part.setSuppliiers(rs.getString("suppliers"));
                part.setQuantity(rs.getString("quantity"));
                partList.add(part);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching record!");
        }
        return partList;
    }
}
