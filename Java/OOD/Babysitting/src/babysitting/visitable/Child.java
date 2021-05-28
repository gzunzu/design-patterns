package babysitting.visitable;

import babysitting.ext.Sex;
import babysitting.visitor.Visitor;

public abstract class Child implements Visitable {
    
    protected final String NAME;
    protected final Sex SEX;

    Child(String name, Sex sex) {
        this.NAME = name;
        this.SEX = sex;
    }

    public Sex getSEX() {
        return SEX;
    }

    @Override
    public String toString() {
        return this.NAME + " es " + this.SEX.DETERMINER + " " + this.SEX.NAME;
    }
    
    @Override
    public abstract void accept(Visitor visitor);
}