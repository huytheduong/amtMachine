import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Account {

    public int select1()
    {
        Scanner myObj = new Scanner(System.in);
        //determines if the user wants to withdraw from checking or savings
        System.out.println("Do you want to withdraw from saving or checking");
        System.out.println("1. Checking ------- 2. Saving ");
        int choice = myObj.nextInt();
        
        return choice;
    }

    public int selec2()
    {
        Scanner myObj = new Scanner(System.in);
        //determines if the user wants to deposit from checking or savings
        System.out.println("Do you want to Deposit from Saving or Checking");
        System.out.println("1. Checking ------ 2. Saving ");
        int choice = myObj.nextInt();
        return choice;

    }

    
    
}
