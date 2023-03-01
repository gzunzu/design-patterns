package cocktails;

import org.apache.commons.lang3.StringUtils;

public enum Vessel {
    BRANDY_SNIFLER,
    CHAMPAGNE_COUPLE,
    CHAMPAGNE_FLUTE,
    COLINS_GLASS,
    GOBLET_GLASS,
    HIGHBALL_GLASS,
    HURRICANE_GLASS,
    MARGARITA_GLASS,
    MARTINI_GLASS,
    RED_WINE_GLASS,
    ROCKS_GLASS,
    SHOT_GLASS,
    TULIP_GLASS,
    WHITE_WINE_GLASS;

    public String getName() {
        return StringUtils.replace(this.name(), "_", " ").toLowerCase();
    }
}
