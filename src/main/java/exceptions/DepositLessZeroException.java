package exceptions;

import enums.NoteValue;

public class DepositLessZeroException extends Exception {
    public DepositLessZeroException(NoteValue note) {
        super("Não é possível depositar 0 ou menos nodas de " + note.getValue() + ".");
    }
}
