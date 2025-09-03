package Atividades29_08.PagamentosMultiplataforma;

public class pagamentoCartaoCredito implements iPagamento {
    private String numeroCartao;

    public pagamentoCartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    private boolean validarCartao() {
        if (numeroCartao.length() == 16) {
            return true;
        }

        return false;
    }

    @Override
    public String processarPagamento(double valorTransacao) {
        if (validarCartao()) {
            return "Pagamento Aprovado";
        }

        return "Numero do Cartao Invalido";
    }

}
