package business;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
public enum Vessel {
    BRANDY_SNIFTER(200),
    CHAMPAGNE_COUPLE(200),
    CHAMPAGNE_FLUTE(200),
    COLLINS_GLASS(300),
    GOBLET_GLASS(400),
    HIGHBALL_GLASS(260),
    HURRICANE_GLASS(590),
    COUPETTE(270),
    MARTINI_GLASS(150),
    PINT_GLASS(450),
    RED_WINE_GLASS(150),
    ROCKS_GLASS(200),
    SHOT_GLASS(40),
    PILSNER_TULIP(500),
    WHITE_WINE_GLASS(150);

    private final int volume;

    public String getName() {
        return StringUtils.replace(this.name(), "_", " ").toLowerCase();
    }
}
