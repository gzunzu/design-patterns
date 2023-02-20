package vehicle;

import feature.DoorsCount;
import feature.Extra;
import feature.Fuel;
import feature.HorsePower;

public class PracticalWorkersVehicle extends Vehicle {

    private static final String PACK_NAME = "practical workers";

    public PracticalWorkersVehicle(Model model, String colour) {
        super(model,
                colour,
                DoorsCount.STANDARD,
                new Extra[]{Extra.NAVIGATION, Extra.PARKING_ASSISTANCE, Extra.AUTO_PILOT},
                Fuel.HYBRID,
                HorsePower.MIDDLE_HIGH
        );
    }

    @Override
    protected String getFeaturesConfigurationPackName() {
        return PACK_NAME;
    }
}
