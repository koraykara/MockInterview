package DynamicProgramming.LeetCodeExamples;

public class MaximumProduct {

    public static int maxProduct(int[] nums) {
        int currentProduct = nums[0];
        int maxProduct = nums[0];

        int currentProduct2 = nums[0];
        int maxProduct2 = nums[0];

        int size = nums.length;
        int[] temp = new int[nums.length];
        for(int i=1;i<size;i++){
            temp[i] = -nums[i];
        }
        for(int i=1;i<size;i++){
            if(nums[i] == 0){
                currentProduct = 1;
                currentProduct2 = 1;
            }
            else{
                currentProduct = Math.max(nums[i], currentProduct * nums[i]);
                currentProduct2 = Math.max(temp[i], currentProduct2 * temp[i]);
            }

            maxProduct = Math.max(currentProduct, maxProduct);

            maxProduct2 = Math.max(currentProduct2, maxProduct2);
        }
        return Math.max(maxProduct, maxProduct2);
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        System.out.println(maxProduct(nums));
    }
}
