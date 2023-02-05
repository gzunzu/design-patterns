package patterns.adapter.nutritionist;


import patterns.adapter.nutritionist.patient.ImperialUnitsUser;
import patterns.adapter.nutritionist.patient.MetricUnitsUser;

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