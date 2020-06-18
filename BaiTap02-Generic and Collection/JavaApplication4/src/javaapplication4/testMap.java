import java.util.*;
import java.io.*;

public class testMap {
    public static void main(String[] args)
    {
        Map m1 = new HashMap(); 
        m1.put("Zara", 8);
        m1.put("Mahnaz", 31);
        m1.replace("Zara", 8, 10);
        System.out.println(m1);
        if (m1.containsKey("Zara"))
        {
            //System.out.println(m1.get("Zara"));
            int val=Integer.parseInt(m1.get("Zara").toString());
            //m1.replace("Zara",val,val+1);
            m1.replace("Zara",val+1);
        }
        System.out.println(m1);

    }
}
        
        
        