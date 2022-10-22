package DevpathsQuestions;

import java.util.*;

public class BBAllRoadsLeadToRome {

    public static int find_rome(int n, List<List<Integer>> roads){
        if(roads.size() == 0) return -1;
        HashMap<Integer, List<Integer>> graph = buildGraph(roads);
        HashSet<Integer> visited = new HashSet<>();
        return  depthFirstPrintRecursively(graph, n, visited);
    }

    public static int returnRome(HashMap<Integer, List<Integer>> graph, int source, HashSet<Integer> visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        int rome = -1;
        while (!stack.isEmpty()){
            rome = stack.pop();
            if (graph.containsKey(rome)) {
                for (int neighbor : graph.get(rome)) {
                    stack.push(neighbor);
                }
            }
        }
        return rome;
    }

    public static int depthFirstPrintRecursively(HashMap<Integer, List<Integer>> graph, int source, HashSet<Integer> visited){
        if(visited.contains(source)) return -1;
        int rome = source;
        visited.add(rome);
        if(graph.containsKey(rome)) {
            for (int neighbor : graph.get(source)) {
                rome = depthFirstPrintRecursively(graph, neighbor, visited);
            }
        }
        return rome;
    }



    public static HashMap<Integer, List<Integer>> buildGraph(List<List<Integer>> roads){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : roads) {
            graph.put(edge.get(0), new ArrayList<>());
        }
        for (List<Integer> edge : roads) {
            graph.get(edge.get(0)).add(edge.get(1));
        }
        return graph;
    }

    public static void main(String[] args) {
        List<List<Integer>> roads = new ArrayList<>();
        List<Integer> road = new ArrayList<>();
        road.add(3);
        road.add(1);
        roads.add(road);
        road = new ArrayList<>();
        road.add(1);
        road.add(3);
        roads.add(road);

        System.out.println(roads);
        System.out.println(find_rome(1, roads));

    }
}
