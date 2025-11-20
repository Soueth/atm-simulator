package atm.state;

import atm.ATM;
import chainOfResponsability.DispenserChainBuilder;
import exceptions.CantDispense;
import interfaces.IDispenser;
import note.NoteFactory;

public class EstadoAutenticado implements ATMState {

    private ATM atm;

    public EstadoAutenticado(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void inserirCartao() {
        System.out.println("Já existe um cartão inserido.");
    }

    @Override
    public void ejetarCartao() {
        System.out.println("Retire seu cartão.");
        atm.setEstadoAtual(atm.getEstadoSemCartao());
    }

    @Override
    public void inserirPIN(String pin) {
        System.out.println("Você já está autenticado.");
    }

    @Override
    public void solicitarSaque(int valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        if (valor > atm.getSaldoConta()) {
            System.out.println("Saldo insuficiente. Saldo disponível: R$" + atm.getSaldoConta());
            return;
        }

        if (NoteFactory.atmEmpty()) {
            System.out.println("ATM sem dinheiro. Operações indisponíveis.");
            atm.setEstadoAtual(atm.getEstadoSemDinheiro());
            return;
        }
        // Aqui o colega do Chain vai implementar a lógica depois
        // System.out.println("Solicitação de saque recebida (pendente Chain of Responsibility).");
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
