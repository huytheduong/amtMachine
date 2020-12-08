public class ATMCard {

    private String cardNum;
    private String cardPin;
    private double checkingBalance;
    private double savingBalance;

    ATMCard(){};

    ATMCard(String cardNum, String cardPin, double checkingBalance, double savingBalance)
    {
        this.cardNum = cardNum;
        this.cardPin = cardPin;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }

    public String getCardNum()
    {
        return this.cardNum;
    }

    public void setCardNum(String cardNum)
    {
        this.cardNum = cardNum;
    }

    public void setCardPin(String cardPin)
    {
        this.cardPin = cardPin;
    }

    public String getCardPin()
    {
        return this.cardPin;
    }

    public double getChecking()
    {
        return this.checkingBalance;
    }

    public double getSaving()
    {
        return this.savingBalance;
    }

    public void setCheckingBalance(double checkingBalance)
    {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingBalance(double savingBalance)
    {
        this.savingBalance = savingBalance;
    }

    public void withDrawChecking(double amount)
    {
        this.checkingBalance -= amount;
    }
    public void withdrawSaving(double amount)
    {
        this.savingBalance -= amount;
    }

    public void depositChecking(double amount)
    {
        this.checkingBalance += amount;
    }

    public void depositSaving(double amount)
    {
        this.savingBalance += amount;
    }



    public String toString()
    {
        return "Card's Number= " + this.cardNum + " Card's Pin= " + this.cardPin + " Checking Balance= $" + this.checkingBalance + " Saving Balance= $" + this.savingBalance;
    }

}
