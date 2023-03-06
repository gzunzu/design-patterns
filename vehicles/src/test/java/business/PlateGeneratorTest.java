package business;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;


class PlateGeneratorTest {

    @Test
    void generateRandomPlateIdTest() {
        String result = PlateGenerator.generateRandomPlateId();

        Pattern platePattern = Pattern.compile("^\\d{4}[B-DF-HJ-NP-TV-Z]{3}$");

        assertThat(result).matches(platePattern);
    }
}