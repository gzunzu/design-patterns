package visitable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.Gender;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ChildTest {

    private Child child;

    @BeforeEach
    public void init() {
        this.child = Mockito.mock(Child.class, Answers.RETURNS_MOCKS);
    }

    @Test
    public void testGetName() {
        Mockito.when(this.child.getName()).thenReturn("John");
        assertThat(this.child.getName()).isEqualTo("John");
    }

    @Test
    public void testGetGender() {
        assertThat(this.child.getGender()).isNotNull();
        assertThat(this.child.getGender()).isInstanceOf(Gender.class);
    }

    @Test
    public void testToString() {
        assertThat(this.child.toString()).isNotBlank();
    }
}