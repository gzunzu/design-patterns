package visitable;

import org.apache.commons.lang3.StringUtils;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BabyTest {

    private static final int WEEKS = 3;

    private Baby baby;

    @Mock
    private Visitor visitor;

    @BeforeAll
    static void setUp() {
        MockitoAnnotations.openMocks(BabyTest.class);
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