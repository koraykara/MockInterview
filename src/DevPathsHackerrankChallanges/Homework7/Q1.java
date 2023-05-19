package DevPathsHackerrankChallanges.Homework7;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Q1 {

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        HashMap<String, Float> map = new HashMap<>();
        int count = 0;
        for(int i=0; i < products.size(); i++){
            // check if hash object has already product key available
            // if it is not present
            // assign a key and it's value from productsPrices
            if(!map.containsKey(products.get(i))){
                map.put(products.get(i), productPrices.get(i));
            }
        }

        for(int j=0; j < productSold.size(); j++){
            if(!Objects.equals(map.get(productSold.get(j)), soldPrice.get(j))){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
