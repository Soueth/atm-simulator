package classes.notes;

import java.util.Map;
import enums.NoteValue;
import exceptions.DepositLessZeroException;
import exceptions.RemoveLessZeroException;
import exceptions.RemoveMoreHaveException;

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


    // Ħ ---------------- Métodos para teste através do menu interativo ---------------- Ħ
    public static void resetSimulation() throws DepositLessZeroException, RemoveMoreHaveException, RemoveLessZeroException {
        // zera todas as notas primeiro
        for (ConcreteNote n : notes.values()) {
            int q = n.getQtd();
            if (q > 0) {
                n.remove(q);
            }
        }

        // deposita valores de exemplo
        notes.get(NoteValue.TWO_HUNDRED).deposit(3);
        notes.get(NoteValue.ONE_HUNDRED).deposit(5);
        notes.get(NoteValue.FIFTY).deposit(8);
        notes.get(NoteValue.TWENTY).deposit(12);
        notes.get(NoteValue.TEN).deposit(15);
        notes.get(NoteValue.FIVE).deposit(4);
        notes.get(NoteValue.TWO).deposit(30);
        notes.get(NoteValue.ONE).deposit(2);
    }

    public static String notesStatus() {
        StringBuilder sb = new StringBuilder();
        for (NoteValue v : NoteValue.values()) {
            ConcreteNote n = notes.get(v);
            sb.append("R$ " + n.getValue() + " - " + n.getQtd() + " notas\n");
        }
        return sb.toString();
    }
}
