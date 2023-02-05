package patterns.adapter.nutritionist.ext;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RandomWeightHelper {
    KILOGRAMS(45, 160),
    POUNDS(100, 350);

    private final int min;

    private final int max;

    public float getWeight() {
        return (float) ((Math.random() * (this.max - this.min)) + this.min);
    }
}