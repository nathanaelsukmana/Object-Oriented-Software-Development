//exceptions bei einigen methoden implementieren, alle exc sollen im java pack b.e abgelegt werden

package bank.exceptions;

public class TransactionAttributeException extends Exception{
    public TransactionAttributeException(String str){
        super(str);
    }
}
