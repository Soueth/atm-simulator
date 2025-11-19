package exceptions;

import enums.NoteValue;

public class RemoveLeseZeroException extends Exception {
    public RemoveLeseZeroException(NoteValue note) {
        super("Não é possível retirar 0 ou menos notas de" + note.getValue() + ".");
    }
}
