package JR_UDM;

import JR_UDM.DynamicArray;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicArrayTest {

    private DynamicArray array;

    @Before
    public void Setup() throws Exception{
        array = new DynamicArray(2);
    }

    @Test
    public void runGetSet(){
        array.set(0,"a");
        Assert.assertEquals("a",array.get(0));
    }

    @Test
    public void Insert(){
        array.add("a");
        array.add("b");
        array.add("c");

        array.insert(1,"d");

        System.out.println("Getting Array Size: " + array.size());

        Assert.assertEquals(4, array.size());

        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("d", array.get(1));
        Assert.assertEquals("b", array.get(2));
        Assert.assertEquals("c", array.get(3));
    }

    @Test
    public void Delete(){

        array.add("a");
        array.add("b");
        array.add("c");

        array.insert(1,"d");

        System.out.println("Getting Array Size: " + array.size());

        Assert.assertEquals(4, array.size());

        array.delete(1);

        Assert.assertEquals(3, array.size());

        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("b", array.get(1));
        Assert.assertEquals("c", array.get(2));

        array.print();


    }

    @Test
    public void isEmpty(){

        Assert.assertEquals(true,array.isArrayEmpty());
    }

    @Test
    public void isContain(){
        array.add("a");
        array.add("b");
        array.add("c");

        Assert.assertEquals(true, array.contains("c"));
    }
}
