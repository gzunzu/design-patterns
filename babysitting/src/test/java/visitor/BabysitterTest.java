package visitor;

import dto.VisitableDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.Gender;
import utils.JsonHelper;
import utils.Randomizer;
import visitable.Baby;
import visitable.Dog;
import visitable.Visitable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Log4j2
@ExtendWith(MockitoExtension.class)
class BabysitterTest {

    private static List<Visitable> sampleVisitables;

    private static AutoCloseable autoClosable;

    private Babysitter babysitter;

    @BeforeAll
    static void setUp() {
        sampleVisitables = getSampleVisitables();
        autoClosable = MockitoAnnotations.openMocks(BabysitterTest.class);
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
        this.babysitter = new Babysitter();
        this.babysitter.admit(sampleVisitables);
    }

    @Test
    void admit() {
        Visitable mockedVisitable = mock(Visitable.class);
        this.babysitter.admit(mockedVisitable);

        assertThat(this.babysitter.getVisitables())
                .hasSize(sampleVisitables.size() + 1);
        assertThat(this.babysitter.getVisitables())
                .contains(mockedVisitable);
    }

    @Test
    void reject() {
        List<Visitable> rejectedVisitables = new ArrayList<>();
        Set<Integer> randomIndexes = Randomizer.getRandomIntegers(this.babysitter.getVisitables().size(), 2);
        randomIndexes.forEach(index -> rejectedVisitables.add(this.babysitter.getVisitables().get(index)));

        this.babysitter.reject(rejectedVisitables.toArray(new Visitable[0]));

        assertThat(this.babysitter.getVisitables())
                .hasSize(sampleVisitables.size() - rejectedVisitables.size());
        assertThat(this.babysitter.getVisitables())
                .doesNotContain(rejectedVisitables.toArray(new Visitable[0]));
    }

    @Test
    void shuffle() {
        this.babysitter.shuffle();

        assertThat(this.babysitter.getVisitables()).hasSameElementsAs(sampleVisitables);
    }

    @Test
    void finishWork() {
        this.babysitter.finishWork();

        assertThat(this.babysitter.getVisitables()).isEmpty();
    }

    @Test
    void takeCare() {
        Visitable mockedVisitable = mock(Visitable.class);
        this.babysitter.admit(mockedVisitable);
        String result = this.babysitter.takeCare();

        verify(mockedVisitable, times(1)).accept(this.babysitter);
        assertThat(result).isNotBlank();
    }

    @Test
    void visitBaby() {
        Baby mockedBaby = mock(Baby.class);

        when(mockedBaby.getGender()).thenReturn(Gender.FEMALE);

        String result = this.babysitter.visit(mockedBaby);

        verify(mockedBaby, times(1)).getGender();
        verify(mockedBaby, times(1)).cradle();
        assertThat(result).containsSubsequence(mockedBaby.toString(),
                Gender.FEMALE.getObjectivePronoun());
    }

    @Test
    void visitDog_clean() {
        Dog mockedDog = mock(Dog.class);

        when(mockedDog.isClean()).thenReturn(true);

        String result = this.babysitter.visit(mockedDog);

        verify(mockedDog, times(1)).walk();
        verify(mockedDog, never()).bath();
        verify(mockedDog, never()).bark();
        assertThat(result).contains("clean. Let's go for a walk.");
    }

    @Test
    void visitDog_notClean() {
        Dog mockedDog = mock(Dog.class);

        when(mockedDog.isClean()).thenReturn(false);

        String result = this.babysitter.visit(mockedDog);

        verify(mockedDog, times(1)).bath();
        verify(mockedDog, times(1)).bark();
        verify(mockedDog, never()).walk();
        assertThat(result).contains("dirty. Let's have a bath.");
    }

    private static List<Visitable> getSampleVisitables() {
        return Objects.requireNonNull(JsonHelper.readJsonFile("src/test/resources/visitables.json", VisitableDTO.class)).getVisitables();
    }
}