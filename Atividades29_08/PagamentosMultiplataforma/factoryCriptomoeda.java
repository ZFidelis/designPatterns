package Atividades29_08.PagamentosMultiplataforma;

public class factoryCriptomoeda extends pagamentoFactory {
    private double saldo;

    public factoryCriptomoeda(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public iPagamento criarPagamento() {
        return new pagamentoCriptomoeda(saldo);
    }

}
