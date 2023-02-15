package vehicle;

import business.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Log4j2
public class VehicleFactory {

    public static Vehicle getVehicle(@NotNull VehiclePackage vehiclePackage, @NotBlank String colour) {

        try {
            Constructor<?> constructor = Class.forName(vehiclePackage.getClazz().getName()).getConstructor(Model.class, String.class);
            return (Vehicle) constructor.newInstance(Store.getModelByName(vehiclePackage.getModelName()), colour);
        } catch (NoSuchMethodException e) {
            log.error("Unrecognized constructor for {} class.", vehiclePackage.getClazz().getName());
        } catch (ClassNotFoundException e) {
            log.error("Unrecognized class {}.", vehiclePackage.getClazz().getName());
        } catch (InvocationTargetException e) {
            log.error("Error while trying to invoke constructor for class {}.", vehiclePackage.getClazz().getName());
        } catch (InstantiationException e) {
            log.error("Error while trying to create an instance of class {}.", vehiclePackage.getClazz().getName());
        } catch (IllegalAccessException e) {
            log.error("Illegal access to {} class constructor.", vehiclePackage.getClazz().getName());
        }
        return null;
    }

    @AllArgsConstructor
    @Getter
    public enum VehiclePackage {
        COMMON_FAMILIAR("common familiar", CommonFamiliarVehicle.class, "Urban Family"),
        PRACTICAL_WORKERS("practical workers", PracticalWorkersVehicle.class, "Hard Labourer"),
        COOL_SPORTS("cool sports", CoolSportsVehicle.class, "Hot Player");

        private final String packageName;

        private final Class<? extends Vehicle> clazz;

        private final String modelName;
    }
}