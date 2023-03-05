package management;

import channels.Channel;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Log4j2
class OrderTest {

    private static AutoCloseable autoCloseable;

    @InjectMocks
    private Order order;
    @Mock
    private Channel channel;

    @BeforeAll
    static void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(OrderTest.class);
    }

    @AfterAll
    static void tearDown() {
        try {
            autoCloseable.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    void processTest() {
        when(this.channel.welcome()).thenReturn("welcome");
        when(this.channel.serveClient()).thenReturn("serve client");
        when(this.channel.farewell()).thenReturn("farewell");

        String result = this.order.process();

        verify(this.channel).welcome();
        verify(this.channel).serveClient();
        verify(this.channel).farewell();
        assertThat(result)
                .contains("welcome", "serve client", "farewell");
    }
}