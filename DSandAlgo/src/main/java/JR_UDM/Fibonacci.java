package JR_UDM;

public class Fibonacci {

    //initialize the memorization
    long[] memorization = new long[1500];

    public long fibonacciNaive(int num){

        //System.out.println("Entered Number: - "+num);

        if(num <= 0){
            return 0;
        }else if(num == 1){
            return 1;
        }

        return fibonacciNaive(num-1) + fibonacciNaive(num-2);
    }



    public long fibonacciMemorization(int num){

       // System.out.println("Entered Number: - "+num);

        if(num <= 0){
            return 0;
        }else if(num == 1){
            return 1;
        }else if(memorization[num] == 0){
            memorization[num] = fibonacciMemorization(num-1) + fibonacciMemorization(num-2);
        }
        return memorization[num];
    }


    //Using iteratively
    public long fibonnacciUsingIterativeAndMemorization(int num){

        long returnNum = 0;

        //initialize the memorization
        long[] arr = new long[num+1];

        //initializing the array with initial values
        arr[0] = 0;
        arr[1] = 1;

        if(num<=0){
            return 0;
        }
        else if(num==1 || num==2){
            return 1;
        }else {
            int i = 1;
            while (i < num){
                i++;
                arr[i] = arr[i-2] + arr[i-1];
            }

            returnNum = arr[i];
        }

        return returnNum;

    }

    public long fibonacciIterative(int num){

        if(num<=1){
            return 1;
        }

        long fibNum = 1; //n-1
        long previousFib = 1; //n-2

        for(int i=2; i<num; i++){

            long temp = fibNum;
            fibNum+=previousFib;
            previousFib = temp;
        }

        return fibNum;
    }


}

