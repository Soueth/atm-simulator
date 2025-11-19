package atm.state;

import atm.ATM;

public class EstadoSemCartao implements ATMState {

    private ATM atm;

    public EstadoSemCartao(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void inserirCartao() {
        System.out.println("Cartão inserido. Por favor, digite seu PIN.");
        atm.setEstadoAtual(atm.getEstadoComCartao());
    }

    @Override
    public void ejetarCartao() {
        System.out.println("Nenhum cartão inserido.");
    }

    @Override
    public void inserirPIN(String pin) {
        System.out.println("Insira um cartão primeiro.");
    }

    @Override
    public void solicitarSaque(int valor) {
        System.out.println("Insira um cartão primeiro.");
    }
}
