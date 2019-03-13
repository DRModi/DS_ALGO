package JR_UDM;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class QueuesTest {

    private Queues queues;

    @Before
    public void setup(){
        queues = new Queues();
    }

    @Test
    public void add(){
        Assert.assertEquals(queues.isEmpty(),true);
        queues.add(1);
        Assert.assertEquals(1, queues.peek());
    }


    @Test
    public void addRemove(){
        queues.add(1);
        queues.add(2);
        queues.add(3);

        Assert.assertEquals(1,queues.peek());

        Assert.assertEquals(1,queues.remove());
        Assert.assertEquals(2,queues.remove());
        Assert.assertEquals(3,queues.remove());


        Assert.assertEquals(0, queues.size());
    }


}
