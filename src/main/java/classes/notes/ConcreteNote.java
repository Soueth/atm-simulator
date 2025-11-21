package classes.notes;

// import java.util.UUID;

import enums.NoteValue;
import exceptions.DepositLessZeroException;
import exceptions.RemoveMoreHaveException;
import exceptions.RemoveLeseZeroException;
import interfaces.INote;

public class ConcreteNote implements INote {

    private final NoteValue value;
    private int qtd;

    public ConcreteNote(NoteValue value) {
        this.value = value;
        this.qtd = 0;
    }

    public NoteValue getValueType() {
        return value;
    }

    public int getValue() {
        return value.getValue();
    }

    @Override
    public void deposit(int qtd) throws DepositLessZeroException {
        if (qtd <= 0) {
            throw new DepositLessZeroException(value);
        }
        this.qtd += qtd;
    }

    @Override
    public void remove(int qtd) throws RemoveMoreHaveException, RemoveLeseZeroException {
        if (qtd <= 0) throw new RemoveLeseZeroException(this.value);
        if (this.qtd < qtd) throw new RemoveMoreHaveException(this.value, qtd);

        this.qtd -= qtd;
    }

    @Override
    public int getQtd() {
        return qtd;
    }

    @Override
    public String toString() {
        return "Nota de " + value + " - " + qtd + " unidades";
    }
}
