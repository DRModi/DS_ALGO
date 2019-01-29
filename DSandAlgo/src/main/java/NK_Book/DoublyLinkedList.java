package NK_Book;

public class DoublyLinkedList {

    class Node{
        int data;
        Node nextElement;
        Node previousElement;

        public Node(int data){
            this.data = data;
        }
    }


    Node head;
    int size;


    public void addFront(int data){

        /*
         * (1) Create new node
         * (2) if head null, then head is new node
         * (3) If head is not null, then point newNode nextElementPointer to Head
         * (4) Make NewNode previousElementPointer null
         * (5) Make head previous pointer to newNode
         * */


        //(1)
        Node newNode = new Node(data);

        //(2) if head = null
        if(head==null){
            head = newNode;
            return;
        }

        //(3)
        newNode.nextElement = head;

        //(4)
       // newNode.previousElement = null;

        //(5)
        //head.previousElement = newNode;

        //(6)
        head = newNode;

        size++;

    }



    public int getHead(){
        if(head==null){
            throw new IllegalStateException("Doubly Linked List is EMPTY!");
        }

        return head.data;
    }



    public void addBack(int data){

        /*
        * (1) Create node
        * (2) if head null, it become head
        * (3) other wise, current.nextElement = newNode
        * (4) newNode.previous = current.nextElement
        * (5) newNode.nextElement = null
        * */


        //(1)
        Node newNode = new Node(data);

        //(2)
        if(head==null){
            head = newNode;
            size++;
            return;
        }

        //(3-A) retrieve last node
        Node currentNode = head;
        while (currentNode.nextElement!=null){
            currentNode = currentNode.nextElement;
        }

        //(4)
        newNode.previousElement = currentNode.nextElement;

        //(5)
        newNode.nextElement = null;

        //(3-B)
        currentNode.nextElement = newNode;

        size++;
    }


    public int getLastElement(){

        if(head==null){
            throw new IllegalStateException("Doubly Linked List is EMPTY");
        }

        Node currentNode = head;
        while (currentNode.nextElement!=null){
            currentNode = currentNode.nextElement;
        }

        return currentNode.data;
    }


    public void delete(int data){

        if(head.data==data){
            /*
            * (1) Make head.nextElement previous pointer to be null
            * (2) Assign head to head.nextElement
            * (3) Make head.previous element null
            * */

            //(1)
            head.nextElement.previousElement = null;
            //(2)
            head = head.nextElement;
            //(3)
            head.previousElement = null;
            return;
        }

        Node currentNode = head;
        while(currentNode.nextElement!=null){


            if(currentNode.nextElement.data==data){

                Node removeNode = currentNode.nextElement;
                Node previousNode = currentNode;
                Node nextToNextNode = currentNode.nextElement.nextElement;

                previousNode.nextElement = nextToNextNode;

                if(nextToNextNode!=null) {
                    nextToNextNode.previousElement = previousNode;
                }
                removeNode.previousElement = null;
                removeNode.nextElement = null;


                size--;
                return;
            }
            currentNode = currentNode.nextElement;
        }
    }



    public void printAll(){

        if(head==null){
            throw new IllegalStateException("Doubly Linked List is EMPTY!");
        }

        Node currentNode = head;
        System.out.println("Head Element: "+head.data);

        while (currentNode.nextElement!=null){
            System.out.println("Element: "+currentNode.nextElement.data);
            currentNode = currentNode.nextElement;
        }
    }


    public void clearList(){
        head = null;
        size = 0;
    }








}
