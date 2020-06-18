import java.util.*;
import java.io.*;

public class StudentClass {
    String MaHS;
    String TenHS;
    float Diem;
    String HinhAnh;
    String DiaChi;
    String GhiChu;
    
    // contructor
    public StudentClass(String ma,String ten,float diem,String hinh,String dc,String note)
    {
        MaHS=ma;
        TenHS=ten;
        Diem=diem;
        HinhAnh=hinh;
        DiaChi=dc;
        GhiChu=note;
    }
    
    // set infor method
    public void setHS(String ma,String ten,float diem,String hinh,String dc,String note)
    {
        MaHS=ma;
        TenHS=ten;
        Diem=diem;
        HinhAnh=hinh;
        DiaChi=dc;
        GhiChu=note;
    }
    
    // get infor method
    public void getHS()
    {
        System.out.println(" + Ma hoc sinh\t : " + MaHS);
        System.out.println(" + Ten hoc sinh\t : " + TenHS);
        System.out.println(" + Diem\t\t : " + Diem);
        System.out.println(" + Hinh anh\t : " + HinhAnh);
        System.out.println(" + Dia chi\t : " + DiaChi);
        System.out.println(" + Ghi chu\t : " + GhiChu);
    }
    
    public static void main(String[] args) throws IOException 
    {
        //StudentClass myStudent = new StudentClass();
        //myStudent.setHS("1612209", "Nguyen Huu Hoa", (float) 8.0, "1612209.jpg", "HCM", "Khong");
        //myStudent.getHS();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"utf8"));
        
        List<StudentClass> list = new ArrayList<StudentClass>();
        //list.add(myStudent);
        //StudentClass cls=list.get(0);
        //cls.getHS();
        
        int chucNang=1;
        while (chucNang!=0)
        {
            System.out.println("-----------------------------------------------");
            System.out.println("-           Vui long chon chuc nang :         -");
            System.out.println("- 1.  Them hoc sinh                           -");
            System.out.println("- 2.  Cap nhat thong tin hoc sinh             -");
            System.out.println("- 3.  Xoa hoc sinh                            -");
            System.out.println("- 4.  Xem danh sach hoc sinh                  -");
            System.out.println("- 41. MaHS tang dan                           -");
            System.out.println("- 42. MaHS giam dan                           -");
            System.out.println("- 43. Diem tang dan                           -");
            System.out.println("- 44. Diem giam dan                           -");
            System.out.println("- 5. Import tu CSV                            -");
            System.out.println("- 6. Export tu CSV                            -");
            System.out.println("- 7. Luu data vao file nhi phan               -");
            System.out.println("- 8. Nhap data tu file nhi phan               -");
            System.out.println("- 0. Thoat                                    -");
            System.out.println("-----------------------------------------------");
            System.out.print(" > Chon chuc nang  : ");
            String temp = br.readLine();
            chucNang=Integer.parseInt(temp);
            
            String tmp; // bien tam
            String ma;
            String ten;
            float diem;
            String hinh;
            String dc;
            String note;
            int id;
            
            switch (chucNang)
            {
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;
                case 1:
                    System.out.println("Vui long nhap thong tin hoc sinh vao day:");
                    System.out.print("> Ma hoc sinh\t : ");
                    ma=br.readLine();
                    System.out.print("> Ten hoc sinh\t : ");
                    ten=br.readLine();
                    System.out.print("> Diem\t\t : ");
                    tmp=br.readLine();
                    diem=Float.parseFloat(tmp);
                    System.out.print("> Hinh anh\t : ");
                    hinh=br.readLine();
                    System.out.print("> Dia chi\t : ");
                    dc=br.readLine();
                    System.out.print("> Ghi chu\t : ");
                    note=br.readLine();
                    list.add(new StudentClass(ma,ten,diem,hinh,dc,note));
                    break;
                case 2:
                    System.out.print("Vui long nhap ma hoc sinh can chinh sua :");
                    tmp=br.readLine();
                    id=-999;
                    for (int i=0;i<list.size();i++)
                    {
                        StudentClass index=list.get(i);
                        if (index.MaHS.compareTo(tmp)==0) // tim thay ma HS de chinh sua
                        {
                            id=i;
                            break;
                        }
                    }
                    if (id==-999)
                    {
                        System.out.println("Khong tim thay ma hoc sinh de chinh sua!");
                    }
                    else
                    {
                        System.out.println("Thong tin cua hoc sinh can chinh sua : ");
                        StudentClass sc = list.get(id);
                        sc.getHS();
                        System.out.println("Vui long nhap lai thong tin cua hoc sinh : ");
                        ma=sc.MaHS;
                        System.out.print("> Ten hoc sinh\t : ");
                        ten=br.readLine();
                        System.out.print("> Diem\t\t : ");
                        tmp=br.readLine();
                        diem=Float.parseFloat(tmp);
                        System.out.print("> Hinh anh\t : ");
                        hinh=br.readLine();
                        System.out.print("> Dia chi\t : ");
                        dc=br.readLine();
                        System.out.print("> Ghi chu\t : ");
                        note=br.readLine();
                        sc.setHS(ma,ten,diem,hinh,dc,note);
                    }
                    break;
                case 3:
                    System.out.print("Vui long nhap ma hoc sinh can xoa :");
                    tmp=br.readLine();
                    id=-999;
                    for (int i=0;i<list.size();i++)
                    {
                        StudentClass index=list.get(i);
                        if (index.MaHS.compareTo(tmp)==0) // tim thay ma HS de xoa
                        {
                            id=i;
                            break;
                        }
                    }
                    if (id==-999)
                    {
                        System.out.println("Khong tim thay ma hoc sinh de xoa!");
                    }
                    else
                    {
                        list.remove(id);
                        System.out.println("Da xoa hoc sinh co ma " + tmp + " !");
                    }
                    break;
                case 4:
                    if (list.size()==0)
                    {
                        System.out.println("Danh sach trong!");
                        break;
                    }
                    System.out.println("         DANH SACH HOC SINH\n");
                    for (StudentClass index:list)
                    {
                        index.getHS();
                        System.out.print("\n");
                    }
                    break;
                case 41:
                    // Sap xep ma hoc sinh tang dan
                    for (int i=0;i<list.size()-1;i++)
                    {
                        for (int j=i+1;j<list.size();j++)
                        {
                            StudentClass cls1 = list.get(i);
                            StudentClass cls2 = list.get(j);
                            if (cls1.MaHS.compareTo(cls2.MaHS)>0)
                            {
                                // swap
                                list.set(i,cls2);
                                list.set(j,cls1);
                            }
                        }
                    }
                    // Xuat ra danh sach
                    System.out.println("         DANH SACH HOC SINH");
                    System.out.println("    Sap xep theo ma hoc sinh tang dan\n");
                    for (StudentClass index:list)
                    {
                        index.getHS();
                        System.out.print("\n");
                    }
                    break;
                case 42:
                    // Sap xep ma hoc sinh giam dan
                    for (int i=0;i<list.size()-1;i++)
                    {
                        for (int j=i+1;j<list.size();j++)
                        {
                            StudentClass cls1 = list.get(i);
                            StudentClass cls2 = list.get(j);
                            if (cls1.MaHS.compareTo(cls2.MaHS)<0)
                            {
                                // swap
                                list.set(i,cls2);
                                list.set(j,cls1);
                            }
                        }
                    }
                    // Xuat ra danh sach
                    System.out.println("         DANH SACH HOC SINH");
                    System.out.println("    Sap xep theo ma hoc sinh giam dan\n");
                    for (StudentClass index:list)
                    {
                        index.getHS();
                        System.out.print("\n");
                    }
                    break;
                case 43:
                    // Sap xep diem tang dan
                    for (int i=0;i<list.size()-1;i++)
                    {
                        for (int j=i+1;j<list.size();j++)
                        {
                            StudentClass cls1 = list.get(i);
                            StudentClass cls2 = list.get(j);
                            if (cls1.Diem>cls2.Diem)
                            {
                                // swap
                                list.set(i,cls2);
                                list.set(j,cls1);
                            }
                        }
                    }
                    // Xuat ra danh sach
                    System.out.println("         DANH SACH HOC SINH");
                    System.out.println("     Sap xep theo diem tang dan\n");
                    for (StudentClass index:list)
                    {
                        index.getHS();
                        System.out.print("\n");
                    }
                    break;
                case 44:
                    // Sap xep diem giam dan
                    for (int i=0;i<list.size()-1;i++)
                    {
                        for (int j=i+1;j<list.size();j++)
                        {
                            StudentClass cls1 = list.get(i);
                            StudentClass cls2 = list.get(j);
                            if (cls1.Diem<cls2.Diem)
                            {
                                // swap
                                list.set(i,cls2);
                                list.set(j,cls1);
                            }
                        }
                    }
                    // Xuat ra danh sach
                    System.out.println("         DANH SACH HOC SINH");
                    System.out.println("     Sap xep theo diem giam dan\n");
                    for (StudentClass index:list)
                    {
                        index.getHS();
                        System.out.print("\n");
                    }
                    break;
                case 5: 
                    System.out.print("Nhap ten file de doc : ");
                    tmp=br.readLine();
                    
                    list.removeAll(list);
                    
                    BufferedReader bfrd = null;
                    try 
                    {
                        String line;
                        bfrd = new BufferedReader(new FileReader(tmp));
 
                        // How to read file in java line by line?
                        while ((line = bfrd.readLine()) != null) 
                        {
                            if (line != null) 
                            {
                                String[] splitData = line.split(",");
                                if (splitData[0].compareTo("MaHS")==0) // skip dong header
                                {
                                    continue;
                                }
                                //System.out.println(splitData[2]);
                                list.add(new StudentClass(splitData[0],splitData[1],Float.parseFloat(splitData[2]),splitData[3],splitData[4],splitData[5]));
                            }
                        }
 
                    } 
                    catch (IOException e) 
                    {
                        System.out.println("Loi khi doc file!");
                        //e.printStackTrace();
                    } 
                    finally 
                    {
                        try 
                        {
                            if (bfrd != null)
                            {
                                bfrd.close();
                                System.out.println("Doc tu file " + tmp + ".CSV thanh cong !!!\nChon chuc nang 4 de kiem tra.");
                            }
                        } 
                        catch (IOException crunchifyException) 
                        {
                            crunchifyException.printStackTrace();
                        }
                    }

                    break;
                case 6:
                    FileWriter fileWriter = null;
 
                    System.out.print("Nhap ten file de ghi : ");
                    tmp=br.readLine();
                    tmp = tmp + ".csv";
                    try 
                    {
                        fileWriter = new FileWriter(tmp);
 
                        // Write the CSV file header
                        fileWriter.append("MaHS,TenHS,Diem,HinhAnh,DiaChi,GhiChu");
 
                        // Add a new line separator after the header
                        fileWriter.append("\n");
 
                        // Write a new object list to the CSV file
                        for (StudentClass index : list) 
                        {
                            fileWriter.append(index.MaHS);
                            fileWriter.append(",");
                            fileWriter.append(index.TenHS);
                            fileWriter.append(",");
                            fileWriter.append(String.valueOf(index.Diem));
                            fileWriter.append(",");
                            fileWriter.append(index.HinhAnh);
                            fileWriter.append(",");
                            fileWriter.append(index.DiaChi);
                            fileWriter.append(",");
                            fileWriter.append(index.GhiChu);
                            fileWriter.append("\n");
                        }
  
                        System.out.println("Ghi vao file " + tmp + " thanh cong !!!");
 
                    } 
                    catch (Exception e) 
                    {
                        System.out.println("Loi ghi file CSV !!!");
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
                            System.out.println("Error while flushing/closing fileWriter !!!");
                            //e.printStackTrace();
                        }
                    }
                    break;
                case 7:
                    System.out.print("Nhap ten file de ghi : ");
                    tmp=br.readLine();
                    
                    DataOutputStream dos;
                    try 
                    {
			dos=new DataOutputStream(new FileOutputStream(tmp));
                    }
                    catch(IOException exc)
                    {
			System.out.println("Khong the mo file de ghi!");
			break;
                    }
		
                    try 
                    {
			dos.writeInt(list.size());
                        dos.writeChar('\n');
                        for (StudentClass index:list)
                        {
                            dos.writeUTF(index.MaHS);
                            dos.writeChar('\n');
                            dos.writeUTF(index.TenHS);
                            dos.writeChar('\n');
                            dos.writeFloat(index.Diem);
                            dos.writeChar('\n');
                            dos.writeUTF(index.HinhAnh);
                            dos.writeChar('\n');
                            dos.writeUTF(index.DiaChi);
                            dos.writeChar('\n');
                            dos.writeUTF(index.GhiChu);
                            dos.writeChar('\n');
                        }
                        
                    }
                    catch(IOException exc) 
                    {
			System.out.println("Khong the ghi vao file!");
                        break;
                    }
                    System.out.println("Ghi vao file " + tmp + " thanh cong!");
                    dos.close();
                    break;
                case 8:
                    System.out.print("Nhap ten file de doc : ");
                    tmp=br.readLine();
                    
                    DataInputStream dis;
                    try 
                    {
			dis=new DataInputStream(new FileInputStream(tmp));
                    }
                    catch(IOException exc)
                    {
			System.out.println("Khong the mo file de doc!");
			break;
                    }
		
                    try 
                    {
                        list.removeAll(list); // delete all de doc tu file len dua vao list
                        int sz = dis.readInt();
                        dis.readChar(); // \n
                        //System.out.println(sz);
                        for (int i=0;i<sz;i++)
                        {
                            ma = dis.readUTF();
                            //System.out.println(ma);
                            dis.readChar();
                            ten = dis.readUTF();
                            //System.out.println(ten);
                            dis.readChar();
                            diem = dis.readFloat();
                            dis.readChar();
                            hinh = dis.readUTF();
                            dis.readChar();
                            dc = dis.readUTF();
                            dis.readChar();
                            note = dis.readUTF();
                            dis.readChar();
                            list.add(new StudentClass(ma,ten,diem,hinh,dc,note));
                        }                        
                    }
                    catch(IOException exc) 
                    {
			System.out.println("Khong the doc noi dung tu file!");
                        break;
                    }
                    System.out.println("Doc noi dung tu file " + tmp + " thanh cong! Chon chuc nang so 4 de xem noi dung.");
                    dis.close();
                    break;
                default:
                    System.out.println("Vui long chon dung chuc nang!");
            }
            
            if (chucNang!=0)
            {
                System.out.print("Ban co muon tiep tuc voi chuong trinh ? (Y/N) : ");
                String choose = br.readLine();
                if (choose.compareTo("N")==0 || choose.compareTo("n")==0)
                {
                    chucNang=0;
                    System.out.println("Thoat chuong trinh!");
                }
            }
        }
    }
}
