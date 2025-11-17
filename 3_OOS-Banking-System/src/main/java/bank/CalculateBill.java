package bank;

/**
 * Definiert Vertrag fuer Klassen, die Final Amount berechnen koennen
 *
 */
//interface ist janji, irgendwer implements CalculateBill will have calculate() method
public interface CalculateBill {

    /**
     * Berechnen und Zurueckgeben Final Amount
     * @return Das berechnete Amount ist double
     */
    double calculate();
}
