package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import visitable.Baby;
import visitable.Dog;
import visitable.Preschooler;
import visitable.Toddler;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
@SuppressWarnings("java:S1948")
public class VisitableDTO implements Serializable {

    @JsonProperty("babies")
    private List<Baby> babies;

    @JsonProperty("toddlers")
    private List<Toddler> toddlers;

    @JsonProperty("preschoolers")
    private List<Preschooler> preschoolers;

    @JsonProperty("dogs")
    private List<Dog> dogs;
}
