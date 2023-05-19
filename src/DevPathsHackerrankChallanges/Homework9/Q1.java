package DevPathsHackerrankChallanges.Homework9;

import java.util.HashMap;

public class Q1 {

    public static int shortestSubstring(String str)
    {
        int n = str.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            if (mp.containsKey(str.charAt(i)))
            {
                Integer a = mp.get(str.charAt(i));
                mp.put(str.charAt(i),a+1);
            }
            else
            {
                mp.put(str.charAt(i), 1);
            }
        }
        int dist_count = mp.size();
        int size = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < n; i++)
        {
            int count = 0;
            int[] visited = new int[256];
            for(int j = 0; j < 256; j++)
                visited[j] = 0;
            StringBuilder sub_str = new StringBuilder();
            for (int j = i; j < n; j++)
            {
                if (visited[str.charAt(j)] == 0)
                {
                    count++;
                    visited[str.charAt(j)] = 1;
                }
                sub_str.append(str.charAt(j));
                if (count == dist_count)
                    break;
            }
            if (sub_str.length() < size && count == dist_count)
            {
                res = sub_str.toString();
                size=res.length();
            }
        }
        return res.length();
    }

    public static void main(String[] args) {
        String str = "dabbcabcd";
        System.out.println(shortestSubstring(str));
    }
}
