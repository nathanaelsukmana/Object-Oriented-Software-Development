package bank;

import java.util.Objects;

//push: ctrl shift k

//abstract class tidak bisa langsung dibuat menjadi objek, hanya bisa diturunkan
//make class abstract using "abstract" keyword and put it vor "class" keyword
public abstract class Transaction implements CalculateBill{
    /**
     * Zeitpunkt einer Ein- oder Auszahlung
     */
    protected String date;

    /**
     * Geldmenge einer Ein- oder Auszahlung
     */
    protected double amount;

    /**
     * Zusaetzliche Beschreibung des Vorgangs
     */
    protected String description;

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
        this.amount=amount;
    }
    /**
     * Setzt die Beschreibung
     */
    public void setDescription(String description){
        this.description = description;
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
     * Objekterstellung
     * @param date
     * @param amount
     * @param description
     */
    public Transaction(String date, double amount, String description){
        this.date = date;
        this.description = description;
        setAmount(amount);
    }

    /**
     * Berechnen Final Amount vom Payment und Transfer
     * @return berechneter Amount
     */
    //calculate muss in jeder klasse implementiert werden
    @Override
    public abstract double calculate();

    /**
     * Ausgabe der Attributten
     * @return Attributen von Klassen
     */
    @Override
    public String toString(){
        //calculate = berechneter wert
        return ("Date: " + this.date + ", Amount: " + this.calculate() + ", Description: " + this.description);
    }

    /**
     * Ueberprueft ob 2 Objekte sind gleich oder nicht
     * @param obj   the reference object with which to compare.
     * @return das Ergebnis vom Vergleich
     */
    @Override
    public boolean equals(Object obj) {
        //identitaet ist gleich, true
        if(obj == this){
            return true;
        }

        //instanceof = typecheck, ergebnis von instanceof ist boolean, ob obj is transaction
        if(!(obj instanceof Transaction)){
            return false;
        }

        //typecast
        Transaction other = (Transaction) obj;
        //nan, 0 = gleich
        return Objects.equals(this.date, other.date) && Double.compare(this.amount, other.amount) == 0
                && Objects.equals(this.description, other.description);
    }
}

//redundant: ditulis berulang ulang