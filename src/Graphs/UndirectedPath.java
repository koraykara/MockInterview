package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UndirectedPath {

    public static boolean undirectedPath(char[][] edges, char source, char destination){
        HashMap<Character, List<Character>> graph = buildGraph(edges);
        System.out.println(graph);
        return hasPath(graph, source, destination, new HashSet<>());
    }

    // in the recursive way, source represents my current position
    public static boolean hasPath(HashMap<Character, List<Character>> graph, char source, char destination, HashSet<Character> visited){
        if(visited.contains(source)) return false;
        if(source == destination) return true;
        visited.add(source);
        for(char neighbor: graph.get(source)){
            if(hasPath(graph, neighbor, destination, visited)) return true;
        }
        return false;
    }

    public static HashMap<Character, List<Character>> buildGraph(char[][] edges){
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for (char[] edge : edges) {
            graph.put(edge[0], new ArrayList<>());
            graph.put(edge[1], new ArrayList<>());
        }
        for (char[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        char[][] edges = {{'i','j'}, {'k','i'}, {'m','k'} , {'k','l'}, {'o','n'}};
        char source = 'j';
        char destination = 'm';

        System.out.println(undirectedPath(edges, source, destination));
    }
}
