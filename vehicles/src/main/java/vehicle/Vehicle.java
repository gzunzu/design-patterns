package vehicle;

import business.PlateGenerator;
import feature.*;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import utils.Printer;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public abstract class Vehicle {

    @NotBlank
    protected String plateId;

    protected Model model;

    protected float finalPrice;

    protected Colour colour;

    protected DoorsCount doors;

    protected List<Extra> extras;

    protected Fuel fuel;

    protected HorsePower horsePower;

    protected Vehicle(Model model, String colour) {
        this.plateId = PlateGenerator.generateRandomPlateId();
        this.model = model;
        this.colour = Colour.valueOf(colour.toUpperCase());
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

    @Override
    public String toString() {
        return String.format("VEHICLE:%nPlate ID: %s%nColour: %s%nConfiguration pack: %s%n\tModel: %s [%s]%n\tDoor set: %s%n"
                        + "\tExtras: %s%n\tFuel: %s%n\tHorsepower: %s%n\tSales price: %s%n",
                this.plateId,
                StringUtils.capitalize(this.colour.getName()),
                StringUtils.capitalize(this.getFeaturesConfigurationPackName()),
                this.model.getName(),
                StringUtils.capitalize(this.model.getStyle().getName()),
                StringUtils.capitalize(this.doors.toString()),
                Printer.getAsString(this.extras),
                StringUtils.capitalize(this.fuel.getName()),
                this.horsePower.toString(),
                String.format("%.2f €", this.getSalesPrice()));
    }
}
