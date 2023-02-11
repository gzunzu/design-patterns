package channels;

import com.ibm.icu.text.RuleBasedNumberFormat;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public abstract class Channel {

    public String attend(int globalOrderId, int channelOrderId) {
        return this.welcome(globalOrderId, channelOrderId)
                + this.announceChannelPromo()
                + this.serveClient();
    }

    protected String welcome(int globalOrderId, int channelOrderId) {
        final RuleBasedNumberFormat formatter
                = new RuleBasedNumberFormat(Locale.ENGLISH, RuleBasedNumberFormat.SPELLOUT);
        return String.format("%nWelcome to our fast food service!%nYour order is the %s of the day and the %s of the %s channel.%n",
                formatter.format(globalOrderId, "%spellout-ordinal"),
                formatter.format(channelOrderId, "%spellout-ordinal"),
                this.getChannelName());
    }

    private String announceChannelPromo() {
        return this instanceof Promoted promoted && promoted.isPromoActive() ?
                String.format("%n%s%n", promoted.announcePromo()) : StringUtils.EMPTY;
    }

    protected abstract String serveClient();

    protected abstract String getChannelName();
}