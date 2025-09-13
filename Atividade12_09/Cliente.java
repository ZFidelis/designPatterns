public class Cliente {
    public String idCliente;
    public String nome;

    public Cliente(String idCliente, String nome) {
        this.idCliente = idCliente;
        this.nome = nome;

        AccountManager.getInstance().novaConta(idCliente, 0);;
    }

    public void depositar(double valor) {
        AccountManager.getInstance().depositar(idCliente, valor);
    }

    public double getSaldo() {
        return AccountManager.getInstance().verSaldo(idCliente);
    }
}
