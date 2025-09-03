package Atividades29_08.PagamentosMultiplataforma;

import java.util.ArrayList;

public class pagamentoPayPal implements iPagamento {

    private String email;

    public pagamentoPayPal(String email) {
        this.email = email;
    }

    public ArrayList<String> getEmail() {

        ArrayList<String> listaEmails = new ArrayList<>();

        listaEmails.add("dummy@mail.com");
        listaEmails.add("dummy@gmail.com");
        listaEmails.add("dummy@hotmail.com");

        return listaEmails;
    }

    public boolean validarConta() {
        ArrayList<String> listaEmails = getEmail();

        if (listaEmails.contains(email)) {
            return true;
        }

        return false;
    }

    @Override
    public String processarPagamento(double valorTransacao) {
        if (validarConta()) {
            return "Pagamento Aprovado";
        }
        return "Email invalido";
    }
}
