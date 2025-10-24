public class PaidState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("Pedido já está pago.");
    }

    @Override
    public void send(Order order) {
        System.out.println("Pedido enviado para o cliente.");
        order.setState(new SentState());
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Não é possível entregar. Pedido ainda não foi enviado.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Pedido cancelado e pagamento reembolsado.");
        order.setState(new CanceledState());
    }
}