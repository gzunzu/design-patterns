package nutritionist.patient;

public abstract class Patient {

    private final String NAME;
    private String citizenship;

    public Patient(String name, String citizenship) {
        this.NAME = name;
        this.citizenship = citizenship;
    }

    public String getNAME() {
        return this.NAME;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCitizenship() {
        return this.citizenship;
    }

    @Override
    public String toString() {
        return this.NAME;
    }
    
    public String getIntroduction() {
        return "[Paciente] Me llamo " + this.NAME + ", soy " + this.citizenship + " y peso " + this.getWeightAndUnit() + ".";
    }
    
    public abstract String getWeightAndUnit();
}