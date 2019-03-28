package JR_UDM;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {

    HashTable hashTable;

    //@Before setup
    @Before
    public void setup() throws Exception{
        hashTable = new HashTable();
    }

    @Test
    public void putData(){

        hashTable.put("Dixit Modi","55120*****");
        hashTable.put("Arti Modi","917499*****");
        hashTable.put("Pratik Modi","99790*****");
        hashTable.put("Rajanikant Modi","98241****");
        hashTable.put("Kailash Modi","812895*****");

        Assert.assertEquals(5,hashTable.getSize());

        hashTable.put("Dixit Modi","55120");
        Assert.assertEquals(6,hashTable.getSize());

        Assert.assertEquals("55120*****", hashTable.get("Dixit Modi"));
        Assert.assertEquals("917499*****", hashTable.get("Arti Modi"));
        Assert.assertEquals("99790*****", hashTable.get("Pratik Modi"));

    }

    @Test
    public void getDataWithCollision(){
        hashTable.put("Rajanikant Modi","98241****");
        hashTable.put("Kailash Modi","812895*****");

        Assert.assertEquals(2,hashTable.getSize());

        Assert.assertEquals("98241****", hashTable.get("Rajanikant Modi"));
        Assert.assertEquals("812895*****", hashTable.get("Kailash Modi"));

    }


    @Test
    public void getDataIndexMatchCollisionHappenButNoKeyMatch(){
        hashTable.put("Rajanikant Modi","98241****");
        //hashTable.put("Kailash Modi","812895*****");

        Assert.assertEquals(1,hashTable.getSize());


        Assert.assertEquals(null, hashTable.get("Kailash Modi"));

    }

}
