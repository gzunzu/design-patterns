package patterns.visitor.babysitting.visitable;


import lombok.AllArgsConstructor;
import patterns.visitor.babysitting.ext.Gender;

@AllArgsConstructor
public abstract class Child implements Visitable {

    protected final String name;

    protected final Gender gender;

    public String getGenderReference() {
        return this.gender.getArticledReference();
    }

    @Override
    public String toString() {
        return this.name + " es " + this.gender.getDeterminedReference();
    }
}