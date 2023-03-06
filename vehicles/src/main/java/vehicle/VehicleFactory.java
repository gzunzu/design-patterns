package vehicle;

import business.Store;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.Assert;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Log4j2
public class VehicleFactory {

    public static Vehicle getVehicle(VehiclePackage vehiclePackage, String colour) {
        try {
            Assert.notNull(vehiclePackage, "Vehicle package should not be null");
            Constructor<?> constructor = Class.forName(vehiclePackage.getClazz().getName()).getConstructor(
                    Model.class,
                    String.class
            );
            return (Vehicle) constructor.newInstance(Store.getModelByName(vehiclePackage.getModelName()), colour);
        } catch (IllegalArgumentException e) {
            log.error(e.getCause(), e);
        } catch (NoSuchMethodException e) {
            log.error("Unrecognized constructor for {} class.", vehiclePackage.getClazz().getName(), e);
        } catch (ClassNotFoundException e) {
            log.error("Unrecognized class {}.", vehiclePackage.getClazz().getName(), e);
        } catch (InvocationTargetException e) {
            log.error("Error while trying to invoke constructor for class {}: {}", vehiclePackage.getClazz().getName(), e.getCause(), e);
        } catch (InstantiationException e) {
            log.error("Error while trying to create an instance of class {}: {}.", vehiclePackage.getClazz().getName(), e.getCause(), e);
        } catch (IllegalAccessException e) {
            log.error("Illegal access to {} class constructor: {}", vehiclePackage.getClazz().getName(), e.getCause(), e);
        }
        return null;
    }

    @AllArgsConstructor
    @Getter(AccessLevel.PACKAGE)
    public enum VehiclePackage {
        COMMON_FAMILIAR(CommonFamiliarVehicle.class, "Urban Family"),
        PRACTICAL_WORKERS(PracticalWorkersVehicle.class, "Hard Labourer"),
        COOL_SPORTS(CoolSportsVehicle.class, "Hot Player");

        private final Class<? extends Vehicle> clazz;

        private final String modelName;
    }
}