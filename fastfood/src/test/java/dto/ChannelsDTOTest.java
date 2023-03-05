package dto;

import channels.Channel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import utils.JsonHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChannelsDTOTest {

    private ChannelsDTO channelsDTO;

    @BeforeEach
    void init() {
        this.channelsDTO = JsonHelper.readJsonFile("src/test/resources/orders.json", ChannelsDTO.class);
    }

    @Test
    void getChannelsTest() {
        Assert.notNull(this.channelsDTO, "Objects should not be null.");

        List<Channel> result = this.channelsDTO.getChannels();

        assertThat(result).hasOnlyElementsOfType(Channel.class);
    }
}