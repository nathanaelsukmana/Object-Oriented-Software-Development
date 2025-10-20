package bank;

/**
 * Ein- und Auszahlungen repraesentieren
 */
public class Payment {

    /**
     * Zeitpunkt einer Ein- oder Auszahlung
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
     * Gibt die Zinsen an, die bei einer Einzahlung anfallen
     */
    private double incomingInterest;

    /**
     * Gibt die Zinsen an, die bei einer Auszahlung anfallen
     */
    private double outgoingInterest;

    /**
     * Setzt das Datum
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     * Setzt den Geldbetrag
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Setzt die Beschreibung
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Setzt den Zinssatz fuer Einzahlungen
     */
    public void setIncomingInterest(double newInterest){
        if (newInterest >= 0 && newInterest <= 1){
            this.incomingInterest = newInterest;
        } else {
            System.out.println("Der Zinsatz muss zwischen 0 und 1 liegen");
        }
    }

    /**
     * Setzt den Zinssatz fuer Auszahlungen
     */
    public void setOutgoingInterest(double newInterest){
        if (newInterest >= 0 && newInterest <= 1){
            this.outgoingInterest = newInterest;
        } else {
            System.out.println("Der Zinsatz muss zwischen 0 und 1 liegen");
        }
    }


    /**
     * Gibt Zeitpunkt einer Ein- oder Auszahlung zurueck
     */
    public String getDate(){
        return this.date;
    }

    /**
     * Gibt den Geldbetrag zurueck
     */
    public double getAmount(){
        return this.amount;
    }

    /**
     * Gibt das Transaktionsbeschreibung zurueck
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Gibt Incoming Interest zurueck
     */
    public double getIncomingInterest(){
        return this.incomingInterest;
    }

    /**
     * Gibt Outgoing Interest zurueck
     */
    public double getOutgoingInterest(){
        return this.outgoingInterest;
    }

    /**
     * Erstellt ein Payment Objekt mit den Basisinformationen
     */
    public Payment(String date, double amount, String description){
        setDate(date);
        setAmount(amount);
        setDescription(description);
    }

    /**
     * Erstellt ein Transfer Objekt mit den allen Informationen
     */
    public Payment(String date, double amount, String description, double incomingInterest, double outgoingInterest){
        this(date,amount,description);
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    /**
     * Erstellt eine Kopie von einem anderen Payment Objekt
     */
    public Payment(Payment original){
        this.date = original.getDate();
        this.amount = original.getAmount();
        this.description = original.getDescription();
        this.incomingInterest = original.getIncomingInterest();
        this.outgoingInterest = original.getOutgoingInterest();
    }

    /**
     * Gibt alle Attribute des Payments auf der Konsole aus
     */
    public void printObject(){
        System.out.println("Date: " + this.getDate());
        System.out.println("Amount: " + this.getAmount());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Incoming Interest: " + this.getIncomingInterest());
        System.out.println("Outgoing Interest: " + this.getOutgoingInterest());
        System.out.println("\n");


    }
}
