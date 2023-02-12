package feature;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@Getter
public enum Colour implements Feature {
    BLACK("black", 300f),
    BLUE("blue", 0f),
    BROWN("brown", 0f),
    GREEN("green", 0f),
    GREY("grey", 250f),
    ORANGE("orange", 0f),
    PINK("pink", 500f),
    PURPLE("purple", 120f),
    RED("red", 120f),
    WHITE("white", 160f),
    YELLOW("yellow", 50f);

    @NotBlank
    private final String name;

    @PositiveOrZero
    private final float price;

    @Override
    public String toString() {
        return this.name;
    }
}
