package atm.state;

public interface ATMState {
    void inserirCartao();
    void ejetarCartao();
    void inserirPIN(String pin);
    void solicitarSaque(int valor);
}
