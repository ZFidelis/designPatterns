package Atividades29_08.PagamentosMultiplataforma;

public class pagamentoCriptomoeda implements iPagamento {

    public double saldo;

    public pagamentoCriptomoeda(double saldo) {
        this.saldo = saldo;
    }

    private boolean saldoSuficiente(double valor) {
        if (saldo >= valor) {
            return true;
        }

        return false;
    }

    @Override
    public String processarPagamento(double valorTransacao) {
        if (saldoSuficiente(valorTransacao)) {
            saldo -= valorTransacao;
            return "Pagamento Aprovado";
        }

        return "Saldo insuficiente na carteira";
    }
    
}
