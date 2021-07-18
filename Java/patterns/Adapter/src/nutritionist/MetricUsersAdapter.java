package nutritionist;

import nutritionist.patient.ImperialUnitsUser;
import nutritionist.patient.MetricUnitsUser;

class MetricUsersAdapter implements ImperialUnitsUser {

    private static final float CONVERSION_FACTOR = 2.20462f;
    private final float KILOGRAMS;
    
    MetricUsersAdapter(MetricUnitsUser metricUnitsUser) {
        this.KILOGRAMS = metricUnitsUser.getWeightInKilograms();
    }

    @Override
    public float getWeigthInPounds() {
        return this.KILOGRAMS * MetricUsersAdapter.CONVERSION_FACTOR;
    }
}