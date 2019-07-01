package JR_UDM;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinaryMaxIntHeapTest {

    BinaryMaxIntHeap binaryMaxIntHeap;

    @Before
    public void setup(){
       binaryMaxIntHeap = new BinaryMaxIntHeap();
    }

    @Test
    public void insert() throws Exception {


        binaryMaxIntHeap.insert(42);
        binaryMaxIntHeap.insert(29);
        binaryMaxIntHeap.insert(18);
        binaryMaxIntHeap.print();

        binaryMaxIntHeap.insert(35);
        System.out.println("\n"+"Insert 35" + "\n");
        binaryMaxIntHeap.print();

        //binaryMaxIntHeap.extractMax();
        System.out.println("\n"+"Extract Max" + "\n");
        binaryMaxIntHeap.print();

        // Test insert
        Assert.assertEquals(42, binaryMaxIntHeap.getItem(0));
        Assert.assertEquals(35, binaryMaxIntHeap.getItem(1));
        Assert.assertEquals(18, binaryMaxIntHeap.getItem(2));
        Assert.assertEquals(29, binaryMaxIntHeap.getItem(3));

        // Text extract max
        Assert.assertEquals(42, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(35, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(29, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(18, binaryMaxIntHeap.extractMax());
    }

    @Test
    public void ExtractMaxBigger() {

        binaryMaxIntHeap.insert(42);
        binaryMaxIntHeap.insert(29);
        binaryMaxIntHeap.insert(18);
        binaryMaxIntHeap.insert(14);
        binaryMaxIntHeap.insert(7);
        binaryMaxIntHeap.insert(18);
        binaryMaxIntHeap.insert(12);
        binaryMaxIntHeap.insert(11);
        binaryMaxIntHeap.insert(13);

        binaryMaxIntHeap.print();

        Assert.assertEquals(42, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(29, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(18, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(18, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(14, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(13, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(12, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(11, binaryMaxIntHeap.extractMax());
        Assert.assertEquals(7,  binaryMaxIntHeap.extractMax());

        System.out.println("\n"+"Final - all extract" + "\n");
        binaryMaxIntHeap.print();
    }
}
