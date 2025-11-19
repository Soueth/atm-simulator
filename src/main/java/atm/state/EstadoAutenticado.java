package atm.state;

import atm.ATM;

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

        // Aqui o colega do Chain vai implementar a lógica depois
        System.out.println("Solicitação de saque recebida (pendente Chain of Responsibility).");

        atm.debitarConta(valor);
        System.out.println("Saldo atualizado: R$" + atm.getSaldoConta());
    }
}
