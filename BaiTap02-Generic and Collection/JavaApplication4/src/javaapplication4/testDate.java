import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testDate {
    public static void main(String[] args) throws ParseException
    {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateString = df.format(date);
 
        System.out.println("Current date: " + dateString);
        final DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
 
        // String ==> Date
        Date date1 = df1.parse(dateString);
        //Date date1 = df1.parse("21/04/2012 00:00:00");
        System.out.println("date = " + date1);
        
        // dùng after,before
        Date d1 = df1.parse("21/04/2012 00:00:00");
        Date d2 = df1.parse("22/04/2012 00:00:00");
        if (d1.after(d2)==true) System.out.println("ngày 1 sau ngày 2");
        else System.out.println("ngày 1 trước ngày 2");
        
        if (d1.before(d2)==true) System.out.println("ngày 1 trước ngày 2");
        else System.out.println("ngày 1 sau ngày 2");
    }
}
        
        
        