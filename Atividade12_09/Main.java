public class Main {
    public static void main(String[] args) {
        AccountManager contas = AccountManager.getInstance();
        //System.out.println(novaConta.getConta() + " " + novaConta.getSaldo());

        Cliente teobaldo = new Cliente("TeeAcc", "Teobaldo");
        Cliente tobias = new Cliente("TobiAcc", "Tobias");
        teobaldo.depositar(10);
        tobias.depositar(50);

        System.out.println(teobaldo.getSaldo()); 
        System.out.println(tobias.getSaldo()); 
        tobias.depositar(50);
        System.out.println(tobias.getSaldo()); 

        contas.listarContas();
    }
}
