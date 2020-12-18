import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.TreeUI;
import javax.swing.plaf.synth.SynthMenuBarUI;


public class Main {

    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);

        ArrayList<ATMCard> myList = new ArrayList<ATMCard>();

        // ATMCard Smith = new ATMCard("123456789", "1111", 550.0d, 1275d);
        // ATMCard Amy = new ATMCard("135792468", "2097", 90.0d, -1.0d);
        // ATMCard Logan = new ATMCard("019283746", "6194", 715.0d, -1.0d);
        // ATMCard Tammy = new ATMCard("675849302", "0071", 790.0d, 211.0d);
        // ATMCard Jill = new ATMCard("347821904", "9871", 113.0d, 78.0d);

        //Use for homework 2

        ATMCard Smith = new ATMCard("123456789", "1111", 500.0d, 200.0d);
        ATMCard Amy = new ATMCard("135792468", "2097", 100.0d, 700.0d);
        ATMCard Logan = new ATMCard("019283746", "6194", 1500.0d, 2500.d);
        ATMCard Tammy = new ATMCard("675849302", "0071", 50.0d, -1.0d);
        ATMCard Jill = new ATMCard("347821904", "9871", 150.0d, 250.0d);

        myList.add(Smith);
        myList.add(Amy);
        myList.add(Tammy);
        myList.add(Logan);
        myList.add(Jill);
 
        double totalAmount = 1000.0d;

        ATMCard user = new ATMCard("","",0.0d,0.0d);
        CardServices card = new CardServices();
        PIN pin = new PIN();
        Money money = new Money();
        Security security = new Security();
        Deposit deposit = new Deposit();
        Transfer transer = new Transfer();
        
        card.initializeCardDB();
        startAMT();

        //boolean fourTimes = true;

        boolean isValid = true;
        
        boolean exit = false;

        while(!exit){

            boolean fourTimes = true;

            if(card.insertCard(user, myList) == true)
            {
                    card.processCard();
                    boolean validPin = pin.processPin(user, myList);
                    card.processCard();
                    if(validPin == false)
                    {
                        int count = 1;
                        while(validPin == false)
                        {
                            if(count == 4)
                            {
                                pin.eatCard();
                                System.out.println("\nPlease Come To Closest Bank's Office...!");
                                fourTimes = false;
                                break;
                            }
                            validPin = pin.processPin(user, myList);
                            count++;
                        }

                    }

                    if(fourTimes == true)
                    {
                        boolean continues = false;

                        while(!continues)
                        {

                        printActions();
                        System.out.println("\n Please Enter Your Option: ");
                        int options = myObj.nextInt();
                        card.processCard();
    
                        switch(options)
                        {
                            case 0:
                                System.out.println("Thanks for using Bank of America....!");
                                continues = true;
                                //System.exit(0);
                                break;
                            case 1:
                                //check balance
                                if(checkingBalanceOptions() == 1) System.out.print("Your Checking Balance is: $" + user.getChecking());
                                else System.out.print("Your Checking Balance is: $" + user.getSaving());
                                break;
                            case 2:
                                deposit.depositMoney(user);
                                //deposit money
                                break;
                            case 3:
                                money.enterAmount(user);
                                //withdraw money
                                break;
                            case 4:
                                //transefer money to another account exist in the database
                                transer.makeTranserToAnotherAccount(user, myList);
                                
                                break;
                            case 5:
                                //transfer money between your account
                                transer.makeTransferBetweenAccount(user);

                                break;
                            default:
                                System.out.print("Invalid Input..");
                                break;
                            }
                    }

                    System.out.println("\nDo you want another Transaction Again? \n 1. YES --- 2. NO");
                    int choice = myObj.nextInt();
                    if(choice == 1)
                    {
                        exit = false;
                    }
                    else
                    {
                        exit = true;
                        System.exit(0);
                    }
                        }
                }
            else
            {
                System.out.println("\nDo you want another Transaction? \n 1. YES --- 2. NO");
                int choice = myObj.nextInt();
                if(choice == 1)
                {
                    exit = false;
                }
                else
                {
                    exit = true;
                    System.exit(0);
                }
            }

        }

        card.returnCard();

        System.exit(0);

    }

    public static void startAMT()
    {
        System.out.println("Welcome to Bank of America....");
    }

    public static void printActions()
    {
        System.out.println("\nPlease chose your option here: ");
        System.out.println("0 - Cancel the transaction");
        System.out.println("1 - Checking balance from checking account or saving account");
        System.out.println("2 - Deposit money");
        System.out.println("3 - Withdraw money");
        System.out.println("4 - Transfer Money To Another People");
        System.out.println("5 - Transfer Money To Between Your Account");
    }

    public static int checkingBalanceOptions()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Which Account do you want to check: ");
        System.out.println("1. Checking ---------- 2. Saving");
        int options = myObj.nextInt();
        
        return options;
    }

}