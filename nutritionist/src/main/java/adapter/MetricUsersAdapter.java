package adapter;

import patient.ImperialUnitsUser;
import patient.MetricUnitsUser;

public class MetricUsersAdapter implements ImperialUnitsUser {

    private static final float CONVERSION_FACTOR = 2.20462f;
    private final float kilograms;

    public MetricUsersAdapter(MetricUnitsUser metricUnitsUser) {
        this.kilograms = metricUnitsUser.getWeightInKilograms();
    }

    @Override
    public float getWeightInPounds() {
        return this.kilograms * CONVERSION_FACTOR;
    }
}