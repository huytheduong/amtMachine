import java.io.Serial;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthMenuBarUI;


public class Main {

    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);

        ArrayList<ATMCard> myList = new ArrayList<ATMCard>();

        ATMCard Smith = new ATMCard("123456789", "1111", 550.0d, 1275d);
        ATMCard Amy = new ATMCard("135792468", "2097", 90.0d, -1.0d);
        ATMCard Logan = new ATMCard("019283746", "6194", 715.0d, -1.0d);
        ATMCard Tammy = new ATMCard("675849302", "0071", 790.0d, 211.0d);
        ATMCard Jill = new ATMCard("347821904", "9871", 113.0d, 78.0d);

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
        
        boolean exit = false;

        do{
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
                                System.out.println("Please Come To Closest Bank's Office...!");
                                exit = true;
                                System.exit(0);
                            }
                            validPin = pin.processPin(user, myList);
                            count++;
                        }
                    }

                    printActions();
                    System.out.println("Please Enter Your Option: ");
                    int options = myObj.nextInt();
                    card.processCard();

                    switch(options)
                    {
                        case 0:
                            System.out.println("Thanks for using Bank of America....!");
                            System.exit(0);
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
                            transer.makeTranser(user, myList);
                            
                            break;
                        default:
                            System.out.print("Invalid Input..");
                            break;
                        }

                        System.out.println("\n Do you want another Transaction? \n 1. YES --- 2. NO");
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
            else
            {
                System.out.println("\n Do you want another Transaction? \n 1. YES --- 2. NO");
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
        }while(!exit);

        card.returnCard();

        System.exit(0);

    }

    public static void startAMT()
    {
        System.out.println("Welcome to Bank of America....");
    }

    public static void printActions()
    {
        System.out.println("Please chose your option here: ");
        System.out.println("0 - Cancel the transaction");
        System.out.println("1 - Checking balance from checking account or saving account");
        System.out.println("2 - Deposit money");
        System.out.println("3 - Withdraw money");
        System.out.println("4 - Transfer Money");
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