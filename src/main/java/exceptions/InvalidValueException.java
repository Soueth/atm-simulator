package exceptions;

public class InvalidValueException extends Exception {
    public InvalidValueException(int value) {
        super("Valor inválido para saque: " + value + ".");
    }
}
