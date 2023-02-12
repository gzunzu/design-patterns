package vehicle;

import features.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public class Vehicle {

    @NotBlank
    private String plateId;

    @NotNull
    private Model model;

    @PositiveOrZero
    private float finalPrice;

    @NotNull
    private Colour colour;

    @NotNull
    private DoorsCount doors;

    @NotNull
    private List<Extra> extras;

    @NotNull
    private Fuel fuel;

    @NotNull
    private HorsePower horsePower;
}
