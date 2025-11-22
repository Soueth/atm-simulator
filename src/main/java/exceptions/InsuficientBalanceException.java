package exceptions;

public class InsuficientBalanceException extends Exception {
    public InsuficientBalanceException(int value) {
        super("Saldo insuficiente. Saldo disponível: R$: " + value + ".");
    }
}
