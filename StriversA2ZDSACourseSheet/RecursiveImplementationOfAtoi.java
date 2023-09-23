package StriversA2ZDSACourseSheet;

public class RecursiveImplementationOfAtoi {

    public static int atoi(String str) {
        // Write your code here.
        boolean containsNumbers = false;
        int idx = 0;
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        while (idx < len) {
            if (str.charAt(idx) == '-') {
                int it = idx;
                sb.append(str.charAt(it));
                while (it < len) {
                    if (str.charAt(it) <= '9' && str.charAt(it) >= '0') {
                        sb.append(str.charAt(it));
                        containsNumbers = true;
                    }
                    it++;
                }
            }
            idx++;
        }
        if (containsNumbers) return helper(sb.toString());
        return 0;
    }

    public static int helper(String str) {
        if (str.charAt(0) == '-') return -helper(str.substring(1));
        if (str.length() == 1) {
            return str.charAt(0) - '0';
        }
        return 10 * helper(str.substring(0, str.length() - 1)) + (str.charAt(str.length() - 1) - '0');
    }

    public static void main(String[] args) {
        String str = "messi1000fjksdlkf";
        System.out.println(atoi(str));

        String a = "-10000";
        System.out.println(helper(a));
    }
}
