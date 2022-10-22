package Graphs;

import java.util.HashMap;
import java.util.HashSet;

public class largestComponent {

    // n = # nodes
    // e  = # edges largestComponent
    // Time: O(e)
    // Space: O(n)
    public static int largestComponent(HashMap<Integer, int[]> graph){
        int largestComponentCount = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(Integer source: graph.keySet()){
            int numOfNodes = exploreCount(graph, source, visited);
            if(largestComponentCount < numOfNodes){
                largestComponentCount = numOfNodes;
            }
        }
        return largestComponentCount;
    }

    public static int exploreCount(HashMap<Integer, int[]> graph, int source, HashSet<Integer> visited){
        if(visited.contains(source)) return 0;
        visited.add(source);
        int size = 1;
        for(int neighbor: graph.get(source)){
            size += exploreCount(graph, neighbor, visited);
        }
        return size;
    }

    public static void main(String[] args) {
        HashMap<Integer, int[]> graph = new HashMap<>();
        graph.put(0, new int[]{8, 1, 5});
        graph.put(1, new int[]{0});
        graph.put(5, new int[]{0, 8});
        graph.put(8, new int[]{0, 5});
        graph.put(2, new int[]{3,4});
        graph.put(3, new int[]{2,4});
        graph.put(4, new int[]{3,2});

        System.out.println(largestComponent(graph));
    }
}
