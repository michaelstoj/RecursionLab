
/**
 * Powers
 *
 * Author: Stuart Hansne
 * Date:  October 2009
 *
 * Demonstrates how to calculate integer exponentiation
 */
import java.util.*;

/**
 * A class that implements a method to calculate powers
 * @author Stuart Hansen
 * @version Fall 2016
 */
public class Powers {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // get base and power from the command line
        System.out.println("Enter the base of the exponent.");
        int n = in.nextInt();

        System.out.println("Enter the exponent.");
        int power = in.nextInt();

        // Call the recursive method to find the integral power
        // of a number 
        System.out.println("The number " + n + " raised to the power " +
                power + " = " + findPower(n, power));
    }

    /**
     * Calculate n raised to the power
     *
     * @param n
     * @param power
     * @return n^power
     */
    public static double findPower(double n, int power) {
        // FILL IN THE REST OF THIS METHOD FOR CHECKPOINT #2


//        if(power == 0){
//            return 1;
//        }
//        else if (power % 2 == 1){
//            return (n * findPower(n, power/2)) *( findPower(n, power/2));
//        }
//        else{
//            return (findPower(n, power/2)) * (findPower(n, power/2));
//        }

        if (power == 0) {
            return 1;
        } else if (power < 0) {
            return (findPower(1 / n, -power / 2) * (findPower(1 / n, -power / 2)));
        } else if (power % 2 == 1) {
            return (n * findPower(n, power / 2)) * (findPower(n, power / 2));
        } else
            return (findPower(n, power / 2)) * (findPower(n, power / 2));



    }
}
