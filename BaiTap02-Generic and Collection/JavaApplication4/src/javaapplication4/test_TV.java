import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class test_TV {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException
    {
        /*
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
            System.out.println("nhập: ");
            String text = br.readLine();
            //String text = "This is an example é";
            
            byte[] byteText = text.getBytes(Charset.forName("UTF-8"));
            //To get original string from byte.
            String originalString= new String(byteText , "UTF-8");
            
            System.out.println(originalString);

        }
        catch (UnsupportedEncodingException ex)
        {
            System.out.println("Không hỗ trợ utf8");
        }
*/
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        for (int i=1;i<=100;i++)
        {
            System.out.print("Nhập : ");
            String jmeno = reader.readLine();
            System.out.print(jmeno);
        }
        
    }
}
