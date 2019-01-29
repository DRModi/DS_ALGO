package JR_UDM;

import JR_UDM.LinkedList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {

    private LinkedList linkedList;

    @Before
    public void Setup() throws Exception {
        linkedList = new LinkedList();
    }

    @Test
    public void getFirst(){
       linkedList.addFront(1);
        Assert.assertEquals(1, linkedList.getFirstElement());
    }

    @Test
    public void getLast(){
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        Assert.assertEquals(1,linkedList.getLastElement());
        Assert.assertEquals(3,linkedList.getFirstElement());
    }


    @Test
    public void getFrontAndBack(){
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        System.out.println("Iterate: Yes: " + linkedList.getLastElement());
        Assert.assertEquals(1,linkedList.getLastElement());
        Assert.assertEquals(3,linkedList.getFirstElement());

        linkedList.addBack(0);

        System.out.println("Iterate: No : " + linkedList.getLastElement());
        Assert.assertEquals(0,linkedList.getLastElement());
        Assert.assertEquals(3,linkedList.getFirstElement());

        linkedList.addFront(4);

        System.out.println("Iterate: No : "+ linkedList.getLastElement());
        Assert.assertEquals(0,linkedList.getLastElement());
        Assert.assertEquals(4,linkedList.getFirstElement());
    }

    @Test
    public void sizeTest(){

        Assert.assertEquals(0,linkedList.size());
        Assert.assertEquals(0,linkedList.sizeUsingInternalCounter());

        linkedList.addFront(1);
        Assert.assertEquals(1, linkedList.size());

        System.out.println("*** "+linkedList.sizeUsingInternalCounter());
        Assert.assertEquals(1, linkedList.sizeUsingInternalCounter());


        linkedList.addBack(2);
        Assert.assertEquals(2,linkedList.size());
        Assert.assertEquals(2, linkedList.sizeUsingInternalCounter());
    }

    @Test
    public void clearLinkedList(){

        linkedList.addFront(1);
        linkedList.addBack(0);

        Assert.assertEquals(2,linkedList.size());
        Assert.assertEquals(2, linkedList.sizeUsingInternalCounter());

        linkedList.clear();

        Assert.assertEquals(0,linkedList.size());
        Assert.assertEquals(0, linkedList.sizeUsingInternalCounter());

    }

    @Test
    public void deleteTest(){
        linkedList.addBack(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addBack(0);


        Assert.assertEquals(4,linkedList.size());
        Assert.assertEquals(4, linkedList.sizeUsingInternalCounter());

        linkedList.delete(3);


        Assert.assertEquals(2,linkedList.getFirstElement());
        Assert.assertEquals(0,linkedList.getLastElement());

        Assert.assertEquals(3,linkedList.size());
        Assert.assertEquals(3, linkedList.sizeUsingInternalCounter());

    }

    @Test
    public void addInMiddleTest(){



       /* linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addFront(4);
        linkedList.addBack(0);

        linkedList.printAllNode(2);

        Assert.assertEquals(4,linkedList.size());
        Assert.assertEquals(4, linkedList.sizeUsingInternalCounter());


        linkedList.addInMiddle(1,0);
        //linkedList.addInMiddle(4,5);

        linkedList.printAllNode(3);

        Assert.assertEquals(6,linkedList.size());
        Assert.assertEquals(6, linkedList.sizeUsingInternalCounter());


        Assert.assertEquals(true, linkedList.isContain(1));
    */
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.addBack(0);

        linkedList.printAllNode(1);

        linkedList.addInMiddle(1,2);

        linkedList.printAllNode(2);

        linkedList.addInMiddle(5,1);

        linkedList.printAllNode(3);

        linkedList.addInMiddle(6,0);

        linkedList.printAllNode(4);

    }


    @Test
    public void addAtGivenPosition() {

        linkedList.addFront(3);
        linkedList.addFront(4);
        linkedList.addFront(5);
        linkedList.addBack(0);

        linkedList.printAllNode(1);

        System.out.println("************** Add 1 to the list");

        linkedList.insertAtGivenPosition(1,3);

        linkedList.printAllNode(2);

        System.out.println("************** Add 2 to the list");

        linkedList.insertAtGivenPosition(2,3);

        linkedList.printAllNode(3);

        System.out.println("************** Add 6 to the list");

        linkedList.insertAtGivenPosition(6,-8);

        linkedList.printAllNode(2);

    }









}
