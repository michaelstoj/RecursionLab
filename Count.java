
/**
 * This class contains recursive counting methods.
 * 
 * @author Stuart Hansen
 * @version October 2009
 *
 * Modified by Stuart Hansen, March 27, 2006
 *     - added Scanner for IO
 */

import java.util.*;

/**
 * A class that implements two simple counters
 * @author Stuart Hansen
 * @version Fall 2016
 */
public class Count
{

    /**
     * A test main that runs a naive test on countDown and countUp
     * @param args
     */
    public static void main(String args[])
    {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter the number to count to.");
        int n = in.nextInt();
        
        System.out.println("Should count down to 1");
        countDown(n);
        
        System.out.println();
        System.out.println("Should count up from 1");
        countUp(n);
    }
       
    /**
     * countDown - a recursive function that counts down from n to 1
     *
     * @param n    the integer value to count down from
     */
    private static void countDown(int n)
    {
        // IMPLEMENT THIS RECURSIVE METHOD FOR CHECKPOINT #1
        if(n == 0){
            return;
        }
        else {
            System.out.println(n);
        }
        countDown(n-1);

    }

    /**
     * countUp - a recursive function that counts up from 1 to n
     *
     * @param n    the integer value to count up to
     */
    private static void countUp(int n)
    {
        // IMPLEMENT THIS RECURSIVE METHOD FOR CHECKPOINT #1
        if(n == 0){
            return;
        }
        else {
            countUp(n -1);
        }
        System.out.println(n);

    }
   
}
