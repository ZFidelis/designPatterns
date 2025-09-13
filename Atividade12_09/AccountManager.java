import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static AccountManager instancia;

    private Map<String, Double> contas = new HashMap<>();

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        if(instancia == null) {
            instancia = new AccountManager();
        }
        return instancia;
    }

    public boolean novaConta(String idCliente, double saldo) {
        if(contas.containsKey(idCliente)) {
            System.out.println("Conta ja existe");
            return false;
        }
        contas.put(idCliente, saldo);
        return true;
    }

    public boolean depositar(String conta, double valor) {
        if (contas.containsKey(conta)) {
            double novoSaldo = valor + contas.get(conta);
            contas.put(conta, novoSaldo);
            return true;
        }
        return false;
    }

    public boolean sacar(String conta, double valor) {
        if (contas.containsKey(conta)) {
            double saldoAtual = contas.get(conta);
            if (saldoAtual < valor) {
                return false;
            }
            contas.put(conta, saldoAtual - valor);
            return true;
        }
        return false;
    }

    public double verSaldo(String conta) {
        if (contas.containsKey(conta)) {
            return contas.get(conta);
        }
        System.out.println("Conta não encontrada.");
        return 0.0;
    }

    public void listarContas() {
        System.out.println("\n--- Contas Ativas ---");
        for (Map.Entry<String, Double> entry : contas.entrySet()) {
            System.out.println("Conta: " + entry.getKey() + " | Saldo: R$ " + entry.getValue());
        }
    }
}
