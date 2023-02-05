package patterns.visitor.babysitting.visitor;

import patterns.visitor.babysitting.visitable.Baby;
import patterns.visitor.babysitting.visitable.Preschooler;
import patterns.visitor.babysitting.visitable.Toddler;

public interface Visitor {

    void visit(Baby baby);

    void visit(Toddler toddler);

    void visit(Preschooler preschooler);
}