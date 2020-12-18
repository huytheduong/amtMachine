import java.util.ArrayList;
import java.util.Scanner;

public class CardServices {

private ATMCard newCard;


public void initializeCardDB()
{
    // Create an array to store ATM card and number
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
}


public boolean insertCard(ATMCard user, ArrayList<ATMCard> myList)
{
    //check user card number
    Scanner myObj = new Scanner(System.in);
    System.out.println("Please Enter The CardId: ");
    String cardId = myObj.nextLine();

    user.setCardNum(cardId);

    for(int i = 0; i < myList.size(); i++)
    {
        if(myList.get(i).getCardNum().equals(user.getCardNum()))
        {
            System.out.println("You Enter The Valid Card!");
            return true;
        }
    }

    System.out.println("Unrecognized card");

    return false;
    
}

public void processCard()
{
    //allows user to request funds to withdraw

    System.out.println("Processing..Please Wait for a second!");

}


public void returnCard()
{
    //return card to user
    System.out.println("Please Take Your Card ........Thanks for chosing Bank of America");
}


    
}
