import bank.Payment;
import bank.Transfer;

public class Main {
    public static void main(String[] args){

        //test payment 1.konstruktor
        Payment transaktion1 = new Payment("01.10.2025", -29.98, "ICE Ticket");
        transaktion1.printObject();

        //test payment 2.konstruktor
        Payment transaktion2 = new Payment("01.10.2025", 1200, "Bybit", 0, 0);
        transaktion2.printObject();

        //test payment copy konstruktor
        Payment transaktion3 = new Payment(transaktion1);
        transaktion3.printObject();

        //test payment 2.konstruktor mit falschem attributtwert
        Payment transaktion4 = new Payment("15.10.2025", 40, "WG", 1.5, 0);
        transaktion4.printObject();

        //test payment 2.konstruktor mit falschem attributwert
        Payment transaktion5 = new Payment("16.10.2025", 189, "Nike Vaporfly 4", 0, 1.5);
        transaktion5.printObject();

        //test transfer 1.konstruktor
        Transfer ueberweisung1 = new Transfer("28.09.2025", 141, "BKK Firmus");
        ueberweisung1.printObject();

        //test transfer 2.konstruktor
        Transfer ueberweisung2 = new Transfer("03.10.2025", 250.0, "Miete", "Nathan", "Ijo");
        ueberweisung2.printObject();

        //test transfer copy konstruktor
        Transfer ueberweisung3 = new Transfer(ueberweisung2);
        ueberweisung3.printObject();

        //test transfer 2.konstruktor mit falschem attributwert
        Transfer ueberweisung4 = new Transfer("15.10.2025", 141, "Versicherung","Nathan", "BKK Firmus");
        ueberweisung4.setAmount(-141.0);
        ueberweisung4.printObject();

    }
}