package Others;

import java.util.HashMap;

public class Fibonacci {

    public static int fibanacci(int num, HashMap<Integer,Integer> memo){
        int result;
        if(memo.containsKey(num))
            return memo.get(num);
        if(num<=2)
            result = 1;
        else{
            result = fibanacci(num-1, memo) + fibanacci(num-2, memo);
            memo.put(num, result);

        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(fibanacci(1000, new HashMap<>()));

    }
}
