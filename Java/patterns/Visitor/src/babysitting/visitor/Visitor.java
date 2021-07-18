package babysitting.visitor;

import babysitting.visitable.Baby;
import babysitting.visitable.Preschooler;
import babysitting.visitable.Toddler;

public interface Visitor {
    
    void visit(Baby baby);
    void visit(Toddler toddler);
    void visit(Preschooler prescholer);
}