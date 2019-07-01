package JR_UDM;

import java.util.Arrays;

public class BinaryMinIntHeap {

    int INITIAL_CAPACITY = 10;
    int size;

    int[] Items = new int[INITIAL_CAPACITY];

    //(1) retrieve pointer/index for parent, left and right child
    private int retrieveLeftChildIndex(int index){
        return 2*index + 1;
    }

    private int retrieveRightChildIndex(int index){
        return 2*index + 2;
    }

    private int retrieveParentIndex(int index){
        return (index - 1)/2;
    }

    //(2) check if parent, left and right child is available
    private boolean isParentExist(int index){
        return retrieveParentIndex(index) >= 0;
    }

    private boolean isLeftChildExist(int index){
        return  retrieveLeftChildIndex(index) < size;
    }

    private boolean isRightChildExist(int index){
        return retrieveRightChildIndex(index) < size;
    }


    //(3) getValue of parent, left and right child
    private int getParentValue(int index){
        return Items[retrieveParentIndex(index)];
    }

    private int getLeftChildValue(int index){
        return Items[retrieveLeftChildIndex(index)];
    }

    private int getRightChildValue(int index){
        return Items[retrieveRightChildIndex(index)];
    }


    //(4) Insert
    public void insert(int value){
        Items[size] = value;
        size++;
        moveUp();
    }

    //(5) Extract Min
    public int extractMin(){
        if(size==0){
            throw new IllegalStateException("Array is EMPTY!");
        }

        int min=0;
        min = Items[0];

        //A. Swap top with bottom
        //B. Find out smaller child of the two child (left and right)
        //C. Compare child with parent, and swap till no more smaller child found.
        //Done Move Down Method.
        moveDown();

        size--;
        return min;
    }

    //(6) Move up
    public void moveUp(){
       int index = size - 1;
        while (isParentExist(index) && (getParentValue(index) > Items[index])) {
            swap(retrieveParentIndex(index), index);
            index = retrieveParentIndex(index);
        }
    }

    //(7) Move down
    public void moveDown(){
        //A. Swap top with bottom
        //B. Find out smaller child of the two child (left and right)
        //C. Compare child with parent, and swap till no more smaller child found.


        //A
        int index = 0;
        Items[index] = Items[size-1];

        //B, C
        while(isLeftChildExist(index)){
            //B.
            // Find smaller child - start with left child
            int smallerChildIndex = retrieveLeftChildIndex(index);
            // if right is smaller then set smaller to right child
            if(Items[smallerChildIndex] > getRightChildValue(index)){
                smallerChildIndex = retrieveRightChildIndex(index);
            }

            //C
            if(Items[smallerChildIndex] < Items[index]){
                swap(smallerChildIndex,index);

            }else
            {
                break;
            }

            index = smallerChildIndex;
        }

    }

    //(8) Swap
    public void swap(int index1, int index2){
        int temp = Items[index1];
        Items[index1] = Items [index2];
        Items[index2] = temp;
    }


    //(9) ensure capacity
    public void ensureCapacity(){

        if(size==INITIAL_CAPACITY){
            Items = Arrays.copyOf(Items, INITIAL_CAPACITY*2);
            INITIAL_CAPACITY *= 2;
        }
    }

    //Print
    public void print(){
        if(size==0){
            System.out.println("ARRAY IS EMPTY!");
            return;
        }

        for(int i=0; i<size; i++){
            System.out.println(i+"["+Items[i]+"]");
        }

    }

    //retrieve items based on index
    public int getItem(int index){
        return Items[index];
    }



}
