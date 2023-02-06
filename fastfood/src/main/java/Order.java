import java.util.HashMap;

class Order {

    private static final HashMap<String, Integer> ORDERS_COUNT = new HashMap<>();
    private final Channel channel;
    private final int globalOrderId;
    private final int channelOrderId;

    Order(Channel channel) {
        this.channel = channel;
        this.increaseOrdersCount();
        this.globalOrderId = Order.getOrdersGlobalCount();
        this.channelOrderId = this.getOrdersCountByChannel();
    }

    private void increaseOrdersCount() {
        ORDERS_COUNT.putIfAbsent(this.channel.getClass().getName(), 0);
        ORDERS_COUNT.put(this.channel.getClass().getName(), this.getOrdersCountByChannel() + 1);
    }

    private int getOrdersCountByChannel() {
        return ORDERS_COUNT.get(this.channel.getClass().getName());
    }

    private static int getOrdersGlobalCount() {
        return ORDERS_COUNT.values().stream().mapToInt(Integer::intValue).sum();
    }

    void process() {
        this.channel.attend(this.globalOrderId, this.channelOrderId);
    }
}