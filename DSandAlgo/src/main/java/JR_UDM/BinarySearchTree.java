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
            return;
        }

        root = insert_node_recursively(root, key, value);
    }

    //insert recursively
    public Node insert_node_recursively(Node node, int key, String value){

        //if node is null - set the new node here.
        if(node==null){
            node = new Node(key,value);
            size++;
            return node;
        }

        //Else walk till null node found
        if(key<node.key){
            node.leftNode = insert_node_recursively(node.leftNode, key, value);
        }else{ //(key>node.key
            node.rightNode = insert_node_recursively(node.rightNode,key,value);
        }

        return node;
    }


    //insert iteratively
    public void insert_node(int key, String value){

        System.out.println("Current Key : "+key);
        if(root==null){
            root = new Node(key, value);
            size++;
            return;
        }


        Node currentNode = root;


        while(currentNode.key!=key){
            System.out.println("### currentNode.key : "+ currentNode.key);
            if(key<currentNode.key){
                if(currentNode.leftNode==null){
                    System.out.println("left - Setup of Key  : "+key);
                    currentNode.leftNode = new Node(key, value);
                    size++;
                    return;
                }else{
                    currentNode = currentNode.leftNode;
                }
            }

            System.out.println("*** currentNode between right and left : "+currentNode.key);

            if(key>currentNode.key){
                if(currentNode.rightNode==null){
                    System.out.println("right - Setup of Key  : "+key);
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

    //Find Min
    public Node findMin(Node node){
        return node.min();
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
        else{ // found this the node we want to delete

            //case 1: if no children
            if(node.rightNode==null || node.leftNode==null){
                node = null;
                //return node;
            }

            //case 2: if single child
            if(node.rightNode==null){
                node = node.leftNode;
            }else if (node.leftNode==null){
                node = node.rightNode;
            }
            else {

                //case 3: if both children are there
                // 1. Find minimum node on right side (could also max the left..)
                //  2. Replace node with minimum node (duplicate it in place of the node which needs to be deleted)
                //  3. Recursively remove the minimum node

                //1. Find minimum node on the right side
                Node minimumNode = findMin(node.rightNode);

                //2. Replace node with minimum node
                node.key = minimumNode.key;
                node.value = minimumNode.value;

                //3. Recursively remove the minimumRightNode - passing minimum right node as root node to find and
                // remove the node from bottom of the tree which was used to replace node in step 2.
                node.rightNode = delete_item_recursively(node.rightNode, node.key);
            }

        }

        return node;
    }





}
