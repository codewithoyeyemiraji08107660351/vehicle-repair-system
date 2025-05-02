package vrmms;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author AmTechGuy
 */
public class VehicleManagement extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String dateTime = formatter.format(cal.getTime());
        System.out.println(dateTime);

    }

}
