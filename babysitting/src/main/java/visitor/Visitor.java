package visitor;

import visitable.Baby;
import visitable.Preschooler;
import visitable.Toddler;

public interface Visitor {
    
    String visit(Baby baby);

    String visit(Toddler toddler);

    String visit(Preschooler preschooler);
}