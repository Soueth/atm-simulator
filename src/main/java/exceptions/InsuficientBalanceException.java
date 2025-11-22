package exceptions;

public class InsuficientBalanceException extends Exception {
    public InsuficientBalanceException(double value) {
        super("Saldo insuficiente. Saldo disponível: R$: " + value + ".");
    }
}
