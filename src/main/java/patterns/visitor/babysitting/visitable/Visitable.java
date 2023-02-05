package patterns.visitor.babysitting.visitable;


import patterns.visitor.babysitting.visitor.Visitor;

public interface Visitable {

    @SuppressWarnings("unused")
    void accept(Visitor visitor);
}