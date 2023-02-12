package features;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@Getter
public enum DoorsCount implements Feature {
    NO_TRUNK_DOOR("no truck", 2, 0f),
    BASIC("basic", 3, 0f),
    STANDARD("standard", 5, 4500f),
    MULTI("multi", 7, 11200f);

    @NotBlank
    private final String name;

    @Positive
    private final int doors;

    @PositiveOrZero
    private final float price;

    @Override
    public String toString() {
        return String.format("%s [%d]", this.name, this.doors);
    }
}
