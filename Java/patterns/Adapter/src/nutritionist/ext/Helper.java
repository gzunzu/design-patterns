package nutritionist.ext;

public class Helper {

    public static float getRandomPoundsWeight() {
        float min = 100, max = 350;
        return (float) ((Math.random() * (max - min)) + min);
    }
    
    public static float getRandomKilogramsWeight() {
        float min = 45, max = 160;
        return (float) ((Math.random() * (max - min)) + min);
    }
}