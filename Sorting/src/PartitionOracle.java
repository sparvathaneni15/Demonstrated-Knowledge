
// These are some imports that the course staff found useful, feel free to use them
// along with other imports from java.util.
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PartitionOracle {

    /**
     * Feel free to use this method to call partition. It catches any exceptions or
     * errors and returns a definitely-invalid pivot (-1) to turn errors into
     * potential failures. For example, in testPartition, you may use
     * 
     * runPartition(p, someArray, someLow, someHigh)
     * 
     * instead of
     * 
     * p.partition(someArray, someLow, someHigh)
     * 
     * @param p
     * @param strs
     * @param low
     * @param high
     * @return
     */
    public static int runPartition(Partitioner p, String[] strs, int low, int high) {
        try {
            return p.partition(strs, low, high);
        } catch (Throwable t) {
            return -1;
        }
    }

    // The three methods below are for you to fill in according to the PA writeup.
    // Feel free to make other helper methods as needed.

    public static String isValidPartitionResult(String[] before, int low, int high, int pivot, String[] after) {
        /*
         * Checks if each element in the array before 
         * partition is present in the after array.
         */
        for (String s : before){ // 
            if (!contains(after, s)){
                return ("There are values after the pivot index that are lesser than it");
            }
        }

        /*
         * Checks if pivot is in between low (inclusive) and high (exclusive)
         */
        if (!(low <= pivot && pivot < high)){
            return "The pivot index is not in between the low and high arguments";
        }

        /*
         * Checks if the elements before index low
         * have stayed in their same index values.
         */
        for (int i = 0; i < low; i++){
            if (!before[i].equals(after[i])){
                return "The values at indices before 'low' were changed";
            }
        }

        /*
         * Checks if the elements after index high
         * have stayed in their same index values.
         */
        for (int i = high; i < before.length; i++){
            if (!before[i].equals(after[i])){
                return "The values at indices after 'high' were changed";
            }
        }

        /*
         * Checks if all of the values at indices less than 
         * pivot are less than or equal to the value at pivot
         */
        for (int i = low; i < pivot+1; i++){
            if (!(after[i].compareTo(after[pivot]) <= 0)){
                return "There are values before the pivot index that are greater than it";
            }
        }

        /*
         * Checks if all of the values at indices higher than
         * pivot are greater than or equal to the value at pivot.
         */
        for (int i = pivot; i < high; i++){
            if (!(after[i].compareTo(after[pivot]) >= 0)){
                return "There are values after the pivot index that are lesser than it";
            }
        }
        return null;
    }

    public static String[] generateInput(int n) {
        String[] result = new String[n];
        Random r = new Random();
        for (int i = 0; i < result.length; i++){
            result[i] = new String(""+(r.nextInt(100)+23));
        }
        return result;
    }

    public static CounterExample findCounterExample(Partitioner p) {
        String[] input = generateInput(10);
        String[] before = new String[input.length];
        for (int i = 0; i < input.length; i++){
            before[i] = input[i];
        }
        int high = input.length-1;
        int low = 0;
        int pivot = runPartition(p, input, low, high);
        String[] after = new String[input.length];
        for (int i = 0; i < input.length; i++){
            after[i] = input[i];
        }
        if (isValidPartitionResult(before, low, high, pivot, after) != null){
        return new CounterExample(before, low, high, pivot, after, isValidPartitionResult(before, low, high, pivot, after));
        }
        else {
            return null;
        }        
    }

    /*
     * This helper method is passed a String[] array and a string s,
     * which returns true if there exists an element in the
     * array that is equal to the String s.
     * Otherwise, returns false.
     */
    public static boolean contains(String[] array, String s){
        for (String element : array){
            if (element.equals(s)){
                return true;
            }
        }
        return false;
    }

}
