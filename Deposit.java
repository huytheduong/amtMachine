import java.util.ArrayList;
import java.util.Scanner;

public class Deposit {

    Scanner myObj = new Scanner(System.in);

    public boolean depositMoney(ATMCard user)
    {
        //deposit money

        Account account = new Account();

        Scanner myObj = new Scanner(System.in);
        int choice = account.selec2();
        System.out.println("Please Enter amount you want to deposit");
        double amount = myObj.nextDouble();
        // 1 is checking and 2 is saving
        if(choice == 1)
        {
            System.out.println("Your Checking Account before: $" + user.getChecking());
            user.depositChecking(amount);
            System.out.println("Your Checking Account after : $" + user.getChecking());
        }
        else if(choice == 2)
        {
            System.out.println("Your Saving Account before: $" + user.getSaving());
            user.depositSaving(amount);
            System.out.println("Your Saving Account after : $" + user.getSaving());

        }

        return true;
    }

    
}
