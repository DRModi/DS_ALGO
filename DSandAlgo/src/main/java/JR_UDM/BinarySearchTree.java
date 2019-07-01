package JR_UDM;

public class BinarySearchTree {

    class Node{
        int key;
        String value;
        Node leftNode, rightNode;

        public Node(int key, String value){
            this.key = key;
            this.value = value;
        }


        //read it twice - return this, means return node where its left node is null
        public Node min(){
            if (leftNode==null){
                return this;
            } else{
                return leftNode.min();
            }

        }

        //Find max on the left
        public Node max(){
            if(rightNode==null){
                return this;
            }else{
                return rightNode.max();
            }
        }
    }

    //Declare root node
    Node root;

    //Declare size
    int size;

    public BinarySearchTree(){
        //initialize root with null value
        root = null;
    }

    //insert recursively
    public void insert_recursively(int key, String value){

        if(root == null){
            root = new Node(key, value);
            size++;
            System.out.println("It came here!");
            return;
        }

        root = insert_node_recursively(root, key, value);
        System.out.println("This is also being printed");
    }

    //insert recursively
    public Node insert_node_recursively(Node node, int key, String value){

        //if node is null - set the new node here.
        if(node==null){
            node = new Node(key,value);
            size++;
            System.out.println("Printed inside null : "+size);
            return node;
        }

        //Else walk till null node found
        if(key<node.key){
            System.out.println("printed inside left : "+size);
            node.leftNode = insert_node_recursively(node.leftNode, key, value);
        }else{ //(key>node.key
            System.out.println("printed inside right : "+size);
            node.rightNode = insert_node_recursively(node.rightNode,key,value);
        }

        System.out.println("Printing the return node.key to understand how node being return - "+node.key+ " : size - "+size);
        return node;

    }


    public void insert(Node node, int key, String value){

        if(node==null){
            node = new Node(key,value);
            return;
        }

        if(key>node.key){
            insert(node.rightNode,key,value);
        }
    }


    //insert iteratively
    public void insert_node(int key, String value){

        //System.out.println("Current Key : "+key);
        if(root==null){
            root = new Node(key, value);
            size++;
            return;
        }


        Node currentNode = root;


        while(currentNode.key!=key){
           // System.out.println("### currentNode.key : "+ currentNode.key);
            if(key<currentNode.key){
                if(currentNode.leftNode==null){
                   // System.out.println("left - Setup of Key  : "+key);
                    currentNode.leftNode = new Node(key, value);
                    size++;
                    return;
                }else{
                    currentNode = currentNode.leftNode;
                }
            }

            //System.out.println("*** currentNode between right and left : "+currentNode.key);

            if(key>currentNode.key){
                if(currentNode.rightNode==null){
                    //System.out.println("right - Setup of Key  : "+key);
                    currentNode.rightNode = new Node(key, value);
                    size++;
                    return;
                }else{
                    currentNode = currentNode.rightNode;
                }
            }
        }
    }


    //find recursively
    public String find_recursively(int key){

        Node node = find_recursively_node(root, key);

        return node == null ? null : node.value;

    }

    //find recursively
    public Node find_recursively_node(Node node, int key){

        if(node == null || node.key==key){
            return node;
        }

        if(key<node.key){
            return find_recursively_node(node.leftNode, key);
        }
        else if (key>node.key){
            return find_recursively_node(node.rightNode, key);
        }

        return node;
    }

    //find iteratively
    public String find_iteratively(int key){

        Node node = root;

        if(node==null) {
            return null;
        }

        if(node.key==key){
            return node.value;
        }

        Node currentNode = node;

        while (currentNode.key!=key){

            if(key<currentNode.key){
                if(currentNode.leftNode==null){
                    return null;
                }else{
                    currentNode = currentNode.leftNode;
                }
            }

            if(key>currentNode.key){
                if(currentNode.rightNode==null){
                   return null;
                }else{
                    currentNode = currentNode.rightNode;
                }
            }
        }

        return currentNode.value;
    }

    //getting size
    public int getSize(){
        return size;
    }

    //Find Min node
    public Node findMinNode(Node node){
        return node.min();
    }

    //find max node
    public Node findMaxNode(Node node){return node.max();}

    //Find min node key
    public String minNodeValue(){
        if(root==null){
            return null;
        }

        String returnKey = "";

        Node currentNode = root.min();

        if(currentNode==null){
            return null;
        }else {

            returnKey=currentNode.value;
        }

        return returnKey;
    }

    //Find min node key
    public String maxNodeValue(){
        if(root==null){
            return null;
        }

        String returnKey = "";

        Node currentNode = root.max();

        if(currentNode==null){
            return null;
        }else {

            returnKey=currentNode.value;
        }

        return returnKey;
    }

    //delete recursively
    public void delete_recursively(int key){

        if(root==null){
            return;
        }

        root = delete_item_recursively(root, key);
    }

    public Node delete_item_recursively(Node node, int key){

        if(node==null){
            return null;
        }
        else if(key<node.key){
            node.leftNode = delete_item_recursively(node.leftNode, key);
        }
        else if(key>node.key){
            node.rightNode = delete_item_recursively(node.rightNode, key);
        }
        else{ // found this the node we want to delete - means (key==node.key)

            //Deletion of the node - Three possible case needs to be handled
            // 1. No child
            // 2. Single child
            // 3. Two children

            //case 1: if no children - both left and right node will be null in this case - Obvious right! :)
            if(node.rightNode==null || node.leftNode==null){
                node = null;
                //return node;
                size--;
            }

            //case 2: if single child
            else if(node.rightNode==null){
                node = node.leftNode;
                size--;
            }else if (node.leftNode==null){
                node = node.rightNode;
                size--;
            }
            else {

                //case 3: if both children are there - Remember one thing - in binary tree can be represented same data in multiple ways.

                //  1. Find minimum node on right side (could also max of the left side do the job..)
                //  2. Replace node with minimum node (duplicate it in place of the node which needs to be deleted)
                //  3. Recursively remove the minimum node

                //1. Find minimum node on the right side(Find min from right end side - if only one node (lets say x) leaves on right side
                //   then use that node otherwise find minimum from that node (x).
                Node minimumNode = findMinNode(node.rightNode);

                //2. Replace node with minimum node
                node.key = minimumNode.key;
                node.value = minimumNode.value;

                //3. Recursively remove the minimumRightNode - passing minimum right node as root node to find and
                // remove the node from bottom of the tree which was used to replace node in step 2.
                node.rightNode = delete_item_recursively(node.rightNode, node.key);
                size--;
            }

        }

        return node;
    }


    //Binary Tree - Depth First Search / Traversal
    // 1. InOrder (Left, Root, Right)
    // 2. PreOrder (Root, Left, Right)
    // 3. PostOrder (Left, Right, Root)


    //1. InOrder (Left, Root, Right)
    public void printInOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node){
        if(node!=null){ //inOrder (Left, Root, Right)
            inOrderTraversal(node.leftNode);
            System.out.println(node.key);
            inOrderTraversal(node.rightNode);
        }
    }

    //2. PreOrder (Root, Left, Right)
    public void printPreOrderTraversal(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node){
        if(node!=null){ // preOrder (Root, Left, Right)
            System.out.println(node.key); // root
            preOrderTraversal(node.leftNode);
            preOrderTraversal(node.rightNode);
        }
    }

    //3. PostOrder (Left, Right, Root)
    public void printPostOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node){

        if(node!=null){ //post order (Left, Right, Root)
            postOrderTraversal(node.leftNode);
            postOrderTraversal(node.rightNode);
            System.out.println(node.key);
        }

    }


    public void prettyPrint() {
        // Hard coded print out of binary tree depth = 3

        int rootLeftKey = root.leftNode == null ? 0 : root.leftNode.key;
        int rootRightKey = root.rightNode == null ? 0 : root.rightNode.key;

        int rootLeftLeftKey = 0;
        int rootLeftRightKey = 0;

        if (root.leftNode != null) {
            rootLeftLeftKey = root.leftNode.leftNode == null ? 0 : root.leftNode.leftNode.key;
            rootLeftRightKey = root.leftNode.rightNode == null ? 0 : root.leftNode.rightNode.key;
        }

        int rootRightLeftKey = 0;
        int rootRightRightKey = 0;

        if (root.rightNode != null) {
            rootRightLeftKey = root.rightNode.leftNode == null ? 0 : root.rightNode.leftNode.key;
            rootRightRightKey = root.rightNode.rightNode == null ? 0 : root.rightNode.rightNode.key;
        }

        System.out.println("     " + root.key);
        System.out.println("   /  \\");
        System.out.println("  " + rootLeftKey + "    " + rootRightKey);
        System.out.println(" / \\  / \\");
        System.out.println(rootLeftLeftKey + "  " + rootLeftRightKey + " " + rootRightLeftKey + "   " + rootRightRightKey);
    }




}
