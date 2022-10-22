package Graphs;


import java.util.*;

public class ShortestPath {

    public static int findShortestPath(char[][] edges, char source, char destination){
        int shortest = 0;
        HashMap<Character, List<Character>> graph = buildGraph(edges);
        Queue<Character> queue = new LinkedList<>();

        return shortest;
    }

    public static HashMap<Character, List<Character>> buildGraph(char[][] edges){
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            graph.put(edges[i][0], new ArrayList<>());
            graph.put(edges[i][1], new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        char[][] edges = {{'w', 'x'}, {'x', 'y'}, {'z', 'y'}, {'z', 'v'}, {'w', 'v'}};

        System.out.println(buildGraph(edges));

        System.out.println(findShortestPath(edges, 'w', 'z'));
    }
}
