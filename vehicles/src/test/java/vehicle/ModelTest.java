package vehicle;

import feature.Colour;
import feature.DoorsCount;
import feature.Extra;
import feature.Fuel;
import feature.HorsePower;
import feature.Style;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModelTest {

    @Test
    void constructorWithNoArgsTest() {
        Model model = new Model();
        assertThat(model)
                .isInstanceOf(Model.class)
                .isNotNull();
    }

    @Test
    void constructorWithArgsTest() {
        Style style = mock(Style.class);
        Model model = Model.builder("name", style, 0f).build();
        assertThat(model)
                .isInstanceOf(Model.class)
                .isNotNull();
        assertThat(model.getName()).isEqualTo("name");
        assertThat(model.getStyle()).isEqualTo(style);
        assertThat(model.getBasePrice()).isEqualTo(0f);
    }

    @Test
    void toStringTest() {
        Colour colour = mock(Colour.class);
        when(colour.toString()).thenReturn("colour");
        DoorsCount doorsCount = mock(DoorsCount.class);
        when(doorsCount.toString()).thenReturn("doors count");
        Extra extra = mock(Extra.class);
        when(extra.toString()).thenReturn("extra");
        Fuel fuel = mock(Fuel.class);
        when(fuel.toString()).thenReturn("fuel");
        HorsePower horsePower = mock(HorsePower.class);
        when(horsePower.toString()).thenReturn("horse power");

        Model model = this.getModelBuilder()
                .setAvailableColours(List.of(colour))
                .setAvailableDoorsCount(List.of(doorsCount))
                .setAvailableExtras(List.of(extra))
                .setAvailableFuels(List.of(fuel))
                .setAvailableHorsePowers(List.of(horsePower))
                .build();

        String result = model.toString();

        assertThat(result).contains("name", "Colour", "Doors count", "Extra", "Fuel", "Horse power");
    }

    @Test
    void getNameTest() {
        Model model = this.getModelBuilder().build();
        String result = model.getName();

        assertThat(result).isEqualTo("name");
    }

    @Test
    void getStyleTest() {
        Style style = mock(Style.class);
        Model model = Model.builder("name", style, 0f).build();
        Style result = model.getStyle();

        assertThat(result).isEqualTo(style);
    }

    @Test
    void getBasePriceTest() {
        Model model = this.getModelBuilder().build();
        float result = model.getBasePrice();

        assertThat(result).isEqualTo(0f);
    }

    @Test
    void getAvailableColoursTest() {
        Colour colour = mock(Colour.class);
        Model model = this.getModelBuilder()
                .setAvailableColours(colour)
                .build();

        List<Colour> result = model.getAvailableColours();

        assertThat(result)
                .contains(colour)
                .size().isEqualTo(1);
    }

    @Test
    void getAvailableDoorsCountTest() {
        DoorsCount doorsCount = mock(DoorsCount.class);
        Model model = this.getModelBuilder()
                .setAvailableDoorsCount(doorsCount)
                .build();

        List<DoorsCount> result = model.getAvailableDoorsCount();

        assertThat(result)
                .contains(doorsCount)
                .size().isEqualTo(1);
    }

    @Test
    void getAvailableExtrasTest() {
        Extra extra = mock(Extra.class);
        Model model = this.getModelBuilder()
                .setAvailableExtras(extra)
                .build();

        List<Extra> result = model.getAvailableExtras();

        assertThat(result)
                .contains(extra)
                .size().isEqualTo(1);
    }

    @Test
    void getAvailableFuelsTest() {
        Fuel fuel = mock(Fuel.class);
        Model model = this.getModelBuilder()
                .setAvailableFuels(fuel)
                .build();

        List<Fuel> result = model.getAvailableFuels();

        assertThat(result)
                .contains(fuel)
                .size().isEqualTo(1);
    }

    @Test
    void getAvailableHorsePowersTest() {
        HorsePower horsePower = mock(HorsePower.class);
        Model model = this.getModelBuilder()
                .setAvailableHorsePowers(horsePower)
                .build();

        List<HorsePower> result = model.getAvailableHorsePowers();

        assertThat(result)
                .contains(horsePower)
                .size().isEqualTo(1);
    }

    @Test
    void setAvailableColoursArrayTest() {
        Colour colour1 = mock(Colour.class);
        Colour colour2 = mock(Colour.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableColours(colour1, colour2);
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableColours())
                .hasSameElementsAs(List.of(colour1, colour2))
                .size().isEqualTo(2);
    }

    @Test
    void setAvailableColoursListTest() {
        Colour colour1 = mock(Colour.class);
        Colour colour2 = mock(Colour.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableColours(List.of(colour1, colour2));
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableColours())
                .hasSameElementsAs(List.of(colour1, colour2))
                .size().isEqualTo(2);
    }

    @Test
    void setAvailableDoorsCountArrayTest() {
        DoorsCount doorsCount1 = mock(DoorsCount.class);
        DoorsCount doorsCount2 = mock(DoorsCount.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableDoorsCount(doorsCount1, doorsCount2);
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableDoorsCount())
                .hasSameElementsAs(List.of(doorsCount1, doorsCount2))
                .size().isEqualTo(2);
    }

    @Test
    void setAvailableDoorsCountListTest() {
        DoorsCount doorsCount1 = mock(DoorsCount.class);
        DoorsCount doorsCount2 = mock(DoorsCount.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableDoorsCount(List.of(doorsCount1, doorsCount2));
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableDoorsCount())
                .hasSameElementsAs(List.of(doorsCount1, doorsCount2))
                .size().isEqualTo(2);
    }

    @Test
    void setAvailableExtrasArrayTest() {
        Extra extra1 = mock(Extra.class);
        Extra extra2 = mock(Extra.class);
        Extra extra3 = mock(Extra.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableExtras(extra1, extra2, extra3);
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableExtras())
                .hasSameElementsAs(List.of(extra1, extra2, extra3))
                .size().isEqualTo(3);
    }

    @Test
    void setAvailableExtrasListTest() {
        Extra extra1 = mock(Extra.class);
        Extra extra2 = mock(Extra.class);
        Extra extra3 = mock(Extra.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableExtras(List.of(extra1, extra2, extra3));
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableExtras())
                .hasSameElementsAs(List.of(extra1, extra2, extra3))
                .size().isEqualTo(3);
    }

    @Test
    void setAvailableFuelsArrayTest() {
        Fuel fuel1 = mock(Fuel.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableFuels(fuel1);
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableFuels())
                .hasSameElementsAs(List.of(fuel1))
                .size().isEqualTo(1);
    }

    @Test
    void setAvailableFuelsListTest() {
        Fuel fuel1 = mock(Fuel.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableFuels(List.of(fuel1));
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableFuels())
                .hasSameElementsAs(List.of(fuel1))
                .size().isEqualTo(1);
    }

    @Test
    void setAvailableDHorsePowersArrayTest() {
        HorsePower horsePower1 = mock(HorsePower.class);
        HorsePower horsePower2 = mock(HorsePower.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableHorsePowers(horsePower1, horsePower2);
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableHorsePowers())
                .hasSameElementsAs(List.of(horsePower1, horsePower2))
                .size().isEqualTo(2);
    }

    @Test
    void setAvailableDHorsePowersListTest() {
        HorsePower horsePower1 = mock(HorsePower.class);
        HorsePower horsePower2 = mock(HorsePower.class);
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model.ModelBuilder result = modelBuilder.setAvailableHorsePowers(List.of(horsePower1, horsePower2));
        Model model = modelBuilder.build();

        assertThat(result).isEqualTo(modelBuilder);
        assertThat(model.getAvailableHorsePowers())
                .hasSameElementsAs(List.of(horsePower1, horsePower2))
                .size().isEqualTo(2);
    }

    @Test
    void buildTest() {
        Model.ModelBuilder modelBuilder = this.getModelBuilder();

        Model result = modelBuilder.build();

        assertThat(result)
                .isInstanceOf(Model.class)
                .isNotNull();
    }

    private Model.ModelBuilder getModelBuilder() {
        return Model.builder("name", mock(Style.class), 0f);
    }
}