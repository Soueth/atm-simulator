package exceptions;

public class CantDispense extends Exception {
    public CantDispense() {
        super("Não foi possível emitir as notas.");
    }
}
