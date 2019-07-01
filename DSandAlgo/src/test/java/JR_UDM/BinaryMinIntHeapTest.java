package JR_UDM;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinaryMinIntHeapTest {

    BinaryMinIntHeap binaryMinIntHeap;

    @Before
    public void setup(){
        binaryMinIntHeap = new BinaryMinIntHeap();
    }

    @Test
    public void insert(){
        binaryMinIntHeap.insert(42);
        binaryMinIntHeap.insert(29);
        binaryMinIntHeap.insert(18);
        binaryMinIntHeap.print();

        binaryMinIntHeap.insert(35);
        System.out.println("\n"+"Insert 35" + "\n");
        binaryMinIntHeap.print();


        //binaryMinIntHeap.extractMin();
        System.out.println("\n"+"Extract Min" + "\n");
        binaryMinIntHeap.print();


        // Test insert
        Assert.assertEquals(18, binaryMinIntHeap.getItem(0));
        Assert.assertEquals(35, binaryMinIntHeap.getItem(1));
        Assert.assertEquals(29, binaryMinIntHeap.getItem(2));
        Assert.assertEquals(42, binaryMinIntHeap.getItem(3));

        // Text extract min
        Assert.assertEquals(18, binaryMinIntHeap.extractMin());
        Assert.assertEquals(29, binaryMinIntHeap.extractMin());
        Assert.assertEquals(35, binaryMinIntHeap.extractMin());
        Assert.assertEquals(42, binaryMinIntHeap.extractMin());
    }

    @Test
    public void ExtractMinSmaller() {

        binaryMinIntHeap.insert(42);
        binaryMinIntHeap.insert(29);
        binaryMinIntHeap.insert(18);
        binaryMinIntHeap.insert(14);
        binaryMinIntHeap.insert(7);
        binaryMinIntHeap.insert(18);
        binaryMinIntHeap.insert(12);
        binaryMinIntHeap.insert(11);
        binaryMinIntHeap.insert(13);

        binaryMinIntHeap.print();


        Assert.assertEquals(7,  binaryMinIntHeap.extractMin());
        Assert.assertEquals(11, binaryMinIntHeap.extractMin());


        Assert.assertEquals(12, binaryMinIntHeap.extractMin());
        Assert.assertEquals(13, binaryMinIntHeap.extractMin());

        //binaryMinIntHeap.extractMin();
        System.out.println("\n"+"Extract 18" + "\n");
        binaryMinIntHeap.print();
        Assert.assertEquals(14, binaryMinIntHeap.extractMin());
        Assert.assertEquals(18, binaryMinIntHeap.extractMin());
        Assert.assertEquals(18, binaryMinIntHeap.extractMin());
        Assert.assertEquals(29, binaryMinIntHeap.extractMin());
        Assert.assertEquals(42, binaryMinIntHeap.extractMin());

        System.out.println("\n"+"Final - all extract" + "\n");
        binaryMinIntHeap.print();

    }
}
