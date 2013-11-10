/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calandar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
import Dish.Input;
import java.io.InputStream;
import java.sql.PreparedStatement;
import javax.sql.rowset.serial.SerialBlob;
public class EventStorer {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        String leader = new Input().getString("Who will lead this meal");
        String date = new Input().getString("When will this meal occur (please use YYYY-MM-DD "
                + "format with dashes)");
        /*Class thing = Class.forName("org.apache.derby.jdbc.ClientDriver");
        Driver access = DriverManager.getDriver("org.apache.derby.jdbc.ClientDriver");*/
        Connection con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Dates",
                "lucas",
                "admin");

        Statement stmt = con.createStatement();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        out = new ObjectOutputStream(bos);
        EventSerial insert = new EventSerial(leader, date);
        out.writeObject(insert);

        byte[] yourBytes = bos.toByteArray();
        String sql = "INSERT INTO DATES.EVENTS " +
                     "VALUES(?,?)";
        Blob bob = new SerialBlob(yourBytes);
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, date);
        pstmt.setBlob(2, bob);
        pstmt.execute();
    }
}
