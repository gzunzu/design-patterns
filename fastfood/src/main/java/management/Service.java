package management;

import channels.Channel;
import dto.ChannelsDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Service {

    private final ArrayList<Order> orders;

    public Service() {
        this.orders = new ArrayList<>();
    }

    public void addChannels(ChannelsDTO channelsDTO) {
        this.addChannels(channelsDTO.getChannels());
    }

    public void addChannels(Channel... channels) {
        Arrays.asList(channels).forEach(channel -> this.orders.add(new Order(channel)));
    }

    public <T extends Channel> void addChannels(List<T> channelList) {
        channelList.forEach(channel -> this.orders.add(new Order(channel)));
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