package JR_UDM;

public class Stacks {

    class Node{
        int data;
        Node nextElement;

        public Node(int data){
           this.data = data;
        }
    }

    //declare head
    Node head = null;

    //private int size - to track the size of the element
    int size;

    //push elements to stacks
    public void push(int data){

        Node newNode = new Node(data);

        //if it is first element in the stack
        /*
        Nothing wrong doing below, but it is not required since you are setting whatever added as Head.
        if(head==null){
            head = newNode;
            return;
        }*/
        //if head is not null
        newNode.nextElement = head;
        head = newNode;
        size++;

    }

    //pop elements to stacks
    public int pop(){

        //check if head is null
        if(head==null){
            throw new IllegalStateException("JR_UDM.Stacks is Empty!!");
        }

        int returnData = head.data;

        /*
        Nothing wrong in this but we no need to check null head since no matter what if head is not null we assign
        head to next element irrespective of null or not.
        if(head.nextElement!=null){
            head = head.nextElement.nextElement;
        }else{
            head = null;
        }*/

        head = head.nextElement;
        size--;
        return returnData;

    }


    public int getSize(){
        return size;
    }


    public boolean isEmpty(){

        if(size==0)
            return true;
        else
            return false;
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
