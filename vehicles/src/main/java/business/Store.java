package business;

import org.apache.commons.lang3.SystemUtils;
import utils.JsonHelper;
import vehicle.Model;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Store {

    private static final String BASE_RESOURCES_PATH = "vehicles/src/main/resources/";

    private static final ArrayList<Model> AVAILABLE_MODELS;

    static {
        AVAILABLE_MODELS = new ArrayList<>();
        createModels(JsonHelper.readJsonArrayFile(BASE_RESOURCES_PATH + "models.json", Model.class));
    }

    private final ArrayList<Vehicle> vehicles;

    public Store() {
        this.vehicles = new ArrayList<>();
    }


    public static void createModels(List<Model> modelList) {

        modelList.forEach(model ->
                AVAILABLE_MODELS.add(new Model.ModelBuilder(model.getName(), model.getStyle(), model.getBasePrice())
                        .setAvailableColours(model.getAvailableColours())
                        .setAvailableDoorsCount(model.getAvailableDoorsCount())
                        .setAvailableExtras(model.getAvailableExtras())
                        .setAvailableFuels(model.getAvailableFuels())
                        .setAvailableHorsePowers(model.getAvailableHorsePowers())
                        .build()
                )
        );
    }

    public static void deleteModels() {
        AVAILABLE_MODELS.clear();
    }

    public static Model getModelByName(String name) {
        Optional<Model> optionalModel = AVAILABLE_MODELS.stream().filter(model -> model.getName().equalsIgnoreCase(name)).findFirst();
        return optionalModel.orElseThrow();
    }

    public static String showAvailableModels() {
        StringBuilder stringBuilder = new StringBuilder("These are our available models:\n\n");
        AVAILABLE_MODELS.forEach(model -> stringBuilder.append(model.toString()).append(SystemUtils.LINE_SEPARATOR));
        return stringBuilder.toString();
    }

    public void addVehicles(Vehicle... vehicles) {
        this.addVehicles(new ArrayList<>(Arrays.asList(vehicles)));
    }

    public void addVehicles(List<Vehicle> vehicleList) {
        this.vehicles.addAll(vehicleList);
    }

    public void deleteVehicles() {
        this.vehicles.clear();
    }

    public String showVehicles() {
        StringBuilder stringBuilder = new StringBuilder("These are some standardized configuration vehicles on sale:\n\n");
        this.vehicles.forEach(vehicle -> stringBuilder.append(vehicle.toString()).append(SystemUtils.LINE_SEPARATOR));
        return stringBuilder.toString();
    }
}
