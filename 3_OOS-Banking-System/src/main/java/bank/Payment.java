package bank;

import java.util.Objects;

/**
 * Ein- und Auszahlungen repraesentieren
 */
//Payment soll von der abstrakten Klasse Transaction erben
public class Payment extends Transaction{

    /**
     * Gibt die Zinsen an, die bei einer Einzahlung anfallen
     */
    private double incomingInterest;

    /**
     * Gibt die Zinsen an, die bei einer Auszahlung anfallen
     */
    private double outgoingInterest;

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
        super(date, amount, description);
    }

    /**
     * Erstellt ein Transfer Objekt mit den allen Informationen
     */
    public Payment(String date, double amount, String description, double incomingInterest, double outgoingInterest){
        super(date,amount,description);
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    /**
     * Erstellt eine Kopie von einem anderen Payment Objekt
     */
    public Payment(Payment original){
        super(original.getDate(), original.getAmount(), original.getDescription());
        this.incomingInterest = original.getIncomingInterest();
        this.outgoingInterest = original.getOutgoingInterest();
    }

    /**
     * Gibt alle Attribute des Payments auf der Konsole aus
     */
    /*
    public void printObject(){
        System.out.println("Date: " + this.getDate());
        System.out.println("Amount: " + this.getAmount());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Incoming Interest: " + this.getIncomingInterest());
        System.out.println("Outgoing Interest: " + this.getOutgoingInterest());
        System.out.println("\n");
    }*/

    /**
     * Berechnen und Zurueckgeben des Amounts von Payment Kategorie
     * @return das berechneten Amount nach incoming und outgoing Interest
     */
    @Override
    public double calculate() {

        if (amount > 0) {
            //depo minus ii
            return amount * (1.0 - incomingInterest);
        } else if (amount < 0) {
            //withdraw tambah oi
            return amount * (1.0 + outgoingInterest);
        } else {
            return 0;
        }
    }

    /**
     * Ausgabe Objekt auf der Konsole und ersetzen printObject() Method
     * @return die Attribute von Payment
     */
    @Override
    public String toString(){
        return (super.toString() + ", Incoming Interest: " + this.getIncomingInterest() + ", Outgoing Interest: " + this.getOutgoingInterest());
    }

    /**
     * Ueberprueft ob 2 Objekte sind gleich oder nicht
     * @param obj   the reference object with which to compare.
     * @return das Ergebnis vom Vergleich
     */
    @Override
    public boolean equals(Object obj) {
        //erstmal cek 3 att in transaction
        if (!super.equals(obj)){
            return false;
        }

        if (!(obj instanceof Payment)){
            return false;
        }
        Payment other = (Payment) obj;                                      //0 = equals
        return Double.compare(this.incomingInterest, other.incomingInterest) == 0 && Double.compare(this.outgoingInterest, other.outgoingInterest) == 0;
    }
}
