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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Vehicles;

public class VehicleDao {

    public static void save(Vehicles vehicles) {
        String query = "insert into vehicleTB(vehicleType,vehicleBrand,fuelType,modelName,plateNumber,customer,modelYear,engineNumber,color)"
                + "values('" + vehicles.getVehicelType() + "','" + vehicles.getVehicleBrand() + "','" + vehicles.getFuelType() + "','" + vehicles.getModelName() + "',"
                + "'" + vehicles.getPlateNumber() + "','" + vehicles.getCustomer() + "','" + vehicles.getModelYear() + "','" + vehicles.getEngineNo() + "','" + vehicles.getColor() + "')";
        DbOperation.setDataOrDelete(query, "Vehicles Added!!");
    }

    public static ArrayList<Vehicles> getAllVehicles() {
        ArrayList<Vehicles> vehicleList = new ArrayList<>();
        String query = "Select * from vehicleTB";
        try {
            ResultSet res = DbOperation.getData(query);
            while (res.next()) {
                Vehicles vehicles = new Vehicles();
                vehicles.setId(res.getString("id"));
                vehicles.setVehicelType(res.getString("vehicleType"));
                vehicles.setVehicleBrand(res.getString("vehicleBrand"));
                vehicles.setFuelType(res.getString("fuelType"));
                vehicles.setModelName(res.getString("modelName"));
                vehicles.setPlateNumber(res.getString("plateNumber"));
                vehicles.setCustomer(res.getString("customer"));
                vehicles.setModelYear(res.getString("modelYear"));
                vehicles.setEngineNo(res.getString("engineNumber"));
                vehicles.setColor(res.getString("color"));
                vehicleList.add(vehicles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

    public static ArrayList<Vehicles> getVehicleNames(String customer) {
        ArrayList<Vehicles> namesList = new ArrayList<>();
        String query = "Select modelName from vehicleTB where customer = '"+customer+"'";
        try {
            ResultSet res = DbOperation.getData(query);
            while (res.next()) {
                Vehicles vehicles = new Vehicles();
                vehicles.setModelName(res.getString("modelName"));
                namesList.add(vehicles);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Fetching records!");
        }
        return namesList;
    }
    
   

}
