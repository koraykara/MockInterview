package Blind75.Stack;

import java.util.Arrays;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        if(len == 1) return result;
        for (int i = 0; i < len-1; i++) {
            int count = 1;
            for (int j = i + 1; j < len; j++) {
                if (temperatures[i] >= temperatures[j]) {
                    if(j == len-1){
                        count = 0;
                        break;
                    }
                    count++;
                }
                else if(temperatures[i] < temperatures[j]){
                    break;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
