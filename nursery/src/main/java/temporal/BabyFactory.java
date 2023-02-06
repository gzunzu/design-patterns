package temporal;

class BabyFactory {

    static Baby getBaby(String gender, String name) {
        return switch (gender.toLowerCase()) {
            case "niño" -> new Boy(name);
            case "niña" -> new Girl(name);
            default -> null;
        };
    }
}