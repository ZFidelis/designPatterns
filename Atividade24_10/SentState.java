public class SentState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("Pedido já foi pago.");
    }

    @Override
    public void send(Order order) {
        System.out.println("Pedido já está a caminho do cliente.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Pedido entregue ao cliente.");
        order.setState(new DeliveredState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Não é possível cancelar. Pedido já foi enviado.");
    }
}
