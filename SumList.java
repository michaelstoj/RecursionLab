
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hansen
 */
public class SumList {

    public static int sumList(ArrayList arr) {
        int sum = 0;

        // PLACE CODE FOR CHECKPOINT #3 HERE

        for(int i = 0; i < arr.size(); i++ ) {
            if (arr.get(i) instanceof ArrayList) {
                sum += sumList((ArrayList) arr.get(i));
            } else {
                sum += (int) arr.get(i);
            }
        }
        return sum;
    }
}
