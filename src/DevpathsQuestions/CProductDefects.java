package DevpathsQuestions;

import java.util.ArrayList;
import java.util.List;

public class CProductDefects {

    public static int findLargestSquareSize(List<List<Integer>> samples){
        int size = 1;
        int maxSize = samples.get(0).size()-1;
        int sampleSize = samples.get(0).size();
        for(int i=maxSize;i>=0;i--){
            boolean found = true;
            for(int a=0;a<i;a++) {
                for(int f = a;f<i;f++) {
                    for (int j = f; j < i; j++) {
                        for (int k = j; k < i; k++) {
                            if (samples.get(j).get(k) != 1) {
                                found = false;
                                break;
                            }
                        }
                        if (!found) break;
                    }
                }
            }
            if(found && i != 0){
                maxSize = i;
                return maxSize;
            }
        }
        return maxSize;
    }

    public static int maximalSquare(List<List<Integer>> samples) {
        if(samples == null) return 0;
        if(samples.size() == 0) return 0;
        if(samples.get(0) == null) return 0;
        if(samples.get(0).size() == 0) return 0;
        int maxSize = 0;
        int row = samples.size();
        int col = samples.get(0).size();
        int[][] table = new int[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                int slot = samples.get(i).get(j);
                if (slot == 1) {
                    table[i][j] = 1;
                    try {
                        table[i][j] = Math.min(Math.min(table[i-1][j-1], table[i][j-1]), table[i-1][j]) + 1;
                    }catch (Exception ignored){}
                    maxSize = Math.max(maxSize, table[i][j]);
                }
            }
        }
        return maxSize;
    }


    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        num.add(0);
        num.add(1);
        num.add(1);
        nums.add(num);

        num = new ArrayList<>();
        num.add(1);
        num.add(1);
        num.add(0);
        nums.add(num);

        num = new ArrayList<>();
        num.add(1);
        num.add(0);
        num.add(1);
        nums.add(num);

        System.out.println(nums);

        System.out.println(findLargestSquareSize(nums));

        System.out.println(maximalSquare(nums));
    }
}
