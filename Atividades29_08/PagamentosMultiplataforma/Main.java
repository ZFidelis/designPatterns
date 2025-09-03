package Atividades29_08.PagamentosMultiplataforma;

public class Main {
    public static void main(String[] args) {
        pagamentoService service = new pagamentoService();

        // Simular pagamento por cartão de crédito
        service.processarPagamento(new factoryCartaoCredito("1234567812345678"), 150.00);

        // Simular pagamento por PayPal
        service.processarPagamento(new factoryPayPal("cliente@paypal.com"), 75.00);

        // Simular pagamento por Criptomoeda
        service.processarPagamento(new factoryCriptomoeda( 500.00), 300.00);
    }
}