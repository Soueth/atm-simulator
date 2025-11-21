package interfaces;

public interface ATMState {
    void insertCard();
    void ejectCard();
    void insertPIN(String pin);
    void requestWithdraw(int valor);
}
