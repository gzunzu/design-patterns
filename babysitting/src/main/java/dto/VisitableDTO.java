package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import visitable.Baby;
import visitable.Dog;
import visitable.Preschooler;
import visitable.Toddler;
import visitable.Visitable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@SuppressWarnings("java:S1948")
public class VisitableDTO implements Serializable {

    @JsonProperty("babies")
    private List<Baby> babies;

    @JsonProperty("dogs")
    private List<Dog> dogs;

    @JsonProperty("preschoolers")
    private List<Preschooler> preschoolers;

    @JsonProperty("toddlers")
    private List<Toddler> toddlers;

    public List<Visitable> getVisitables() {
        ArrayList<Visitable> visitables = new ArrayList<>();
        visitables.addAll(this.babies);
        visitables.addAll(this.dogs);
        visitables.addAll(this.preschoolers);
        visitables.addAll(this.toddlers);
        return visitables;
    }
}
