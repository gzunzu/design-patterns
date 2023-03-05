package management;

import channels.Channel;
import channels.Promoted;
import com.ibm.icu.text.RuleBasedNumberFormat;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.util.HashMap;
import java.util.Locale;

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

    private String getOrderNumber() {
        final RuleBasedNumberFormat formatter
                = new RuleBasedNumberFormat(Locale.ENGLISH, RuleBasedNumberFormat.SPELLOUT);
        return String.format("Your order will be the %s of the %s sales channel and %sthe %s of the day.%n",
                formatter.format(this.channelOrderId, "%spellout-ordinal"),
                this.channel.getChannelName(),
                this.globalOrderId == this.channelOrderId ? "also " : StringUtils.EMPTY,
                formatter.format(this.globalOrderId, "%spellout-ordinal"));
    }

    public String process() {
        this.updateOrdersCounter();
        return this.channel.welcome()
                .concat(this.channel instanceof Promoted promo && promo.isActive() ? promo.announcePromo() : StringUtils.EMPTY)
                .concat(this.getOrderNumber())
                .concat(String.format("[...]%n%s", this.channel.serveClient()))
                .concat(this.channel.farewell())
                .concat(SystemUtils.LINE_SEPARATOR);
    }
}