package classes.atm.states;

import classes.atm.ATM;
import classes.notes.NoteFactory;
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
        atm.setEstadoAtual(atm.getStateNoCard());
        tentativas = 0;
    }

    @Override
    public void insertPIN(String pin) {
        if (atm.validarPIN(pin)) {
            System.out.println("PIN correto. Escolha uma operação.");
            atm.setEstadoAtual(atm.getStateAuthenticated());
            tentativas = 0;
        } else {
            tentativas++;
            System.out.println("PIN incorreto. Tentativa " + tentativas + "/" + MAX_TENTATIVAS);
            if (tentativas >= MAX_TENTATIVAS) {
                System.out.println("Máximo de tentativas atingido. Cartão ejetado.");
                atm.setEstadoAtual(atm.getStateNoCard());
            }
        }
    }

    @Override
    public void requestWithdraw(int valor) {
        if (NoteFactory.atmEmpty()) {
            atm.setEstadoAtual(atm.getStateNoMoney());
            atm.requestWithdraw(valor);
            return;
        }
        
        System.out.println("Digite o PIN antes de solicitar saque.");
    }
}
