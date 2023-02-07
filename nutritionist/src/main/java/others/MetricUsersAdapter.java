package others;

import patient.ImperialUnitsUser;
import patient.MetricUnitsUser;

class MetricUsersAdapter implements ImperialUnitsUser {

    private static final float CONVERSION_FACTOR = 2.20462f;
    private final float kilograms;

    MetricUsersAdapter(MetricUnitsUser metricUnitsUser) {
        this.kilograms = metricUnitsUser.getWeightInKilograms();
    }

    @Override
    public float getWeightInPounds() {
        return this.kilograms * CONVERSION_FACTOR;
    }
}