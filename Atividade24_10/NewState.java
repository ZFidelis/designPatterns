public class NewState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("Pagamento registrado com sucesso!");
        order.setState(new PaidState());
    }

    @Override
    public void send(Order order) {
        System.out.println("Não é possível enviar. Pedido ainda não foi pago.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Não é possível entregar. Pedido ainda não foi pago.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Pedido cancelado.");
        order.setState(new CanceledState());
    }
}