package feature;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@Getter
public enum Extra implements Feature {
    AUTO_PILOT("auto pilot", 1250f),
    EMERGENCY_BREAKING("emergency breaking system", 3200f),
    LIGHTER("lighter", 80f),
    NAVIGATION("GPS", 345f),
    OFFTRACK_DETECTION("offtrack detection system", 2200f),
    PARKING_ASSISTANCE("parking assistance", 395.99f),
    STEREO("stereo audio", 210.5f);

    @NotBlank
    private final String name;

    @PositiveOrZero
    private final float price;

    @Override
    public String toString() {
        return this.name;
    }
}
