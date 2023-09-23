package SDESheet.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<Integer> rows = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        rows.add(1);
        res.add(rows);
        for (int numR = 0; numR < numRows-1; numR++) {
            rows = new ArrayList<>();
            rows.add(1);
            for (int i = 0; i < res.get(numR).size() - 1; i++) {
                rows.add(res.get(numR).get(i) + res.get(numR).get(i + 1));
            }
            rows.add(1);
            res.add(rows);
        }
        return res;
    }

    public static void main(String[] args) {
        int numRow = 5;
        System.out.println(generate(numRow));
    }
}
