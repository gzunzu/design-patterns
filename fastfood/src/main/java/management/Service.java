package management;

import channels.Channel;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Service {

    private final ArrayList<Order> orders;

    public Service() {
        this.orders = new ArrayList<>();
    }

    @SuppressWarnings("unused")
    public void addOrders(Channel... channels) {
        Arrays.asList(channels).forEach(channel -> this.orders.add(new Order(channel)));
    }

    public <T extends Channel> void addOrders(List<T> chanelList) {
        if (CollectionUtils.isNotEmpty(chanelList)) {
            chanelList.forEach(channel -> this.orders.add(new Order(channel)));
        }
    }

    @SuppressWarnings("unused")
    public void reject(Order... orders) {
        this.orders.removeAll(Arrays.asList(orders));
    }

    public void shuffle() {
        Collections.shuffle(this.orders);
    }

    public void finishWork() {
        this.orders.clear();
    }

    public String processOrders() {
        StringBuilder result = new StringBuilder();
        for (Order order : this.orders) {
            result.append(order.process());
        }
        return result.toString();
    }
}