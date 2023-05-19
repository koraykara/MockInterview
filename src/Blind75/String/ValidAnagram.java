package Blind75.String;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ValidAnagram {

    // Time: n*log(n)
    // Space: O(n)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i])
                return false;
        }
        return true;
    }

    // Time: O(n + m) where n and m is the length of s and t respectively
    // Space: O(n + m) where n and m is the length of s and t respectively
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch: s.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for(char ch: t.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        for(char key: map1.keySet()){
            if(!map2.containsKey(key))
                return false;
            else{
                if(!map1.get(key).equals(map2.get(key)))
                    return false;
            }
        }
        return true;
    }

    // TODO: alphabet çözümüne de bak ya da kendin yap!

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s, t));
    }
}
