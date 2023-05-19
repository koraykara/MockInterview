package Blind75.String;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        String s1 = removeNonAlphanumeric(s).toLowerCase();
        return helper(s1);
    }

    public static boolean helper(String s){
        if(s.length() == 0 || s.length() == 1) return true;
        if(s.charAt(0) != s.charAt(s.length()-1)) return false;
        return helper(s.substring(1, s.length()-1));
    }

    public static String removeNonAlphanumeric(String str)
    {
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return str;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
