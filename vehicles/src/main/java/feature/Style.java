package feature;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@Getter
public enum Style implements Feature {
    CARGO("cargo", 7200f),
    CONVERTIBLE("convertible", 6000f),
    COUPE("coupe", 800f),
    HATCHBACK("hatchback", 0f),
    OFFROADER("off-roader", 4500f),
    PICKUP("pickup", 3500f),
    SEDAN("sedan", 0f),
    SUV("SUV", 800f),
    TRUCK("truck", 25000f),
    VAN("van", 8000f),
    WAGON("wagon", 6500f);

    @NotBlank
    private final String name;

    @PositiveOrZero
    private final float price;

    @Override
    public String toString() {
        return this.name;
    }
}
