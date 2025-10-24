public class DeliveredState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("Pedido já foi pago.");
    }

    @Override
    public void send(Order order) {
        System.out.println("Pedido já foi entregue.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Pedido já foi entregue.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Não é possível cancelar. Pedido já foi entregue.");
    }
}
