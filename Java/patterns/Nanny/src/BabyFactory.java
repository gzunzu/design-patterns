class BabyFactory {

    static Baby getBaby(String gender, String name) {
        switch (gender.toLowerCase()) {
            case "niño":
                return new Boy(name);
            case "niña":
                return new Girl(name);
            default:
                return null;
        }
    }
}