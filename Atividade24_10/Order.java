public class Order {
    private OrderState state;

    public Order() {
        this.state = new NewState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void pay() {
        state.pay(this);
    }

    public void send() {
        state.send(this);
    }

    public void deliver() {
        state.deliver(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    @Override
    public String toString() {
        return "Pedido está atualmente em: " + state.getClass().getSimpleName();
    }
}
