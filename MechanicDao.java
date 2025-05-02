package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mechanic;

/**
 *
 * @author AmTechGuy
 */
public class MechanicDao {

    public static void save(Mechanic mechanic) {

        String qiery = "insert into mechanics(name, email, password, gender, mobileNumber, branch, joinDate, dob, country, state, lga, town, address, status)"
                + "values('" + mechanic.getName() + "', '" + mechanic.getEmail() + "', '" + mechanic.getPassword() + "', '" + mechanic.getGender() + "', '" + mechanic.getMobileNumber() + "',"
                + "'" + mechanic.getBranch() + "', '" + mechanic.getJoinDate() + "', '" + mechanic.getDob() + "', '" + mechanic.getCountry() + "', '" + mechanic.getState() + "', '" + mechanic.getLga() + "',"
                + "'" + mechanic.getTown() + "', '" + mechanic.getAddress() + "', 'Available')";
        DbOperation.setDataOrDelete(qiery, "Mechanic Successfully Added!!");
    }

    public static Mechanic login(String email, String password) {
        try {
            String query = "select * from mechanics where email = '" + email + "' and password = '" + password + "'";
            ResultSet res = DbOperation.getData(query);
            while (res.next()) {
                Mechanic mechanic = new Mechanic();
                mechanic.setEmail(res.getString("email"));
                mechanic.setPassword(res.getString("password"));
                return mechanic;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Mechanic> getAllMechanicNames() {
        ArrayList<Mechanic> mechanicList = new ArrayList<>();
        String name = "Select name from mechanics";
        try {
            ResultSet res = DbOperation.getData(name);
            while (res.next()) {
                Mechanic mechanic = new Mechanic();
                mechanic.setName(res.getString("name"));
                mechanicList.add(mechanic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mechanicList;
    }

    public static ArrayList<String> getAllCountry() {
        ArrayList<String> countryList = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT country FROM countrystate";
            ResultSet res = DbOperation.getData(query);
            while (res.next()) {
                String countryName = res.getString("country");
                countryList.add(countryName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryList;
    }

    public static ArrayList<String> getAllState(String country) {
        ArrayList<String> stateList = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT state FROM countrystate WHERE country = '" + country + "'";
            ResultSet res = DbOperation.getData(query);
            while (res.next()) {
                String stateName = res.getString("state");
                stateList.add(stateName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stateList;
    }

    public static ArrayList<String> getAllLga(String state) {
        ArrayList<String> lgaList = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT lga FROM countrystate WHERE state = '" + state + "'";
            ResultSet res = DbOperation.getData(query);
            while (res.next()) {
                String lgaName = res.getString("lga");
                lgaList.add(lgaName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lgaList;
    }

    public static ArrayList<Mechanic> getAllStatus() {
        ArrayList<Mechanic> mechStatus = new ArrayList<>();
        try {
            ResultSet rs = DbOperation.getData("Select * from mechanics");
            while (rs.next()) {
                Mechanic mechanic = new Mechanic();
                mechanic.setId(rs.getString("id"));
                mechanic.setName(rs.getString("name"));
                mechanic.setStatus(rs.getString("status"));
                mechStatus.add(mechanic);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching record!");
        }
        return mechStatus;
    }

    public static void changeStatus(String id, String status) {
        String statusUpdate = "update mechanics set status = '" + status + "' where id = '" + id + "'";
        DbOperation.setDataOrDelete(statusUpdate, "");
    }

    public static void delete(String id) {
        String deleteMechanic = "delet from mechanics where id = '" + id + "'";
        DbOperation.setDataOrDelete(deleteMechanic, "Sucessfully Deleted!!");
    }

    public static ArrayList<Mechanic> getAllMechanics() {
        ArrayList<Mechanic> mechanicsList = new ArrayList<>();
        String query = "Select * from mechanics";
        try {
            ResultSet res = DbOperation.getData(query);
            while (res.next()) {
                Mechanic mechanic = new Mechanic();
                mechanic.setId(res.getString("id"));
                mechanic.setName(res.getString("name"));
                mechanic.setStatus(res.getString("status"));
                mechanicsList.add(mechanic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mechanicsList;
    }
}
