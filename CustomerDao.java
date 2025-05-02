package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Customer;
import model.Mechanic;

/**
 *
 * @author AmTechGuy
 */
public class CustomerDao {

    public static void save(Customer customers) {
        String query = "insert into customer(name, gender, mobileNumber, email, companyName, country, state, address)"
                + "values('" + customers.getName() + "', '" + customers.getGender() + "', '" + customers.getMobileNumber() + "', '" + customers.getEmail() + "',"
                + "'" + customers.getCompanyName() + "', '" + customers.getCountry() + "', '" + customers.getState() + "',  '" + customers.getAddress() + "')";
        DbOperation.setDataOrDelete(query, "Customer Successfull Added!!");

    }

    public static ArrayList<Customer> getAllCustomerNames() {
        ArrayList<Customer> customerList = new ArrayList<>();
        String name = "Select name from customer";
        try {
            ResultSet res = DbOperation.getData(name);
            while (res.next()) {
                Customer customer = new Customer();
                customer.setName(res.getString("name"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static ArrayList<Customer> getAllRecords() {
        ArrayList<Customer> customersList = new ArrayList<>();
        try {
            ResultSet rs = DbOperation.getData("Select * from customer");
            while (rs.next()) {
                Customer customers = new Customer();
                customers.setId(rs.getString("id"));
                customers.setName(rs.getString("name"));
                customers.setGender(rs.getString("gender"));
                customers.setMobileNumber(rs.getString("mobileNumber"));
                customers.setEmail(rs.getString("email"));
                customers.setCompanyName(rs.getString("companyName"));
                customers.setCountry(rs.getString("country"));
                customers.setState(rs.getString("state"));
                customers.setAddress(rs.getString("address"));
                customersList.add(customers);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching record!");
        }
        return customersList;
    }
    
        public static ArrayList<Customer> getAllCustomerDetails() {
        ArrayList<Customer> customerDetails = new ArrayList<>();
        String query = "Select id, name from customer";
        try {
            ResultSet res = DbOperation.getData(query);
            while (res.next()) {
                Customer customer = new Customer();
                customer.setId(res.getString("id"));
                customer.setName(res.getString("name"));
                customerDetails.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerDetails;
    }

}
