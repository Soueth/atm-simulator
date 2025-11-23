package classes.atm.states;

import classes.atm.ATM;
import classes.chainOfResponsability.HandlerChainBuilder;
import classes.notes.NoteFactory;
import exceptions.InsuficientBalanceException;
import exceptions.InvalidValueException;
import interfaces.ATMState;
import interfaces.IHandler;

public class StateAuthenticated implements ATMState {

    private ATM atm;

    public StateAuthenticated(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Já existe um cartão inserido.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Retire seu cartão.");
        atm.setActualState(atm.getStateNoCard());
    }

    @Override
    public void insertPIN(String pin) {
        System.out.println("Você já está autenticado.");
    }

    @Override
    public void requestWithdraw(int valor) throws InvalidValueException, InsuficientBalanceException {
        if (valor <= 0) {
            throw new InvalidValueException(valor);
        }

        if (valor > atm.getAccountBalance()) {
            throw new InsuficientBalanceException(atm.getAccountBalance());
        }

        if (NoteFactory.atmEmpty()) {
            atm.setActualState(atm.getStateNoMoney());
            atm.requestWithdraw(valor);
            return;
        }
        IHandler handler = HandlerChainBuilder.build();

        System.out.println("Solicitando: R$" + valor);
        int dispensed = handler.dispense(valor);

        atm.debitAccount(dispensed);
        System.out.println("Saldo atualizado: R$" + atm.getAccountBalance());
    }

    @Override
    public String getStateName() {
        return "AUTENTICADO";
    }
}
