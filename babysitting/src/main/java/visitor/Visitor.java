package visitor;

import visitable.Baby;
import visitable.Preschooler;
import visitable.Toddler;

public interface Visitor {

    void visit(Baby baby);

    void visit(Toddler toddler);

    void visit(Preschooler preschooler);
}