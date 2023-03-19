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
class PracticalWorkersVehicleTest {

    private static final String AVAILABLE_MODEL_NAME = "Hard Labourer";

    private static Model model;

    @BeforeAll
    static void setUp() {
        model = mock(Model.class);
        mockBasicModelAttributes();
    }

    @Test
    void constructorTest() {
        mockSpecificModelFeatures();
        Vehicle vehicle = new PracticalWorkersVehicle(model, "GREY");

        assertThat(vehicle)
                .isInstanceOf(PracticalWorkersVehicle.class)
                .isNotNull();
        assertThat(vehicle.getColour())
                .isEqualTo(Colour.valueOf("GREY"));
        assertThat(vehicle.getModel())
                .isEqualTo(model);
        assertThat(vehicle.getModel().getStyle())
                .isEqualTo(Style.CARGO);
        assertThat(vehicle.getModel().getBasePrice())
                .isEqualTo(14250f);
        assertThat(vehicle.getDoors())
                .isEqualTo(DoorsCount.STANDARD);
        assertThat(vehicle.getExtras())
                .hasSameElementsAs(List.of(Extra.NAVIGATION, Extra.PARKING_ASSISTANCE, Extra.AUTO_PILOT))
                .size().isEqualTo(3);
        assertThat(vehicle.getFuel())
                .isEqualTo(Fuel.HYBRID);
        assertThat(vehicle.getHorsePower())
                .isEqualTo(HorsePower.MIDDLE_HIGH);
    }

    @Test
    void getFeaturesConfigurationPackNameTest() {
        Vehicle vehicle = new PracticalWorkersVehicle(model, "GREY");

        String result = vehicle.getFeaturesConfigurationPackName();

        assertThat(result).isEqualTo("practical workers");
    }

    @Test
    void toStringTest() {
        mockSpecificModelFeatures();
        Vehicle vehicle = new PracticalWorkersVehicle(model, "GREY");

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
        when(model.getStyle()).thenReturn(Style.CARGO);
        when(model.getBasePrice()).thenReturn(14250f);
    }

    private static void mockSpecificModelFeatures() {
        when(model.getAvailableColours()).thenReturn(new ArrayList<>(List.of(Colour.BLACK,
                Colour.GREY,
                Colour.WHITE)));
        when(model.getAvailableDoorsCount()).thenReturn(new ArrayList<>(List.of(DoorsCount.STANDARD,
                DoorsCount.MULTI)));
        when(model.getAvailableExtras()).thenReturn(new ArrayList<>(List.of(Extra.AUTO_PILOT,
                Extra.EMERGENCY_BREAKING,
                Extra.NAVIGATION,
                Extra.PARKING_ASSISTANCE)));
        when(model.getAvailableFuels()).thenReturn(new ArrayList<>(List.of(Fuel.DIESEL,
                Fuel.HYBRID)));
        when(model.getAvailableHorsePowers()).thenReturn(new ArrayList<>(List.of(HorsePower.STANDARD,
                HorsePower.MIDDLE_HIGH)));
    }
}