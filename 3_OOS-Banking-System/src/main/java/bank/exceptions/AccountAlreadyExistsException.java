//exceptions bei einigen methoden implementieren, alle exc sollen im java pack b.e abgelegt werden

package bank.exceptions;

public class AccountAlreadyExistsException extends Exception { //exc adl unterklasse dr throwable, exc: bewaeltigbar fehler, error: fatale fehler
    public AccountAlreadyExistsException(String str){
        super(str);                                                                 //mengarah ke str/m di parentclass exc
    }
}
