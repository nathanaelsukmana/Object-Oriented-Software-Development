//exceptions bei einigen methoden implementieren, alle exc sollen im java pack b.e abgelegt werden

package bank.exceptions;

public class TransactionDoesNotExistException extends Exception{
    public TransactionDoesNotExistException(String str){
        super(str);
    }
}
