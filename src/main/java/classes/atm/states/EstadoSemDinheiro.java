package classes.atm.states;

import classes.atm.ATM;
import interfaces.ATMState;

public class EstadoSemDinheiro implements ATMState {

    private ATM atm;

    public EstadoSemDinheiro(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void inserirCartao() {
        System.out.println("ATM sem dinheiro. Operações indisponíveis.");
    }

    @Override
    public void ejetarCartao() {
        System.out.println("Nenhum cartão inserido.");
    }

    @Override
    public void inserirPIN(String pin) {
        System.out.println("ATM sem dinheiro. Operações indisponíveis.");
    }

    @Override
    public void solicitarSaque(int valor) {
        System.out.println("ATM sem dinheiro. Operações indisponíveis.");
    }
}
