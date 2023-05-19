package Blind75.Graph;

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = createAdjList(numCourses, prerequisites);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> marked = new HashSet<>();
        for(int node: adjList.keySet()){
            if(isCyclic(adjList, node, visited, marked))
                return false;
        }
        return true;
    }

    public static boolean isCyclic(HashMap<Integer, List<Integer>> adjList, int source, Set<Integer> visited, Set<Integer> marked){
        if(visited.contains(source) && !marked.contains(source)) return true; // I found cycle in the graph...
        if(visited.contains(source) && marked.contains(source)) return false;
        visited.add(source);
        if(adjList.containsKey(source)) {
            for (int neighbor : adjList.get(source)) {
                if (isCyclic(adjList, neighbor, visited, marked)) {
                    return true; // I found cycle in the graph...
                }
            }
        }
        marked.add(source);
        return false;
    }

    public static HashMap<Integer, List<Integer>> createAdjList(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        return adjList;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}, {0,1}};
        System.out.println((canFinish(2, prerequisites)));
    }
}
