package features;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@Getter
public enum Fuel implements Feature {
    ELECTRIC("electric", 17500f),
    HYBRID("hybrid", 12000f),
    GASOLINE("gasoline", 0f),
    DIESEL("diesel", 3000f);

    @NotBlank
    private final String name;

    @PositiveOrZero
    private final float price;

    @Override
    public String toString() {
        return this.name;
    }
}
