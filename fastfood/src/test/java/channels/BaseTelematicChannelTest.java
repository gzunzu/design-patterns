package channels;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class BaseTelematicChannelTest extends BaseChannelTest {

    private TelematicChannel telematicChannel;

    @Override
    protected final Channel getTestedChannelInstance() {
        this.telematicChannel = this.getTestedTelematicChannelInstance();
        return this.telematicChannel;
    }

    protected abstract TelematicChannel getTestedTelematicChannelInstance();

    protected abstract TelematicChannel getNoArgsConstructorTestedTelematicChannelInstance();

    protected abstract String getTestedChannelLocation();

    @Override
    protected final String[] getTestedChannelServeClient() {
        return new String[]{this.getTestedTelematicChannelGetCommand(), "Your order will be sent to ", this.getTestedChannelLocation()};
    }

    @Test
    final void getCommandTest() {
        String result = this.telematicChannel.getCommand();

        assertThat(result).contains(this.getTestedTelematicChannelGetCommand());
    }

    protected abstract String getTestedTelematicChannelGetCommand();

    @Test
    final void noArgsConstructorTest() {
        final TelematicChannel telematicChannelWithoutArgs = this.getNoArgsConstructorTestedTelematicChannelInstance();

        assertThat(telematicChannelWithoutArgs).isNotNull();
        assertThat(telematicChannelWithoutArgs.location).isNull();
    }
}