package Atividades29_08.PagamentosMultiplataforma;

public class factoryPayPal extends pagamentoFactory {
    private String email;

    public factoryPayPal(String email) {
        this.email = email;
    }

    @Override
    public iPagamento criarPagamento() {
        return new pagamentoPayPal(email);
    }

}
