package patterns.visitor.babysitting.visitable;


import patterns.visitor.babysitting.ext.Gender;
import patterns.visitor.babysitting.visitor.Visitor;

public abstract class Child implements Visitable {

    protected final String NAME;
    protected final Gender GENDER;

    Child(String name, Gender gender) {
        this.NAME = name;
        this.GENDER = gender;
    }

    public String getGenderReference() {
        return this.GENDER.getArticledReference();
    }

    @Override
    public String toString() {
        return this.NAME + " es " + this.GENDER.getDeterminedReference();
    }

    @Override
    public abstract void accept(Visitor visitor);
}