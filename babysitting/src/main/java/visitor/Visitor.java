package visitor;

import visitable.Baby;
import visitable.Dog;
import visitable.Preschooler;
import visitable.Toddler;

public interface Visitor {

    String visit(Baby baby);

    String visit(Toddler toddler);

    String visit(Preschooler preschooler);

    String visit(Dog dog);
}