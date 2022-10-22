package DevpathsQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HSharedInterest {

    public static int maxShared(int friendsNodes, List<Integer> friendsFrom, List<Integer> friendsTo, List<Integer> friendsWeight) {

        HashMap<Integer, HashSet<Integer>> graph = buildGraph( friendsFrom, friendsTo, friendsWeight);
        System.out.println(graph);
        int max = 0, maxValue = 0;
        for (int i = 1; i < friendsNodes; i++) {
            HashSet<Integer> friendIInterests = graph.get(i);
            for (int j = i+1; j < friendsNodes; j++) {
                HashSet<Integer> friendJInterests = graph.get(j);
                int numOfCommonInterests = 0;
                for (int interestNumber : friendIInterests) {
                    if (friendJInterests.contains(interestNumber)) {
                        numOfCommonInterests += 1;
                    }
                }
                int val = i*j;
                if (numOfCommonInterests > max || (numOfCommonInterests == max && val > maxValue)) {
                    max = numOfCommonInterests;
                    maxValue = val;
                }
            }
        }
        return maxValue;
    }

    public static HashMap<Integer, HashSet<Integer>> buildGraph(List<Integer> friendsFrom, List<Integer> friendsTo, List<Integer> friendsWeight){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int size = friendsFrom.size();
        for (int i = 0; i < size; ++i) {
            int friend = friendsFrom.get(i);
            if (!graph.containsKey(friend)) {
                graph.put(friend, new HashSet<>());
            }

            graph.get(friend).add(friendsWeight.get(i));

            friend = friendsTo.get(i);
            if (!graph.containsKey(friend)) {
                graph.put(friend, new HashSet<>());
            }

            graph.get(friend).add(friendsWeight.get(i));
        }
        return graph;
    }

    public static void main(String[] args) {
        int friendsNodes = 4;
        int friendsEdges = 5;
        List<Integer> friendsFrom = new ArrayList<>();
        friendsFrom.add(1);
        friendsFrom.add(1);
        friendsFrom.add(2);
        friendsFrom.add(2);
        friendsFrom.add(2);
        List<Integer> friendsTo = new ArrayList<>();
        friendsTo.add(2);
        friendsTo.add(2);
        friendsTo.add(3);
        friendsTo.add(3);
        friendsTo.add(4);
        List<Integer> friendsWeight = new ArrayList<>();
        friendsWeight.add(1);
        friendsWeight.add(2);
        friendsWeight.add(1);
        friendsWeight.add(3);
        friendsWeight.add(3);
        System.out.println(maxShared(friendsNodes, friendsFrom, friendsTo, friendsWeight));
    }
}
