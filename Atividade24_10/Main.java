public class Main {
    public static void main(String[] args) {
        Order pedido = new Order();
        System.out.println(pedido);
        
        pedido.pay();
        System.out.println(pedido);
        
        pedido.send();
        System.out.println(pedido);
        
        pedido.deliver();
        System.out.println(pedido);
        
        pedido.cancel();
    }
}