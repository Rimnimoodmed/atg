import java.util.ArrayList;
import java.util.HashMap;

public class Searcher {


    ArrayList<Aspect> visited = new ArrayList<>();
    ArrayList<ArrayList<Aspect>> paths = new ArrayList<>();
    ArrayList<Aspect> pasth = new ArrayList<>();
    ArrayList<Aspect> finalPath = new ArrayList<>();
    HashMap pathMap = new HashMap<>();
    
    int count = 0;

    public Searcher(){
        pathMap.put("", new ArrayList<Aspect>());
    }

    public void search(Aspect start, Aspect end){
        ArrayList<Aspect> path = new ArrayList<>();
        path.addAll(pasth);
        pasth.add(start);
        path.add(start);
        paths.add(path);
        System.out.println(paths);
        for (Aspect aspect : start.potomci) {
            search(aspect, end);
        }
    }

    public void pathSearch(Aspect start, Aspect end, String id){
        if(visited.contains(start)){
            return;
        }
        visited.add(start);
        ArrayList<Aspect> path = new ArrayList<>();
        String dadId = id.substring(0, id.length()-1);
        path = (ArrayList<Aspect>) ((ArrayList<Aspect>)(pathMap.get(dadId))).clone();
        System.out.println(path+","+id);
        path.add(start);
        System.out.println(path+","+id);
        pathMap.put(id, path);
        if (start == end){
            bakePath(id);
            return;
        }
        
        ArrayList<Aspect> related = start.potomci;
        related.addAll(start.rodice);
        for (int i = 0; i < related.size(); i++) {
            Aspect aspect = related.get(i);
            String sonId = id + i;
            pathSearch(aspect, end,sonId);
        }
    }
    
    

    private void bakePath(String id){
            System.out.println("Working Path"+pathMap.get(id));
    }
    public void search2(Aspect start, Aspect end){
        pathSearch(start,end,"0");
    }

    /*public void search(Aspect start, Aspect end){
        System.out.println("hledam z "+start.getName()+" do "+ end.getName());
        visited.add(start);
        ArrayList<Aspect> related = start.potomci;
        related.addAll(start.rodice);
        for (ArrayList<Aspect> path : paths) {
            paths.add(new ArrayList<>());
        }    

        System.out.println(paths);

        //pro mysaka chce videt
        /*ArrayList<Aspect> tempPath = new ArrayList<>();
        path.add(start);
        
        ArrayList<Aspect> related = start.potomci;
        related.addAll(start.rodice);
        for (Aspect aspect : related) {
            if (!visited.contains(aspect)) {
                tempPath.add(start);
                tempPath.add(aspect);
                paths.add(tempPath);
                tempPath = new ArrayList<>();
            }
        }
        for (ArrayList<Aspect> path : paths) {
            System.out.println(path.getLast());
        }
        System.out.println("paths "+paths);*/


        /*if (start.isRelated(end)) {
            path.add(end);
            for (int i = 1; i < path.size(); i++) {
                if (path.get(i-1).isRelated(path.get(i))) {
                    finalPath.add(path.get(i-1));
                }
            }
            finalPath.add(end);
            return finalPath;
        }
        else{
            ArrayList<Aspect> related = start.potomci;
            related.addAll(start.rodice);
            for (Aspect aspect : related) {
                if (!visited.contains(aspect)) {
                    search(aspect,end);
                }
            }
        }
    }*/


    /*public ArrayList<Aspect> search2(Aspect start, Aspect end, ArrayList<Aspect> fPath){
        System.out.println("hledam z "+start.getName()+" do "+ end.getName());
        visited.add(start);
        path.add(start);
        if (start.isRelated(end)) {
            return fPath;
        }
        else{
             ArrayList<Aspect> related = start.potomci;
             related.addAll(start.rodice);
            for (Aspect aspect : related) {
                if (!visited.contains(aspect)) {
                    fPath.add(aspect);
                    search2(aspect,end,fPath);
                    fPath.removeLast();
                    System.out.println(fPath);
                }
            }
        }
        return path;
        
    }*/
}
