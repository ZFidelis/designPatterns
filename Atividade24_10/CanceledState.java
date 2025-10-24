public class CanceledState implements OrderState {

    @Override
    public void pay(Order order) {
        System.out.println("Pedido cancelado. Não é possível pagar.");
    }

    @Override
    public void send(Order order) {
        System.out.println("Pedido cancelado. Não é possível enviar.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Pedido cancelado. Não é possível entregar.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Pedido já está cancelado.");
    }

}
