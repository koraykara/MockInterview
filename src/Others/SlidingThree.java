package Others;

public class SlidingThree {

    public static int[] func(int[] nums,int k){
        int size = nums.length;
        int[] res = new int[size-k+1];
        int index = 0;
        for(int i=0;i<size-k+1;i++) {
            int max = nums[i];
            for(int j=i;j<i+k;j++){
                if(nums[j] > max)
                    max = nums[j];
            }
            res[index++] = max;
        }
        return res;
    }

    public static void printArray(int[] arr){
        int size = arr.length;
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        printArray(nums);
        int[] res = func(nums,3);
        printArray(res);
    }
}
