package Graphs;

import java.util.HashMap;
import java.util.HashSet;

// n = # nodes
// e = # edges
// Time: O(e)
// Space: O(n)
public class ConnectedComponentsCount {

    public static int connectedComponentCount(HashMap<Integer, int[]> graph){
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(int source: graph.keySet()){
            if(explore(graph, source, visited)) {
                count++;
            }
        }
        return count;
    }

    public static boolean explore(HashMap<Integer, int[]> graph, int source, HashSet<Integer> visited){
        if(visited.contains(source)) return false;
        visited.add(source);
        for(int neighbor: graph.get(source)){
            explore(graph, neighbor, visited);
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap<Integer, int[]> graph = new HashMap<>();
        graph.put(0, new int[]{8, 1, 5});
        graph.put(1, new int[]{0});
        graph.put(5, new int[]{0, 8});
        graph.put(8, new int[]{0, 5});
        graph.put(2, new int[]{3, 4});
        graph.put(3, new int[]{2, 4});
        graph.put(4, new int[]{3, 2});
        System.out.println(graph);
        System.out.println(connectedComponentCount(graph));
    }
}
