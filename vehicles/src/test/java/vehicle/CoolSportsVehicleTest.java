package vehicle;

import feature.Colour;
import feature.DoorsCount;
import feature.Extra;
import feature.Fuel;
import feature.HorsePower;
import feature.Style;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CoolSportsVehicleTest {

    private static final String AVAILABLE_MODEL_NAME = "Hot Player";

    private static Model model;

    @BeforeAll
    static void setUp() {
        model = mock(Model.class);
        mockBasicModelAttributes();
    }

    @Test
    void constructorTest() {
        mockSpecificModelFeatures();
        Vehicle vehicle = new CoolSportsVehicle(model, "RED");

        assertThat(vehicle)
                .isInstanceOf(CoolSportsVehicle.class)
                .isNotNull();
        assertThat(vehicle.getColour())
                .isEqualTo(Colour.valueOf("RED"));
        assertThat(vehicle.getModel())
                .isEqualTo(model);
        assertThat(vehicle.getModel().getStyle())
                .isEqualTo(Style.CONVERTIBLE);
        assertThat(vehicle.getModel().getBasePrice())
                .isEqualTo(23800f);
        assertThat(vehicle.getDoors())
                .isEqualTo(DoorsCount.NO_TRUNK_DOOR);
        assertThat(vehicle.getExtras())
                .hasSameElementsAs(List.of(Extra.NAVIGATION,
                        Extra.STEREO))
                .size().isEqualTo(2);
        assertThat(vehicle.getFuel())
                .isEqualTo(Fuel.GASOLINE);
        assertThat(vehicle.getHorsePower())
                .isEqualTo(HorsePower.SUPER);
    }

    @Test
    void getFeaturesConfigurationPackNameTest() {
        Vehicle vehicle = new CoolSportsVehicle(model, "RED");

        String result = vehicle.getFeaturesConfigurationPackName();

        assertThat(result).isEqualTo("cool sports");
    }

    @Test
    void toStringTest() {
        mockSpecificModelFeatures();
        Vehicle vehicle = new CoolSportsVehicle(model, "RED");

        String result = vehicle.toString();

        assertThat(result)
                .containsSubsequence(
                        vehicle.getPlateId(),
                        StringUtils.capitalize(vehicle.getColour().toString()),
                        StringUtils.capitalize(vehicle.getFeaturesConfigurationPackName()),
                        model.getName(),
                        StringUtils.capitalize(model.getStyle().getName()),
                        StringUtils.capitalize(vehicle.getDoors().toString()),
                        TextUtils.getListAsPrettyString(vehicle.getExtras()),
                        StringUtils.capitalize(vehicle.getFuel().getName()),
                        vehicle.getHorsePower().toString());
    }

    private static void mockBasicModelAttributes() {
        when(model.getName()).thenReturn(AVAILABLE_MODEL_NAME);
        when(model.getStyle()).thenReturn(Style.CONVERTIBLE);
        when(model.getBasePrice()).thenReturn(23800f);
    }

    private static void mockSpecificModelFeatures() {
        when(model.getAvailableColours()).thenReturn(new ArrayList<>(List.of(Colour.BLACK,
                Colour.BLUE,
                Colour.ORANGE,
                Colour.RED,
                Colour.YELLOW)));
        when(model.getAvailableDoorsCount()).thenReturn(new ArrayList<>(List.of(DoorsCount.NO_TRUNK_DOOR)));
        when(model.getAvailableExtras()).thenReturn(new ArrayList<>(List.of(Extra.AUTO_PILOT,
                Extra.EMERGENCY_BREAKING,
                Extra.LIGHTER,
                Extra.NAVIGATION,
                Extra.OFFTRACK_DETECTION,
                Extra.PARKING_ASSISTANCE,
                Extra.STEREO)));
        when(model.getAvailableFuels()).thenReturn(new ArrayList<>(List.of(Fuel.DIESEL,
                Fuel.GASOLINE)));
        when(model.getAvailableHorsePowers()).thenReturn(new ArrayList<>(List.of(HorsePower.HIGH,
                HorsePower.SUPER,
                HorsePower.ULTRA)));
    }
}