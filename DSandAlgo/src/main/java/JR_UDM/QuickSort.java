package JR_UDM;

public class QuickSort {

    public int[] sort(int[] arr){

        //1. Find pivot point
        //2. Partition array around pivot point
        //3. walk through the arr making sure that all left elements to the pivot point are smaller
        //   and right elements to the pivot are greater
        //Note: all this being done in place! That's killer feature. No extra array required.

        //4. Same process of step 2 apply over the right and left portion over and over again
        // eventually Array becomes sorted.

        quickSort(arr, 0, arr.length-1);

        return arr;
    }

    private void quickSort(int[] arr, int leftIndex, int rightIndex) {

        if(leftIndex>=rightIndex){
            return;
        }

        //1. Find pivot point
        // Choose left+(right-left)/2 (as this avoid overflow error for large array. i.e 2GB)
        int pivot = leftIndex + (rightIndex-leftIndex)/2;

        //2. Partition array (step 3: will be done under partition)
        int index = partition(arr, leftIndex, rightIndex, pivot);

        //3. Sort on the left portion and right portion
        quickSort(arr, leftIndex, index-1);
        quickSort(arr, index, rightIndex);

    }

    private int partition(int[] arr, int leftIndex, int rightIndex, int pivot) {

        //1. move left and right index pointers in towards to each other
        while(leftIndex <= rightIndex){

            //A. move left until you find an element bigger than the pivot
            while(arr[leftIndex] < pivot){
                leftIndex++;
            }

            //B. move the right index until you find an element smaller than the pivot
            while (arr[rightIndex] > pivot){
                rightIndex--;
            }

            //then swap
            if(leftIndex <= rightIndex){
                swap(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }

        }

        //when we reach here, everything in this partition will be in right order (meaning left side
        //  of given pivot would be equal or small and right side would be equal or large)

        //Now we required to return next partition point
        return leftIndex;

    }

    private void swap(int[] arr, int index, int index1) {
        int temp = arr[index];
        arr[index] = arr[index1];
        arr[index1] = temp;
    }

    private void prettyPrint(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.println("arr["+i+"]"+arr[i]);
        }
    }
}
