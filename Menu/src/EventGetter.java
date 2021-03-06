/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static com.oracle.jrockit.jfr.ContentType.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import day.EventDay;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Lucas
 */
public class EventGetter {
    private ArrayList<EventDay> fromTable;
    private Connection con;
    public EventGetter(Connection con) throws SQLException, IOException, ClassNotFoundException{
        this.con = con;
        fromTable = extract(con);
    }
    private ArrayList<EventDay> extract(Connection con) throws SQLException, IOException, ClassNotFoundException{
        PreparedStatement state = con.prepareStatement("SELECT Date"
                + " FROM DATES.EVENTS WHERE DATE(NOW()) <= Date");
        ResultSet dates = state.executeQuery();
        PreparedStatement state2 = con.prepareStatement("SELECT EVENT"
                + " FROM DATES.EVENTS WHERE DATE(NOW()) <= Date");
        ResultSet blobs = state2.executeQuery();
        ArrayList<Blob> serials = new ArrayList<Blob>();
        ArrayList<EventDay> answer = new ArrayList<EventDay>();
        while(blobs.next()){
            byte[] stream1 = blobs.getBlob(1).getBytes(1, (int) (blobs.getBlob(1).length()-1));
            ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(stream1));
            EventDay day = (EventDay) stream.readObject();
            answer.add(day);
            stream.close();
        }
        return answer;
        
    }
}
