package DevPathsHackerrankChallanges.Homework4;

import java.util.*;

public class Q2 {

    public static int romanToInt(String roman) {
        int total = 0;
        //create hashmap to store the roman numerals
        HashMap<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        for (int j = 0; j < roman.length(); j++) {
            char c = roman.charAt(j); //grab first char
            //check to see if next roman is greater
            if (j + 1 < roman.length() && romans.get(c) < romans.get(roman.charAt(j + 1))) {
                //if next roman is greater, you need to subtract
                int add = romans.get(roman.charAt(j + 1)) - romans.get(c);
                total += add;
                j++; //skip over next one since already calculated
            }
            //if less than, just add in order
            else {
                total += romans.get(c);
            }
        }
        return total;
    }

    public static List<String> sortRoman(List<String> names) {
        names.sort((s1, s2) -> {
            //split the strings up into name,roman
            String[] arr1 = s1.split(" ");
            String[] arr2 = s2.split(" ");

            //grab the numerical values of the romans
            int val1 = romanToInt(arr1[1]);
            int val2 = romanToInt(arr2[1]);

            //if the names are equal, compare the numerals
            if (arr1[0].equals(arr2[0])) {
                //if first one is greater than, push it back
                if (val1 > val2) {
                    return 1;
                }
                //if first one is less than, stay same
                else {
                    return -1;
                }
            } else { //if not same, just compare the names
                return arr1[0].compareTo(arr2[0]);
            }
        });
        return names;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Steven XVI");
        names.add("David IX");
        names.add("Steven XL");
        names.add("Mary XV");
        names.add("Mary XIII");
        names.add("Mary XX");
        System.out.println(sortRoman(names));
    }
}
