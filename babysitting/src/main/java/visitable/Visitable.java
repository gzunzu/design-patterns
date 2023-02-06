package visitable;

import visitor.Visitor;

public interface Visitable {

    @SuppressWarnings("unused")
    void accept(Visitor visitor);
}