package DevPathsHackerrankChallanges.Homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumWeightPathInDirectedGraph {

    public static int minCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        if(gNodes == 1) return 0;
        int V = gFrom.size();
        int[][] graph = initializeGraph(V+1);
        boolean[] visited = new boolean[V];
        buildGraph(graph, gFrom, gTo, gWeight, V);
        System.out.println(Arrays.deepToString(graph));
        return minimumCostSimplePath(1, gNodes, visited, graph, V);
    }

    static int minimumCostSimplePath(int u, int destination,
                                     boolean visited[],
                                     int graph[][], int V)
    {

        // Check if we find the destination
        // then further cost will be 0
        if (u == destination)
            return 0;

        // Marking the current node as visited
        visited[u] = true;

        int ans = Integer.MAX_VALUE;

        // Traverse through all
        // the adjacent nodes
        for(int i = 0; i < V; i++)
        {
            if (!visited[i])
            {

                // Cost of the further path
                int curr = minimumCostSimplePath(i, destination, visited, graph, V);

                // Check if we have reached the
                // destination
                if (curr < Integer.MAX_VALUE)
                {
                    // Taking the minimum cost path
                    ans = Math.min(ans, graph[u][i] + curr);
                }
            }
        }

        // Unmarking the current node
        // to make it available for other
        // simple paths
        visited[u] = false;

        // Returning the minimum cost
        return ans;
    }

    public static void buildGraph(int[][] graph, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight, int V){
        for(int i=0;i<V;i++){
            graph[gFrom.get(i)][gTo.get(i)] = gWeight.get(i);
        }
    }

    public static int[][] initializeGraph(int V){
        int[][] graph = new int[V][V];
        for(int i = 0; i < V; i++)
        {
            for(int j = 0; j < V; j++)
            {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        int gNodes = 4;

        gFrom.add(1);
        gFrom.add(1);
        gFrom.add(2);
        gFrom.add(1);

        gTo.add(2);
        gTo.add(3);
        gTo.add(1);
        gTo.add(4);

        gWeight.add(3);
        gWeight.add(2);
        gWeight.add(3);
        gWeight.add(5);

        System.out.println(minCost(gNodes, gFrom, gTo, gWeight));

    }
}
