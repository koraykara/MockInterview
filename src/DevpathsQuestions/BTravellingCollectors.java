package DevpathsQuestions;

import java.util.HashMap;
import java.util.Map;

public class BTravellingCollectors {

    public static int shortestRoute(String route){
        if(route.isEmpty()) return 0;
        int maxSubstrLen = route.length();
        HashMap<Character, Integer> mapGiven = initializeMap(route, 0);
        HashMap<Character, Integer> mapNeeded = initializeMap(route, 1);
        System.out.println(mapGiven);
        System.out.println(mapNeeded);
        int have = 0;
        int need = mapNeeded.keySet().size();
        char[] routeCharArr = route.toCharArray();
        int l = 0;
        int[] result = new int[2];
        int resultLen = Integer.MAX_VALUE;
        int i;
        for(i=0;i<routeCharArr.length;i++){
            mapGiven.put(route.charAt(i), mapGiven.get(route.charAt(i)) + 1);
            if(mapNeeded.containsKey(route.charAt(i)) && mapGiven.get(route.charAt(i)).equals(mapNeeded.get(route.charAt(i)))){
                have++;
            }
            while (have == need){
                if(i - l + 1 < resultLen){
                    result[0] = l;
                    result[1] = i;
                    resultLen = i - l + 1;
                }
                mapGiven.put(route.charAt(l), mapGiven.get(route.charAt(l)) - 1);
                if(mapNeeded.containsKey(route.charAt(l)) && mapGiven.get(route.charAt(l)) < mapNeeded.get(route.charAt(l))){
                    have -= 1;
                }
                l += 1;
            }
        }
        l = result[0];
        i = result[1];
        if(resultLen != Integer.MAX_VALUE){
            return route.substring(l, i+1).length();
        }
        return 0;
    }

    public static HashMap<Character, Integer> initializeMap(String route, int with){
        char[] routeArr = route.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: routeArr){
            map.put(ch, with);
        }
        return map;
    }


    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // record the min window's start position
        int startIndex = 0, minLen = Integer.MAX_VALUE;
        int count = map.size();
        // left side (left) and right side (right) of sliding window
        for (int left = 0, right = 0; right < s.length(); right++) {
            char cRight = s.charAt(right);
            if (map.containsKey(cRight)) {
                map.put(cRight, map.get(cRight) - 1);
                if (map.get(cRight) == 0) {
                    count -= 1;
                }
            }

            while (count <= 0) {
                char cLeft = s.charAt(left);
                if (map.containsKey(cLeft)) {
                    map.put(cLeft, map.get(cLeft) + 1);
                    // map.get(cLeft) means cLeft is the start character(position) of curr window
                    // pay attention to the duplicated characters.
                    if (map.get(cLeft) >= 1) {
                        count += 1;
                    }
                }
                // Get the min window
                if (right - left + 1 < minLen) {
                    startIndex = left;
                    minLen = right - left + 1;
                }
                left++;
            }
        }
        System.out.println(s.substring(startIndex, startIndex + minLen));
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }


    public static void main(String[] args) {
        String route = "asdfkjeghfalawefhaef";
        //System.out.println(minWindow(route,"asdefgwhjkl").length() );

        System.out.println(shortestRoute(route));

    }
}
