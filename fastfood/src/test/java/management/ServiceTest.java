package management;

import channels.Takeaway;
import channels.Telephone;
import channels.Web;
import dto.ChannelsDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServiceTest {

    private static ChannelsDTO channelsDTO;
    private static Takeaway takeaway;
    private static Telephone telephone;
    private static Web web;

    private Service service;

    @BeforeEach
    void init() {
        this.service = new Service();
    }

    @BeforeAll
    static void setUp() {
        channelsDTO = mock(ChannelsDTO.class);
        takeaway = mock(Takeaway.class);
        telephone = mock(Telephone.class);
        web = mock(Web.class);

        when(channelsDTO.getChannels()).thenReturn(List.of(takeaway, telephone, web));
        when(takeaway.welcome()).thenReturn("takeaway welcome");
        when(takeaway.serveClient()).thenReturn("takeaway serveClient");
        when(takeaway.farewell()).thenReturn("takeaway farewell");
        when(telephone.welcome()).thenReturn("telephone welcome");
        when(telephone.serveClient()).thenReturn("telephone serveClient");
        when(telephone.farewell()).thenReturn("telephone farewell");
        when(web.welcome()).thenReturn("web welcome");
        when(web.serveClient()).thenReturn("web serveClient");
        when(web.farewell()).thenReturn("web farewell");
    }

    @Test
    void addChannelsByChannelsDTOTest() {
        String previousResult = this.service.processOrders();

        this.service.addChannels(channelsDTO);

        String result = this.service.processOrders();

        assertThat(previousResult)
                .doesNotContain("takeaway welcome", "takeaway serveClient", "takeaway farewell")
                .doesNotContain("telephone welcome", "telephone serveClient", "telephone farewell")
                .doesNotContain("web welcome", "web serveClient", "web farewell");
        assertThat(result)
                .isNotEqualTo(previousResult)
                .contains("takeaway welcome", "takeaway serveClient", "takeaway farewell")
                .contains("telephone welcome", "telephone serveClient", "telephone farewell")
                .contains("web welcome", "web serveClient", "web farewell");
    }

    @Test
    void testAddChannelsByArrayTest() {
        String previousResult = this.service.processOrders();

        this.service.addChannels(takeaway, telephone, web);

        String result = this.service.processOrders();

        assertThat(previousResult)
                .doesNotContain("takeaway welcome", "takeaway serveClient", "takeaway farewell")
                .doesNotContain("telephone welcome", "telephone serveClient", "telephone farewell")
                .doesNotContain("web welcome", "web serveClient", "web farewell");
        assertThat(result)
                .isNotEqualTo(previousResult)
                .contains("takeaway welcome", "takeaway serveClient", "takeaway farewell")
                .contains("telephone welcome", "telephone serveClient", "telephone farewell")
                .contains("web welcome", "web serveClient", "web farewell");
    }

    @Test
    void shuffle() {
        this.service.addChannels(takeaway, telephone, web);

        assertThatNoException().isThrownBy(() -> {
            this.service.shuffle();
            String result = this.service.processOrders();
            assertThat(result)
                    .contains("takeaway welcome", "takeaway serveClient", "takeaway farewell")
                    .contains("telephone welcome", "telephone serveClient", "telephone farewell")
                    .contains("web welcome", "web serveClient", "web farewell");
        });

    }

    @Test
    void finishWork() {
        this.service.addChannels(takeaway, telephone, web);
        String previousResult = this.service.processOrders();

        assertThatNoException().isThrownBy(() -> {
            this.service.finishWork();
            String result = this.service.processOrders();
            assertThat(previousResult)
                    .contains("takeaway welcome", "takeaway serveClient", "takeaway farewell")
                    .contains("telephone welcome", "telephone serveClient", "telephone farewell")
                    .contains("web welcome", "web serveClient", "web farewell");
            assertThat(result)
                    .isNotEqualTo(previousResult)
                    .doesNotContain("takeaway welcome", "takeaway serveClient", "takeaway farewell")
                    .doesNotContain("telephone welcome", "telephone serveClient", "telephone farewell")
                    .doesNotContain("web welcome", "web serveClient", "web farewell");
        });
    }

    @Test
    void processOrders() {
        this.service.addChannels(takeaway, telephone, web);

        assertThatNoException().isThrownBy(() -> {
            String result = this.service.processOrders();

            assertThat(result)
                    .contains("takeaway welcome", "takeaway serveClient", "takeaway farewell")
                    .contains("telephone welcome", "telephone serveClient", "telephone farewell")
                    .contains("web welcome", "web serveClient", "web farewell");
        });
    }
}