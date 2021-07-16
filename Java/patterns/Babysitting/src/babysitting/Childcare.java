package babysitting;

import babysitting.ext.Gender;
import babysitting.visitable.*;
import babysitting.visitor.Babysitter;
import java.util.ArrayList;
import java.util.Arrays;

class Childcare {

    private final Babysitter BABYSITTER = new Babysitter();
    private final ArrayList<Child> CHILDREN = new ArrayList<>();
    
    void addChildren(Child ...children) {
        Arrays.asList(children).forEach(child ->this.CHILDREN.add(child));
    }
    
    void takeCare() {
        this.CHILDREN.forEach((child) -> child.accept(this.BABYSITTER));
    }
    
    public static void main(String[] args) {
        Childcare childcare = new Childcare();
        childcare.addChildren(
                new Baby("Emma", Gender.FEMALE, 3), 
                new Toddler("Víctor", Gender.MALE, 8), 
                new Preschooler("Paula", Gender.FEMALE, 100)
        );
        childcare.takeCare();
    }
}