package JR_UDM;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    BinarySearchTree bst;

    @Before
    public void setup(){
        bst = new BinarySearchTree();
    }

    //iteratively
    @Test
    public void insertTestIteratively(){

        long currentMilisecondsAtStart = System.currentTimeMillis();
        System.out.println("Start Time in insert:  "+ currentMilisecondsAtStart);

        bst.insert_node(5, "e");
        //System.out.println("\n");
        bst.insert_node(3, "c");
        //System.out.println("\n");
        bst.insert_node(2, "b");
        //System.out.println("\n");
        bst.insert_node(4, "d");
        //System.out.println("\n");
        bst.insert_node(7, "g");
        //System.out.println("\n");
        bst.insert_node(6, "f");
        //System.out.println("\n");
        bst.insert_node(8, "h");
        //System.out.println("\n");
        bst.insert_node(1, "a");

        long currentMilisecondsAfterInsert = System.currentTimeMillis();
        System.out.println("End Time in insert:  "+ currentMilisecondsAfterInsert);

        long totalInsertTime = currentMilisecondsAfterInsert - currentMilisecondsAtStart;

        System.out.println("Total Time in insert:  "+ totalInsertTime);

        Assert.assertEquals(8,bst.getSize());

        Assert.assertEquals("e",bst.find_iteratively(5));
        Assert.assertEquals("e",bst.find_iteratively(5));
        Assert.assertEquals("c",bst.find_iteratively(3));
        Assert.assertEquals("b",bst.find_iteratively(2));

        Assert.assertEquals("d",bst.find_iteratively(4));

        Assert.assertEquals("g",bst.find_iteratively(7));
        Assert.assertEquals("f",bst.find_iteratively(6));
        Assert.assertEquals("h",bst.find_iteratively(8));
        Assert.assertEquals(null,bst.find_iteratively(99));



        Assert.assertEquals("e",bst.find_recursively(5));
        Assert.assertEquals("c",bst.find_recursively(3));
        Assert.assertEquals("b",bst.find_recursively(2));

        //Assert.assertEquals("d",bst.find_recursively(4));

        Assert.assertEquals("g",bst.find_recursively(7));
        Assert.assertEquals("f",bst.find_recursively(6));
        Assert.assertEquals("h",bst.find_recursively(8));
        Assert.assertEquals(null,bst.find_recursively(99));


    }

    //recursively
    @Test
    public void insertTestRecursively(){
        long currentMilisecondsAtStart = System.currentTimeMillis();
        System.out.println("Start Time in insert:  "+ currentMilisecondsAtStart);

        bst.insert_recursively(5, "e");
        System.out.println("\n");
        bst.insert_recursively(3, "c");
        System.out.println("\n");
        bst.insert_recursively(2, "b");
        System.out.println("\n");
        bst.insert_recursively(4, "d");
        System.out.println("\n");
        bst.insert_recursively(7, "g");
        System.out.println("\n");
        bst.insert_recursively(6, "f");
        //System.out.println("\n");
        bst.insert_recursively(8, "h");
        //System.out.println("\n");
        bst.insert_recursively(1, "a");

        long currentMilisecondsAfterInsert = System.currentTimeMillis();
        System.out.println("End Time in insert:  "+ currentMilisecondsAfterInsert);

        long totalInsertTime = currentMilisecondsAfterInsert - currentMilisecondsAtStart;

        System.out.println("Total Time in insert:  "+ totalInsertTime);

        Assert.assertEquals(8,bst.getSize());

        Assert.assertEquals("e",bst.find_iteratively(5));
        Assert.assertEquals("e",bst.find_iteratively(5));
        Assert.assertEquals("c",bst.find_iteratively(3));
        Assert.assertEquals("b",bst.find_iteratively(2));

        Assert.assertEquals("d",bst.find_iteratively(4));

        Assert.assertEquals("g",bst.find_iteratively(7));
        Assert.assertEquals("f",bst.find_iteratively(6));
        Assert.assertEquals("h",bst.find_iteratively(8));
        Assert.assertEquals("a",bst.find_iteratively(1));
        Assert.assertEquals(null,bst.find_iteratively(99));



        Assert.assertEquals("e",bst.find_recursively(5));
        Assert.assertEquals("c",bst.find_recursively(3));
        Assert.assertEquals("b",bst.find_recursively(2));

        //Assert.assertEquals("d",bst.find_recursively(4));

        Assert.assertEquals("g",bst.find_recursively(7));
        Assert.assertEquals("f",bst.find_recursively(6));
        Assert.assertEquals("h",bst.find_recursively(8));
        Assert.assertEquals("a",bst.find_recursively(1));
        Assert.assertEquals(null,bst.find_recursively(99));


        System.out.println("\n"+"max Node Value: " + bst.maxNodeValue() + " min Node value : "+bst.minNodeValue());
        Assert.assertEquals("h",bst.maxNodeValue());
        Assert.assertEquals("a", bst.minNodeValue());


    }

    @Test
    public void deleteNodeWithNoChild(){
        long currentMilisecondsAtStart = System.currentTimeMillis();
        System.out.println("Start Time in insert:  "+ currentMilisecondsAtStart);

        bst.insert_recursively(5, "e");
        //System.out.println("\n");
        bst.insert_recursively(3, "c");
        //System.out.println("\n");
        bst.insert_recursively(2, "b");
        //System.out.println("\n");
        bst.insert_recursively(4, "d");
        //System.out.println("\n");
        bst.insert_recursively(7, "g");
        //System.out.println("\n");
        bst.insert_recursively(6, "f");
        //System.out.println("\n");
        bst.insert_recursively(8, "h");
        //System.out.println("\n");
        //bst.insert_recursively(1, "a");

        long currentMilisecondsAfterInsert = System.currentTimeMillis();
        System.out.println("End Time in insert:  "+ currentMilisecondsAfterInsert);

        long totalInsertTime = currentMilisecondsAfterInsert - currentMilisecondsAtStart;

        System.out.println("Total Time in insert:  "+ totalInsertTime);

        Assert.assertEquals(7,bst.getSize());
        Assert.assertEquals("h",bst.find_recursively(8));

        bst.delete_recursively(8);
        Assert.assertEquals(6,bst.getSize());

        Assert.assertEquals(null,bst.find_recursively(8));

    }

    @Test
    public void deleteNodeWithSingleChild(){
        long currentMilisecondsAtStart = System.currentTimeMillis();
        System.out.println("Start Time in insert:  "+ currentMilisecondsAtStart);

        bst.insert_recursively(5, "e");
        //System.out.println("\n");
        bst.insert_recursively(3, "c");
        //System.out.println("\n");
        bst.insert_recursively(2, "b");
        //System.out.println("\n");
        bst.insert_recursively(4, "d");
        //System.out.println("\n");
        bst.insert_recursively(7, "g");
        //System.out.println("\n");
        bst.insert_recursively(6, "f");
        //System.out.println("\n");
        bst.insert_recursively(8, "h");
        //System.out.println("\n");
        bst.insert_recursively(1, "a");

        long currentMilisecondsAfterInsert = System.currentTimeMillis();
        System.out.println("End Time in insert:  "+ currentMilisecondsAfterInsert);

        long totalInsertTime = currentMilisecondsAfterInsert - currentMilisecondsAtStart;

        System.out.println("Total Time in insert:  "+ totalInsertTime);

        Assert.assertEquals(8,bst.getSize());
        Assert.assertEquals("a",bst.find_recursively(1));
        bst.delete_recursively(1);
        Assert.assertEquals(7,bst.getSize());
        Assert.assertEquals(null,bst.find_recursively(1));

    }

    @Test
    public void deleteNodeTwoChild(){
        long currentMilisecondsAtStart = System.currentTimeMillis();
        System.out.println("Start Time in insert:  "+ currentMilisecondsAtStart);

        bst.insert_recursively(5, "e");
        //System.out.println("\n");
        bst.insert_recursively(3, "c");
        //System.out.println("\n");
        bst.insert_recursively(2, "b");
        //System.out.println("\n");
        bst.insert_recursively(4, "d");
        //System.out.println("\n");
        bst.insert_recursively(7, "g");
        //System.out.println("\n");
        bst.insert_recursively(6, "f");
        //System.out.println("\n");
        bst.insert_recursively(8, "h");
        //System.out.println("\n");
        //bst.insert_recursively(1, "a");

        long currentMilisecondsAfterInsert = System.currentTimeMillis();
        System.out.println("End Time in insert:  "+ currentMilisecondsAfterInsert);

        long totalInsertTime = currentMilisecondsAfterInsert - currentMilisecondsAtStart;

        System.out.println("Total Time in insert:  "+ totalInsertTime);

        Assert.assertEquals(7,bst.getSize());
        Assert.assertEquals("g",bst.find_recursively(7));

        bst.delete_recursively(7);

        //Assert.assertEquals(6,bst.getSize());

        Assert.assertEquals(null,bst.find_recursively(7));

    }

    @Test
    public void testInOrderTraversal(){

        bst.insert_recursively(5, "e");
        //System.out.println("\n");
        bst.insert_recursively(3, "c");
        //System.out.println("\n");
        bst.insert_recursively(2, "b");
        //System.out.println("\n");
        //bst.insert_recursively(4, "d");
        //System.out.println("\n");
        bst.insert_recursively(7, "g");
        //System.out.println("\n");
        bst.insert_recursively(6, "f");
        //System.out.println("\n");
        bst.insert_recursively(8, "h");
        //System.out.println("\n");
        //bst.insert_recursively(1, "a");

        bst.prettyPrint();
        System.out.println("\n"+"\n");
        bst.printInOrderTraversal();


    }

}
