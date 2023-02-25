package visitable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import utils.Gender;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Child implements Visitable {

    @JsonProperty("name")
    protected String name;

    @Getter
    @JsonProperty("gender")
    protected Gender gender;

    @Override
    public String toString() {
        return this.name + " is a " + this.gender.getName() + ".";
    }
}