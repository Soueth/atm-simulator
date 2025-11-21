package classes.atm.states;

import classes.atm.ATM;
import classes.chainOfResponsability.DispenserChainBuilder;
import classes.notes.NoteFactory;
import exceptions.CantDispense;
import interfaces.ATMState;
import interfaces.IDispenser;

public class StateAuthenticated implements ATMState {

    private ATM atm;

    public StateAuthenticated(ATM atm) {
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
    }

    @Override
    public void insertPIN(String pin) {
        System.out.println("Você já está autenticado.");
    }

    @Override
    public void requestWithdraw(int valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        if (valor > atm.getSaldoConta()) {
            System.out.println("Saldo insuficiente. Saldo disponível: R$" + atm.getSaldoConta());
            return;
        }

        if (NoteFactory.atmEmpty()) {
            atm.setEstadoAtual(atm.getStateNoMoney());
            atm.requestWithdraw(valor);
            return;
        }
        IDispenser dispenser = DispenserChainBuilder.build();

        try {
            System.out.println("Solicitando: R$" + valor);
            dispenser.dispense(valor);
        } catch (CantDispense e) {
            System.out.println(e.getMessage());
        }

        atm.debitarConta(valor);
        System.out.println("Saldo atualizado: R$" + atm.getSaldoConta());
    }
}
