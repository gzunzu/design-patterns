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
class ToddlerTest {

    private static final int TEETH_COUNT = 8;

    private static AutoCloseable autoClosable;

    private Toddler toddler;

    @Mock
    private Visitor visitor;

    @BeforeAll
    static void setUp() {
        autoClosable = MockitoAnnotations.openMocks(ToddlerTest.class);
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
        this.toddler = new Toddler("Nombre", Gender.FEMALE, TEETH_COUNT);
    }

    @Test
    void getGender() {
        Gender result = this.toddler.getGender();

        assertThat(result).isEqualTo(Gender.FEMALE);
    }

    @Test
    void accept() {
        String mockedResult = "Result of the visitor.visit method";

        when(this.visitor.visit(any(Toddler.class))).thenReturn(mockedResult);

        String result = this.toddler.accept(this.visitor);

        verify(this.visitor, times(1)).visit(this.toddler);
        assertThat(result).isEqualTo(mockedResult);
    }

    @Test
    void suckPacifier() {
        String result = this.toddler.suckPacifier();

        assertThat(result).containsSequence(this.toddler.name, " is calming down while sucking the pacifier.");
    }

    @Test
    void toStringTest() {
        String result = this.toddler.toString();

        assertThat(result).isNotBlank().containsSubsequence(
                StringUtils.capitalize(this.toddler.gender.getSubjectivePronoun()),
                " tooth is coming out.");
    }
}