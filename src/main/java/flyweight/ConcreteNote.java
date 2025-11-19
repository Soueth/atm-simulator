package flyweight;

// import java.util.UUID;

import enums.NoteValue;
import exceptions.DepositLessZeroException;
import exceptions.RemoveMoreHaveException;
import exceptions.RemoveLeseZeroException;
import interfaces.NoteFlyweight;

public class ConcreteNote implements NoteFlyweight {

    private final NoteValue value;
    private int amount;

    public ConcreteNote(NoteValue value) {
        this.value = value;
        this.amount = 0;
    }

    public NoteValue getValueType() {
        return value;
    }

    public int getValue() {
        return value.getValue();
    }

    @Override
    public void deposit(int amount) throws DepositLessZeroException {
        if (amount <= 0) {
            throw new DepositLessZeroException(value);
        }
        this.amount += amount;
    }

    @Override
    public void remove(int amount) throws RemoveMoreHaveException, RemoveLeseZeroException {
        if (amount <= 0) throw new RemoveLeseZeroException(this.value);
        if (this.amount < amount) throw new RemoveMoreHaveException(this.value, amount);

        this.amount -= amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Nota de " + value + " - " + amount + " unidades";
    }
}
