package emailapp;
import javax.swing.*;
import java.awt.desktop.SystemSleepEvent;
import java.io.FileReader;
import java.io.FileWriter;
import  java.util.*;
public class Email {
        Scanner sc=new Scanner(System.in);
        private String fname;
        private String lname;
        private String dept;
        private String email;
        private String password;
        private int mailCapacity =500;
        private String alter_email;
        public  Email(String fname,String lname)
        {
                this.fname=fname;
                this.lname=lname;
                System.out.println("New Employee:"+this.fname+" "+this.lname);
                //calling method
                this.dept=this.setDept();
                this.password=this.generate_password(8);
                this.email=this.generate_email();

        }
        private  String generate_email()
        {
                return  this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
        }
        private String setDept()
        {
                System.out.println(("Department code \n1 for sales \n2 for Development \n3 for Accounting \n0 for none"));
                boolean flag=false;
                do {
                        System.out.println("Enter Department code");
                        int choice = sc.nextInt();
                        switch (choice)
                        {
                                case 1:
                                        return "Sales";
                                case 2:
                                        return "Development";
                                case 3:
                                        return  "Accounting";
                                case 0:
                                        return  "None";
                                default:
                                        System.out.println("Invalid choise please choose it again");
                        }

                }while (!flag);
                return null;
        }
        //Generate Random password method
        private  String generate_password(int length)
        {
                Random r=new Random();
                String Capital_chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String Small_chars="abcdefghijklmnopqrstuvwxyz";
                String numbers="0123456789";
                String sysbols="!@#$%&?";
                String values=Capital_chars+Small_chars+numbers+sysbols;
                String password="";
                for(int i=0;i<length;i++)
                {
                        password=password+values.charAt(r.nextInt(values.length()));
                }
                return  password;
        }
        //change password method
        public void set_password()
        {
                boolean flag=false;
                do {
                        System.out.println("Do you want to change your password!(Y?N)");
                        char choice = sc.next().charAt(0);
                        if(choice=='Y'|| choice=='y')
                        {
                                flag=true;
                                System.out.println("Enter your current password:");
                                String temp=sc.next();
                                if(temp.equals(this.password))
                                {
                                        System.out.println("Enter new password:");
                                        this.password=sc.next();
                                        System.out.println("Password changed successfully");
                                }
                                else
                                {
                                        System.out.println("Incorrect password");
                                }
                        }
                        else if(choice=='N'|| choice=='n')
                        {
                                flag=true;
                                System.out.println("Password changed option cancelled!");
                        }
                        else
                        {
                                System.out.println("Enter Valid choice");
                        }
                }while (!flag);
        }
        //set mailbox capacity method
        public void set_mailCap()
        {
                System.out.println("Current capacity= "+this.mailCapacity+"mb");
                System.out.println("Enter new mailbox capacity");
                this.mailCapacity=sc.nextInt();
                System.out.println("Mailbox capacity is successfullu changed");
        }
        //set alternate mail
        public void alternate_email()
        {
                System.out.println("Enter new alternate mail");
                this.alter_email= sc.next();
                System.out.println("Alternate email is set");
        }
        //Display user information method
        public void getInfo() {
                System.out.println("New:" + this.fname + " " + this.lname);
                System.out.println("Department:" + this.dept);
                System.out.println("Email:" + this.email);
                System.out.println("Password:" + this.password);
                System.out.println("Mailbox capacity:" + this.mailCapacity + "mb");
                System.out.println("Alternate mail:" + this.alter_email);
        }
        public void storefile(){
                try{
                        FileWriter in =new FileWriter("C:\\Users\\ELCOT\\Desktop\\info.txt");
                        in.write("First name:"+this.fname);
                        in.append("\nLast name:"+this.lname);
                        in.append("\nEmail:"+this.email);
                        in.append("\nPassword:"+this.password);
                        in.append("\nCapacity mail"+this.mailCapacity);
                        in.append("\nAlternate mail"+this.alter_email);
                        in.close();
                        System.out.println("Data Stored...");

                }
                catch(Exception e)
                {
                        System.out.println(e);
                }

        }
        public void read_file()
        {
                try{
                        FileReader f1=new FileReader("C:\\Users\\ELCOT\\Desktop\\info.txt");
                        int i;
                        while((i=f1.read())!=-1)
                        {
                                System.out.print((char)i);
                        }
                        System.out.println();
                        f1.close();
                }
                catch (Exception e)
                {
                        System.out.println(e);
                }
        }


}
