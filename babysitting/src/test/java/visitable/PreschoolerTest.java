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
class PreschoolerTest {

    private static final int NUMBERS_KNOWN = 10;

    private static AutoCloseable autoClosable;

    private Preschooler preschooler;

    @Mock
    private Visitor visitor;

    @BeforeAll
    static void setUp() {
        autoClosable = MockitoAnnotations.openMocks(PreschoolerTest.class);
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
        this.preschooler = new Preschooler("Nombre", Gender.FEMALE, NUMBERS_KNOWN);
    }

    @Test
    void getGender() {
        Gender result = this.preschooler.getGender();

        assertThat(result).isEqualTo(Gender.FEMALE);
    }

    @Test
    void accept() {
        String mockedResult = "Result of the visitor.visit method";

        when(this.visitor.visit(any(Preschooler.class))).thenReturn(mockedResult);

        String result = this.preschooler.accept(this.visitor);

        verify(this.visitor, times(1)).visit(this.preschooler);
        assertThat(result).isEqualTo(mockedResult);
    }

    @Test
    void play() {
        String result = this.preschooler.play();

        assertThat(result).containsSequence(this.preschooler.name, " is now having fun playing.");
    }

    @Test
    void toStringTest() {
        String result = this.preschooler.toString();

        assertThat(result).containsSubsequence(
                StringUtils.capitalize(this.preschooler.gender.getSubjectivePronoun()),
                String.valueOf(NUMBERS_KNOWN));
    }
}