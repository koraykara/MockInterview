package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LeetCodeValidPath {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> graph = buildGraph(edges);
        System.out.println(graph);
        return hasPath(graph, source, destination, new HashSet<>());
    }

    // in the recursive way, source represents my current position
    public static boolean hasPath(HashMap<Integer, List<Integer>> graph, int source, int destination, HashSet<Integer> visited){
        if(visited.contains(source)) return false;
        if(source == destination) return true;
        visited.add(source);
        for(Integer neighbor: graph.get(source)){
            if(hasPath(graph, neighbor, destination, visited)) return true;
        }
        return false;
    }

    public static HashMap<Integer, List<Integer>> buildGraph(int[][] edges){
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.put(edge[0], new ArrayList<>());
            graph.put(edge[1], new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static void main(String[] args) {

        int[][] edges = {{0,1}, {0,2}, {3,5} , {5,4}, {4,3}};
        int source = 0;
        int destination = 5;

        System.out.println(validPath(3, edges, source, destination));

    }
}
