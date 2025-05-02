package controllers;

/**
 *
 * @author AmTechGuy
 */
public class Tables {

    public static void main(String args[]) {
        String userQuery = "create table mechanics(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200),"
                + "password varchar(200), gender varchar(200), mobileNumber varchar(200), branch varchar(200),"
                + "joinDate varchar(200), dob varchar(200), country varchar(200), state varchar(200), lga varchar(200),"
                + "town varchar(200), address varchar(200), status varchar(200), UNIQUE(email))";
        //DbOperation.setDataOrDelete(userQuery, "Mechanic table created Successfully!");

        String countryStateTable = "create table countryState(id int AUTO_INCREMENT primary key, country varchar(200),"
                + " state varchar(200), lga varchar(200))";
        //DbOperation.setDataOrDelete(countryStateTable , "Country and State table created Successfully!");

        String customerQuery = "create table customer(id int AUTO_INCREMENT primary key, name varchar(200), gender varchar(200), mobileNumber varchar(200),"
                + "email varchar(200), companyName varchar(200), country varchar(200), state varchar(200), town varchar(200), address varchar(200), UNIQUE(email))";
        //DbOperation.setDataOrDelete(customerQuery, "Customer table created successfully!!!");

        String vehicleQuery = "create table vehicleTB(id int AUTO_INCREMENT primary key, vehicleType varchar(200), vehicleBrand varchar(200), fuelType varchar(200),"
                + "modelName varchar(200), plateNumber varchar(200), customer varchar(200), modelYear varchar(200), engineNumber varchar(200), color varchar(200))";
        //DbOperation.setDataOrDelete(vehicleQuery, "Table created successfully!");

        String faultsTB = "create table FaultTB(id int AUTO_INCREMENT primary key, name varchar(200), price varchar(200))";
        //DbOperation.setDataOrDelete(faultsTB, "Table created successfully!");

        String productTB = "create table part(id int AUTO_INCREMENT primary key, name varchar(200), manufacturer varchar(200), purchase varchar(200), "
                + "price varchar(200), suppliers varchar(200), quantity varchar(200))";
        //DbOperation.setDataOrDelete(productTB, "Table created successfully!");

        String serviceTB = "create table service(id int AUTO_INCREMENT primary key, serviceID varchar(200),  serviceDate varchar(200),mechanic varchar(200),"
                + " customer varchar(200), vehicle varchar(200), totalAmount INT)";
        DbOperation.setDataOrDelete(serviceTB, "Table created successfully!");

    }

}
