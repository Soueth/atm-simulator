package atm.state;

import atm.ATM;

public class EstadoComCartao implements ATMState {

    private ATM atm;
    private int tentativas = 0;
    private final int MAX_TENTATIVAS = 3;

    public EstadoComCartao(ATM atm) {
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
        tentativas = 0;
    }

    @Override
    public void inserirPIN(String pin) {
        if (atm.validarPIN(pin)) {
            System.out.println("PIN correto. Escolha uma operação.");
            atm.setEstadoAtual(atm.getEstadoAutenticado());
            tentativas = 0;
        } else {
            tentativas++;
            System.out.println("PIN incorreto. Tentativa " + tentativas + "/" + MAX_TENTATIVAS);
            if (tentativas >= MAX_TENTATIVAS) {
                System.out.println("Máximo de tentativas atingido. Cartão ejetado.");
                atm.setEstadoAtual(atm.getEstadoSemCartao());
            }
        }
    }

    @Override
    public void solicitarSaque(int valor) {
        System.out.println("Digite o PIN antes de solicitar saque.");
    }
}
