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
public class StringProcessing {
    public static String charRemoveAt(String str, int p) 
    {  
        return str.substring(0, p) + str.substring(p + 1);  
    } 
    
    public static String validURL(String url)
    {
        char c='/';
        char end=url.charAt(url.length()-1);
        if (end!=c)
        {
            url=url + c;
        }
        return url;
    }
    
    public static String findURL(String line,String root)
    {
        String res="";
        if (line.contains(root)) // xử lí với những trường hợp đầy đủ địa chỉ. vd : a.com/trangchu.html, a.com/game.html
        {
            if (line.contains("<a")) // có chứa url nhưng phải là thẻ <a>
            {
                // Find URL
                int begin=line.indexOf(root);
                int end=line.indexOf("\"", begin+1);
                res=line.substring(begin,end);
                int getpost=res.indexOf('?'); // bỏ phần getpost phía sau, vd : http://a.com/a.html?i=1&if=2 => chỉ còn http://a.com/a.html
                if (getpost!=-1)
                {
                    res=res.substring(0,getpost);
                }
                int shape=res.indexOf('#'); // bỏ phần shape phía sau, vd : http://a.com/a.html#box => chỉ còn http://a.com/a.html
                if (shape!=-1)
                {
                    res=res.substring(0,shape);
                }
                res=StringProcessing.validURL(res);
                
                // Replace URL : ex : a.com/index.html => /index.html (để duyệt máy local)
                /*String[] splitData = res.split("/");
                String file_name=splitData[splitData.length-1];
                if (!file_name.contains("html"))
                {
                    file_name = file_name + ".html";
                }
                line=line.substring(0,begin) + "/" + file_name + line.substring(end,line.length()-1);
*/
            }
        }
        return res;
    }
    
    public static String ReplaceURL(String line,String root)
    {
        String res=line;
        if (line.contains(root)) // xử lí với những trường hợp đầy đủ địa chỉ. vd : a.com/trangchu.html, a.com/game.html
        {
            if (line.contains("<a")) // có chứa url nhưng phải là thẻ <a>
            {
                // Find name URL
                int begin=line.indexOf(root);
                int end=line.indexOf("\"", begin+1);
                String needReplace=line.substring(begin,end);
                int getpost=needReplace.indexOf('?'); // bỏ phần getpost phía sau, vd : http://a.com/a.html?i=1&if=2 => chỉ còn http://a.com/a.html
                if (getpost!=-1)
                {
                    res=needReplace.substring(0,getpost);
                }
                int shape=res.indexOf('#'); // bỏ phần shape phía sau, vd : http://a.com/a.html#box => chỉ còn http://a.com/a.html
                if (shape!=-1)
                {
                    res=res.substring(0,shape);
                }
                
                // Replace URL : ex : a.com/index.html => /index.html (để duyệt máy local)
                String[] splitData = res.split("/");
                String file_name=splitData[splitData.length-1];
                if (!file_name.contains("html"))
                {
                    file_name = file_name + ".html";
                }
                res=line.replace(needReplace,"./"+file_name);
            }
        }
        return res;
    }
    
    public static String FindDownloadReplaceImage(String inputLine)
    {
        String res=inputLine;
        if (inputLine.contains("<img") && inputLine.contains("src=\"http")) // thẻ có chứa hình & link
        {
            int p=inputLine.indexOf("src=\"http");
            int begin=inputLine.indexOf("\"",p);
            int end=inputLine.indexOf("\"",begin+1);
            String img_url=inputLine.substring(begin+1, end);
            String img_name=GetImage.getImg(img_url);
            res=inputLine.replace(img_url, "./image/"+img_name);
        }
        return res;
    }
}
