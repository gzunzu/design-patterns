package vehicle;

import feature.DoorsCount;
import feature.Extra;
import feature.Fuel;
import feature.HorsePower;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class CoolSportsVehicle extends Vehicle {

    private static final String PACK_NAME = "cool sports";

    public CoolSportsVehicle(Model model, String colour) {
        super(model, colour);
        this.doors = DoorsCount.STANDARD;
        this.configureExtras(Extra.NAVIGATION, Extra.STEREO);
        this.fuel = Fuel.DIESEL;
        this.horsePower = HorsePower.STANDARD;
    }

    @Override
    protected String getFeaturesConfigurationPackName() {
        return PACK_NAME;
    }
}
