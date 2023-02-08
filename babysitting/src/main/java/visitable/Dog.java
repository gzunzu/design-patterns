package visitable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import visitor.Visitor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dog implements Visitable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("isClean")
    private boolean isClean;

    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public String bark() {
        String bark = this.isClean ? "excited for a walk." : "sadly feeling dirty.";
        return this.name + " barks " + bark;
    }

    public void bath() {
        this.isClean = true;
    }

    public String walk() {
        return this.name + " enjoys running outside.";
    }

    @Override
    public String toString() {
        return this.name + " is a " + (this.isClean ? "clean" : "dirty") + " dog. ";
    }
}