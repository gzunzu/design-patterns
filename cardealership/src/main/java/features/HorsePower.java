package features;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@Getter
public enum HorsePower implements Feature {
    MINIMUM("minimum", 55, 0f),
    LOW("low", 70, 900f),
    BASIC("basic", 85, 1800f),
    STANDARD("standard", 90, 2300f),
    MIDDLE_HIGH("middle-high", 110, 4800f),
    HIGH("high", 130, 7500f),
    SUPER("super", 160, 13000f),
    ULTRA("ultra", 195, 23500f);

    @NotBlank
    private final String name;

    @Positive
    private final int cc;

    @PositiveOrZero
    private final float price;

    @Override
    public String toString() {
        return String.format("%d cc", this.cc);
    }
}
