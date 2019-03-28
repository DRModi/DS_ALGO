package JR_UDM;

public class DynamicArray {

    private Object[] dataArray;
    private int size;
    private int initialCapacity;


    //create dynamic array
    public DynamicArray(int initialCapacity){
        this.initialCapacity = initialCapacity;
        dataArray = new Object[initialCapacity];
    }


    public String get(int index){
        return (String) dataArray[index];
    }

    public void set(int index, String value){
        dataArray[index] = value;
    }

    public void insert(int index, String value){
       /*
       * Pseudo code:
       * (1) Check the size, and compare with initial capacity to make sure sufficient space to insert element
       *     otherwise create new array with twice an initial capacity
       * (2) Copy existing array values to new array
       * (3) Point old array to new array
       * (4) Move/Copy up the elements, increment the size
       * */

        //Check size, create if full (1), (2), (3) is done.
       if(size==initialCapacity){
           resize();
       }

       //(4) Copy/Move up the array elements, remember size count start from 1 and index 0
        for(int j = size; j>index; j--){
           dataArray[j] = dataArray[j-1];
        }

        //Insert
        dataArray[index] = value;
        size++;
    }


    public void delete(int index){

        /*
        * (1) Move down the element
        * (2) Decrement the size
        * */

        //(1) size count is start with 1, index with 0
        for(int i = index; i < size - 1 ; i++){
            dataArray[i] = dataArray[i+1];
        }

        //(2)
        size--;
    }


    private void resize(){

        Object[] newDataArray = new Object[initialCapacity * 2];

        //copy existing old array to newly created array (with more capacity)
        for(int i = 0; i < initialCapacity; i++){
            newDataArray[i] = dataArray[i];
        }

        //Assigning old array to new array
        dataArray = newDataArray;
        initialCapacity = initialCapacity * 2;
    }


    //return array size.
    public int size(){
        return size;
    }



    //some array implementation offer methods like insert (also known as pushBack).
    //which is like insert, only in does the insert at the end of the array.
    public void add(String value){

        //check if array have space, if not then resize it
        if(size == initialCapacity){
            resize();
        }

        //insert new element at the end
        dataArray[size] = value;
        size++;

    }

    //Array is empty
    public boolean isArrayEmpty(){
        return size==0;
    }

    //String contains
    public boolean contains(String value){

        //boolean isStrContain = false;
        String inArrayStr = "";

        for(int i=0; i<size;i++){
            inArrayStr = (String) dataArray[i];
            if(inArrayStr.equalsIgnoreCase(value)){
        //        isStrContain = true;
                return true;
        //        break;
            }
        }
        //return isStrContain;
        return false;
    }

    public void print(){
        for(int i = 0; i<size; i++){
            System.out.println("dataArray["+i+"] = " + dataArray[i]);
        }
    }
}
