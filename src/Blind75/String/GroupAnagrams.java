package Blind75.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newString = new String(charArray);
            if(map.containsKey(newString)){
                map.get(newString).add(str);
            }
            else {
                map.put(newString, new ArrayList<>());
                map.get(newString).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    // Time: O(n * m) where n is the number of elements in strs, and m is the average length of each string
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] memo = new int[26];
            for(char ch: str.toCharArray()){
                memo[ch - 'a']++;
            }
            String newString = Arrays.toString(memo);
            if(!map.containsKey(newString)){
                map.put(newString, new ArrayList<>());
            }
            map.get(newString).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams2(strs));
    }
}
