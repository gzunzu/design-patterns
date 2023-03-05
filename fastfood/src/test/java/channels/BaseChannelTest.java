package channels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class BaseChannelTest {

    private Channel channel;

    @BeforeEach
    final void init() {
        this.channel = this.getTestedChannelInstance();
    }

    protected abstract Channel getTestedChannelInstance();

    @Test
    final void welcomeTest() {
        String result = this.channel.welcome();

        assertThat(result).containsSubsequence(this.getTestedChannelWelcome());
    }

    protected abstract String[] getTestedChannelWelcome();

    @Test
    final void getChannelNameTest() {
        String result = this.channel.getChannelName();

        assertThat(result).isEqualTo(this.getTestedChannelName());
    }

    protected abstract String getTestedChannelName();

    @Test
    final void serveClientTest() {
        String result = this.channel.serveClient();

        assertThat(result).containsSubsequence(this.getTestedChannelServeClient());
    }

    protected abstract String[] getTestedChannelServeClient();

    @Test
    final void farewellTest() {
        String result = this.channel.farewell();

        assertThat(result).contains(this.getTestedChannelFarewell());
    }

    protected abstract String[] getTestedChannelFarewell();

    @Test
    final void promotedMethodsTest() {
        if (this.channel instanceof Promoted promo) {
            if (this.getTestedChannelPromoIsActive()) {
                assertThat(promo.isActive()).isTrue();
                assertThat(promo.announcePromo()).contains(this.getTestedChannelPromo());
            } else {
                assertThat(promo.isActive()).isFalse();
            }
        }
    }

    protected abstract boolean getTestedChannelPromoIsActive();

    protected abstract String getTestedChannelPromo();
}