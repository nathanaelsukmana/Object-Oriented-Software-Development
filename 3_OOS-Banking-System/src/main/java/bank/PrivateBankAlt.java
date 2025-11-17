package bank;

import bank.exceptions.*;

import java.util.*;

//am anfang error, denn es gibt noch keine methode von bank implementiert wird
/**
 * Implementiert das Bank Interface zur Verwaltung von Konten und Transaktionen und spezielle addTransaction.
 * Diese Klasse speichert Konten und die zugehörigen Transaktionen in einer Map.
 *
 * @author Nathanael Lumen Sukmana
 */
public class PrivateBankAlt implements Bank{

    //2 klassenatributen und sichtbarkeit
    /**
     * Der Name der Bank.
     */
    private String name; //den namen der privaten bank repraesentieren

    /**
     * Der Incoming Interest (positiver Wert, 0-1), der bei Einzahlungen (Deposit) berechnet wird.
     */
    private double incomingInterest;

    /**
     * Der Outgoing Interest (positiver Wert, 0-1), der bei Auszahlungen (Withdrawal) berechnet wird.
     */
    private double outgoingInterest;

    /**
     * Map, die Kontonamen (String) auf eine Liste von Transaktionen (List<Transaction>) abbildet.
     * Wird direkt initialisiert.
     */
                                                                        //kelas konkret di java yang implementasi interface map, hm simpen key(nama akun) dan value (daftar transaksi)
    private Map<String, List<Transaction>> accountsToTransactions = new HashMap<>(); //konten mit transactions verknuepfen, direkt bei der defin des klassenatt mit new

    //3 getter setter
    /**
     * Ruft den Namen der Bank ab.
     * @return der aktuelle Name der Bank.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Ruft den Incoming Interest der Bank ab.
     * @return der aktuelle Habenzins (0-1).
     */
    public double getIncomingInterest(){
        return this.incomingInterest;
    }

    /**
     * Ruft den Outgoing Interest der Bank ab.
     * @return der aktuelle Sollzins (0-1).
     */
    public double getOutgoingInterest() {
        return this.outgoingInterest;
    }

    /**
     * Setzt den Namen der Bank.
     * @param name der neue Name der Bank.
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Setzt den Incoming Interest der Bank.
     * @param incomingInterest der neue Habenzins (0-1).
     */
    public void setIncomingInterest(double incomingInterest){
        this.incomingInterest = incomingInterest;
    }

    /**
     * Setzt den Outgoing Interest der Bank.
     * @param outgoingInterest der neue Sollzins (0-1).
     */
    public void setOutgoingInterest(double outgoingInterest){
        this.outgoingInterest = outgoingInterest;
    }

    //4 konst fuer die ersten drei att
    /**
     * Konstruktor zur Erstellung einer neuen PrivateBank mit spezifischen Zinsen.
     *
     * @param name             Name der Bank.
     * @param incomingInterest Habenzins (0-1).
     * @param outgoingInterest Sollzins (0-1).
     */
    public PrivateBankAlt(String name, double incomingInterest, double outgoingInterest){
        setName(name);
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    //5 cc
    /**
     * Copy-Konstruktor. Erstellt eine Kopie einer bestehenden PrivateBank.
     * Kopiert nur die Attribute Name, incomingInterest und outgoingInterest.
     *
     * @param original Die zu kopierende PrivateBank.
     */
    public PrivateBankAlt(PrivateBankAlt original){
        setName(original.name);
        setIncomingInterest(original.incomingInterest);
        setOutgoingInterest(original.outgoingInterest);
    }

    //6 toString und equals(Object)-Methoden der Klasse Object
    /**
     * Gibt eine String-Repräsentation der Bank zurück.
     *
     * @return Ein String mit Name, Zinsen und Anzahl der verwalteten Konten.
     */
    @Override //sengaja ubah metode dr superclass Object
    public String toString() { //ubah nilai2 att obj jadi string sehingga bisa dibaca
        return "Name: " + this.name + ", Incoming Interest: " + this.incomingInterest + ", Outgoing Interest: " + this.outgoingInterest
                + ", und Total Accounts to Transaction: " + this.accountsToTransactions.size();
    }

    //sollen alle klassenatt verwendet und geprueft werden
    /**
     * Vergleicht diese Bank mit einem anderen Objekt auf Gleichheit.
     * Zwei Banken sind gleich, wenn alle Attribute (Name, Zinsen und die Transaktions-Map) übereinstimmen.
     *
     * @param obj Das zu vergleichende Objekt.
     * @return true, wenn die Objekte gleich sind, sonst false.
     */
    @Override
    public boolean equals(Object obj) { //apakah 2 obj ini isinya sm
        if(this == obj){ //self check
            return true;
        }
        if(obj == null){ //null check
            return false;
        }
        if(this.getClass() != obj.getClass()){ //klo obj bukan dr kelas yg sama
            return false;
        }
        PrivateBankAlt other = (PrivateBankAlt) obj; //casting si obj
        return this.name.equals(other.name) && Double.compare(this.incomingInterest, other.incomingInterest) == 0 && //0 angka sama, compare yg ini balikin int
                Double.compare(this.outgoingInterest, other.outgoingInterest) == 0 && this.accountsToTransactions.equals(other.accountsToTransactions);
    }

    //7 alle methoden von Bank in privatebank implementieren, generate und implement methods
    //die restlichen Methoden sollten mit Hilfe der Methodensignatur und Javadoc-Dokumentation problemslos implementiert werden können
    /**
     * Erstellt ein neues, leeres Konto in der Bank.
     *
     * @param account Der Name des zu erstellenden Kontos.
     * @throws AccountAlreadyExistsException wenn das Konto bereits existiert.
     */
    @Override
    public void createAccount(String account) throws AccountAlreadyExistsException {
        if(this.accountsToTransactions.containsKey(account)) { //apakah acc udah ada di map aTT
            throw new AccountAlreadyExistsException("Account: " + account + " ist vorhanden.");
        }
            this.accountsToTransactions.put(account, new ArrayList<>()); //tambahin key (acc) dgn value -> { "accname":[], "accname2":[]}
    }

    /**
     * Erstellt ein neues Konto und fügt eine Liste von Transaktionen hinzu.
     *
     * @param account      Der Name des zu erstellenden Kontos.
     * @param transactions Eine Liste von Transaktionen, die hinzugefügt werden sollen.
     * @throws AccountAlreadyExistsException    wenn das Konto bereits existiert.
     * @throws TransactionAlreadyExistException wenn eine Transaktion bereits existiert.
     * @throws TransactionAttributeException    bei ungültigen Transaktionsattributen.
     */
    @Override
    public void createAccount(String account, List<Transaction> transactions) throws AccountAlreadyExistsException,
            TransactionAlreadyExistException, TransactionAttributeException {
        createAccount(account);                                                             //add an acc und damit nicht redundant
        if(transactions != null){                                                           //biar program ga crash kalo list transaksinya 0
            for(Transaction everyT : transactions) {                                        //loop satu2 transaksinya
                try{
                    this.addTransaction(account, everyT);                                   //nambahin satu transaksi ke akun
                } catch (AccountDoesNotExistException e) {                                  //butuh exc ini karena gua manggil aT
                    throw new RuntimeException("(fast impossible)" + e);                    //karena baru aja dibuat akunnya
                } catch (TransactionAlreadyExistException e){
                    throw new TransactionAlreadyExistException("Transaction" + transactions + " already exists.");
                } catch (TransactionAttributeException e){
                    throw new TransactionAttributeException("Error in Transaction Attribute");
                }
            }
        }
    }

    /**
     * Fügt eine einzelne Transaktion einem bestehenden Konto hinzu.
     * Validiert die Transaktion, prüft auf Duplikate und setzt bei Payments die Zinsen.
     * Validiert den 'amount' bei Transfers.
     *
     * @param account     Das Konto, dem die Transaktion hinzugefügt wird.
     * @param transaction Die hinzuzufügende Transaktion.
     * @throws TransactionAlreadyExistException wenn die Transaktion bereits existiert.
     * @throws AccountDoesNotExistException     wenn das Konto nicht existiert.
     * @throws TransactionAttributeException    bei ungültigen Attributen (z.B. Amount <= 0 bei Transfer).
     */
    @Override
    public void addTransaction(String account, Transaction transaction) throws TransactionAlreadyExistException, AccountDoesNotExistException, TransactionAttributeException {
        if(!this.accountsToTransactions.containsKey(account)){ //ngecek isi mapny
            throw new AccountDoesNotExistException("Account: " + account + " ist nicht vorhanden.");
        }

        List<Transaction> listTA = this.accountsToTransactions.get(account); //ambil list transaksi yang nempel di akun itu

        if(listTA.contains(transaction)){ //trans check
            throw new TransactionAlreadyExistException("Transaction: " + transaction + " bereits vorhanden in " + account);
        }

//        Im Falle von Payments sollen die Attribute incomingInterest und outgoingInterest mit den Werten aus der PrivateBank überschrieben werden.
        //Bei der Überprüfung der Klassenattribute amount (Transfer-Objekte) und incomingInterest/outgoingInterest (Payment-Objekte) soll im Fehlerfall eine Exception des Types TransactionAttributeException geworfen werden.
        if(transaction instanceof Payment){
            Payment p = (Payment) transaction; //typecast, biar tipe datanya jadi payment supaya bisa pake methode2 dari payment
            p.setIncomingInterest(this.incomingInterest);
            p.setOutgoingInterest(this.outgoingInterest);
        }

        else if(transaction instanceof Transfer){
            Transfer t = (Transfer) transaction;
        }

        //wenn alles gut
        listTA.add(transaction);
    }

    /**
     * Entfernt eine Transaktion von einem Konto.
     *
     * @param account     Das Konto, von dem entfernt wird.
     * @param transaction Die zu entfernende Transaktion.
     * @throws AccountDoesNotExistException     wenn das Konto nicht existiert.
     * @throws TransactionDoesNotExistException wenn die Transaktion auf dem Konto nicht existiert.
     */
    @Override
    public void removeTransaction(String account, Transaction transaction) throws AccountDoesNotExistException, TransactionDoesNotExistException {

        if(!this.accountsToTransactions.containsKey(account)){ //cek ada akunnya ga
            throw new AccountDoesNotExistException("Account: " + account + " ist nicht vorhanden.");
        }

        List<Transaction> listTA = this.accountsToTransactions.get(account); //kalo aman baru ambil listnya

        if(!listTA.contains(transaction)){ //cek transaksinya ada di list itu ga
            throw new TransactionDoesNotExistException("Transaction: " + transaction + " ist nicht vorhanden");
        }

        listTA.remove(transaction); //hapus
    }

    /**
     * Prüft, ob eine Transaktion auf einem Konto existiert.
     *
     * @param account     Das zu prüfende Konto.
     * @param transaction Die gesuchte Transaktion.
     * @return true, wenn Konto und Transaktion existieren, sonst false.
     */
    @Override
    public boolean containsTransaction(String account, Transaction transaction) {
                                            //akun ada                                        //listnya ada transaksi itu       map = {"account":[t1,t2,t3]}
        return this.accountsToTransactions.containsKey(account) && this.accountsToTransactions.get(account).contains(transaction);
    }

    /**
     * Berechnet den aktuellen Kontostand für ein Konto.
     *
     * @param account Das Konto, dessen Saldo berechnet wird.
     * @return Der berechnete Kontostand (0.0 bei nicht existentem Konto).
     */
    @Override
    public double getAccountBalance(String account) {
        double total = 0;                                                                                               //nampung hasil itungan
        List<Transaction> listTA = this.accountsToTransactions.get(account);                                            //ambil list transaksi punya si acc dr map aTT
        if(listTA != null){                                                                                             //kalo akunnya gaada, .get(account) bakal balikin null
            for(Transaction everyT : listTA){

                if(everyT instanceof Transfer){                                                                         //apakah everyt tipenya transfer
                    Transfer t = (Transfer) everyT;                                                                     //typecast karena bakal pake equals

                    if(t.getSender().equals(account)){                                                                  //apakah si acc yg kirim duit
                        total -= t.calculate();
                    } else if(t.getRecipient().equals(account)){                                                        //apakah si acc yg terima duit
                        total += t.calculate();
                    }

                } else if (everyT instanceof Payment){
                    Payment p = (Payment) everyT;
                    total += p.calculate();
                }
            }
        }
        return total;
    }

    /**
     * Ruft alle Transaktionen für ein Konto ab.
     *
     * @param account Das ausgewählte Konto.
     * @return Eine Liste von Transaktionen. Gibt eine leere Liste zurück, wenn das Konto nicht existiert.
     */
    @Override
    public List<Transaction> getTransactions(String account) {
        List<Transaction> listTA = this.accountsToTransactions.get(account); //datanya kan disimpen disini, pake get buat ambil value yg nempel di key
        if(listTA == null){             //kalo akunnya gaada
            return new ArrayList<>(); //balikin list kosong
        } else {
            return listTA;
        }
    }

    /**
     * Ruft eine nach dem berechneten Betrag sortierte Liste von Transaktionen ab.
     *
     * @param account Das ausgewählte Konto.
     * @param asc     true für aufsteigende (ASC) Sortierung, false für absteigende (DESC).
     * @return Die sortierte Transaktionsliste.
     */
    @Override
    public List<Transaction> getTransactionsSorted(String account, boolean asc) {
        List<Transaction> listSorted = this.getTransactions(account); //butuh listnya
        if(asc == true){
            listSorted.sort(Comparator.comparingDouble(Transaction::calculate)); //compare the trans
        } else if (asc == false) {
            listSorted.sort(Comparator.comparingDouble(Transaction::calculate).reversed());
        }
        return listSorted;
    }

    /**
     * Ruft eine gefilterte Liste von Transaktionen ab (entweder nur positive oder nur negative Beträge).
     *
     * @param account  Das ausgewählte Konto.
     * @param positive true, um nur Transaktionen mit positivem Betrag (> 0) zu erhalten,
     * false, um nur Transaktionen mit negativem Betrag (< 0) zu erhalten.
     * @return Die gefilterte Transaktionsliste.
     */
    @Override
    public List<Transaction> getTransactionsByType(String account, boolean positive) {
        List<Transaction> allT = this.getTransactions(account);
        List<Transaction> filteredList = new ArrayList<>(); //buat nampung hasil
        for(Transaction t : allT){                              //kunjungin transaksi satu satu
            double amount = t.calculate();
            if(positive == true){
                if(amount > 0){
                    filteredList.add(t);
                }
            } else if(positive == false){
                if(amount < 0){
                    filteredList.add(t);
                }
            }
        }
        return filteredList;
    }
}

