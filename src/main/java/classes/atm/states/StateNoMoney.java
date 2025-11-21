package classes.atm.states;

import classes.atm.ATM;
import interfaces.ATMState;

public class StateNoMoney implements ATMState {

    private ATM atm;

    public StateNoMoney(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("ATM sem dinheiro. Operações indisponíveis.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Nenhum cartão inserido.");
    }

    @Override
    public void insertPIN(String pin) {
        System.out.println("ATM sem dinheiro. Operações indisponíveis.");
    }

    @Override
    public void requestWithdraw(int valor) {
        System.out.println("ATM sem dinheiro. Operações indisponíveis.");
    }
}
