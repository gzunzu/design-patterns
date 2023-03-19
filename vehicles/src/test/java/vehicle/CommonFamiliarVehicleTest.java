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
class CommonFamiliarVehicleTest {

    private static final String AVAILABLE_MODEL_NAME = "Urban Family";

    private static Model model;

    @BeforeAll
    static void setUp() {
        model = mock(Model.class);
        mockBasicModelAttributes();
    }

    @Test
    void constructorTest() {
        mockSpecificModelFeatures();
        CommonFamiliarVehicle commonFamiliarVehicle = new CommonFamiliarVehicle(model, "BLACK");

        assertThat(commonFamiliarVehicle)
                .isInstanceOf(CommonFamiliarVehicle.class)
                .isNotNull();
        assertThat(commonFamiliarVehicle.getColour())
                .isEqualTo(Colour.valueOf("BLACK"));
        assertThat(commonFamiliarVehicle.getModel())
                .isEqualTo(model);
        assertThat(commonFamiliarVehicle.getModel().getStyle())
                .isEqualTo(Style.SUV);
        assertThat(commonFamiliarVehicle.getModel().getBasePrice())
                .isEqualTo(12600f);
        assertThat(commonFamiliarVehicle.getDoors())
                .isEqualTo(DoorsCount.STANDARD);
        assertThat(commonFamiliarVehicle.getExtras())
                .hasSameElementsAs(List.of(Extra.NAVIGATION, Extra.PARKING_ASSISTANCE))
                .size().isEqualTo(2);
        assertThat(commonFamiliarVehicle.getFuel())
                .isEqualTo(Fuel.DIESEL);
        assertThat(commonFamiliarVehicle.getHorsePower())
                .isEqualTo(HorsePower.STANDARD);
    }

    @Test
    void getFeaturesConfigurationPackNameTest() {
        Vehicle vehicle = new CommonFamiliarVehicle(model, "BLACK");

        String result = vehicle.getFeaturesConfigurationPackName();

        assertThat(result).isEqualTo("common familiar");
    }

    @Test
    void toStringTest() {
        mockSpecificModelFeatures();
        Vehicle vehicle = new CommonFamiliarVehicle(model, "BLACK");

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
        when(model.getStyle()).thenReturn(Style.SUV);
        when(model.getBasePrice()).thenReturn(12600f);
    }

    private static void mockSpecificModelFeatures() {
        when(model.getAvailableColours()).thenReturn(new ArrayList<>(List.of(Colour.BLACK,
                Colour.BLUE,
                Colour.GREEN,
                Colour.ORANGE,
                Colour.RED,
                Colour.WHITE,
                Colour.YELLOW)));
        when(model.getAvailableDoorsCount()).thenReturn(new ArrayList<>(List.of(DoorsCount.STANDARD,
                DoorsCount.MULTI)));
        when(model.getAvailableExtras()).thenReturn(new ArrayList<>(List.of(Extra.AUTO_PILOT,
                Extra.EMERGENCY_BREAKING,
                Extra.NAVIGATION,
                Extra.PARKING_ASSISTANCE,
                Extra.STEREO)));
        when(model.getAvailableFuels()).thenReturn(new ArrayList<>(List.of(Fuel.DIESEL,
                Fuel.ELECTRIC,
                Fuel.HYBRID)));
        when(model.getAvailableHorsePowers()).thenReturn(new ArrayList<>(List.of(HorsePower.BASIC,
                HorsePower.STANDARD,
                HorsePower.MIDDLE_HIGH)));
    }
}