package babysitting;

import babysitting.ext.Gender;
import babysitting.visitable.Baby;
import babysitting.visitable.Child;
import babysitting.visitable.Preschooler;
import babysitting.visitable.Toddler;
import babysitting.visitor.Babysitter;
import java.util.ArrayList;

class Childcare {

    private final Babysitter BABYSITTER;
    private final ArrayList<Child> CHILDREN;
    
    Childcare() {
        this.BABYSITTER = new Babysitter();
        this.CHILDREN = new ArrayList<>();
    }
    
    void takeCare() {
        this.CHILDREN.forEach((child) -> child.accept(this.BABYSITTER));
    }
    
    void addChildren(Child child) {
        this.CHILDREN.add(child);
    }
    
    public static void main(String[] args) {
        Childcare childcare = new Childcare();
        
        childcare.addChildren(new Baby("Emma", Gender.F, 3));
        childcare.addChildren(new Toddler("Víctor", Gender.M, 8));
        childcare.addChildren(new Preschooler("Paula", Gender.F, 100));
        
        childcare.takeCare();
    }
}