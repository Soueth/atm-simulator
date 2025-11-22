package classes.chainOfResponsability;

import classes.notes.ConcreteNote;
import classes.notes.NoteFactory;
import enums.NoteValue;
import interfaces.IHandler;

public abstract class AbstractHandler implements IHandler {

    protected IHandler next;
    protected final NoteValue noteValue;

    public AbstractHandler(NoteValue noteValue) {
        this.noteValue = noteValue;
    }

    @Override
    public void setNext(IHandler next) {
        this.next = next;
    }

    @Override
    public int dispense(int amount) {
        ConcreteNote note = NoteFactory.get(noteValue);

        int available = note.getQtd(); // estoque disponível
        int needed = amount / noteValue.getValue();  // máximo possível dessa nota

        int toWithdraw = Math.min(available, needed); // escolhe o disponível

        int dispensed = 0;

        if (toWithdraw > 0) {
            try {
                note.remove(toWithdraw);
                int toDispense = toWithdraw * noteValue.getValue();
                amount -= toDispense;
    
                System.out.println(
                    "Dispensando " + toWithdraw + " nota(s) de R$" + noteValue.getValue()
                );
                dispensed += toDispense;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Se ainda faltou algum valor, passa para o próximo da cadeia
        if (amount > 0 && next != null) {
            dispensed += next.dispense(amount);
        } else if (amount > 0) {
            System.out.println("Não foi possível completar o valor com notas. Faltam R$" + amount);
        }
        return dispensed;
    }
}
