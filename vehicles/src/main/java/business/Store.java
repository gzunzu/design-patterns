package business;

import org.apache.commons.lang3.SystemUtils;
import vehicle.Model;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Store {

    private final ArrayList<Model> availableModels;

    private final ArrayList<Vehicle> vehicles;

    public Store() {
        this.availableModels = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }


    public void createModels(List<Model> modelList) {

        modelList.forEach(model ->
                this.availableModels.add(new Model.ModelBuilder(model.getName(), model.getStyle(), model.getBasePrice())
                        .setAvailableColours(model.getAvailableColours())
                        .setAvailableDoorsCount(model.getAvailableDoorsCount())
                        .setAvailableExtras(model.getAvailableExtras())
                        .setAvailableFuels(model.getAvailableFuels())
                        .setAvailableHorsePowers(model.getAvailableHorsePowers())
                        .build()
                )
        );
    }

    public void deleteModels() {
        this.availableModels.clear();
    }

    public Model getModelByName(String name) {
        Optional<Model> optionalModel = this.availableModels.stream().filter(model -> model.getName().equalsIgnoreCase(name)).findFirst();
        return optionalModel.orElseThrow();
    }

    public String showAvailableModels() {
        StringBuilder stringBuilder = new StringBuilder("These are our available models:\n\n");
        this.availableModels.forEach(model -> stringBuilder.append(model.toString()).append(SystemUtils.LINE_SEPARATOR));
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
        StringBuilder stringBuilder = new StringBuilder("These are some standardized configuration vehicles sold:\n\n");
        this.vehicles.forEach(vehicle -> stringBuilder.append(vehicle.toString()).append(SystemUtils.LINE_SEPARATOR));
        return stringBuilder.toString();
    }
}
