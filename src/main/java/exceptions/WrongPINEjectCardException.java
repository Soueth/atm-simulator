package exceptions;

public class WrongPINEjectCardException extends Exception {
    public WrongPINEjectCardException() {
        super("PIN incorreto. Máximo de tentativas atingido. Cartão ejetado.");
    }
}
