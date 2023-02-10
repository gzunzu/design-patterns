package machine;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum Product {
    WATER("water", 1f),
    SODA("soda", 1.2f),
    SNACK("snack", 2.3f);

    private String name;

    private Float price;

    public static Product getRandomProduct() {
        return Product.values()[new Random().nextInt(values().length)];
    }
}
