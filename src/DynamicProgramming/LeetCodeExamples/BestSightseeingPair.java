package DynamicProgramming.LeetCodeExamples;

import java.util.ArrayList;

public class BestSightseeingPair {

    public static int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;
        int j = 0;
        ArrayList<Integer> iArr = new ArrayList<>();
        ArrayList<Integer> jArr = new ArrayList<>();
        jArr.add(Integer.MIN_VALUE);
        for(int i=0;i<values.length;i++, j++){
            iArr.add(values[i] + i);
            if(j > 0)
                jArr.add(values[j] - j);
        }
        System.out.println(iArr);
        System.out.println(jArr);
        int max = Integer.MIN_VALUE;
        int maxI = Integer.MIN_VALUE;
        for(int i=1;i<iArr.size();i++){
            if(maxI < iArr.get(i-1))
                maxI = iArr.get(i-1);
            if(max < maxI + jArr.get(i))
                max = maxI + jArr.get(i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(values));
    }
}
