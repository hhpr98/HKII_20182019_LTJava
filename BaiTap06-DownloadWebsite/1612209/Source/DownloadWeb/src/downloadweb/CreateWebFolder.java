/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadweb;

import java.io.File;

/**
 *
 * @author nguyenhuuhoa
 */
public class CreateWebFolder {
    public static void createFolder(String folderName)
    {
        File file = new File(folderName);
        char c='\\';
        int pos=folderName.lastIndexOf(c);
        String name=folderName.substring(pos+1,folderName.length());
        
        if (!file.exists()) 
        {
            if (file.mkdir()) 
            {
                System.out.println("Directory " + name + " is created!");
            } else 
            {
                System.out.println("Failed to create directory " + name + " !");
            }
        }
        else
        {
            System.out.println("Folder name \"" + name + "\" is exists !");
        }
    }
    
    /*
    public static boolean checkFileExist(String root,String file_name)
    {
        boolean exists=true;
        try
        {
            final Path path = Files.createTempFile("WebDownloaded\\" + file_name, ".html");
            exists = Files.exists(path);
        }
        catch (IOException e)
        {
            //e.printStackTrace();
        }
        return exists;
    }
    */
}
