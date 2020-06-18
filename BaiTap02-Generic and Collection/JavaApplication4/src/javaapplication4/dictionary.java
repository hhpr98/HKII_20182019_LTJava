import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class dictionary
{
    public String en;
    public String vn;
    public boolean isFavorite;
    
    // contructor
    public dictionary(String e,String v)
    {
        en=e;
        vn=v;
        isFavorite=false;
    }
    
    public void getWord()
    {
        System.out.println(en + ": " + vn);
    }
    
    public void getWordVN()
    {
        System.out.println(vn + ": " + en);
    }
    
    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException 
    {
        
        List<dictionary> list = new ArrayList<dictionary>();
        
        try
	{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("dict.xml"),"utf-8"));
            br.readLine(); // đọc header
            br.readLine(); // đọc <dictionary>
            String chuoi=br.readLine(); // đọc <number>50</number>
            int start=chuoi.indexOf('>');
            int end=chuoi.lastIndexOf('<');
            String temp=chuoi.substring(start+1, end);
            //System.out.println(soluong);
            int soluong=Integer.parseInt(temp);
            for (int i=0;i<soluong;i++)
            {
                br.readLine(); // đọc <word>
                chuoi=br.readLine(); // đọc <en>...</en>
                start=chuoi.indexOf('>');
                end=chuoi.lastIndexOf('<');
                String chuoiEN=chuoi.substring(start+1, end);
                chuoi=br.readLine(); // đọc <vn>...</vn>
                start=chuoi.indexOf('>');
                end=chuoi.lastIndexOf('<');
                String chuoiVN=chuoi.substring(start+1, end);
                br.readLine(); // đọc </word>
                list.add(new dictionary(chuoiEN,chuoiVN));
            }
            br.readLine(); // đọc </dictionary>
	}
	catch (IOException ex)
	{
            System.out.println("Không tìm thấy file dict.xml .Vui lòng thử lại.");
            return;
	}
        
        // test
        //list.get(0).getWord();
        //list.get(15).getWord();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        
        String lang="en";
        int chucNang=1;
        while (chucNang!=0)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("-           Vui lòng chọn chức năng :         -");
            System.out.println("- 1.  Chuyển đổi ngôn ngữ tra cứu             -");
            System.out.println("- 2.  Tra cứu từ                              -");
            System.out.println("- 3.  Xem danh sách từ ưa thích               -");
            System.out.println("- 31. Xem danh sách từ ưa thích (A-Z)         -");
            System.out.println("- 32. Xem danh sách từ ưa thích (Z-A)         -");
            System.out.println("- 4.  Thống kê tần suất tra cứu               -");
            System.out.println("- 0. Thoát                                    -");
            System.out.println("-----------------------------------------------");
            System.out.print(" > Chọn chức năng  : ");
            String temp = reader.readLine();
            chucNang=Integer.parseInt(temp);
            
            switch (chucNang)
            {
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                case 1:
                    if (lang.compareTo("en")==0)
                    {
                        System.out.println("Ngôn ngữ hiện tại: english");
                    }
                    else
                    {
                        System.out.println("Ngôn ngữ hiện tại: vietnamese");
                    }
                    System.out.print("Vui lòng chọn ngôn ngữ muốn tra cứu (en/vn) : ");
                    String choose = reader.readLine();
                    if (choose.compareTo("en")!=0 && choose.compareTo("vn")!=0)
                    {
                        System.out.println("Cú pháp sai. Gõ en để chọn tiếng Anh hoặc vn để chọn tiếng Việt làm ngôn ngữ tra cứu.");
                    }
                    else
                    {
                        lang=choose;
                        if (lang.compareTo("en")==0)
                        {
                            System.out.println("Ngôn ngữ đã chọn: english");
                        }
                        else
                        {
                            System.out.println("Ngôn ngữ đã chọn: vietnamese");
                        }
                    }
                    break;
                case 2:
                    if (lang.compareTo("en")==0)
                    {
                        System.out.println("Ngôn ngữ hiện tại: english");
                        System.out.print("Vui lòng nhập vào từ cần tra : ");
                        String key=reader.readLine();
                        boolean notFound=true;
                        //for (dictionary index:list)
                        for (int i=0;i<list.size();i++)
                        {
                            dictionary index=list.get(i);
                            if (index.en.compareTo(key)==0)
                            {
                                notFound=false;
                                index.getWord();
                                if (index.isFavorite==false) // từ này chưa có trong mục ưa thích
                                {
                                    System.out.print("Bạn có muốn lưu từ này vào mục ưa thích ? (Y/N) : ");
                                    String f = reader.readLine();
                                    if (f.compareTo("Y")==0 || f.compareTo("y")==0)
                                    {
                                        index.isFavorite=true;
                                        System.out.println(index.en + ": " + index.vn + " đã được lưu vào mục ưa thích!");
                                    }
                                    else
                                    {
                                        System.out.println("Không lưu vào mục ưa thích!");
                                    }
                                }
                                // ghi vào file để thống kê với định dạng : ngày giá trị
                                // vd : 0 13/04/2019 12:59:33 // 0 là từ thứ 0 trong list (list.get(0))
                                // nghĩa là nhày 13/04 tra cứu từ thứ 0
                                FileWriter fileWriter = null;
                                String tenfile="thongke.txt";
                                try 
                                {
                                    // Mở file để ghi
                                    fileWriter = new FileWriter(tenfile,true);
                                    // Lấy ngày hiện tại
                                    Date date = new Date();
                                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                    String dateString = df.format(date);
                                    fileWriter.append(i + " " + dateString + "\n");
                                }
                                catch (Exception e) 
                                {
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
                                    }
                                }
                                break;
                            } 
                            
                        }
                        if (notFound)
                        {
                            System.out.println("Không tìm thấy từ " + key + " trong bộ từ điển!");
                        }
                    }
                    else
                    {
                        System.out.println("Ngôn ngữ hiện tại: vietnamese");
                        System.out.print("Vui lòng nhập vào từ cần tra : ");
                        String key=reader.readLine();
                        boolean notFound=true;
                        //for (dictionary index:list)
                        for (int i=0;i<list.size();i++)
                        {
                            dictionary index=list.get(i);
                            if (index.vn.compareTo(key)==0)
                            {
                                notFound=false;
                                index.getWordVN();
                                if (index.isFavorite==false) // từ này chưa có trong mục ưa thích
                                {
                                    System.out.print("Bạn có muốn lưu từ này vào mục ưa thích ? (Y/N) : ");
                                    String f = reader.readLine();
                                    if (f.compareTo("Y")==0 || f.compareTo("y")==0)
                                    {
                                        index.isFavorite=true;
                                        System.out.println(index.vn + ": " + index.en + " đã được lưu vào mục ưa thích!");
                                    }
                                    else
                                    {
                                        System.out.println("Không lưu vào mục ưa thích!");
                                    }
                                }
                                // ghi vào file để thống kê với định dạng : ngày giá trị
                                // vd : 0 13/04/2019 12:59:33 // 0 là từ thứ 0 trong list (list.get(0))
                                // nghĩa là nhày 13/04 tra cứu từ thứ 0
                                FileWriter fileWriter = null;
                                String tenfile="thongke.txt";
                                try 
                                {
                                    // Mở file để ghi
                                    fileWriter = new FileWriter(tenfile,true);
                                    // Lấy ngày hiện tại
                                    Date date = new Date();
                                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                    String dateString = df.format(date);
                                    fileWriter.append(i + " " + dateString + "\n");
                                }
                                catch (Exception e) 
                                {
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
                                    }
                                }
                                break;
                            }
                        }
                        if (notFound)
                        {
                            //System.out.println("Không tìm thấy từ " + key + " trong bộ từ điển!");
                            System.out.println("Không tìm thấy từ này trong bộ từ điển!");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Danh sách các từ ưa thích : ");
                    List<dictionary> fav3=new ArrayList<dictionary>();
                    // get danh sách mục ưa thích
                    for (dictionary index:list)
                    {
                        if (index.isFavorite==true)
                        {
                            fav3.add(index);
                        }
                    }
                    // in ra màn hình
                    if (lang.compareTo("en")==0)
                    {
                        for (dictionary i:fav3)
                        {
                            System.out.print(i.en + " ; ");
                        }
                        System.out.print("\n");
                    }
                    else
                    {
                        for (dictionary i:fav3)
                        {
                            System.out.print(i.vn + " ; ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 31:
                    System.out.print("Danh sách các từ ưa thích (A-Z) : ");
                    List<dictionary> fav31=new ArrayList<dictionary>();
                    // get danh sách mục ưa thích
                    for (dictionary index:list)
                    {
                        if (index.isFavorite==true)
                        {
                            fav31.add(index);
                        }
                    }
                    
                    // sắp xếp & in ra màn hình
                    if (lang.compareTo("en")==0)
                    {
                        // Sắp xếp : A-Z
                        for (int i=0;i<fav31.size()-1;i++)
                        {
                            for (int j=i+1;j<fav31.size();j++)
                            {
                                if (fav31.get(i).en.compareTo(fav31.get(j).en)>0)
                                {
                                    // swap
                                    dictionary dic1=fav31.get(i);
                                    dictionary dic2=fav31.get(j);
                                    fav31.set(i,dic2);
                                    fav31.set(j,dic1);
                                }
                            }
                        }
                        // In ra màn hình
                        for (dictionary i:fav31)
                        {
                            System.out.print(i.en + " ; ");
                        }
                        System.out.print("\n");
                    }
                    else
                    {
                        // Sắp xếp A-Z
                        for (int i=0;i<fav31.size()-1;i++)
                        {
                            for (int j=i+1;j<fav31.size();j++)
                            {
                                if (fav31.get(i).vn.compareTo(fav31.get(j).vn)>0)
                                {
                                    // swap
                                    dictionary dic1=fav31.get(i);
                                    dictionary dic2=fav31.get(j);
                                    fav31.set(i,dic2);
                                    fav31.set(j,dic1);
                                }
                            }
                        }
                        // in ra màn hình
                        for (dictionary i:fav31)
                        {
                            System.out.print(i.vn + " ; ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 32:
                    System.out.print("Danh sách các từ ưa thích (Z-A) : ");
                    List<dictionary> fav32=new ArrayList<dictionary>();
                    // get danh sách mục ưa thích
                    for (dictionary index:list)
                    {
                        if (index.isFavorite==true)
                        {
                            fav32.add(index);
                        }
                    }
                    
                    // sắp xếp & in ra màn hình
                    if (lang.compareTo("en")==0)
                    {
                        // Sắp xếp : Z-A
                        for (int i=0;i<fav32.size()-1;i++)
                        {
                            for (int j=i+1;j<fav32.size();j++)
                            {
                                if (fav32.get(i).en.compareTo(fav32.get(j).en)<0)
                                {
                                    // swap
                                    dictionary dic1=fav32.get(i);
                                    dictionary dic2=fav32.get(j);
                                    fav32.set(i,dic2);
                                    fav32.set(j,dic1);
                                }
                            }
                        }
                        // In ra màn hình
                        for (dictionary i:fav32)
                        {
                            System.out.print(i.en + " ; ");
                        }
                        System.out.print("\n");
                    }
                    else
                    {
                        // Sắp xếp Z-A
                        for (int i=0;i<fav32.size()-1;i++)
                        {
                            for (int j=i+1;j<fav32.size();j++)
                            {
                                if (fav32.get(i).vn.compareTo(fav32.get(j).vn)<0)
                                {
                                    // swap
                                    dictionary dic1=fav32.get(i);
                                    dictionary dic2=fav32.get(j);
                                    fav32.set(i,dic2);
                                    fav32.set(j,dic1);
                                }
                            }
                        }
                        // in ra màn hình
                        for (dictionary i:fav32)
                        {
                            System.out.print(i.vn + " ; ");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.out.println("Lưu ý : ngày nhập vào có định dạng dd/MM/yyyy");
                    System.out.println("Ví dụ : 15/03/2019 hoặc 01/01/2018");
                    
                    System.out.print("Cần thống kê từ ngày : ");
                    String day1 = reader.readLine();
                    System.out.print("            đến ngày : ");
                    String day2 = reader.readLine();
                    day1 = day1 + " 00:01:00";
                    day2 = day2 + " 23:59:00";
                    DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date1=null;
                    Date date2=null;
                    try
                    {
                        date1 = df1.parse(day1);
                        date2 = df1.parse(day2);
                        //System.out.println(date1);
                        //System.out.println(date2);
                    }
                    catch (ParseException pex)
                    {
                        System.out.println("Sai định dạng ngày!");
                        break;
                    }
                    
                    Map m = new HashMap();
                    String file="thongke.txt";
                    BufferedReader bfrd = null;
                    try 
                    {
                        String line;
                        bfrd = new BufferedReader(new FileReader(file));
 
                        while ((line = bfrd.readLine()) != null) 
                        {
                            if (line != null) 
                            {
                                int pos=line.indexOf(' ');
                                int idx=Integer.parseInt(line.substring(0,pos));
                                String d=line.substring(pos+1,line.length());
                                //System.out.println(idx+":"+d);
                                Date dateIdx=null;
                                try
                                {
                                    dateIdx=df1.parse(d);
                                }
                                catch (ParseException pex)
                                {
                                    break;
                                }
                                
                                // nếu nằm trong khoảng ngày cần xét
                                if (date1.before(dateIdx)==true && dateIdx.before(date2)==true)
                                {
                                    // nếu từ chưa xuất hiện thì thêm từ vào
                                    if (m.containsKey(idx)==false)
                                    {
                                        m.put(idx, 1);
                                    }
                                    // nếu từ có rồi thì thêm biến đếm + 1
                                    else
                                    {
                                        int val=Integer.parseInt(m.get(idx).toString());
                                        m.replace(idx, val+1);
                                    }
                                }
                                        
                                
                            }
                        }
                    } 
                    catch (IOException e) 
                    {
                        System.out.println("Lỗi khi đọc file! Không thể thống kê dữ liệu từ file log.");
                        break;
                    } 
                    finally 
                    {
                        try 
                        {
                            if (bfrd != null)
                            {
                                bfrd.close();
                            }
                        } 
                        catch (IOException crunchifyException) {}
                    }
                    //System.out.println(m);
                    if (lang.compareTo("en")==0)
                    {
                        if (m.isEmpty())
                        {
                            System.out.println("Không có hoạt động tra cứu trong khoảng thời gian này!");
                        }
                        else
                        {
                            System.out.println("Danh sách từ đã tra cứu từ ngày " + day1 + " đến ngày " + day2 + " bằng tiếng Anh :");
                            // kí pháp lamda
                            //m.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));
                            m.forEach((k,v)->System.out.println("* " + list.get(Integer.parseInt(k.toString())).en + " => " + v + " (lần)"));
                        }
                    }
                    else
                    {
                        if (m.isEmpty())
                        {
                            System.out.println("Không có hoạt động tra cứu trong khoảng thời gian này!");
                        }
                        else
                        {
                            System.out.println("Danh sách từ đã tra cứu từ ngày" + day1 + " đến ngày " + day2 + " bằng tiếng Việt :");
                            m.forEach((k,v)->System.out.println("* " + list.get(Integer.parseInt(k.toString())).vn + " => " + v + " (lần)"));
                        }
                    }
                    break;
                default:
                    System.out.println("Vui lòng chọn đúng chức năng!");
            }
            
            if (chucNang!=0)
            {
                System.out.print("Bạn có muốn tiếp tục với chương trình ? (Y/N) : ");
                String choose = reader.readLine();
                if (choose.compareTo("N")==0 || choose.compareTo("n")==0)
                {
                    chucNang=0;
                    System.out.println("Thoát chương trình!");
                }
            }
        }
    }
}