package exceptions;

import enums.NoteValue;

public class RemoveLessZeroException extends Exception {
    public RemoveLessZeroException(NoteValue note) {
        super("Não é possível retirar 0 ou menos notas de" + note.getValue() + ".");
    }
}
