import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Aspect air = new Aspect("air");
        Aspect earth = new Aspect("earth");
        Aspect fire = new Aspect("fire");
        Aspect ordo = new Aspect("ordo");
        Aspect water = new Aspect("water");
        Aspect perditio = new Aspect("perditio");
        Aspect energy = new Aspect(ordo, fire, "energy");
        Aspect life = new Aspect(earth, water, "life");
        Aspect vacuos = new Aspect(air, perditio, "vacuos");
        Aspect steam = new Aspect(water,fire,"steam");
        Aspect dust = new Aspect(earth, air, "dust");
        Aspect praecanto = new Aspect(energy, vacuos, "praecanto");
        Searcher searcher = new Searcher();
        //searcher.search(energy, dust);
        searcher.search2(fire, dust);
    }
}
