//exceptions bei einigen methoden implementieren, alle exc sollen im java pack b.e abgelegt werden

package bank.exceptions;

public class AccountDoesNotExistException extends Exception{
    public AccountDoesNotExistException(String str){
        super(str);
    }
}
