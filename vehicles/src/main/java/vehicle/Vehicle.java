package vehicle;

import business.PlateGenerator;
import feature.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import utils.Printer;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Vehicle {

    @NotBlank
    private String plateId;

    private Model model;

    private Colour colour;

    private DoorsCount doors;

    private List<Extra> extras;

    private Fuel fuel;

    private HorsePower horsePower;

    protected Vehicle(
            Model model,
            String colour,
            DoorsCount doorsCount,
            Extra[] extras,
            Fuel fuel,
            HorsePower horsePower) {
        this.model = model;
        this.validateConfiguration(
                Colour.valueOf(colour.toUpperCase()),
                doorsCount,
                extras,
                fuel,
                horsePower
        );
        this.plateId = PlateGenerator.generateRandomPlateId();
        this.model = model;
        this.colour = Colour.valueOf(colour.toUpperCase());
        this.doors = doorsCount;
        this.configureExtras(extras);
        this.fuel = fuel;
        this.horsePower = horsePower;
    }

    protected void configureExtras(Extra... extras) {
        this.configureExtras(Arrays.asList(extras));
    }

    protected void configureExtras(List<Extra> extrasList) {
        this.extras = new ArrayList<>(extrasList);
    }

    private float getSalesPrice() {
        return this.model.getBasePrice()
                + this.model.getStyle().getPrice()
                + this.colour.getPrice()
                + this.doors.getPrice()
                + this.getExtrasPrice()
                + this.fuel.getPrice()
                + this.horsePower.getPrice();
    }

    private float getExtrasPrice() {
        float extrasTotalPrice = 0f;
        for (Extra extra : this.extras) {
            extrasTotalPrice += extra.getPrice();
        }
        return extrasTotalPrice;
    }

    protected abstract String getFeaturesConfigurationPackName();

    protected void validateConfiguration(
            Colour colour,
            DoorsCount doorsCount,
            Extra[] extras,
            Fuel fuel,
            HorsePower horsePower) {
        this.validateColour(colour);
        this.validateDoorsCount(doorsCount);
        this.validateExtras(extras);
        this.validateFuel(fuel);
        this.validateHorsePower(horsePower);
    }

    private void validateColour(Colour colour) {
        Assert.isTrue(this.model.getAvailableColours().contains(colour),
                String.format("Colour %s is not among %s model available colours: %s",
                        colour,
                        this.model.getName(),
                        Printer.getAsString(this.model.getAvailableColours()
                        )
                )
        );
    }

    private void validateDoorsCount(DoorsCount doorsCount) {
        Assert.isTrue(this.model.getAvailableDoorsCount().contains(doorsCount),
                String.format("%s door set is not among %s model door sets available: %s",
                        doorsCount,
                        this.model.getName(),
                        Printer.getAsString(this.model.getAvailableDoorsCount()
                        )
                )
        );
    }

    private void validateExtras(Extra[] extras) {
        Arrays.stream(extras).forEach(extra ->
                Assert.isTrue(this.model.getAvailableExtras().contains(extra),
                        String.format("Extra %s is not among %s model available extras: %s",
                                extra,
                                this.model.getName(),
                                Printer.getAsString(this.model.getAvailableExtras()
                                )
                        )
                )
        );
    }

    private void validateFuel(Fuel fuel) {
        Assert.isTrue(this.model.getAvailableFuels().contains(fuel),
                String.format("Fuel %s is not among %s model available fuels: %s",
                        fuel,
                        this.model.getName(),
                        Printer.getAsString(this.model.getAvailableFuels()
                        )
                )
        );
    }

    private void validateHorsePower(HorsePower horsePower) {
        Assert.isTrue(this.model.getAvailableHorsePowers().contains(horsePower),
                String.format("Horspower %s is not among %s model available horsepowers: %s",
                        horsePower,
                        this.model.getName(),
                        Printer.getAsString(this.model.getAvailableHorsePowers()
                        )
                )
        );
    }

    @Override
    public String toString() {
        return String.format("VEHICLE:%n%-20%s%n%-20s%s%n%-20s%s%n%-15s%s [%s]%n%-15s%s%n"
                        + "%-15s%s%n%-15s%s%n%-15s%s%n%-15s%s%n",
                "Plate ID:",
                this.plateId,
                "Colour:",
                StringUtils.capitalize(this.colour.getName()),
                "Configuration pack:",
                StringUtils.capitalize(this.getFeaturesConfigurationPackName()),
                "\tModel:",
                this.model.getName(),
                StringUtils.capitalize(this.model.getStyle().getName()),
                "\tDoor set:",
                StringUtils.capitalize(this.doors.toString()),
                "\tExtras:",
                Printer.getAsString(this.extras),
                "\tFuel:",
                StringUtils.capitalize(this.fuel.getName()),
                "\tHorsepower:",
                this.horsePower.toString(),
                "\tSales price:",
                String.format("%.2f €", this.getSalesPrice()));
    }
}
