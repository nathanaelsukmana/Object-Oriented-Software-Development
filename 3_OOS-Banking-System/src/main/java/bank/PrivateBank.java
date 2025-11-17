package bank;

import java.util.*; //*: include all

import bank.exceptions.*;

//am anfang error, denn es gibt noch keine methode von bank implementiert wird
/**
 * Implementiert das BankInterface zur Verwaltung von Konten und Transaktionen.
 * Diese Klasse speichert Konten und die zugehörigen Transaktionen in einer Map.
 *
 * @author Nathanael Lumen Sukmana
 */
public class PrivateBank implements Bank{                       //interface pake implements bukan extends

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
     */                                                                    //kelas konkret di java yang implementasi interface map, hm simpen key(nama akun) dan value (daftar transaksi)
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
     * @return der aktuelle Incoming Interest (0-1).
     */
    public double getIncomingInterest(){
        return this.incomingInterest;
    }

    /**
     * Ruft den Outgoing Interest der Bank ab.
     * @return der aktuelle Outgoing Interest (0-1).
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
     * @param incomingInterest der neue Incoming Interest (0-1).
     */
    public void setIncomingInterest(double incomingInterest){
        this.incomingInterest = incomingInterest;
    }

    /**
     * Setzt den Outgoing Interest der Bank.
     * @param outgoingInterest der neue Outgoing Interest (0-1).
     */
    public void setOutgoingInterest(double outgoingInterest){
        this.outgoingInterest = outgoingInterest;
    }

    //4 konst fuer die ersten drei att
    /**
     * Konstruktor zur Erstellung einer neuen PrivateBank mit spezifischen Zinsen.
     *
     * @param name             Name der Bank.
     * @param incomingInterest Incoming Interest (0-1).
     * @param outgoingInterest Outgoing Interest (0-1).
     */
    public PrivateBank(String name, double incomingInterest, double outgoingInterest){
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
    public PrivateBank(PrivateBank original){
        //nur 3 att
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
        PrivateBank other = (PrivateBank) obj; //casting si obj
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
    public void createAccount(String account) throws AccountAlreadyExistsException {                //nambahin akun baru ke dalam map
        if(this.accountsToTransactions.containsKey(account)) {                                      //apakah acc udah ada di map aTT
            throw new AccountAlreadyExistsException("Account: " + account + " ist vorhanden.");     //kalo true methodnya berhenti smp sini
        }
            this.accountsToTransactions.put(account, new ArrayList<>());                            //put akun baru ke map || key (acc) dgn valuenya satu list kosong baru -> { "accname":[], "accname2":[]}
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
    public void addTransaction(String account, Transaction transaction) throws TransactionAlreadyExistException,        //nambahin 1 transaksi ke 1 akun yg sudah ada, tp sblm nambahin dia validasi dulu
            AccountDoesNotExistException, TransactionAttributeException {
        if(!this.accountsToTransactions.containsKey(account)){                                                          //ngecek akun ada atau ga di map
            throw new AccountDoesNotExistException("Account: " + account + " ist nicht vorhanden.");
        }

        List<Transaction> listTA = this.accountsToTransactions.get(account);                                            //kalo akunnya ada, ambil list transaksi yang nempel di akun itu

        if(listTA.contains(transaction)){                                                                               //cek T kyk gini udh ada di list blm, contains -> equals() bisa kyk gini krn java yg nentuin pake yg mana (magic polymorph)
            throw new TransactionAlreadyExistException("Transaction: " + transaction + " bereits vorhanden in " + account);
        }

//        Im Falle von Payments sollen die Attribute incomingInterest und outgoingInterest mit den Werten aus der PrivateBank überschrieben werden.
        if(transaction instanceof Payment){
            Payment p = (Payment) transaction;                                                                          //typecast, biar tipe datanya jadi payment supaya bisa pake methode2 dari payment
            p.setIncomingInterest(this.incomingInterest);
            p.setOutgoingInterest(this.outgoingInterest);
        }

        else if(transaction instanceof Transfer){
            Transfer t = (Transfer) transaction;
        }

        listTA.add(transaction);                                                                                        //wenn alles gut
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
    public void removeTransaction(String account, Transaction transaction) throws AccountDoesNotExistException,         //ngehapus satu transaksi spesifik dari satu akun
            TransactionDoesNotExistException {

        if(!this.accountsToTransactions.containsKey(account)){                                                          //cek ada akunnya ga di map
            throw new AccountDoesNotExistException("Account: " + account + " ist nicht vorhanden.");
        }

        List<Transaction> listTA = this.accountsToTransactions.get(account);                                            //kalo akunnya ada, ambil list transaksi acc itu

       if(!listTA.contains(transaction)){                                                                               //cari transaksi yg mau dihapus dlm list itu, kalo ga ketemu lempar
           throw new TransactionDoesNotExistException("Transaction: " + transaction + " ist nicht vorhanden");
       } listTA.remove(transaction);                                                                                    //kalo ketemu, hapus
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
        return this.accountsToTransactions.containsKey(account) &&
                this.accountsToTransactions.get(account).contains(transaction);                                         //cek nama acc dan cek transaksi di list acc itu
    }

    /**
     * Berechnet den aktuellen Kontostand für ein Konto.
     *
     * @param account Das Konto, dessen Saldo berechnet wird.
     * @return Der berechnete Kontostand (0.0 bei nicht existentem Konto).
     */
    @Override
    public double getAccountBalance(String account) {                                                                   //ngambil list transaksi punya si acc dr map
        double total = 0;

        List<Transaction> listT = this.accountsToTransactions.get(account);                                             //1 payment, calculatenya return -5, 1 incomingtransfer calculate 500
        if(listT != null){
            for(Transaction everyT : listT){                                                                            //kunjungi setiap transaksi di list itu
                total += everyT.calculate();                                                                            //loop ngitung total = 0 - 5 + 500
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
        List<Transaction> listTA = this.accountsToTransactions.get(account);                                            //datanya kan disimpen disini, pake get buat ambil value yg nempel di key
        if(listTA == null){                                                                                             //kalo akunnya gaada
            return new ArrayList<>();                                                                                   //balikin list kosong
        } else {
            return listTA;                                                                                              //balikin list transaksi si acc itu
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
        List<Transaction> listSorted = this.getTransactions(account);                                                   //500,-5,100
        if(asc == true){
            listSorted.sort(Comparator.comparingDouble(Transaction::calculate));                                        //metode bawaan dari java buat ngurutin list, method reference -> ksh tau comparator buat ngebandingin 2 transaksi, tinggal panggil method calculate punya mereka berdua, terus hasil calculatenya diurutin secara double
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
        List<Transaction> allT = this.getTransactions(account);                                                         //pake methode gT untuk ambil semua data transaksi punya si acc
        List<Transaction> filteredList = new ArrayList<>();                                                             //buat nampung hasil

        for(Transaction t : allT){                                                                                      //kunjungin transaksi satu satu
           double amount = t.calculate();

           if(positive == true){
               if(amount > 0){                                                                                          //cek lagi, beneran + ga
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
