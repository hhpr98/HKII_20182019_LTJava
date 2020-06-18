/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadweb;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author nguyenhuuhoa
 */
public class OpenFile {
    public static void openFile(String url)
    {
        try
        {
            File htmlFile = new File(url);
            Desktop.getDesktop().browse(htmlFile.toURI());
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        } 
    }
    
    public static void openFolder(String url)
    {
        try
        {
            Desktop.getDesktop().open(new File(url));
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
