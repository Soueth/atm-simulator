package exceptions;

import enums.NoteValue;

public class DepositLessZeroException extends Exception {
    public DepositLessZeroException(int value, NoteValue note) {
        super("Não foi possível depositar " + value + " notas de" + note.getValue() + " reais. São aceitas apenas quantidades maiores do que 0.");
    }
}
