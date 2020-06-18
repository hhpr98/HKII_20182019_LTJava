/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadweb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyenhuuhoa
 */
public class downloadWebThread extends Thread{
    private String url_string;
    List<String> list = new ArrayList<String>();
    
    downloadWebThread()
    {
        url_string="http://localhost/";
    }
    downloadWebThread(String stringURL)
    {
        url_string=stringURL;
    }
    
    @Override
    public void run() 
    {
        String root="D:\\WebDownloaded";
        String image="D:\\WebDownloaded\\image";
        
        FileWriter fileWriter = null;
        String url_dir=url_string;

        try
        {
            URL url = new URL(url_dir); 
            URLConnection urlCon = url.openConnection(); 
            
            String[] splitData = url_dir.split("/");
            String file_name=splitData[splitData.length-1];
            String path="";
            if (file_name.contains("html"))
            {
                path = root + "\\" + file_name;
            }
            else
            {
                path = root + "\\" + file_name + ".html";
            }
            
            File userDataFile = new File(path);
            if (userDataFile.exists())
            {
                //System.out.println("File " + file_name + " is exists!");
                return;
            }
           
            fileWriter = new FileWriter(path);
            System.out.println("Downloading : " + path);
            
            // Lấy lại đường dẫn gốc (url_dir đây là đường dẫn phụ)
            // vd : gốc : a.com.vn/
            // phụ (url_dir) : a.com.vn/2018/4/a.html
            int pos=url_dir.indexOf("/",10); // số 10 là start, next dấu // của http
            String url_root="";
            url_root=url_dir.substring(0,pos);
            url_root=StringProcessing.validURL(url_root);
            
            BufferedReader in = new BufferedReader(
                new InputStreamReader(urlCon.getInputStream())); 
                
            String inputLine; 
            while ((inputLine = in.readLine()) != null)
            {
                
                String find=StringProcessing.findURL(inputLine, url_root);
                if (find.compareTo("")!=0)
                {
                    //System.out.println(url_root);
                    //System.out.println(find);
                    //System.out.println(find);
                    if (!list.contains(find) && !ListManagement.listDownloaded.contains(find))
                    {
                        list.add(find);
                    }
                }
                String line=StringProcessing.ReplaceURL(inputLine, url_root);
                line=StringProcessing.FindDownloadReplaceImage(line);
                fileWriter.append(line + "\n");
            }
            in.close(); 
            System.out.println("Downloaded : " + path);
        } 
        catch (Exception e)
        {
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
            catch (NullPointerException npe)
            {
                //npe.printStackTrace();
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
    }
}
