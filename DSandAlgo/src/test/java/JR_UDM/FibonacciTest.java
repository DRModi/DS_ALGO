package JR_UDM;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

    Fibonacci fib;


    @Before
    public void setup(){
        fib = new Fibonacci();
    }

    @Test
    public void testFibNaive(){
        long finalNum = fib.fibonacciNaive(47); //takes around 12 sec
        System.out.println("\n Final Number :- "+finalNum);
    }

    @Test
    public void testFibwithMemorization(){
        long finalNum = fib.fibonacciMemorization(50); //takes around 1 ms
        System.out.println("\n Final Number :- "+finalNum);
    }

    @Test
    public void testFibwithUsingIterativeAndMemory(){
        long finalNum = fib.fibonnacciUsingIterativeAndMemorization(50);//takes around 1 ms
        System.out.println("\n Final Number :- "+finalNum);
    }

    @Test
    public void testFibwithUsingIterative(){
        long finalNum = fib.fibonacciIterative(50); //takes around 1 ms
        System.out.println("\n Final Number :- "+finalNum);
    }
}
