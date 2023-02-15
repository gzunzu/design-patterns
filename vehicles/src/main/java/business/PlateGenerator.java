package business;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.NONE)
public abstract class PlateGenerator {

    private static final Random RANDOM = new Random();

    private static final String PLATE_AVAILABLE_LETTERS = "BCDFGHJKLMNPQRSTVWXYZ";

    public static String generateRandomPlateId() {
        StringBuilder result = new StringBuilder();
        IntStream.range(0, 4).forEach(element -> result.append(RANDOM.nextInt(10)));
        IntStream.range(0, 3).forEach(element -> result.append(getRandomPlateLetter()));

        return result.toString();
    }

    private static char getRandomPlateLetter() {
        return PLATE_AVAILABLE_LETTERS.charAt(RANDOM.nextInt(PLATE_AVAILABLE_LETTERS.length()));
    }
}
