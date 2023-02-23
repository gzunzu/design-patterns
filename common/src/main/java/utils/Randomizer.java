package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.NONE)
public abstract class Randomizer {

    private static final Random RANDOM = new Random();

    public static Set<Integer> getRandomIntegers(@Positive int bound, @Positive int quantity) {
        Assert.isTrue(bound > quantity,
                "Bound for random must be greater than the quantity of random numbers wanted.");
        final Set<Integer> indexes = new HashSet<>();
        while (indexes.size() < quantity) {
            indexes.add(RANDOM.nextInt(bound));
        }
        return indexes;
    }
}