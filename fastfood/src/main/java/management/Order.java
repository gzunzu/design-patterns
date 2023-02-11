package management;

import channels.Channel;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;

@Log4j2
public class Order {

    private static final HashMap<String, Integer> ORDERS_COUNTER = new HashMap<>();
    private final Channel channel;
    private int globalOrderId;
    private int channelOrderId;

    Order(Channel channel) {
        this.channel = channel;
    }

    private static int getGlobalOrdersCount() {
        return ORDERS_COUNTER.values().stream().mapToInt(Integer::intValue).sum();
    }

    private int getChannelOrderCount() {
        return ORDERS_COUNTER.get(this.channel.getClass().getName());
    }

    private void updateOrdersCounter() {
        ORDERS_COUNTER.putIfAbsent(this.channel.getClass().getName(), 0);
        ORDERS_COUNTER.put(this.channel.getClass().getName(), this.getChannelOrderCount() + 1);
        this.channelOrderId = this.getChannelOrderCount();
        this.globalOrderId = getGlobalOrdersCount();
    }

    public String process() {
        this.updateOrdersCounter();
        return this.channel.attend(this.globalOrderId, this.channelOrderId);
    }
}