package exceptions;

import enums.NoteValue;

public class RemoveMoreHaveException extends Exception {
    public RemoveMoreHaveException(NoteValue note, int amount) {
        super("Não há notas de " + note.getValue() + " o suficiente para retirar " + amount + " notas.");
    }
}
