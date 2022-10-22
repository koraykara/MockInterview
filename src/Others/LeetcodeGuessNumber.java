package Others;

public class LeetcodeGuessNumber {

    public static int guessNumber(int n) {
        int low = 1, high = n;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid == n) return mid;
            else if(n < mid) high = mid-1;
            else low = mid+1;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
