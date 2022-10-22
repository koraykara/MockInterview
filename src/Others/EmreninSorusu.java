package Others;

public class EmreninSorusu {

    public static int[] removeClosestElementToX(int[] arr,int x){
        int arrSize = arr.length;
        int[] returnedArr = new int[arrSize-1];

        int minDifference = Integer.MAX_VALUE;
        int removedIndex = -1;

        for(int i=0;i<arrSize;i++){
            int currentDifference = Math.abs(x - arr[i]);
            if(currentDifference < minDifference){
                minDifference = currentDifference;
                removedIndex = i;
            }
        }

        if(removedIndex != -1){
            int j = 0;
            for(int i=0;i<arrSize;i++){
                if(i != removedIndex){
                    returnedArr[j++] = arr[i];
                }
            }
        }
        return returnedArr;
    }

    public static void printElements(int[] arr, int size) {
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {10,9,123,5,34,45,56,67};

        printElements(arr,arr.length);
        int[] newArr = removeClosestElementToX(arr, 1);
        printElements(newArr, newArr.length);
    }
}
