package temporal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class BabyFactory {

    static Baby getBaby(String gender, String name) {
        return switch (gender.toLowerCase()) {
            case "niño" -> new Boy(name);
            case "niña" -> new Girl(name);
            default -> null;
        };
    }
}