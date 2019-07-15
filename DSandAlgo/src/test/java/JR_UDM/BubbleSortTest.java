package JR_UDM;

import junit.framework.*;
import org.junit.Before;
import org.junit.Test;


public class BubbleSortTest {

    BubbleSort bubbleSort;

    @Before
    public void setup(){
        bubbleSort = new BubbleSort();
    }

    @Test
    public void sort(){

        int[] inputArr =  new int[5];
        inputArr[0] = 5;
        inputArr[1] = 25;
        inputArr[2] = 45;
        inputArr[3] = 4;
        inputArr[4] = 8;

        int[] arr = {5,1,4,2,8};



        int[] outputArr = bubbleSort.sort(arr);

        for(int i=0;i<outputArr.length;i++){
            System.out.println("Print outputArry["+ i +"]"+outputArr[i]);
        }

     }
}
