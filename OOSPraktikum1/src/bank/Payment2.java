package bank;

public class Payment2 {
    private double amount;
    private String description;

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getDescription(){
        return this.description;
    }

    public Payment2(double amount, String description){
        this.amount = amount;
        this.description = description;
    }
}
