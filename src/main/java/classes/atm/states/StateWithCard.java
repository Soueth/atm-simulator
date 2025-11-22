package classes.atm.states;

import classes.atm.ATM;
import classes.notes.NoteFactory;
import exceptions.InsuficientBalanceException;
import exceptions.InvalidValueException;
import exceptions.WrongPINEjectCardException;
import interfaces.ATMState;

public class StateWithCard implements ATMState {

    private ATM atm;
    private int tentativas = 0;
    private final int MAX_TENTATIVAS = 3;

    public StateWithCard(ATM atm) {
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
        tentativas = 0;
    }

    @Override
    public void insertPIN(String pin) throws WrongPINEjectCardException {
        if (atm.validatePIN(pin)) {
            System.out.println("PIN correto. Escolha uma operação.");
            atm.setActualState(atm.getStateAuthenticated());
            tentativas = 0;
        } else {
            tentativas++;
            if (tentativas < MAX_TENTATIVAS) {
                System.out.println("PIN incorreto. Tentativa " + tentativas + "/" + MAX_TENTATIVAS);
                return;
            }
            atm.setActualState(atm.getStateNoCard());
            throw new WrongPINEjectCardException();
        }
    }

    @Override
    public void requestWithdraw(int valor) throws InvalidValueException, InsuficientBalanceException {
        if (NoteFactory.atmEmpty()) {
            atm.setActualState(atm.getStateNoMoney());
            atm.requestWithdraw(valor);
            return;
        }
        
        System.out.println("Digite o PIN antes de solicitar saque.");
    }

    @Override
    public String getStateName() {
        return "COM CARTÃO";
    }
}
