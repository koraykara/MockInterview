package Blind75.Graph;

import java.util.*;

public class CloneGraph {


    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer, Node> visited = new HashMap<>();
        Node result = new Node(node.val);
        return helper(node, result, visited);
    }

    public static Node helper(Node node, Node result, HashMap<Integer, Node> visited) {
        visited.put(result.val, result);
        for (Node neighbor : node.neighbors) {
            if(!visited.containsKey(neighbor.val)) {
                Node newResult = new Node(neighbor.val);
                result.neighbors.add(newResult);
                helper(neighbor, newResult, visited);
            }
            else {
                result.neighbors.add(visited.get(neighbor.val));
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
