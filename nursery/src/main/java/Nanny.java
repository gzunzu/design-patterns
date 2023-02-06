import java.util.ArrayList;
import java.util.Collections;

class Nanny {

    private final ArrayList<Baby> babies = new ArrayList<>();

    private void addBabies(Baby... babies) {
        Collections.addAll(this.babies, babies);
    }

    private void takeToBathroom() {
        this.babies.forEach(baby -> System.out.println(baby.pee()));
    }

    private void letBoysSing() {
        this.babies.stream().filter(baby -> baby.getGender() == Gender.BOY).forEach(baby -> System.out.println(((Boy) baby).sing()));
    }

    private void letGirlsDraw() {
        this.babies.stream().filter(baby -> baby.getGender() == Gender.GIRL).forEach(baby -> System.out.println(((Girl) baby).draw()));
    }

    public static void main(String[] args) {
        Baby baby1 = BabyFactory.getBaby("niña", "Carla");
        Baby baby2 = BabyFactory.getBaby("niña", "Isabel");
        Baby baby3 = BabyFactory.getBaby("niño", "Roberto");
        Baby baby4 = BabyFactory.getBaby("niño", "Andrés");
        Baby baby5 = BabyFactory.getBaby("niña", "Elsa");
        Baby baby6 = BabyFactory.getBaby("niña", "Aurora");

        Nanny nanny = new Nanny();
        nanny.addBabies(baby1, baby2, baby3, baby4, baby5, baby6);

        nanny.takeToBathroom();

        nanny.letGirlsDraw();
        nanny.letBoysSing();
    }
}