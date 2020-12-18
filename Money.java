import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;



public class Money {

    double totalAmount = 1000.0d;
 
    public boolean enterAmount(ATMCard user)
    {
        //ask user to enter amount to withdraw

        Scanner myObj = new Scanner(System.in);

        Security security = new Security();

        Account acc = new Account();

        int choice = acc.select1();
        System.out.println("Please Enter The Amount Do you want to withdraw");
        double amount = myObj.nextDouble();


        if(!security.verityBalance(user, amount, choice))
        {
            System.out.println("You dont have enough money....");
            return false;
        }
        if(!security.verifyMachineBalance(totalAmount, amount))
        {
            System.out.println("Machine doesn have enough money....");
            System.out.println("Please Enter New Amount....");
            amount = myObj.nextDouble();
            if(!security.verifyMachineBalance(totalAmount, amount))
            {
                return false;
            }
        }

        totalAmount -= amount;
        
        if(choice == 1)
        {
            System.out.println("Your Checking Account before: $" + user.getChecking());
            user.withDrawChecking(amount);
            System.out.println("Your Checking Account after : $" + user.getChecking());
        }
        else if(choice == 2)
        {
            System.out.println("Your Checking Account before: $" + user.getSaving());
            user.withdrawSaving(amount);
            System.out.println("Your Checking Account after : $" + user.getSaving());
        }

        return true;

    }
    

}
