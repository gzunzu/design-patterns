package vehicle;

import feature.DoorsCount;
import feature.Extra;
import feature.Fuel;
import feature.HorsePower;

public class CommonFamiliarVehicle extends Vehicle {

    private static final String PACK_NAME = "common familiar";

    public CommonFamiliarVehicle(Model model, String colour) {
        super(model,
                colour,
                DoorsCount.STANDARD,
                new Extra[]{Extra.NAVIGATION, Extra.PARKING_ASSISTANCE},
                Fuel.DIESEL,
                HorsePower.STANDARD
        );
    }

    @Override
    protected String getFeaturesConfigurationPackName() {
        return PACK_NAME;
    }
}
