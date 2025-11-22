package classes.atm;

import classes.atm.states.*;
import exceptions.InsuficientBalanceException;
import exceptions.InvalidValueException;
import exceptions.WrongPINEjectCardException;
import interfaces.ATMState;

public class ATM {

    private ATMState stateNoCard;
    private ATMState stateWithCard;
    private ATMState stateAuthenticated;
    private ATMState stateNoMoney;

    private ATMState actualState;

    private double accountBalance = 2000;
    private final String PIN_CORRETO = "1234";

    public ATM() {
        stateNoCard = new StateNoCard(this);
        stateWithCard = new StateWithCard(this);
        stateAuthenticated = new StateAuthenticated(this);
        stateNoMoney = new StateNoMoney(this);

        actualState = stateNoCard;
    }

    // getters dos estados
    public ATMState getStateNoCard() {
        return stateNoCard;
    }

    public ATMState getStateWithCard() {
        return stateWithCard;
    }

    public ATMState getStateAuthenticated() {
        return stateAuthenticated;
    }

    public ATMState getStateNoMoney() {
        return stateNoMoney;
    }

    public ATMState getActualState() {
        return actualState;
    }

    public void setActualState(ATMState estado) {
        this.actualState = estado;
    }

    // Métodos delegados
    public void insertCard() {
        actualState.insertCard();
    }

    public void ejectCard() {
        actualState.ejectCard();
    }

    public void insertPIN(String pin) throws WrongPINEjectCardException {
        actualState.insertPIN(pin);
    }

    public void requestWithdraw(int valor) throws InvalidValueException, InsuficientBalanceException {
        actualState.requestWithdraw(valor);
    }

    // Funções auxiliares
    public boolean validatePIN(String pin) {
        return PIN_CORRETO.equals(pin);
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void debitAccount(int valor) {
        accountBalance -= valor;
    }

    public String getStateName() {
        return actualState.getStateName();
    }
}
