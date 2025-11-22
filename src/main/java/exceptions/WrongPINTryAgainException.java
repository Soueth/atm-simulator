package exceptions;

public class WrongPINTryAgainException extends Exception {
    public WrongPINTryAgainException(int tentativas, int MAX_TENTATIVAS) {
        super("PIN incorreto. Tentativa " + tentativas + "/" + MAX_TENTATIVAS + ".");
    }
}
