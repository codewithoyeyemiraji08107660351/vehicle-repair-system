/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.ResultSet;
import model.Fault;
import java.util.ArrayList;
/**
 *
 * @author AmTechGuy
 */
public class RepairDao {
    
    public static void save(Fault fault){
        String saveQuery = "insert into FaultTB(name, price)values('"+fault.getName()+"', '"+fault.getPrice()+"')";
        DbOperation.setDataOrDelete(saveQuery, "Saved!!");
    }
    
    public static ArrayList<Fault> getAllProblems(){
        ArrayList<Fault> faultList = new ArrayList<>();
        try {
            String query = "select * from FaultTB";
            ResultSet res = DbOperation.getData(query);
            while(res.next()){
                Fault fault = new Fault();
                fault.setId(res.getInt("id"));
                fault.setName(res.getString("name"));
                fault.setPrice(res.getString("price"));
                faultList.add(fault);
            }
            
        } catch (Exception e) {
        }
        return faultList;
    }
    
}
