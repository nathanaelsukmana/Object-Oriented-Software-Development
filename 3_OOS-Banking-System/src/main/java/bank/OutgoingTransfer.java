package bank;

public class OutgoingTransfer extends Transfer{
    //muss klo g error
    public OutgoingTransfer(String date, double amount, String description, String sender, String recipient){
        super(date, amount, description, sender, recipient);
    }

    @Override
    public double calculate() { //kasih tau getAccountBalance brp duit yang harus ditambah/dikurang
        //return -this.getAmount();
        return -super.calculate();
    }
}
