package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum Salute {
    HI("Hi"),
    HELLO("Hello"),
    NTMY("Nice to meet you"),
    GOOD_MORNING("Good morning"),
    GOOD_AFTERNOON("Good afternoon");

    private static final Random RANDOM = new Random();

    private final String text;

    public static Salute random() {
        Salute[] salutes = values();
        return salutes[RANDOM.nextInt(salutes.length)];
    }
}