import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class App {
    HashMap<String,Aspect> aspectHashMap = new HashMap<>();
    public void main(String[] args) throws Exception {
//        Aspect air = new Aspect("air");
//        Aspect earth = new Aspect("earth");
//        Aspect fire = new Aspect("fire");
//        Aspect ordo = new Aspect("ordo");
//        Aspect water = new Aspect("water");
//        Aspect perditio = new Aspect("perditio");
//        Aspect energy = new Aspect(ordo, fire, "energy");
//        Aspect life = new Aspect(earth, water, "life");
//        Aspect vacuos = new Aspect(air, perditio, "vacuos");
//        Aspect steam = new Aspect(water,fire,"steam");
//        Aspect dust = new Aspect(earth, air, "dust");
//        Aspect praecanto = new Aspect(energy, vacuos, "praecanto");
        Searcher searcher = new Searcher();
        //searcher.search(energy, dust);
        loadAspectsFromFile("C:\\Users\\mouse\\IdeaProjects\\atg\\src\\Aspects.txt");
        searcher.search(aspectHashMap.get("Motus"),aspectHashMap.get("Vinculum"));
    }

    public void loadAspectsFromFile(String filePath) throws IOException {
        File aspectFile = new File(filePath);
        FileReader reader = new FileReader(aspectFile);
        List<String> aspectStrings =  reader.readAllLines();
        for (String aspectString : aspectStrings){
            String[] strings = aspectString.split(";");
            if(Objects.equals(strings[1], "Primal")){
                aspectHashMap.put(strings[0],new Aspect(strings[0]));
            }
            else {
                Aspect aspect1 = aspectHashMap.get(strings[1]);
                Aspect aspect2 = aspectHashMap.get(strings[2]);
                aspectHashMap.put(strings[0],new Aspect(aspect1,aspect2,strings[0]));
            }
        }
    }
}
