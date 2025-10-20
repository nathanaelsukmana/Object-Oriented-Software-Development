package bank;

/**
 * Ueberweisung repraesentieren
 */
public class Transfer {

    /**
     * Zeitpunkt einer Transfer
     */
    private String date;

    /**
     * Geldmenge einer Ein- oder Auszahlung
     */
    private double amount;

    /**
     * Zusaetzliche Beschreibung des Vorgangs
     */
    private String description;

    /**
     * Welcher Akteur die Geldmenge, die in amount angegeben wurde, ueberwiesen hat
     */
    private String sender;

    /**
     * Welcher Akteur, die Geldmenge, die in amount angegeben wurde, ueberwisen bekommen hat
     */
    private String recipient;

    /**
     * Setzt das Datum
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     * Setzt den Geldbetrag
     */
    public void setAmount(double amount){
        if (amount > 0){ //lediglich positive werte
            this.amount = amount;
        } else {
            System.out.println("Transferbetrag muss positiv sein");
        }
    }

    /**
     * Setzt die Beschreibung
     */
    public void setDescription(String description){
        this.description = description;
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

    /**
     * Gibt das Transfersdatum zurueck
     */
    public String getDate(){
        return this.date;
    }


    /**
     * Gibt das Amount zurueck
     */
    public double getAmount(){
        return this.amount;
    }


    /**
     * Gibt das Transfersbeschreibung zurueck
     */
    public String getDescription(){
        return this.description;
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
        setDate(date);
        setAmount(amount);
        setDescription(description);
    }


     //Erstellt ein Transfer Objekt mit den allen Informationen
    public Transfer(String date, double amount, String description, String sender, String recipient){
        this(date, amount, description);
        setSender(sender);
        setRecipient(recipient);
    }


     //Erstellt eine Kopie von einem anderen Transfer Objekt
    public Transfer(Transfer original){
        this.date = original.getDate();
        this.amount = original.getAmount();
        this.description = original.getDescription();
        this.sender = original.getSender();
        this.recipient = original.getRecipient();
    }


     //Gibt alle Attribute des Transfers auf der Konsole aus
    public void printObject(){
        System.out.println("Date: " + this.getDate());
        System.out.println("Amount: " + this.getAmount());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Sender: " + this.getSender());
        System.out.println("Recipient: " + this.getRecipient());
        System.out.println("\n");

    }
}
