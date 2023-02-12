package business;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import vehicle.CommonFamiliarVehicle;
import vehicle.CoolSportsVehicle;
import vehicle.PracticalWorkersVehicle;
import vehicle.Vehicle;

@Log4j2
@AllArgsConstructor
public class VehicleFactory {

    private Store store;

    public Vehicle getVehicle(String packName, String colour) {

        if (StringUtils.isEmpty(packName) || StringUtils.isEmpty(colour)) {
            String errorMessage = String.format("Unrecognized value for pack ame [%s] or colour [%s].", packName, colour);
            log.error(errorMessage);
            throw new UnsupportedOperationException(errorMessage);
        }
        switch (packName.toLowerCase()) {
            case "common familiar":
                return new CommonFamiliarVehicle(this.store.getModelByName("Urban Family"), colour);
            case "practical workers":
                return new PracticalWorkersVehicle(this.store.getModelByName("Hard Labourer"), colour);
            case "cool sports":
                return new CoolSportsVehicle(this.store.getModelByName("Hot Player"), colour);
            default:
                String errorMessage = String.format("Unrecognized value for pack ame [%s] or colour [%s].", packName, colour);
                log.error(errorMessage);
                throw new UnsupportedOperationException(errorMessage);
        }
    }
}