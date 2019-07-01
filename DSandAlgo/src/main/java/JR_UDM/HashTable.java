package JR_UDM;

public class HashTable {

    private int INITIAL_SIZE=16;
    //array of hashEntries
    private HashEntry[] dataArray;

    //declare hashEntry object - linked list for chaining to resolve collision
    class HashEntry{
        String key;
        String value;
        HashEntry nextHashEntry;

        public HashEntry(String key, String value){
            this.key = key;
            this.value = value;
            this.nextHashEntry = null;
        }
    }


    //Default Constructor - Initialize the HashTable array!
    public HashTable(){
        dataArray = new HashEntry[INITIAL_SIZE];
    }


    //declare size
    int size;

    //put method
    public void put(String key, String value){

        //Get the index
        int index = getIndex(key);

        //create new entry based on the input key and value
        HashEntry newEntry = new HashEntry(key,value);

        //check if index is null
        if(dataArray[index]==null){
            dataArray[index] = newEntry;
            size++;
        }
        //index available meaning it is collision so need to perform chaining of linked-list
        else{
            HashEntry entryList = dataArray[index];

            while (entryList.nextHashEntry!=null){
                entryList = entryList.nextHashEntry;
            }
            //Add new entry to end of the linked list object at retrieved index
            entryList.nextHashEntry = newEntry;
            size++;
        }
    }


    //get method
    public String get(String key){
        String returnValue = null;

        //get the index
        int index = getIndex(key);

        //get the listOfEntries at given index
        HashEntry entries = dataArray[index];

        //if index is not null
        if(entries!=null){

           //loop through the entries(entryList of given index) till it matches the key
           // meaning, walk the chain till it matches the key
            while (!entries.key.equalsIgnoreCase(key) && entries.nextHashEntry!=null){
                entries = entries.nextHashEntry;
            }

            if(entries.key.equalsIgnoreCase(key)){
                return entries.value;
            }

        }

        //if no entries available at the return index then return null
        return returnValue;
    }


    //retrieve index
    private int getIndex(String key) {
        int index=0;

        int hashCode = key.hashCode();
        System.out.println("Key Hash Code : "+hashCode);

        //convert hasCode to index

        index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

        //index = hashCode % INITIAL_SIZE;
        System.out.println("Converted Key Hash Code : "+index);

        //Hack to force collision for testing
        //In this case automatically rajanikant modi and kailash modi collision happening
        /*if(key.equalsIgnoreCase("Rajanikant Modi") || key.equalsIgnoreCase("Kailash Modi")){
            index = 5;
            System.out.println("Fixed index for collision for : "+index);
        }*/

        return index;
    }

    //return total size at this point
    public int getSize(){
        return size;
    }

}
