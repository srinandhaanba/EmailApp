package emailapp;

import java.util.*;
public class EmailApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //user info
        System.out.println("Enter first name");
        String f_name=sc.next();
        System.out.println("Enetr last name");
        String l_name=sc.next();
        //create obj for email class
        Email em1=new Email(f_name,l_name);
        int choise=-1;
        do {
            System.out.println("\n*******\nEnetr your choice\n1.Show Info\n2.Change password\n3.Change mailbox capcity\n4.Set Alternate mail\n5.Store data in file\n6.Display data from file\n7.Exit");
            choise=sc.nextInt();
            switch (choise)
            {
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    em1.storefile();
                    break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    System.out.println("Thank you for using application!");
                    break;
                default:
                    System.out.println("Invalid choice!!\nEnter proper choice");

            }
        }while (choise!=7);
    }
}
