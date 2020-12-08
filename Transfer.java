import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;


public class Transfer {

    public boolean makeTranser(ATMCard user, ArrayList<ATMCard> myList)
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
                    }
                    else
                    {
                        System.out.println("Your Saving : $" + user.getSaving());
                        user.withdrawSaving(amount);
                        System.out.println("Your Saving: $" + user.getSaving());
                        myList.get(i).depositSaving(amount);

                    }
                }

            }
        }
        

        return true;


    }
    
}
