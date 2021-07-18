package fastFood;

import java.util.HashMap;

class Order {
    
    private static final HashMap<String, Integer> ORDERS_COUNT = new HashMap<String, Integer>();
    private final Channel CHANNEL;
    private int globalOrderId;
    private int channelOrderId;
    
    Order (Channel channel) {
        this.CHANNEL = channel;
        this.increaseOrdersCount();
        this.globalOrderId = Order.getOrdersGlobalCount();
        this.channelOrderId = this.getOrdersCountByChannel();
    }
    
    private void increaseOrdersCount() {
        Order.ORDERS_COUNT.putIfAbsent(this.CHANNEL.getClass().getName(), 0);
        Order.ORDERS_COUNT.put(this.CHANNEL.getClass().getName(), this.getOrdersCountByChannel() + 1);
    }
    
    private int getOrdersCountByChannel() {
        return Order.ORDERS_COUNT.get(this.CHANNEL.getClass().getName());
    }
    
    private static int getOrdersGlobalCount() {
        return Order.ORDERS_COUNT.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    void process() {
        this.CHANNEL.attend(this.globalOrderId, this.channelOrderId);
    }
}