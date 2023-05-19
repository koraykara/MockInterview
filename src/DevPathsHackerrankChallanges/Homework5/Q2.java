package DevPathsHackerrankChallanges.Homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {

    public static int slotWheels(List<String> history, int n) {
        // Write your code here
        int col = history.size() / n;
        int[][] spins = new int[n][col];
        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<col;j++){
                try {
                    spins[i][j] = Integer.parseInt(history.get(index++));
                }
                catch (Exception ignored){}
            }
        }

        int sum = 0;
        while (!isValid(spins)){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                int candidateMax = findMax(spins, i);
                if( candidateMax > max){
                    max = candidateMax;
                }
            }
            sum += max;
        }


        return sum;
    }

    public static boolean isValid(int[][] spins){
        for(int i=0;i<spins.length;i++){
            for(int j=0;j<spins[0].length;j++){
                if(spins[i][j] != -1)
                    return false;
            }
        }
        return true;
    }

    public static int findMax(int[][] spins, int row){
        int max = Integer.MIN_VALUE;
        int rowIdx = -1;
        int colIdx = -1;

        for(int i=0;i<spins[0].length;i++){
            if(spins[row][i] > max){
                max = spins[row][i];
                rowIdx = row;
                colIdx = i;
            }
        }
        spins[rowIdx][colIdx] = -1;
        return max;
    }

    public static void main(String[] args) {
        List<String> history = new ArrayList<>();
        history.add("1");
        history.add("1");
        history.add("1");
        history.add("2");

        history.add("1");
        history.add("1");
        history.add("1");
        history.add("1");

        history.add("1");
        history.add("2");
        history.add("1");
        history.add("1");

        history.add("1");
        history.add("1");
        history.add("1");
        history.add("1");
        System.out.println(slotWheels(history, 4));
        System.out.println();
    }
}
