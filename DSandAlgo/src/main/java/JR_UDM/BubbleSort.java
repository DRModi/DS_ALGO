package JR_UDM;

public class BubbleSort {

    public int[] sort(int arr[]){

        int n = arr.length;

        for(int i=0; i < n-1; i++){

            for(int j=0; j < n-i-1; j++){

                System.out.println("Print J " + j +" with value: " + arr[j] );
                System.out.println("Print J+1: " + (j+1) +" with value: " + arr[j+1] );
                System.out.println("Print i " + i );
                System.out.println();

                if(arr[j]>arr[j+1]){

                    System.out.println("## SWAP - START");
                    System.out.println("Came in for J : "+ j +" and J+1: " + (j+1));
                    System.out.println("## SWAP - END");
                    System.out.println();
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;

    }
}
