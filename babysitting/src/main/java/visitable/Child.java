package visitable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import utils.Gender;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Child implements Visitable {

    @JsonProperty("name")
    protected String name;

    @JsonProperty("gender")
    protected Gender gender;

    @Override
    public String toString() {
        return this.name + " is a " + this.gender.getName() + ".";
    }
}