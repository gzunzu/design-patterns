package management;

import channels.Channel;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Service {

    private final ArrayList<Order> orders;

    public Service() {
        this.orders = new ArrayList<>();
    }

    public void addOrders(Channel... channels) {
        Arrays.asList(channels).forEach(channel -> this.orders.add(new Order(channel)));
    }

    public <T extends Channel> void addOrders(List<T> chanelList) {
        chanelList.stream().forEach(channel -> this.orders.add(new Order(channel)));
    }

    public void reject(Channel... channels) {
        this.orders.removeAll(Arrays.asList(channels));
    }

    public void shuffle() {
        Collections.shuffle(this.orders);
    }

    public void finishWork() {
        this.orders.clear();
    }

    public String processOrders() {
        String result = StringUtils.EMPTY;
        for (Order order : this.orders) {
            result += order.process();
        }
        return result;
    }
}