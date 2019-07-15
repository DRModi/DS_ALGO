package JR_UDM;

import junit.framework.*;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

    MergeSort mergeSort;

    @Before
    public void setUp(){
        mergeSort = new MergeSort();
    }

    @Test
    public void sort(){

        //int[] inputArr = {4, 7, 14, 1, 3, 9, 17};
        //int[] inputArr = {9,3,7,5,6,4,8,2};
        int[] inputArr = {11,5,14,7,1};

        //System.out.println("Starting array :===> "+"{9,3,7,5,6,4,8,2}");
        System.out.println("Starting array :===> "+"{11,5,14,7,1}");
        int leftIndex = 0;
        int rightIndex = inputArr.length-1;

        mergeSort.sort(inputArr, 0, rightIndex);


    }
}
