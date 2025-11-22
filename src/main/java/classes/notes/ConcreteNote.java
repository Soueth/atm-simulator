package classes.notes;

import enums.NoteValue;
import exceptions.DepositLessZeroException;
import exceptions.RemoveMoreHaveException;
import exceptions.RemoveLessZeroException;
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
            throw new DepositLessZeroException(qtd, value);
        }
        this.qtd += qtd;
    }

    @Override
    public void remove(int qtd) throws RemoveMoreHaveException, RemoveLessZeroException {
        if (qtd <= 0) throw new RemoveLessZeroException(this.value);
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
