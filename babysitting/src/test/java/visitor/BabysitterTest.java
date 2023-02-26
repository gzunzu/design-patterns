package visitor;

import dto.VisitablesDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.Gender;
import visitable.Baby;
import visitable.Dog;
import visitable.Preschooler;
import visitable.Toddler;
import visitable.Visitable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Log4j2
@ExtendWith(MockitoExtension.class)
class BabysitterTest {

    private static AutoCloseable autoCloseable;

    private Babysitter babysitter;

    @Mock
    private Baby baby;

    @Mock
    private Dog dog;

    @Mock
    private Preschooler preschooler;

    @Mock
    private Toddler toddler;

    @BeforeAll
    static void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(BabysitterTest.class);
    }

    @AfterAll
    static void tearDown() {
        try {
            autoCloseable.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @BeforeEach
    void init() {
        this.babysitter = new Babysitter();
        this.babysitter.admit(baby, dog, preschooler);
    }

    @Test
    void getVisitablesCount() {
        assertThat(this.babysitter.getVisitablesCount()).isEqualTo(3);
    }

    @Test
    void isTakingCareOf() {
        assertThat(this.babysitter.isTakingCareOf(baby, dog, preschooler)).isTrue();
        assertThat(this.babysitter.isTakingCareOf(toddler)).isFalse();
    }

    @Test
    void admitVisitablesDTO() {
        int initialSize = this.babysitter.getVisitablesCount();
        VisitablesDTO visitablesDTO = mock(VisitablesDTO.class);

        this.babysitter.admit(visitablesDTO);

        verify(visitablesDTO, times(1)).getVisitables();
        assertThat(this.babysitter.getVisitablesCount()).isEqualTo(initialSize + visitablesDTO.getVisitables().size());
        assertThat(this.babysitter.isTakingCareOf(visitablesDTO.getVisitables().toArray(new Visitable[0]))).isTrue();
    }

    @Test
    void admitArray() {
        int initialSize = this.babysitter.getVisitablesCount();
        boolean previousResult = this.babysitter.isTakingCareOf(toddler);

        this.babysitter.admit(toddler);

        assertThat(previousResult).isFalse();
        assertThat(this.babysitter.getVisitablesCount()).isEqualTo(initialSize + 1);
        assertThat(this.babysitter.isTakingCareOf(toddler)).isTrue();
    }

    @Test
    void reject() {
        int initialSize = this.babysitter.getVisitablesCount();

        this.babysitter.reject(baby, preschooler);

        assertThat(this.babysitter.getVisitablesCount()).isEqualTo(initialSize - 2);
        assertThat(this.babysitter.isTakingCareOf(baby)).isFalse();
        assertThat(this.babysitter.isTakingCareOf(preschooler)).isFalse();
        assertThat(this.babysitter.isTakingCareOf(dog)).isTrue();
    }

    @Test
    void shuffle() {
        int initialSize = this.babysitter.getVisitablesCount();

        this.babysitter.shuffle();

        assertThat(this.babysitter.getVisitablesCount()).isEqualTo(initialSize);
        assertThat(this.babysitter.isTakingCareOf(baby, dog, preschooler)).isTrue();
        assertThat(this.babysitter.isTakingCareOf(toddler)).isFalse();
    }

    @Test
    void finishWork() {
        int initialSize = this.babysitter.getVisitablesCount();

        this.babysitter.finishWork();

        assertThat(initialSize).isPositive();
        assertThat(this.babysitter.getVisitablesCount()).isZero();
    }

    @Test
    void takeCare() {
        when(baby.accept(any(Visitor.class))).thenReturn("Mocked Baby accept value");
        when(dog.accept(any(Visitor.class))).thenReturn("Mocked Dog accept value");
        when(preschooler.accept(any(Visitor.class))).thenReturn("Mocked Preschooler accept value");

        String result = this.babysitter.takeCare();

        verify(baby, times(1)).accept(this.babysitter);
        verify(dog, times(1)).accept(this.babysitter);
        verify(preschooler, times(1)).accept(this.babysitter);
        verify(toddler, never()).accept(this.babysitter);
        assertThat(result).containsSubsequence("Mocked Baby accept value",
                "Mocked Dog accept value",
                "Mocked Preschooler accept value");
    }

    @Test
    void visitBaby() {
        when(baby.toString()).thenReturn("Mocked toString value");
        when(baby.getGender()).thenReturn(Gender.FEMALE);
        when(baby.cradle()).thenReturn("Mocked cradle value");

        String result = this.babysitter.visit(baby);

        verify(baby, times(1)).getGender();
        verify(baby, times(1)).cradle();
        assertThat(result).containsSubsequence("Mocked toString value",
                Gender.FEMALE.getObjectivePronoun(),
                "Mocked cradle value");
    }

    @Test
    void visitDog_clean() {
        when(dog.toString()).thenReturn("Mocked toString value");
        when(dog.isClean()).thenReturn(true);
        when(dog.walk()).thenReturn("Mocked walk value");

        String result = this.babysitter.visit(dog);

        verify(dog, times(1)).walk();
        verify(dog, never()).bath();
        verify(dog, never()).bark();
        assertThat(result).containsSequence("Mocked toString value",
                SystemUtils.LINE_SEPARATOR,
                "[BABYSITTER] The dog is ",
                String.format("clean. Let's go for a walk.%n%s", "Mocked walk value"),
                SystemUtils.LINE_SEPARATOR);
    }

    @Test
    void visitDog_notClean() {
        when(dog.toString()).thenReturn("Mocked toString value");
        when(dog.isClean()).thenReturn(false);
        when(dog.bark()).thenReturn("Mocked bark value");

        String result = this.babysitter.visit(dog);

        verify(dog, times(1)).bath();
        verify(dog, times(1)).bark();
        verify(dog, never()).walk();
        assertThat(result).containsSequence("Mocked toString value",
                SystemUtils.LINE_SEPARATOR,
                "[BABYSITTER] The dog is ",
                String.format("dirty. Let's have a bath.%n%s", "Mocked bark value"),
                SystemUtils.LINE_SEPARATOR);
    }

    @Test
    void visitPreschooler() {
        when(preschooler.toString()).thenReturn("Mocked toString value");
        when(preschooler.getGender()).thenReturn(Gender.NON_BINARY);
        when(preschooler.play()).thenReturn("Mocked play value");

        String result = this.babysitter.visit(preschooler);

        verify(preschooler, times(1)).getGender();
        verify(preschooler, times(1)).play();
        assertThat(result).contains(String.format("%s%n[BABYSITTER] The preschooler is bored. I'll bring %s a game.%n%s%n",
                "Mocked toString value",
                Gender.NON_BINARY.getObjectivePronoun(),
                "Mocked play value"));
    }

    @Test
    void visitToddler() {
        when(toddler.toString()).thenReturn("Mocked toString value");
        when(toddler.getGender()).thenReturn(Gender.MALE);
        when(toddler.suckPacifier()).thenReturn("Mocked suckPacifier value");

        String result = this.babysitter.visit(toddler);

        verify(toddler, times(1)).getGender();
        verify(toddler, times(1)).suckPacifier();
        assertThat(result).contains(String.format("%s%n[BABYSITTER] The toddler teeth hurt. I'll give %s a pacifier.%n%s%n",
                "Mocked toString value",
                Gender.MALE.getObjectivePronoun(),
                "Mocked suckPacifier value"));
    }
}