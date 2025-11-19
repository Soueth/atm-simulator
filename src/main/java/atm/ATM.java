package atm;

import atm.state.*;

public class ATM {

    private ATMState estadoSemCartao;
    private ATMState estadoComCartao;
    private ATMState estadoAutenticado;
    private ATMState estadoSemDinheiro;

    private ATMState estadoAtual;

    private int saldoConta = 2000;
    private final String PIN_CORRETO = "1234";

    public ATM() {
        estadoSemCartao = new EstadoSemCartao(this);
        estadoComCartao = new EstadoComCartao(this);
        estadoAutenticado = new EstadoAutenticado(this);
        estadoSemDinheiro = new EstadoSemDinheiro(this);

        estadoAtual = estadoSemCartao;
    }

    // getters dos estados
    public ATMState getEstadoSemCartao() { return estadoSemCartao; }
    public ATMState getEstadoComCartao() { return estadoComCartao; }
    public ATMState getEstadoAutenticado() { return estadoAutenticado; }
    public ATMState getEstadoSemDinheiro() { return estadoSemDinheiro; }

    public ATMState getEstadoAtual() { return estadoAtual; }
    public void setEstadoAtual(ATMState estado) { this.estadoAtual = estado; }

    // Métodos delegados
    public void inserirCartao() { estadoAtual.inserirCartao(); }
    public void ejetarCartao() { estadoAtual.ejetarCartao(); }
    public void inserirPIN(String pin) { estadoAtual.inserirPIN(pin); }
    public void solicitarSaque(int valor) { estadoAtual.solicitarSaque(valor); }

    // Funções auxiliares
    public boolean validarPIN(String pin) {
        return PIN_CORRETO.equals(pin);
    }

    public int getSaldoConta() {
        return saldoConta;
    }

    public void debitarConta(int valor) {
        saldoConta -= valor;
    }
}
