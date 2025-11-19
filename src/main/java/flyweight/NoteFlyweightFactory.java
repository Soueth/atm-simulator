package flyweight;

import java.util.Map;
import enums.NoteValue;
import java.util.EnumMap;

public class NoteFlyweightFactory {

    private static final Map<NoteValue, ConcreteNote> flyweights = new EnumMap<>(NoteValue.class);

    static {
        // Pré-carrega todas as notas
        for (NoteValue v : NoteValue.values()) {
            flyweights.put(v, new ConcreteNote(v));
        }
    }

    public static ConcreteNote get(NoteValue value) {
        ConcreteNote n = flyweights.get(value);

        if (n == null) {
            throw new IllegalArgumentException("Unsupported note value: " + value);
        }
        return n;
    }
}
