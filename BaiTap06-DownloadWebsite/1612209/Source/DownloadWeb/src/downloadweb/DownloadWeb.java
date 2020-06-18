/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadweb;

/**
 *
 * @author nguyenhuuhoa
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List; // List dùng console => util.List, List dùng GUI => awt.List

public class DownloadWeb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        List<String> list = new ArrayList<String>();
        
        String root="D:\\WebDownloaded";
        CreateWebFolder.createFolder(root);
        String image="D:\\WebDownloaded\\image";
        CreateWebFolder.createFolder(image);
        
        
        FileWriter fileWriter = null;
        System.out.print("Enter URL : ");
        String url_dir="http://localhost"; // default
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            url_dir = br.readLine();
            br.close();
            // check url (add / in end url)
            url_dir=StringProcessing.validURL(url_dir);
        }
        catch (IOException ioe)
        {
            //ioe.printStackTrace();
        }

        try
	{
            URL url = new URL(url_dir); 
            URLConnection urlCon = url.openConnection(); 
            //String _File = url.getFile(); 
            
            fileWriter = new FileWriter(root + "\\index.html");
            
            BufferedReader in = new BufferedReader(
		new InputStreamReader(urlCon.getInputStream())); 
            
            String inputLine; 
            while ((inputLine = in.readLine()) != null)
            {
                String find=StringProcessing.findURL(inputLine, url_dir);
                if (find.compareTo("")!=0)
                {
                    //System.out.println(find);
                    if (!list.contains(find) && !ListManagement.listDownloaded.contains(find))
                    {
                        list.add(find);
                    }
                }
                String line=StringProcessing.ReplaceURL(inputLine, url_dir);
                line=StringProcessing.FindDownloadReplaceImage(line);
                fileWriter.append(line + "\n");
                //System.out.println(inputLine);
            }
            in.close(); 
	} 
	catch (Exception e)
	{
            System.out.println("Get connect fail!");
            //e.printStackTrace();
	}
        finally
        {
            try
            {
                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException e) 
            {
                //e.printStackTrace();
            }
        }
        
        
        while(!list.isEmpty())
        {
            int sz=list.size();
            if (sz>=3)
            {
                String item1=list.get(sz-1);
                String item2=list.get(sz-2);
                String item3=list.get(sz-3);
                ListManagement.listDownloaded.add(item1);
                ListManagement.listDownloaded.add(item2);
                ListManagement.listDownloaded.add(item3);
                list.remove(sz-1);
                list.remove(sz-2);
                list.remove(sz-3);
                
                downloadWebThread t1=new downloadWebThread(item1);
                t1.start();
                downloadWebThread t2=new downloadWebThread(item2);
                t2.start();
                downloadWebThread t3=new downloadWebThread(item3);
                t3.start();
            }
            else
            {
                while(!list.isEmpty())
                {
                    sz=list.size();
                    String item=list.get(sz-1);
                    downloadWebThread t1=new downloadWebThread(item);
                    t1.start();
                    ListManagement.listDownloaded.add(item);
                    list.remove(sz-1);
                }
            }  
        }
        

        // open folder downloaded
        OpenFile.openFolder(root);
        // open the file downloaded
        OpenFile.openFile(root + "\\index.html");
    }
}
