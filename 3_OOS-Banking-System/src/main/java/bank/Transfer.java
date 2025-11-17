package bank;

import java.util.Objects;

//Inheritance: Mewarisi semua att parent class

/**
 * Ueberweisung repraesentieren
 */
public class Transfer extends Transaction {

    /**
     * Welcher Akteur die Geldmenge, die in amount angegeben wurde, ueberwiesen hat
     */
    private String sender;

    /**
     * Welcher Akteur, die Geldmenge, die in amount angegeben wurde, ueberwisen bekommen hat
     */
    private String recipient;

    /**
     * Setzt den Geldbetrag
     */
    @Override
    public void setAmount(double amount){
        if (amount > 0){ //lediglich positive werte
            this.amount = amount;
        } else {
            System.out.println("Transferbetrag muss positiv sein");
        }
    }

    /**
     * Setzt die Sender
     */
    public void setSender(String sender){
        this.sender = sender;
    }

    /**
     * Setzt die Recipient
     */
    public void setRecipient(String recipient){
        this.recipient = recipient;
    }

    //Gibt das Sender zurueck
    public String getSender(){
        return this.sender;
    }


    //Gibt das Empfaenger zurueck
    public String getRecipient(){
        return this.recipient;
    }

    //Erstellt ein Transfer Objekt mit den Basisinformationen
    public Transfer (String date, double amount, String description){
        super(date, amount, description);
    }


    //Erstellt ein Transfer Objekt mit den allen Informationen
    public Transfer(String date, double amount, String description, String sender, String recipient){
        super(date, amount, description);
        setSender(sender);
        setRecipient(recipient);
    }


    //Erstellt eine Kopie von einem anderen Transfer Objekt
    public Transfer(Transfer original){
        super(original.getDate(), original.getAmount(), original.getDescription());
        this.sender = original.getSender();
        this.recipient = original.getRecipient();
    }

    /*
     //Gibt alle Attribute des Transfers auf der Konsole aus
    public void printObject(){
        System.out.println("Date: " + this.getDate());
        System.out.println("Amount: " + this.getAmount());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Sender: " + this.getSender());
        System.out.println("Recipient: " + this.getRecipient());
        System.out.println("\n");
    }
    */

    /**
     * Berechnen und Zurueckgeben des Amounts von Transfer Kategorie
     * @return Transferamount
     */
    @Override
    public double calculate() {
        return amount;
    }


    /**
     * Ausgabe Objekt auf der Konsole und ersetzen printObject() Method
     * @return die Attribute von Payment
     */
    @Override
    public String toString(){
        return (super.toString() + ", Sender: " + this.getSender() + ", Recipient: " + this.getRecipient());
    }

    /**
     * Ueberprueft ob 2 Objekte sind gleich oder nicht
     * @param obj allgemeine object.
     * @return das Ergebnis vom Vergleich
     */
    @Override
    public boolean equals(Object obj) {
        //wenn 3 att ungleich
        if(!super.equals(obj)){
            return false;
        }

        //wenn der object nicht gleich
        if(!(obj instanceof Transfer)){
            return false;
        }

        //typecast, obj ist transfer
        Transfer other = (Transfer) obj;

        return Objects.equals(this.sender, other.sender) && Objects.equals(this.recipient, other.recipient);
    }
}
