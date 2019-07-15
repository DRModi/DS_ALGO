package JR_UDM;

public class MergeSort {

    public void sort(int[] arr, int leftIndex, int rightIndex){

       // System.out.println("Splitting l r: " + leftIndex + " "+ rightIndex);

        if(leftIndex < rightIndex){
            System.out.println("Splitting l r: " + leftIndex + " "+ rightIndex);

            //find medianIndex
            int medianIndex = (leftIndex+rightIndex)/2;

            //sort first and second halves, by dividing the index
            sort(arr, leftIndex, medianIndex);
            sort(arr, medianIndex + 1, rightIndex);

            //Merge the sorted halves
            merge(arr, leftIndex, medianIndex, rightIndex);

        }

    }

    private void merge(int[] arr, int leftIndex, int medianIndex, int rightIndex) {

        System.out.println("==> merge left median right: "+ leftIndex + " " + medianIndex + " "+rightIndex );

        System.out.println("\n input array: ");
        printArray(arr);


        //find sizes of two sub-arrays
        int n1 = medianIndex - leftIndex + 1;
        int n2 = rightIndex - medianIndex;


        //create temp array
        int tempLeftArr[] = new int[n1];
        int tempRightArr[] = new int[n2];

        //copy data to temp array
        for(int i = 0; i<n1; ++i){
            tempLeftArr[i] = arr[leftIndex+i];
        }
        for(int j = 0; j<n2; ++j){
            tempRightArr[j] = arr[medianIndex+1+j];
        }

        System.out.println("\n Temp Left: ");
        printArray(tempLeftArr);
        System.out.println("\n Temp Right: ");
        printArray(tempRightArr);
        /* now merge the temp array */

        //initial index for first and second sub-arrays
        int index1 = 0, index2 = 0;

        //initial index of first and second sub-array array
        int k = leftIndex;

        System.out.println("n1 n2 : "+ n1 + " "+ n2);

        while(index1<n1 && index2<n2){

            System.out.println(tempLeftArr[index1] + " " + tempRightArr[index2]);
            if(tempLeftArr[index1] <= tempRightArr[index2]){
                arr[k] = tempLeftArr[index1];
                index1++;
            }else{
                arr[k] = tempRightArr[index2];
                index2++;
            }

            k++;
        }

        //System.out.println("index1 index2 k :" +index1+ " "+index2+" "+k);

        //copy remaining temp Left arr values
        while(index1 < n1)
        {
            arr[k] = tempLeftArr[index1];
            index1++;
            k++;
        }

        //copy remaining temp right arr values
        while(index2 < n2){
            arr[k] = tempRightArr[index2];
            index2++;
            k++;
        }

        System.out.println("\n \n After Merge");
        printArray(arr);





    }

    private void printArray(int[] arr) {

        for(int i = 0; i < arr.length; i++){
            System.out.println("arr["+i+"]"+arr[i]+" "+"\n");

        }
    }
}
