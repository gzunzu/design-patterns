package vehicle;

import feature.DoorsCount;
import feature.Extra;
import feature.Fuel;
import feature.HorsePower;

public class CoolSportsVehicle extends Vehicle {

    private static final String PACK_NAME = "cool sports";

    public CoolSportsVehicle(Model model, String colour) {
        super(model,
                colour,
                DoorsCount.NO_TRUNK_DOOR,
                new Extra[]{Extra.NAVIGATION, Extra.STEREO},
                Fuel.GASOLINE,
                HorsePower.SUPER
        );
    }

    @Override
    protected String getFeaturesConfigurationPackName() {
        return PACK_NAME;
    }
}
