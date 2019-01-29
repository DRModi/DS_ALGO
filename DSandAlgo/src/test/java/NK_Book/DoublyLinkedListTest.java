package NK_Book;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {

    private DoublyLinkedList doublyLinkedList;


    @Before
    public void initialSetup(){
       doublyLinkedList  = new DoublyLinkedList();
    }

    @Test
    public void addFrontTest(){

        doublyLinkedList.addFront(0);
        Assert.assertEquals(0, doublyLinkedList.getHead());

        doublyLinkedList.addFront(1);
        Assert.assertEquals(1, doublyLinkedList.getHead());

        doublyLinkedList.printAll();

    }

    @Test
    public void addBackTest(){

        doublyLinkedList.addBack(2);
        Assert.assertEquals(2, doublyLinkedList.getLastElement());

        doublyLinkedList.addBack(1);
        Assert.assertEquals(1, doublyLinkedList.getLastElement());

        doublyLinkedList.addBack(0);
        Assert.assertEquals(0, doublyLinkedList.getLastElement());

        doublyLinkedList.printAll();

    }

    @Test
    public void deleteTest(){
        doublyLinkedList.addFront(1);
        doublyLinkedList.addFront(2);
        doublyLinkedList.addFront(3);


        doublyLinkedList.printAll();

        doublyLinkedList.delete(1);

        doublyLinkedList.printAll();


    }
}
