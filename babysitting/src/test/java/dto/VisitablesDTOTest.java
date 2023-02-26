package dto;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import utils.JsonHelper;
import visitable.Visitable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VisitablesDTOTest {

    @Test
    void getVisitables() {
        VisitablesDTO visitablesDTO = JsonHelper.readJsonFile("src/test/resources/visitables.json", VisitablesDTO.class);
        Assert.notNull(visitablesDTO, "Objects should not be null.");

        List<Visitable> result = visitablesDTO.getVisitables();

        assertThat(result).hasOnlyElementsOfType(Visitable.class);
    }
}