package Atividades29_08.PagamentosMultiplataforma;

public class pagamentoService {
    public void processarPagamento(pagamentoFactory factory, double valorTransacao) {
        iPagamento pagamento = factory.criarPagamento();
        String resultado = pagamento.processarPagamento(valorTransacao);
        System.out.println(resultado);
    }
}
