package business;

import java.util.Random;
import java.util.stream.IntStream;

public class PlateGenerator {

    private final static Random RANDOM = new Random();

    private final static String PLATE_AVAILABLE_LETTERS = "BCDFGHJKLMNPQRSTVWXYZ";

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
