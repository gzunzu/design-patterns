package vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import feature.Colour;
import feature.DoorsCount;
import feature.Extra;
import feature.Fuel;
import feature.HorsePower;
import feature.Style;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import utils.TextUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Getter
public final class Model {

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotBlank
    @JsonProperty("style")
    private Style style;

    @PositiveOrZero
    @JsonProperty("basePrice")
    private float basePrice;

    @NotNull
    @JsonProperty("availableColours")
    private List<Colour> availableColours;

    @NotNull
    @JsonProperty("availableDoorsCount")
    private List<DoorsCount> availableDoorsCount;

    @NotNull
    @JsonProperty("availableExtras")
    private List<Extra> availableExtras;

    @NotNull
    @JsonProperty("availableFuels")
    private List<Fuel> availableFuels;

    @NotNull
    @JsonProperty("availableHorsePowers")
    private List<HorsePower> availableHorsePowers;

    private Model(final @NotNull ModelBuilder modelBuilder) {
        this.name = modelBuilder.name;
        this.style = modelBuilder.style;
        this.basePrice = modelBuilder.basePrice;
        this.availableColours = modelBuilder.availableColours;
        this.availableDoorsCount = modelBuilder.availableDoorsCount;
        this.availableExtras = modelBuilder.availableExtras;
        this.availableFuels = modelBuilder.availableFuels;
        this.availableHorsePowers = modelBuilder.availableHorsePowers;
    }

    public static ModelBuilder builder(final String name, final Style style, final float basePrice) {
        return new ModelBuilder(name, style, basePrice);
    }

    @Override
    public String toString() {
        return String.format("Model name: %s%nStyle: %s%nAvailable colours: %s%nAvailable doors set: %s%n"
                        + "Available extras: %s%nAvailable fuels: %s%nAvailable horsepowers: %s%n",
                this.name,
                StringUtils.capitalize(this.style.toString()),
                TextUtils.getListAsPrettyString(this.availableColours),
                TextUtils.getListAsPrettyString(this.availableDoorsCount),
                TextUtils.getListAsPrettyString(this.availableExtras),
                TextUtils.getListAsPrettyString(this.availableFuels),
                TextUtils.getListAsPrettyString(this.availableHorsePowers)
        );
    }

    public static class ModelBuilder {

        @NotBlank
        private final String name;

        @NotNull
        private final Style style;

        @PositiveOrZero
        private final float basePrice;

        @NotNull
        private List<Colour> availableColours;

        @NotNull
        private List<DoorsCount> availableDoorsCount;

        @NotNull
        private List<Extra> availableExtras;

        @NotNull
        private List<Fuel> availableFuels;

        @NotNull
        private List<HorsePower> availableHorsePowers;

        private ModelBuilder(String name, Style style, float basePrice) {
            this.name = name;
            this.style = style;
            this.basePrice = basePrice;
            this.availableColours = new ArrayList<>();
            this.availableDoorsCount = new ArrayList<>();
            this.availableExtras = new ArrayList<>();
            this.availableFuels = new ArrayList<>();
            this.availableHorsePowers = new ArrayList<>();
        }

        public ModelBuilder setAvailableColours(Colour... colours) {
            return this.setAvailableColours(Arrays.asList(colours));
        }

        public ModelBuilder setAvailableColours(List<Colour> colourList) {
            this.availableColours = new ArrayList<>(colourList);
            return this;
        }

        public ModelBuilder setAvailableDoorsCount(DoorsCount... doorsCounts) {
            return this.setAvailableDoorsCount(Arrays.asList(doorsCounts));
        }

        public ModelBuilder setAvailableDoorsCount(List<DoorsCount> doorsCountList) {
            this.availableDoorsCount = new ArrayList<>(doorsCountList);
            return this;
        }

        public ModelBuilder setAvailableExtras(Extra... extras) {
            return this.setAvailableExtras(Arrays.asList(extras));
        }

        public ModelBuilder setAvailableExtras(List<Extra> extraList) {
            this.availableExtras = new ArrayList<>(extraList);
            return this;
        }

        public ModelBuilder setAvailableFuels(Fuel... fuels) {
            return this.setAvailableFuels(Arrays.asList(fuels));
        }

        public ModelBuilder setAvailableFuels(List<Fuel> fuelList) {
            this.availableFuels = new ArrayList<>(fuelList);
            return this;
        }

        public ModelBuilder setAvailableHorsePowers(HorsePower... horsePowers) {
            return this.setAvailableHorsePowers(Arrays.asList(horsePowers));
        }

        public ModelBuilder setAvailableHorsePowers(List<HorsePower> horsePowers) {
            this.availableHorsePowers = new ArrayList<>(horsePowers);
            return this;
        }

        public Model build() {
            return new Model(this);
        }
    }
}