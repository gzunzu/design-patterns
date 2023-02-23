package visitor;

import dto.VisitableDTO;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.Gender;
import utils.JsonHelper;
import utils.Randomizer;
import visitable.Baby;
import visitable.Dog;
import visitable.Preschooler;
import visitable.Toddler;
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

@ExtendWith(MockitoExtension.class)
class BabysitterTest {

    private static List<Visitable> sampleVisitables;

    private Babysitter babysitter;

    @BeforeAll
    static void setUp() {
        sampleVisitables = getSampleVisitables();
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

        when(mockedBaby.toString()).thenReturn("Mocked toString value");
        when(mockedBaby.getGender()).thenReturn(Gender.FEMALE);
        when(mockedBaby.cradle()).thenReturn("Mocked cradle value");

        String result = this.babysitter.visit(mockedBaby);

        verify(mockedBaby, times(1)).getGender();
        verify(mockedBaby, times(1)).cradle();
        assertThat(result).containsSubsequence("Mocked toString value",
                Gender.FEMALE.getObjectivePronoun(),
                "Mocked cradle value");
    }

    @Test
    void visitDog_clean() {
        Dog mockedDog = mock(Dog.class);

        when(mockedDog.toString()).thenReturn("Mocked toString value");
        when(mockedDog.isClean()).thenReturn(true);
        when(mockedDog.walk()).thenReturn("Mocked walk value");

        String result = this.babysitter.visit(mockedDog);

        verify(mockedDog, times(1)).walk();
        verify(mockedDog, never()).bath();
        verify(mockedDog, never()).bark();
        assertThat(result).containsSequence("Mocked toString value",
                SystemUtils.LINE_SEPARATOR,
                "[BABYSITTER] The dog is ",
                String.format("clean. Let's go for a walk.%n%s", "Mocked walk value"),
                SystemUtils.LINE_SEPARATOR);
    }

    @Test
    void visitDog_notClean() {
        Dog mockedDog = mock(Dog.class);

        when(mockedDog.toString()).thenReturn("Mocked toString value");
        when(mockedDog.isClean()).thenReturn(false);
        when(mockedDog.bark()).thenReturn("Mocked bark value");

        String result = this.babysitter.visit(mockedDog);

        verify(mockedDog, times(1)).bath();
        verify(mockedDog, times(1)).bark();
        verify(mockedDog, never()).walk();
        assertThat(result).containsSequence("Mocked toString value",
                SystemUtils.LINE_SEPARATOR,
                "[BABYSITTER] The dog is ",
                String.format("dirty. Let's have a bath.%n%s", "Mocked bark value"),
                SystemUtils.LINE_SEPARATOR);
    }

    @Test
    void visitPreschooler() {
        Preschooler mockedPreschooler = mock(Preschooler.class);

        when(mockedPreschooler.toString()).thenReturn("Mocked toString value");
        when(mockedPreschooler.getGender()).thenReturn(Gender.NON_BINARY);
        when(mockedPreschooler.play()).thenReturn("Mocked play value");

        String result = this.babysitter.visit(mockedPreschooler);

        assertThat(result).contains(String.format("%s%n[BABYSITTER] The preschooler is bored. I'll bring %s a game.%n%s%n",
                "Mocked toString value",
                Gender.NON_BINARY.getObjectivePronoun(),
                "Mocked play value"));
    }

    @Test
    void visitToddler() {
        Toddler mockedToddler = mock(Toddler.class);

        when(mockedToddler.toString()).thenReturn("Mocked toString value");
        when(mockedToddler.getGender()).thenReturn(Gender.MALE);
        when(mockedToddler.suckPacifier()).thenReturn("Mocked suckPacifier value");

        String result = this.babysitter.visit(mockedToddler);

        assertThat(result).contains(String.format("%s%n[BABYSITTER] The toddler teeth hurt. I'll give %s a pacifier.%n%s%n",
                "Mocked toString value",
                Gender.MALE.getObjectivePronoun(),
                "Mocked suckPacifier value"));
    }

    private static List<Visitable> getSampleVisitables() {
        return Objects.requireNonNull(JsonHelper.readJsonFile("src/test/resources/visitables.json", VisitableDTO.class)).getVisitables();
    }
}