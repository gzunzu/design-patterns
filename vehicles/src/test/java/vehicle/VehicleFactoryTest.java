package vehicle;

import business.Store;
import feature.Colour;
import feature.DoorsCount;
import feature.Extra;
import feature.Fuel;
import feature.HorsePower;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.JsonHelper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Log4j2
class VehicleFactoryTest {

    @BeforeAll
    static void setUp() {
        Store.deleteModels();
        Store.createModels(JsonHelper.readJsonArrayFile("src/test/resources/models.json", Model.class));
    }

    @Test
    void getVehicleWithValidColourTest() {
        Vehicle result = VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COMMON_FAMILIAR, "BLACK");

        assertThat(result)
                .isInstanceOf(CommonFamiliarVehicle.class)
                .isNotNull();
        assertThat(result.getColour())
                .isEqualTo(Colour.BLACK);
    }

    @Test
    void getVehicleWithNullPackage() {
        assertThatNoException().isThrownBy(() -> {
            Vehicle result = VehicleFactory.getVehicle(null, "WHITE");
            assertThat(result).isNull();
        });
    }

    @Test
    void getVehicleWithNullColourTest() {
        assertThatNoException().isThrownBy(() -> {
            Vehicle result = VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.PRACTICAL_WORKERS, null);
            assertThat(result).isNull();
        });
    }

    @Test
    void getVehicleNonExistentColourTest() {
        assertThatNoException().isThrownBy(() -> {
            Vehicle result = VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COOL_SPORTS, "NONEXISTENT");
            assertThat(result).isNull();
        });
    }

    @Test
    void getVehicleNonAvailableColourTest() {
        assertThatNoException().isThrownBy(() -> {
            Vehicle result = VehicleFactory.getVehicle(VehicleFactory.VehiclePackage.COOL_SPORTS, "PURPLE");
            assertThat(result).isNull();
        });
    }

    @Test
    void getVehicleNoSuchMethodExceptionTest() {
        VehicleFactory.VehiclePackage nonValidVehiclePackage = mock(VehicleFactory.VehiclePackage.class);
        Class nonValidVehicleInheritor = NonValidConstructorVehicleInheritor.class;
        when(nonValidVehiclePackage.getClazz()).thenReturn(nonValidVehicleInheritor);

        assertThatNoException().isThrownBy(() -> {
            Vehicle result = VehicleFactory.getVehicle(nonValidVehiclePackage, "PURPLE");
            assertThat(result).isNull();
        });
    }

    /**
     * Created just to be used under the NoSuchMethodException exception test.
     */
    static class NonValidConstructorVehicleInheritor extends Vehicle {

        protected NonValidConstructorVehicleInheritor(Model model, String colour, DoorsCount doorsCount, Extra[] extras, Fuel fuel, HorsePower horsePower) {
            super(model, colour, doorsCount, extras, fuel, horsePower);
        }

        @Override
        protected String getFeaturesConfigurationPackName() {
            return null;
        }
    }
}