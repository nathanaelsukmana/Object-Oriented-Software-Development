import bank.*;
import bank.exceptions.*;

import java.util.ArrayList;
import java.util.List;

//default package: src/main/java alias diluar package bank
public class Main {
    public static void main(String[] args) {
        //Erzeugen Sie Objekte der Klassen PrivateBank mit incomingInterest und outgoingInterest mit Werten größer 0
        PrivateBank bank1 = new PrivateBank("Bank Variante 1", 0.05, 0.03);
        PrivateBankAlt bank2 = new PrivateBankAlt("Bank Variante 2", 0.1, 0.08);
        System.out.println("Objekt 1 erstellt: " + bank1);
        System.out.println("Objekt 2 erstellt: " + bank2);

        //transactions anlegen
        Payment einzahlung1 = new Payment("13.11.2025", 1000, "Gehalt");
        Payment auszahlung1 = new Payment("13.11.2025", -300, "Miete");
        //normal
        Transfer nathan_an_ferren = new Transfer("13.11.2025", 50, "Food", "Nathan", "Ferren");
        //v1
        IncomingTransfer i1 = new IncomingTransfer("14.11.2025", 200, "Bonus", "NVIDIA", "Nathan");
        OutgoingTransfer o1 = new OutgoingTransfer("14.11.2025", 20, "Lebensmittel", "Nathan", "LIDL" );

        try{
            System.out.println("TEST CREATE ACCOUNT 1");
            bank2.createAccount("Nathan");
            bank2.createAccount("Ferren");

            System.out.println("TEST ADD TRANSACTION");
            bank2.addTransaction("Nathan",einzahlung1);
            bank2.addTransaction("Nathan", auszahlung1);
            bank2.addTransaction("Nathan", nathan_an_ferren);
            bank2.addTransaction("Ferren", nathan_an_ferren);

            System.out.println("TEST GET ACCOUNT BALANCE");
            double balanceNathan = bank2.getAccountBalance("Nathan");
            System.out.println("Kontostand Nathan: " + balanceNathan);
            double balanceFerren = bank2.getAccountBalance("Ferren");
            System.out.println("Kontostand Ferren: " + balanceFerren);

            System.out.println("\n TEST GET TRANSACTION");
            List<Transaction> transactions = bank2.getTransactions("Nathan");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }

            System.out.println("\n TEST GET TRANSACTION BY TYPE");
            for(Transaction transaction : bank2.getTransactionsByType("Nathan",true)){
                System.out.println(transaction);
            }

            System.out.println("\n TEST GET TRANSACTION SORTED");
            for(Transaction transaction : bank2.getTransactionsByType("Nathan",true)){
                System.out.println(transaction);
            }

            System.out.println("REMOVE TRANSACTION");
            bank2.removeTransaction("Nathan",einzahlung1);
            System.out.println(bank2.containsTransaction("Nathan",einzahlung1));

            System.out.println("\n TEST CREATE ACCOUNT 2");
            List<Transaction> transactions2 = new ArrayList<>();
            transactions2.add(new Payment("15.11.2025", 1000, "Gehalt"));
            bank2.createAccount("Liman", transactions2);
            System.out.println("Liman's account balance: " + bank2.getAccountBalance("Liman"));
            System.out.println(bank2);
        } catch (Exception e){
            System.out.println("Unerwartet Exception: " + e.getMessage());
        }

        try {
            System.out.println("\nTEST ACCOUNT ALREADY EXISTS");
            bank2.createAccount("Nathan");
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unerwartet Exception: " + e.getClass().getSimpleName());
        }

        try {
            System.out.println("TEST ACCOUNT DOESNT EXISTS");
            bank2.addTransaction("Ghost",einzahlung1);
        }catch (AccountDoesNotExistException e){
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }catch (Exception e){
            System.out.println("Unerwartet Exception: " + e.getClass().getSimpleName());
        }

        try {
            System.out.println("TEST TRANSACTION DOESNT EXISTS");
            bank2.removeTransaction("Nathan",einzahlung1);
        }catch (TransactionDoesNotExistException e){
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }catch (Exception e){
            System.out.println("Unerwartet Exception: " + e.getClass().getSimpleName());
        }

        PrivateBank bank1_1 = new PrivateBank("Bank Variante 1.1", 0.05, 0.03);
        PrivateBank bank1__ = new PrivateBank("Bank Variante 1 Unknown", 0.05, 0.03);

        System.out.println("\nTest == :" + (bank1 == bank1_1));
        System.out.println("Test .equals():" + bank1.equals(bank1_1));

        System.out.println("\nTest .equals() CC");
        PrivateBank bank1Copy = new PrivateBank(bank1);
        System.out.println("Test .equals(): " + bank1.equals(bank1Copy));

        //Neue Transaction ins Bank 1 addieren
        try{
            bank1.createAccount("Test");
            bank1.addTransaction("Test",einzahlung1);
        }catch (Exception e){
            System.out.println("Unerwartet Exception: " + bank1.equals(bank1Copy));
        }
        System.out.println("Test .equals(): " + bank1.equals(bank1Copy));

    }
}
