package office;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum Product {
    WATER("water", 1f),
    SODA("soda", 1.2f),
    SNACK("snack", 2.3f);

    @Getter(AccessLevel.NONE)
    private static final Random RANDOM = new Random();
    private final String name;
    private final Float price;

    public static Product getRandomProduct() {
        return Product.values()[RANDOM.nextInt(values().length)];
    }
}
