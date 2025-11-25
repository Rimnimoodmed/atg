import java.util.ArrayList;

public class Aspect {
    ArrayList<Aspect> potomci = new ArrayList<>();
    ArrayList<Aspect> rodice = new ArrayList<>();
    String name;

    public Aspect(String primaryName) {
        this.name = primaryName;
    }

    public Aspect(Aspect asp1, Aspect asp2, String primaryName){
        this.name = primaryName;
        this.rodice.add(asp2);
        this.rodice.add(asp1);
        asp1.addPotomek(this);
        asp2.addPotomek(this);
    }

    public void addPotomek(Aspect aspect){
        this.potomci.add(aspect);
    }

    public ArrayList<Aspect> getPotomci() {
        return potomci;
    }
    
    public ArrayList<Aspect> getRodice() {
        return rodice;
    }

    public String getName() {
        return name;
    }
    
    public boolean isRelated(Aspect asp){
        for (Aspect aspect : potomci) {
            if (asp.getName() == aspect.getName()) {
                //System.out.println("ptomelk");
                return true;
            }
        }
        for (Aspect aspect : rodice) {
            if (asp.getName() == aspect.getName()) {
                //System.out.println("roduc");
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

}
