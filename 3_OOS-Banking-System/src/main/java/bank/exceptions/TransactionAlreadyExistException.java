//exceptions bei einigen methoden implementieren, alle exc sollen im java pack b.e abgelegt werden

package bank.exceptions;

public class TransactionAlreadyExistException extends Exception{
    public TransactionAlreadyExistException(String str){
        super(str);
    }
}
