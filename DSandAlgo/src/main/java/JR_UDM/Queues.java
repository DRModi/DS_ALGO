package JR_UDM;

public class Queues {

    class Node{
        int data;
        Node nextElement;

        public Node(int data){
            this.data = data;
        }
    }


    //declare head
    Node head = null;

    //Size for tracking the number of elements in Queues
    int size;

    //declare tail
    Node tail = null;

    //Adding the element at the back of the linked list
    public void add(int data){

        Node newNode = new Node(data);

        //if head is null
        if(head==null){
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        //adding element at the back
        tail.nextElement = newNode;
        tail = newNode;

        size++;

    }

    //Removing element from the top
    public int remove(){

        //if head is null
        if(head==null){
            throw new IllegalStateException("Queue is empty!");
        }

        int returnData = head.data;
        head = head.nextElement;

        size--;
        return returnData;
    }

    //return current size
    public int size(){
        return size;
    }

    //check if it is empty
    public boolean isEmpty(){
        boolean isEmpty=false;

        if(size==0 || head==null) {
             isEmpty = true;
        }

        return isEmpty;
    }

    public int peek(){
        //if head is null
        if(head==null){
            throw new IllegalStateException("Queue is empty!");
        }
        int returnData = head.data;
        return returnData;
    }
}
