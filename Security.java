public class Security {

    public boolean verityBalance(ATMCard user, Double amount, int choice)
    {
        //ensure card's owner has enough money
        if(choice == 1) // 1 is checking
        {
            if(user.getChecking() >= amount)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else // 2 is saving
        {
            if(user.getSaving() >= amount)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    }

    public boolean verifyMachineBalance(double totalAmount, double amount)
    {
        //ensure the ATM machine has enough money

        if(amount > totalAmount)
        {
            return false;
        }

        return true;
    }

    public boolean verifyTransfer(double amount, ATMCard user, int choice)
    {
        if(choice == 1) //check from checking
        {
            if(user.getChecking() >= amount)
            {
                return true;
            }
            else{
                return false;
            }
        }
        else
        {
            if(user.getSaving() >= amount)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
