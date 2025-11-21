package classes.notes;

import java.util.Map;
import enums.NoteValue;
import java.util.EnumMap;

public class NoteFactory {

    private static final Map<NoteValue, ConcreteNote> notes = new EnumMap<>(NoteValue.class);

    static {
        // Pré-carrega todas as notas
        for (NoteValue v : NoteValue.values()) {
            notes.put(v, new ConcreteNote(v));
        }
    }

    public static ConcreteNote get(NoteValue value) {
        ConcreteNote n = notes.get(value);

        if (n == null) {
            throw new IllegalArgumentException("Unsupported note value: " + value);
        }
        return n;
    }

    public static boolean atmEmpty() {
        boolean isEmpty = true;

        for (ConcreteNote n : notes.values()) {
            isEmpty = isEmpty && (n.getQtd() == 0);
        }

        return isEmpty;
    }
}
