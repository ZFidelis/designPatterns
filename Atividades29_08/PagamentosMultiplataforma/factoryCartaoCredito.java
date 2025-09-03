package Atividades29_08.PagamentosMultiplataforma;

public class factoryCartaoCredito extends pagamentoFactory {
    private String numeroCartao;

    public factoryCartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public iPagamento criarPagamento() {
        return new pagamentoCartaoCredito(numeroCartao);
    }

}
