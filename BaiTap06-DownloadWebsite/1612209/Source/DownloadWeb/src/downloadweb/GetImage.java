/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadweb;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenhuuhoa
 */
public class GetImage {
    public static String getImg(String url_string)
    {
        String imgName="";
        try(InputStream in = new URL(url_string).openStream())
        {
            String[] splitData = url_string.split("/");
            imgName=splitData[splitData.length-1];
            Files.copy(in, Paths.get("D:/WebDownloaded/image/"+imgName));
        } 
        catch (MalformedURLException ex) {
            Logger.getLogger(GetImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ioe)
        {
            return imgName;
            //ioe.printStackTrace();
            //System.out.println("Fail to get image!");
        }
        return imgName;
    }
}
