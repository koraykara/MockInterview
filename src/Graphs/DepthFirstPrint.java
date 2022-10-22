package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstPrint {

    public static void depthFirstPrint(HashMap<Character, char[]> graph, Character source){
        Stack<Character> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()){
            Character current = stack.pop();
            System.out.print(current + " ");
            for(char neighbor: graph.get(current)){
                stack.push(neighbor);
            }
        }
    }

    public static void depthFirstPrintRecursively(HashMap<Character, char[]> graph, Character source){
        System.out.print(source + " ");
        for(char neighbor: graph.get(source)){
            depthFirstPrintRecursively(graph, neighbor);
        }
    }

    public static void breathFirstPrint(HashMap<Character, char[]> graph, Character source){
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            Character current = queue.remove();
            System.out.print(current + " ");
            for(char neighbor: graph.get(current)){
                queue.add(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Character, char[]> graph = new HashMap<>();
        graph.put('a', new char[]{'c', 'b'});
        graph.put('b', new char[]{'d'});
        graph.put('c', new char[]{'e'});
        graph.put('d', new char[]{'f'});
        graph.put('e', new char[]{});
        graph.put('f', new char[]{});

        depthFirstPrint(graph, 'a');
        System.out.println();
        depthFirstPrintRecursively(graph, 'a');
        System.out.println();
        breathFirstPrint(graph, 'a');
    }
}
