package visitable;

import visitor.Visitor;

public interface Visitable {

    @SuppressWarnings("unused")
    String accept(Visitor visitor);
}