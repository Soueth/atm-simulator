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

    private ATMState estadoAtual;

    private int saldoConta = 2000;
    private final String PIN_CORRETO = "1234";

    public ATM() {
        stateNoCard = new StateNoCard(this);
        stateWithCard = new StateWithCard(this);
        stateAuthenticated = new StateAuthenticated(this);
        stateNoMoney = new StateNoMoney(this);

        estadoAtual = stateNoCard;
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

    public ATMState getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(ATMState estado) {
        this.estadoAtual = estado;
    }

    // Métodos delegados
    public void insertCard() {
        estadoAtual.insertCard();
    }

    public void ejectCard() {
        estadoAtual.ejectCard();
    }

    public void insertPIN(String pin) throws WrongPINEjectCardException {
        estadoAtual.insertPIN(pin);
    }

    public void requestWithdraw(int valor) throws InvalidValueException, InsuficientBalanceException {
        estadoAtual.requestWithdraw(valor);
    }

    // Funções auxiliares
    public boolean validarPIN(String pin) {
        return PIN_CORRETO.equals(pin);
    }

    public int getSaldoConta() {
        return saldoConta;
    }

    public void debitarConta(int valor) {
        saldoConta -= valor;
    }
}
