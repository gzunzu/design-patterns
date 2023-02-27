package cocktails;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Step {

    private final Ingredient ingredient;

    private final float amount;

    private final int stepOrder;
}
