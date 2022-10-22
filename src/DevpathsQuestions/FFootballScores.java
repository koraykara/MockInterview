package DevpathsQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FFootballScores {

    public static List<Integer> countsBad(List<Integer> teamA, List<Integer> teamB){
        List<Integer> result_count = new ArrayList<>();
        for (Integer teamBVal : teamB) {
            int count = 0;
            for (Integer teamAVal : teamA) {
                if (teamBVal >= teamAVal) {
                    count++;
                }
            }
            result_count.add(count);
        }
        return result_count;
    }

    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB){
        Collections.sort(teamA);
        List<Integer> result_count = new ArrayList<>();
        for(int teamBVal: teamB){
            int low = 0;
            int high = teamA.size() - 1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(teamA.get(mid) <= teamBVal){
                    low = mid + 1;
                }
                else if(teamA.get(mid) > teamBVal){
                    high = mid - 1;
                }
            }
            result_count.add(low);
        }
        return result_count;
    }

    public static void main(String[] args) {
        List<Integer> teamA = new ArrayList<>();
        teamA.add(2);
        teamA.add(10);
        teamA.add(5);
        teamA.add(4);
        teamA.add(8);
        List<Integer> teamB = new ArrayList<>();
        teamB.add(3);
        teamB.add(1);
        teamB.add(7);
        teamB.add(8);
        System.out.println(countsBad(teamA, teamB));

        System.out.println(counts(teamA, teamB));
    }
}
