package visitable;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import visitor.Visitor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Log4j2
@ExtendWith(MockitoExtension.class)
class DogTest {

    private static AutoCloseable autoClosable;

    private Dog dog;

    @Mock
    private Visitor visitor;

    @BeforeAll
    static void setUp() {
        autoClosable = MockitoAnnotations.openMocks(DogTest.class);
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
        this.dog = new Dog();
        dog.bath();
    }

    @Test
    void isClean() {
        boolean result = dog.isClean();
        assertThat(result).isTrue();
    }

    @Test
    void accept() {
        String mockedResult = "Result of the visitor.visit method";

        when(this.visitor.visit(any(Dog.class))).thenReturn(mockedResult);

        String result = this.dog.accept(this.visitor);

        verify(this.visitor, times(1)).visit(this.dog);
        assertThat(result).isEqualTo(mockedResult);
    }

    @Test
    void bark() {
        String result = this.dog.bark();

        assertThat(result).satisfiesAnyOf(
                string -> assertThat(string).contains(" barks excited for a walk."),
                string -> assertThat(string).contains(" barks sadly feeling dirty.")
        );
    }

    @Test
    void walk() {
        String result = this.dog.walk();

        assertThat(result).contains(" enjoys running outside.");
    }

    @Test
    void toStringTest() {
        String result = this.dog.toString();

        assertThat(result).satisfiesAnyOf(
                string -> assertThat(string).contains(" is a dirty dog."),
                string -> assertThat(string).contains(" is a clean dog.")
        );
    }
}