package visitable;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.Gender;
import visitor.Visitor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@Log4j2
@ExtendWith(MockitoExtension.class)
class BabyTest {

    private static final int WEEKS = 3;

    private static AutoCloseable autoClosable;

    private Baby baby;

    @Mock
    private Visitor visitor;

    @BeforeAll
    static void setUp() {
        autoClosable = MockitoAnnotations.openMocks(BabyTest.class);
    }

    @AfterAll
    static void tearDown() {
        try {
            autoClosable.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @BeforeEach
    void init() {
        this.baby = new Baby("Nombre", Gender.FEMALE, WEEKS);
    }

    @Test
    void accept() {
        String mockedResult = "Result of the visitor.visit method";

        when(this.visitor.visit(any(Baby.class))).thenReturn(mockedResult);

        String result = this.baby.accept(this.visitor);

        verify(this.visitor, times(1)).visit(this.baby);
        assertThat(result).isNotBlank().isEqualTo(mockedResult);
    }

    @Test
    void cradle() {
        String result = this.baby.cradle();

        assertThat(result).isNotBlank().containsSequence(this.baby.name, " loves being cradled.");
    }

    @Test
    void toStringTest() {
        String result = this.baby.toString();

        assertThat(result).isNotBlank().containsSubsequence(
                StringUtils.capitalize(this.baby.gender.getSubjectivePronoun()),
                String.valueOf(WEEKS)
        );
    }
}