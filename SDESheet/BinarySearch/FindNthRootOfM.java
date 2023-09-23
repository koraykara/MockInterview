package SDESheet.BinarySearch;

public class FindNthRootOfM {

    // TC: m * log(base2)n
    public static int NthRootBruteForce(int n, int m) {
        for (int i = 1; i < m; i++) {
            int power = (int) (Math.pow(i, n));
            if (power == m) return i;
            else if (power > m) break;
        }
        return -1;
    }

    // TC: log(base2)m * log(base2)n = log(m+n)
    public static int NthRootOptimal(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int power = (int) Math.pow(mid, n);
            if (power > m) {
                high = mid - 1;
            } else if (power < m) {
                low = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        System.out.println(NthRootBruteForce(n, m));
        System.out.println(NthRootOptimal(n, m));
    }
}
