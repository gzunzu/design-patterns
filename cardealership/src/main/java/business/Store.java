package business;

import org.apache.commons.lang3.SystemUtils;
import vehicle.Model;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final ArrayList<Model> availableModels;

    public Store() {
        this.availableModels = new ArrayList<>();
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

    public String showAvailableModels() {
        StringBuilder stringBuilder = new StringBuilder("These are our available models:\n\n");
        this.availableModels.forEach(model -> stringBuilder.append(model.toString()).append(SystemUtils.LINE_SEPARATOR));
        return stringBuilder.toString();
    }
}
