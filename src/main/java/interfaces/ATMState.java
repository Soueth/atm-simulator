package interfaces;

import exceptions.InsuficientBalanceException;
import exceptions.InvalidValueException;
import exceptions.WrongPINEjectCardException;

public interface ATMState {
    void insertCard();
    void ejectCard();
    void insertPIN(String pin) throws WrongPINEjectCardException;
    void requestWithdraw(int valor) throws InvalidValueException, InsuficientBalanceException;
    String getStateName();
}
