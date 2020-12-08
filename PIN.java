import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class PIN {


    public boolean processPin(ATMCard user, ArrayList<ATMCard> myList)
    {
        //compare the pin entered to the pin store in the card

        //allow user to enter card;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please Enter The PinId: ");
        String cardPin = myObj.nextLine();

        user.setCardPin(cardPin);

        for(int i = 0; i < myList.size(); i++)
        {
            if(myList.get(i).getCardPin().equals(user.getCardPin()))
            {
                user.setCheckingBalance(myList.get(i).getChecking());
                user.setSavingBalance(myList.get(i).getSaving());
                System.out.print("You Enter Valid Pin: ");
                return true;
            }
        }

        System.out.println("You Enter Invalid Pin: ");

        return false;
    }

    public void eatCard()
    {
        //if the PIN is incorrect entered 4 times and eat the card
        System.out.print("We've eaten your card :))");

    }
    
}
