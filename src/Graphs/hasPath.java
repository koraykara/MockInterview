package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class hasPath {

    // n = # nodes
    // e  = # edges
    // Time: O(e)
    // Space: O(n)
    public static boolean hasPathUsingDfsRecursively(HashMap<Character, char[]> graph, Character source, Character destination){
        if(graph == null) return false;
        if(source == destination) return true;
        for(char neighbor: graph.get(source)){
            if(hasPathUsingDfsRecursively(graph, neighbor, destination)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasPathUsingBfs(HashMap<Character, char[]> graph, Character source, Character destination){
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            Character current = queue.remove();
            if(current == destination) return true;
            for(char neighbor: graph.get(current)){
                queue.add(neighbor);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<Character, char[]> graph = new HashMap<>();
        graph.put('f', new char[]{'g', 'i'});
        graph.put('g', new char[]{'h'});
        graph.put('h', new char[]{});
        graph.put('i', new char[]{'g', 'k'});
        graph.put('j', new char[]{'i'});
        graph.put('k', new char[]{});

        //inputs: j,f    and    f,k

        System.out.println(hasPathUsingDfsRecursively(graph, 'j', 'f'));
        System.out.println(hasPathUsingBfs(graph, 'f', 'k'));

    }
}
