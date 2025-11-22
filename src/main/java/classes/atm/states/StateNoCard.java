package classes.atm.states;

import classes.atm.ATM;
import classes.notes.NoteFactory;
import exceptions.InsuficientBalanceException;
import exceptions.InvalidValueException;
import interfaces.ATMState;

public class StateNoCard implements ATMState {

    private ATM atm;

    public StateNoCard(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Cartão inserido. Por favor, digite seu PIN.");
        atm.setActualState(atm.getStateWithCard());
    }

    @Override
    public void ejectCard() {
        System.out.println("Nenhum cartão inserido.");
    }

    @Override
    public void insertPIN(String pin) {
        System.out.println("Insira um cartão primeiro.");
    }

    @Override
    public void requestWithdraw(int valor) throws InvalidValueException, InsuficientBalanceException {
        if (NoteFactory.atmEmpty()) {
            atm.setActualState(atm.getStateNoMoney());
            atm.requestWithdraw(valor);
            return;
        }

        System.out.println("Insira um cartão primeiro.");
    }

    @Override
    public String getStateName() {
        return "SEM CARTÃO";
    }
}
