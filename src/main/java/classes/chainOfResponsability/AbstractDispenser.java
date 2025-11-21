package classes.chainOfResponsability;

import classes.notes.ConcreteNote;
import classes.notes.NoteFactory;
import enums.NoteValue;
import exceptions.CantDispense;
import interfaces.IDispenser;

public abstract class AbstractDispenser implements IDispenser {

    protected IDispenser next;
    protected final NoteValue noteValue;

    public AbstractDispenser(NoteValue noteValue) {
        this.noteValue = noteValue;
    }

    @Override
    public void setNext(IDispenser next) {
        this.next = next;
    }

    @Override
    public void dispense(int amount) {
        ConcreteNote note = NoteFactory.get(noteValue);

        int available = note.getQtd(); // estoque disponível
        int needed = amount / noteValue.getValue();  // máximo possível dessa nota

        int toWithdraw = Math.min(available, needed);

        if (toWithdraw > 0) {
            try {
                note.remove(toWithdraw);
                amount -= toWithdraw * noteValue.getValue();
    
                System.out.println(
                    "Dispensando " + toWithdraw + " nota(s) de R$" + noteValue.getValue()
                );
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Se ainda faltou algum valor, passa para o próximo da cadeia
        if (amount > 0 && next != null) {
            try {
                next.dispense(amount);
            } catch (CantDispense e) {
                System.out.println(e.getMessage());
            }
        } else if (amount > 0) {
            System.out.println("Não foi possível completar o valor com notas. Faltam R$" + amount);
        }
    }
}
