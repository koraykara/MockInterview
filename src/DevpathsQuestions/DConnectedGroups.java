package DevpathsQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DConnectedGroups {

    public static int countGroups(List<String> related){
        // Write your code here
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> graph = buildGraph(related);
        for(int source: graph.keySet()){
            if(explore(graph, source, visited)) {
                count++;
            }
        }
        return count;
    }

    public static boolean explore(HashMap<Integer, List<Integer>> graph, int source, HashSet<Integer> visited){
        if(visited.contains(source)) return false;
        visited.add(source);
        for(int neighbor: graph.get(source)){
            explore(graph, neighbor, visited);
        }
        return true;
    }

    public static HashMap<Integer, List<Integer>> buildGraph(List<String> related){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int size = related.get(0).length();

        for(int i=0;i<size;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<related.get(i).length();j++){
                if(related.get(i).charAt(j) == '1'){
                    graph.get(i).add(j);
                }
            }
        }
        return graph;
    }


    public static void main(String[] args) {
        List<String> related = new ArrayList<>();
        related.add("1100");
        related.add("1110");
        related.add("0110");
        related.add("0001");

        System.out.println(buildGraph(related));
        System.out.println(countGroups(related));

    }
}
