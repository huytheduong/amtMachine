import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
import javax.print.ServiceUI;


public class Transfer {

    public boolean makeTranserToAnotherAccount(ATMCard user, ArrayList<ATMCard> myList)
    {
        //return true or false;
        Scanner myObj = new Scanner(System.in);
        //String account = myObj.nextLine();

        ATMCard another = new ATMCard();

        System.out.println("Enter Account Num you want to transfer: ");
        String account = myObj.nextLine();

        //another.setCardNum(account);

        Account acc = new Account();
        Security security = new Security();
        
        for(int i = 0; i < myList.size(); i++)
        {
            if(myList.get(i).getCardNum().equals(account))
            {
                //lam cai j do trong nay
                System.out.println("Please chose the account you want to transfer --- 1. Checking ----- 2. Saving");
                int choice = myObj.nextInt();
                System.out.println("Enter Amount you want to tranfer");
                double amount = myObj.nextDouble();
                if(security.verifyTransfer(amount, user, choice))
                {
                    if(choice == 1)
                    {
                        System.out.println("Your Checking : $" + user.getChecking());
                        user.withDrawChecking(amount);
                        System.out.println("Your Checking: $" + user.getChecking());
                        myList.get(i).depositChecking(amount);
                        System.out.print("Account Number" + myList.get(i).getCardNum() + " has recieved amount " + amount + "into checking account");
                    }
                    else
                    {
                        System.out.println("Your Saving : $" + user.getSaving());
                        user.withdrawSaving(amount);
                        System.out.println("Your Saving: $" + user.getSaving());
                        myList.get(i).depositSaving(amount);
                        System.out.print("Account Number " + myList.get(i).getCardNum() + " has recieved amount $" + amount + " into saving account");

                    }
                }

            }
        }
        

        return true;
    }


    public boolean makeTransferBetweenAccount(ATMCard user)
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please Choose The Options below: ");
        System.out.println("1. Checking -> Saving  ----- 2. Saving -> Checking ");
        int choice = myObj.nextInt();

        Security security = new Security();

        if(choice == 1)
        {
            System.out.println("Please Enter The amount you want to transfer from checking to saving: ");
            double amount = myObj.nextDouble();
            
            if(security.verifyTransfer(amount, user, choice))
            {
                System.out.println("Your Checking Balance Before Transfer : " + user.getChecking());
                System.out.println("Your Saving Balance Before Transfer : " + user.getSaving());
                user.withDrawChecking(amount);
                user.depositSaving(amount);
                System.out.println("Your Checking Balance After Transfer : " + user.getChecking());
                System.out.println("Your Saving Balance After Transfer  : " + user.getSaving());
                return true;
            }
            else
            {
                System.out.println("Invalid.. transaction unsuccessfull");
                return false;
            }
        }
        else if(choice == 2)
        {
            System.out.println("Please Enter The amount you want to transfer from saving to checking: ");
            double amount = myObj.nextDouble();
            
            if(security.verifyTransfer(amount, user, choice))
            {
                System.out.println("Your Checking Balance Before Transfer: " + user.getChecking());
                System.out.println("Your Saving Balance Before Transfer: " + user.getSaving());
                user.withdrawSaving(amount);
                user.depositChecking(amount);
                System.out.println("Your Checking Balance After Transfer: " + user.getChecking());
                System.out.println("Your Saving Balance After Transfer: " + user.getSaving());
                return true;
            }
            else
            {
                System.out.println("Invalid.. transaction unsuccessfull");
                return false;
            }

        }




        return true;
    }
    
}
