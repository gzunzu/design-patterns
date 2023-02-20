package vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import feature.*;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import utils.Printer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Model {

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

    public Model(ModelBuilder modelBuilder) {
        this.name = modelBuilder.getName();
        this.style = modelBuilder.getStyle();
        this.basePrice = modelBuilder.getBasePrice();
        this.availableColours = modelBuilder.getAvailableColours();
        this.availableDoorsCount = modelBuilder.getAvailableDoorsCount();
        this.availableExtras = modelBuilder.getAvailableExtras();
        this.availableFuels = modelBuilder.getAvailableFuels();
        this.availableHorsePowers = modelBuilder.getAvailableHorsePowers();
    }

    @Override
    public String toString() {
        return String.format("Model name: %s%nStyle: %s%nAvailable colours: %s%nAvailable doors set: %s%n"
                        + "Available extras: %s%nAvailable fuels: %s%nAvailable horsepowers: %s%n",
                this.name,
                StringUtils.capitalize(this.style.toString()),
                Printer.getAsString(this.availableColours),
                Printer.getAsString(this.availableDoorsCount),
                Printer.getAsString(this.availableExtras),
                Printer.getAsString(this.availableFuels),
                Printer.getAsString(this.availableHorsePowers)
        );
    }

    @SuppressWarnings("unused")
    @Getter(AccessLevel.PRIVATE)
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

        public ModelBuilder(String name, Style style, float basePrice) {
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

        public ModelBuilder addAvailableColours(Colour... colours) {
            return this.addAvailableColours(Arrays.asList(colours));
        }

        public ModelBuilder addAvailableColours(List<Colour> colourList) {
            this.availableColours.addAll(colourList);
            return this;
        }

        public ModelBuilder setAvailableDoorsCount(DoorsCount... doorsCounts) {
            return this.setAvailableDoorsCount(Arrays.asList(doorsCounts));
        }

        public ModelBuilder setAvailableDoorsCount(List<DoorsCount> doorsCountList) {
            this.availableDoorsCount = new ArrayList<>(doorsCountList);
            return this;
        }

        public ModelBuilder addAvailableDoorsCount(DoorsCount... doorsCounts) {
            return this.addAvailableDoorsCount(Arrays.asList(doorsCounts));
        }

        public ModelBuilder addAvailableDoorsCount(List<DoorsCount> doorsCountList) {
            this.availableDoorsCount.addAll(doorsCountList);
            return this;
        }

        public ModelBuilder setAvailableExtras(Extra... extras) {
            return this.setAvailableExtras(Arrays.asList(extras));
        }

        public ModelBuilder setAvailableExtras(List<Extra> extraList) {
            this.availableExtras = new ArrayList<>(extraList);
            return this;
        }

        public ModelBuilder addAvailableExtras(Extra... extras) {
            return this.addAvailableExtras(Arrays.asList(extras));
        }

        public ModelBuilder addAvailableExtras(List<Extra> extraList) {
            this.availableExtras.addAll(extraList);
            return this;
        }

        public ModelBuilder setAvailableFuels(Fuel... fuels) {
            return this.setAvailableFuels(Arrays.asList(fuels));
        }

        public ModelBuilder setAvailableFuels(List<Fuel> fuelList) {
            this.availableFuels = new ArrayList<>(fuelList);
            return this;
        }

        public ModelBuilder addAvailableFuels(Fuel... fuels) {
            return this.addAvailableFuels(Arrays.asList(fuels));
        }

        public ModelBuilder addAvailableFuels(List<Fuel> fuelList) {
            this.availableFuels.addAll(fuelList);
            return this;
        }

        public ModelBuilder setAvailableHorsePowers(HorsePower... horsePowers) {
            return this.setAvailableHorsePowers(Arrays.asList(horsePowers));
        }

        public ModelBuilder setAvailableHorsePowers(List<HorsePower> horsePowers) {
            this.availableHorsePowers = new ArrayList<>(horsePowers);
            return this;
        }

        public ModelBuilder addAvailableHorsePowers(HorsePower... horsePowers) {
            return this.addAvailableHorsePowers(Arrays.asList(horsePowers));
        }

        public ModelBuilder addAvailableHorsePowers(List<HorsePower> horsePowers) {
            this.availableHorsePowers.addAll(horsePowers);
            return this;
        }

        public Model build() {
            return new Model(this);
        }
    }
}