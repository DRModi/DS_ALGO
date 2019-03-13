package JR_UDM;

import JR_UDM.Stacks;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class StacksTest {

    private Stacks stacks;

    @Before
    public void setup(){
        stacks = new Stacks();
    }

    @Test
    public void add(){
        Assert.assertEquals(stacks.isEmpty(),true);
        stacks.push(1);
        Assert.assertEquals(1, stacks.peek());
    }


    @Test
    public void addRemove(){
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        Assert.assertEquals(3, stacks.getSize());
        Assert.assertFalse(stacks.isEmpty());

        Assert.assertEquals(3,stacks.peek());

        Assert.assertEquals(3,stacks.pop());
        Assert.assertEquals(2,stacks.pop());
        Assert.assertEquals(1,stacks.pop());

        Assert.assertEquals(0, stacks.getSize());
        Assert.assertTrue(stacks.isEmpty());

    }


}
