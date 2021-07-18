package babysitting.visitable;

import babysitting.visitor.Visitor;

public interface Visitable {
    
    void accept(Visitor visitor);
}