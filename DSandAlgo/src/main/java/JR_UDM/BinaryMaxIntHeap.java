package JR_UDM;

import java.util.Arrays;

public class BinaryMaxIntHeap {

    private int initialCapacity = 10;
    private int size;
    private int[] items;

    public BinaryMaxIntHeap(){
       items = new int[initialCapacity];
    }


    //retrieve index for parent, left child, right child.
    private int retrieveLeftChildIndex(int parentIndex){return (2 * parentIndex + 1);}
    private int retrieveRightChildIndex(int parentIndex){return (2 * parentIndex + 2);}
    private int retrieveParentIndex(int childIndex){return (childIndex - 1)/2;}


    //check if parent, left child, right child exist
    private boolean hasLeftChild(int index){return retrieveLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index) {return retrieveRightChildIndex(index) < size;}
    private boolean hasParent(int index) {return retrieveParentIndex(index)>=0;}


    //return the value of parent, left child and right child
    private int getLeftChildValue(int index){return items[retrieveLeftChildIndex(index)];}
    private int getRightChildValue(int index){return items[retrieveRightChildIndex(index)];}
    private int getParentValue(int index){return items[retrieveParentIndex(index)];}

    //insert items
    public void insert(int item){
        //ensure the capacity of the Array
        ensureCapacity();

        /*/empty array - No need to check, since we are not retrieving
        if(size==0){
            items[0] = item;
            size++;
            return;
        }*/
        items[size] = item;
        size++;
        MoveUp();
    }

    //Extract Items
    public int extractMax(){
        int max = 0;

        if(size==0){
           // return 0; //return 0 or Null based on the requirement.
            throw new IllegalStateException("Array is empty!");
        }
        max = items[0]; //grab the max
        items[0] = items[size-1]; //swap top and bottom
        size--;
        MoveDown();
        return max;
    }

    private void MoveDown() {

        //check which child is greater and replace that child with parent
        int index = 0; //max index

        while (hasLeftChild(index)){


            //set greaterChildIndex = rightChildIndex to start with
            int greaterChildIndex = retrieveRightChildIndex(index);

            //if leftchild is greater than right, set greaterChildIndex = leftChildIndex
            if(getLeftChildValue(index) > getRightChildValue(index)){
                greaterChildIndex = retrieveLeftChildIndex(index);
            }

            //now check if larger Child is greater than parent, then swap them
            if(items[greaterChildIndex] < items[index])
            {
                break;
            }else
            {
                swap(greaterChildIndex, index);
            }

            index = greaterChildIndex;
        }


    }

    private void MoveUp() {
        //Find the bottom index where new node inserted
        int index = size-1;

        while (hasParent(index) && getParentValue(index) < items[index]){
            swap(retrieveParentIndex(index), index);
            index = retrieveParentIndex(index);
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }


    //resize the array
    public void ensureCapacity(){
        if(size==initialCapacity) {
            items = Arrays.copyOf(items, initialCapacity * 2);
            initialCapacity *= 2;
        }
    }

    //Print the array
    public void print(){
        if(size==0) {
            System.out.println("Array is EMPTY!");
            return;
        }

        for (int i=0; i<size; i++){
            System.out.println(i+"["+items[i]+"]");
        }
    }

    //retrieve items based on index
    public int getItem(int index){
        return items[index];
    }



}
