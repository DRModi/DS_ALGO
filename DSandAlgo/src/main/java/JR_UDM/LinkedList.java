package JR_UDM;

import sun.awt.image.ImageWatched;

public class LinkedList {

    class Node{
        int data;
        Node nextElement;

        public Node(int data){
            this.data = data;
        }
    }

    //declare head
    private Node head;

    //Internal increment counter for size.
    private int size;

    //As part of improvement, keep track of tail whenever possible, in case you want to access it so that no need to iterate to just get that:
    private Node tailNode;


    //Add front - Adding/setting head.
    public void addFront(int data){
        /*
        * (1) create new node,
        * (2) Check if it is the first ever node then set as head
        * (3) if 2 is not applicable, then point new node to head
        * (4) set head as new node.
        * */

        //(1) Create new node:
        Node newNode = new Node(data);

        //(2) set head
        if(head==null){
            head = newNode;
            size++;
            return;

        }

        //(3) point newNode to head.
        newNode.nextElement = head;

        //(4) make/set new node as head/
        head = newNode;

        //To retrieve size
        size++;
    }


    //Add back - Adding at the tail
    public void addBack(int data){
        /*
        * (1) Create new node
        * (2) If head=null, make new node as head and return head
        * (3) Loop the elements find the tail
        * (4) Set/Add tail.nextElement = newNode (made newNode tail).
        * */

        //(1) Create Node
        Node newTailNode = new Node(data);

        //(2) check if head is null, if yes then set newNode as head.
        if(head==null){
            head = newTailNode;
            size ++;
            return;
        }


        //(3) Iterate all the element and find tail
        Node currentNode = head;
        while(currentNode.nextElement!=null){
            currentNode = currentNode.nextElement;
        }

        //(4) Set/append the tailNode to the currentNode.
        currentNode.nextElement = newTailNode;

        //Improvement Keep track of tail node:
        tailNode = newTailNode;

        //To retrieve size
        size++;
    }



    //retrieve getFirst
    public int getFirstElement(){
        //check if head is not null
        if(head==null){
            throw new IllegalStateException("JR_UDM.LinkedList is Empty!!");
        }

        return head.data;
    }

    //retrieve the last element
    public int getLastElement(){
        //check if head is null
        if(head==null){
            throw new IllegalStateException("JR_UDM.LinkedList is Empty!!");
        }

        //point head element
        Node currentNode = head;

       /*
        //while loop, we are not at the tail, just before element of tail.

        while (currentNode.nextElement!=null){
            currentNode = currentNode.nextElement; //linear time BigO(n), bcoz we have loop this till,
                                                   // we reach the last element where nextElement Pointer have value of null
        }
        */

       // Improvement.
       // Commented above code to save the iteration if trailNode is available,
       // which was setup by this code previously or the AddBack method>
        if(tailNode==null){
            while (currentNode.nextElement!=null){
                currentNode = currentNode.nextElement; //linear time BigO(n), bcoz we have loop this till,
                // we reach the last element where nextElement Pointer have value of null
            }
            System.out.println("This being iterate! "+currentNode.data);
            tailNode = currentNode;
        }
        return tailNode.data;
    }



    //find size of linked list, more of brut force, so it is like for size operation is linear O(n)
    public int size(){

        //check if it is empty
        if(head==null){
            return 0;
        }

        int count = 1;
        Node currentNode = head;
        while(currentNode.nextElement!=null){
            currentNode = currentNode.nextElement;
            count++;
        }

     return count;
    }


    //it is more efficient and elegant way
    public int sizeUsingInternalCounter(){

        return size;
    }


    //Clear full list
    public void clear(){
        head = null;
        size = 0; //since we are clearing the linked list.
    }


    public void delete(int data){
       /* Delete involves three scenario
       * (1) head is null or size 0, just return
       * (2) if head being removed then, head.nextElement become head
       * (3) Same (2) step thing apply to middle element where we move nextElement.nextElement twice
       * */

       //(1) Head or size is 0
        if(head==null||size==0){
            return;
        }

        //(2) If head is being removed then point nextElement to head.
        if(head.data==data){
            head = head.nextElement;
            size--;
            return;
        }

        //(3) if it is tail or middle element then
        Node currentNode = head;

        while (currentNode.nextElement!=null){

            if(currentNode.nextElement.data==data){
                currentNode.nextElement = currentNode.nextElement.nextElement;
                size--;
                return;
            }
            currentNode = currentNode.nextElement;
        }

    }

    //check if data contain
    public boolean isContain(int data){
        if(head==null || size==0){
            return false;
        }

        if(head.data==data){
            return true;
        }

        boolean isContain = false;

        Node currentNode = head;
        while(currentNode.nextElement!=null){

            if(currentNode.nextElement.data==data){
                isContain = true;
            }

            currentNode = currentNode.nextElement;
        }

        return isContain;

    }


    //Add in middle
    public void addInMiddle(int newData, int beforeThisData ){

        if(head.data == beforeThisData){
            addFront(newData);
            return;
        }


      /*  if(tailNode.data == beforeThisData){
            delete(beforeThisData);
            int temp = tailNode.data;
            addBack(newData);
            addBack(temp);
            return;
        }
*/

        if(isContain(beforeThisData)){
            boolean isAddTail = false;
            Node newNode = new Node(newData);
            Node currentNode = head;

            while(currentNode.nextElement!=null){
                Node iterativeNode = currentNode.nextElement;

                if(currentNode.nextElement.data == beforeThisData){

                    Node nextNode = currentNode.nextElement;
                    Node nextToNextNode = currentNode.nextElement.nextElement;

                    //System.out.println("Print previous Node: " + previousNode.data);
                    //System.out.println("Print N2N Node: " + nextToNextNode.data);

                    currentNode.nextElement = newNode;
                    //System.out.println("Print previous Node Next Element Data: " + previousNode.nextElement.data);

                    newNode.nextElement = nextNode;
                    //System.out.println("After New Node Next Element Data: " + newNode.nextElement.data);

                    nextNode.nextElement = nextToNextNode;
                    //System.out.println("Final Next to Next Element Data: " + currentNode.nextElement.data);




                   /*Node nextTonextNode = currentNode.nextElement.nextElement;
                    Node nextNode = currentNode.nextElement;

                    currentNode = newNode;


                   // System.out.println("data: at CurrentNode : " + currentNode.data);
                    //System.out.println("data: at CurrentNode NextElement : " + currentNode.nextElement.data);

                    newNode.nextElement = nextNode;

                    //System.out.println("data: at NewNode : " + newNode.data);

                    nextNode.nextElement = nextTonextNode;

                    //System.out.println("data: at Next to Next CurrentNode : " + currentNode.nextElement.nextElement.data);
                   */
                    size++;
                    return;
                }
                currentNode = currentNode.nextElement;
            }

        }

    }


    //Add value at given position
    public void insertAtGivenPosition(int data, int position){

        /*
        * (1) if position is <= 0 then, set position to 0, means head add front
        * (2) if position is >= size then, set position to size+1, means next to tail node addBack
        * (3) if it is in between then add it at proper place
        *
        * */

        //(1)
        if(position<=0){
            addFront(data);
            return;
        }


        //(2)
        if(position>=size){
            addBack(data);
            return;
        }

        //(3)
        Node currentNode = head;


        int countPosition = 0;

        while(currentNode.nextElement!=null){
            countPosition++;

            if(countPosition==position){
                Node newNode = new Node(data);
                Node nextToCurrent = currentNode.nextElement;


                currentNode.nextElement = newNode;
                newNode.nextElement = nextToCurrent;


                size++;
                return;
            }

            currentNode = currentNode.nextElement;
        }


    }

    //Print All node:
    public void printAllNode(int number){
        if(size==0||head==null){
            System.out.println("List is Empty!");
            return;
        }

        Node currentNode = head;
        System.out.println("Element Data : For Number: "+number+" - " + head.data + "\n");

        while(currentNode.nextElement!=null){
            currentNode = currentNode.nextElement;
            System.out.println("Element Data : For Number: "+number+" - " + currentNode.data + "\n");
        }
    }
}
