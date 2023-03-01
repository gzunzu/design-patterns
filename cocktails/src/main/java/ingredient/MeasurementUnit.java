package ingredient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MeasurementUnit {
    BALL("ball", "ball(s)"),
    BIT("bit", "bit"),
    BLOCK("block", "block(s)"),
    LEAF("leaf", "leaf(s)"),
    MILLILITERS("milliliters", "ml"),
    PEEL("peel", "peel(s)"),
    PIECE("piece", "piece(s)"),
    PINCH("pinch", "pinch"),
    SLICE("slice", "slice(s)"),
    SPRIG("sprig", "sprig(s)"),
    UNIT("unit", "unit(s)"),
    WEDGE("wedge", "wedge(s)");

    private final String name;

    private final String symbol;
}
