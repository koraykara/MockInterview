package Blind75.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int amount = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        int maxLeftVal = height[0];
        int maxRightVal = height[len - 1];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = maxLeftVal;
            maxLeftVal = Math.max(maxLeftVal, height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = maxRightVal;
            maxRightVal = Math.max(maxRightVal, height[i]);
        }
        for (int i = 0; i < len; i++) {
            int trap = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (trap > 0) {
                amount += trap;
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
