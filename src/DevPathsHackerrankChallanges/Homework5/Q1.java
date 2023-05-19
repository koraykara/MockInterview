package DevPathsHackerrankChallanges.Homework5;

import java.util.*;

public class Q1 {
    static boolean isValidSequence(String subList, Vector<Character> vowels)
    {
        for(char c : vowels)
        {
            if (subList.indexOf(c) < 0)
                return false;
        }
        return true;
    }

    public static String helper(String str, String subList, int index){
        Vector<Character> vowels = new Vector<Character>();
        HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();

        mapping.put('a', 0);
        mapping.put('e', 1);
        mapping.put('i', 2);
        mapping.put('o', 3);
        mapping.put('u', 4);

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int len = str.length();

        if (index >= len)
        {
            if (isValidSequence(subList, vowels))
                return subList;
            else
                return "";
        }

        else if (subList.length() == 0)
        {
            if (str.charAt(index) != 'a')
                return helper(str, "", index + 1);
            else
                return helper(str, subList + str.charAt(index), index + 1);
        }

        else if (mapping.get(subList.charAt(subList.length() - 1)) ==
                mapping.get(str.charAt(index)))
            return helper(str, subList+str.charAt(index), index + 1);

        else if (mapping.get(subList.charAt(subList.length() - 1)) + 1 ==
                mapping.get(str.charAt(index)))
        {
            String sub1 = helper(
                    str, subList + str.charAt(index), index + 1);
            String sub2 = helper(
                    str, subList, index + 1);

            if (sub1.length() > sub2.length())
                return sub1;
            else
                return sub2;
        }
        else
            return helper(
                    str, subList, index + 1);
    }
    public static int longestVowelSubsequence(String str)
    {
        System.out.println(helper(str, "", 0));
        return helper(str, "", 0).length();
    }





    public static char getPrevChar(char c)
    {

        // previous characters in the order {a -> e -> i ->
        // o -> u} previous of 'a' is 'a' (since 'a' can be
        // placed after 'a')
        if (c == 'a')
            return 'a';
        if (c == 'e')
            return 'a';
        if (c == 'i')
            return 'e';
        if (c == 'o')
            return 'i';
        else
            return 'o';
    }

    public static int longestVowelSubsequence2(String s)
    {
        String result = "";
        int n = s.length();
        ArrayList<Integer> parent
                = new ArrayList<Integer>();
        ArrayList<Integer> dp = new ArrayList<Integer>();

        // parent[i] ---> stores the previous character's
        // index to which it can be added
        for (int i = 0; i < n; i++) {
            parent.add(i);
            dp.add(0);
        }
        // dp[i] ----> length of longest sequence ending at
        // index i;
        int ind = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                dp.set(i, 1);
                ind = i;
                break;
            }
        }

        // if there is no 'a'
        if (ind == -1) {
            System.out.println("NO POSSIBLE SEQUENCE");
        }

        // iterating from next character (after 'a')
        for (int i = ind + 1; i < n; i++) {
            int prev = getPrevChar(s.charAt(i));

            // previous character of the current character
            // in vowel sequence {a -> e -> i -> o -> u}
            int cur = dp.get(i);
            int par = i;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == prev
                        || s.charAt(j) == s.charAt(i))
                {

                    // if it matches its prev char or itself
                    // then we can add to it if its length
                    // is maximum than previous
                    if (cur <= dp.get(j) + 1) {
                        cur = dp.get(j) + 1;
                        par = j;
                    }
                }
            }
            dp.set(i, Math.max(cur, 1));
            parent.set(i, par);
        }

        int lastIndex = -1;

        // finding the last occurrence of 'u' which will be
        // last occurrence of the sequence
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'u') {
                lastIndex = i;
                break;
            }
        }

        // if we do not find 'u'
        if (lastIndex == -1) {
            System.out.println("NO POSSIBLE SEQUENCE");
        }
        else {
            String res = "";
            while (lastIndex != parent.get(lastIndex)) {
                res += s.charAt(lastIndex);
                lastIndex = parent.get(lastIndex);
            }
            res += s.charAt(lastIndex);

            // adding first character in the subsequence
            // (which has the parent as its index)
            if (s.charAt(lastIndex) != 'a') {
                System.out.println("NO POSSIBLE SEQUENCE");
            }
            else
            {

                // reversing the string because we added
                // from the last
                StringBuilder ans = new StringBuilder();
                ans.append(res);
                ans.reverse();
                System.out.println(ans);
                result = ans.toString();
            }
        }
        return result.length();
    }

    public static void main(String[] args) {
        String s = "aeiaaioooaauuaeiu";
        System.out.println(longestVowelSubsequence2(s));

    }
}
