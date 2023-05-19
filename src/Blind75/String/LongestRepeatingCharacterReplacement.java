package Blind75.String;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> characterMap = buildMap(s);
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            characterMap.put(s.charAt(right), characterMap.get(s.charAt(right)) + 1);
            int difference = (right - left + 1) - findMaxOccurence(characterMap);
            if (difference > k) {
                characterMap.put(s.charAt(left), characterMap.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static int findMaxOccurence(HashMap<Character, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
            }
        }
        return max;
    }

    public static HashMap<Character, Integer> buildMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, 0);
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "AAAA";
        int k = 0;
        System.out.println(characterReplacement(s, k));
    }
}
