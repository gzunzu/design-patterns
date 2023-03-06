package business;

import feature.Colour;
import feature.DoorsCount;
import feature.Fuel;
import feature.HorsePower;
import feature.Style;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicle.Model;
import vehicle.Vehicle;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Log4j2
class StoreTest {

    private static final String AVAILABLE_MODEL_NAME = "Country Titan";

    private static Model model;

    private static Vehicle vehicle;

    private Store store;

    @BeforeAll
    static void setUp() {
        model = getMockedModel();
        vehicle = getMockedVehicle();
        Store.createModels(List.of(model));
    }

    @BeforeEach
    void init() {
        this.store = new Store();
    }

    @Test
    void constructorTest() {
        Store result = new Store();

        assertThat(result).isInstanceOf(Store.class).isNotNull();
    }

    @Test
    void createModelsTest() {
        assertThatNoException().isThrownBy(() -> {
            assertThat(Store.getModelByName(AVAILABLE_MODEL_NAME).getName()).isEqualTo(model.getName());
        });
    }

    @Test
    void deleteModelsTest() {
        Throwable throwable = catchThrowable(() -> {
            String previousResult = Store.getModelByName(AVAILABLE_MODEL_NAME).getName();

            Store.deleteModels();
            String result = Store.getModelByName(AVAILABLE_MODEL_NAME).getName();

            assertThat(previousResult).isEqualTo(model.getName());
            assertThat(result).isNull();
        });
        assertThat(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void showAvailableModelsTest() {
        assertThatNoException().isThrownBy(() -> {
            String result = Store.showAvailableModels();
            assertThat(result)
                    .contains("name")
                    .containsIgnoringCase(Style.CARGO.toString())
                    .containsIgnoringCase(Colour.BLUE.toString())
                    .containsIgnoringCase(DoorsCount.NO_TRUNK_DOOR.toString())
                    .containsIgnoringCase(Fuel.GASOLINE.toString())
                    .containsIgnoringCase(Fuel.DIESEL.toString())
                    .containsIgnoringCase(HorsePower.MIDDLE_HIGH.toString())
                    .containsIgnoringCase(HorsePower.HIGH.toString());
        });
    }

    @Test
    void getModelByNameTest() {
        assertThatNoException().isThrownBy(() -> {
            assertThat(Store.getModelByName(AVAILABLE_MODEL_NAME).getName()).isEqualTo(model.getName());
        });

        Throwable throwable = catchThrowable(() -> {
            Model nonExistingModel = Store.getModelByName("nonExisting");
            assertThat(nonExistingModel).isNull();
        });
        assertThat(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void addVehiclesTest() {
        String previousResult = this.store.showVehicles();

        assertThat(previousResult).doesNotContain("vehicle toString");

        assertThatNoException().isThrownBy(() -> {
            this.store.addVehicles(vehicle);

            String result = this.store.showVehicles();
            assertThat(result)
                    .isNotEqualTo(previousResult)
                    .contains("vehicle toString");
        });
    }

    @Test
    void deleteVehiclesTest() {
        this.store.addVehicles(vehicle);
        String previousResult = this.store.showVehicles();

        assertThatNoException().isThrownBy(() -> this.store.deleteVehicles());
        String result = this.store.showVehicles();

        assertThat(previousResult).contains(vehicle.toString());
        assertThat(result)
                .isNotEqualTo(previousResult)
                .doesNotContain(vehicle.toString());
    }

    @Test
    void showVehiclesTest() {
        String previousResult = this.store.showVehicles();
        this.store.addVehicles(vehicle);

        String result = this.store.showVehicles();

        assertThat(previousResult).doesNotContain(vehicle.toString());
        assertThat(result)
                .isNotEqualTo(previousResult)
                .contains(vehicle.toString());
    }

    private static Model getMockedModel() {
        Model mockedModel = mock(Model.class);
        when(mockedModel.getName()).thenReturn(AVAILABLE_MODEL_NAME);
        when(mockedModel.getStyle()).thenReturn(Style.CARGO);
        when(mockedModel.getBasePrice()).thenReturn(1f);
        when(mockedModel.getAvailableColours()).thenReturn(List.of(Colour.BLUE));
        when(mockedModel.getAvailableDoorsCount()).thenReturn(List.of(DoorsCount.NO_TRUNK_DOOR));
        when(mockedModel.getAvailableExtras()).thenReturn(Collections.emptyList());
        when(mockedModel.getAvailableFuels()).thenReturn(List.of(Fuel.GASOLINE, Fuel.DIESEL));
        when(mockedModel.getAvailableHorsePowers()).thenReturn(List.of(HorsePower.MIDDLE_HIGH, HorsePower.HIGH));
        return mockedModel;
    }

    private static Vehicle getMockedVehicle() {
        Vehicle mockedVehicle = mock(Vehicle.class);
        when(mockedVehicle.toString()).thenReturn("vehicle toString");
        return mockedVehicle;
    }
}