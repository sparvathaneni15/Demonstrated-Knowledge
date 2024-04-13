import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.Test;

/**
 * This is an example of how to implement the Partitioner interface to implement
 * a concrete Partitioner. You can use this bad implementation to test your PartitionOracle,
 * to ensure that it works in detecting a bad Partitioner. You should add a correct implementation
 * of a Partitioner here, maybe one from class, to verify that your PartitionOracle also works
 * correctly on good implementations. Once you implement part 2, you can also test those Partitioner
 * implementations here as well.
 * 
 */
class CopyFirstElementPartition implements Partitioner {
    public int partition(String[] strs, int low, int high) {
        if (high - low < 1)
            return 0;
        for (int i = 0; i < strs.length; i += 1) {
            strs[i] = strs[0];
        }
        return 0;
    }
}

public class TestPartitionOracle {
    @Test
    public void testCopyFirstElementPartition() {
        CounterExample ce = PartitionOracle.findCounterExample(new CopyFirstElementPartition());
        System.out.println(ce);
        assertNotNull(ce);
    }
    

    @Test
    public void testIsValidPartitionCorrect(){
        String[] input = {"b", "e", "j", "a", "t"};
        String[] output = {"b", "a", "e", "j", "t"};
        assertEquals(null, PartitionOracle.isValidPartitionResult(input, 0, 5, 3, output));
    }

    @Test
    public void testIsValidPartitionMissingElements(){
        String[] input = {"b", "e", "j", "a", "t"};
        String[] output = {"b", "e", "j", "t"};
        assertEquals("There are values after the pivot index that are lesser than it", PartitionOracle.isValidPartitionResult(input, 0, 5, 2, output));
    }

    @Test
    public void testIsValidPartitionChangedLow(){
        String[] input = {"b", "e", "j", "a", "t"};
        String[] output = {"e", "b", "a", "j", "t"};
        assertEquals("The values at indices before 'low' were changed", PartitionOracle.isValidPartitionResult(input, 2, 5, 3, output));
    }

    @Test
    public void testIsValidPartitionChangedHigh(){
        String[] input = {"e", "b", "j", "a", "t"};
        String[] output = {"b", "e", "j", "t", "a"};
        assertEquals("The values at indices after 'high' were changed", PartitionOracle.isValidPartitionResult(input, 0, 3, 1, output));
    }

    @Test
    public void testIsValidPartitionPivotValid(){
        String[] input = {"b", "e", "j", "a", "t"};
        String[] output = {"a", "b", "e", "j", "t"};
        assertEquals("The pivot index is not in between the low and high arguments", PartitionOracle.isValidPartitionResult(input, 1, 4, 0, output));
    }

    @Test
    public void testIsValidPartitionLargeLessers(){
        String[] input = {"b", "e", "j", "a", "t"};
        String[] output = {"b", "j", "a", "e", "t"};
        assertEquals("There are values before the pivot index that are greater than it", PartitionOracle.isValidPartitionResult(input, 1, 4, 3, output));
    }

    @Test
    public void testIsValidPartitionSmallGreaters(){
        String[] input = {"b", "e", "j", "a", "t"};
        String[] output = {"b", "e", "j", "a", "t"};
        assertEquals("There are values after the pivot index that are lesser than it", PartitionOracle.isValidPartitionResult(input, 1, 4, 2, output));
    }

    @Test
    public void testGenerateInput(){
        String[] array = PartitionOracle.generateInput(5);
        assertEquals(5, array.length);
    }

    @Test
    public void testFindCounterExampleCorrect(){
        Partitioner p = new FirstElePivotPartitioner();
        assertNull(PartitionOracle.findCounterExample(p));
        assertNull(PartitionOracle.findCounterExample(p));
        assertNull(PartitionOracle.findCounterExample(p));
        assertNull(PartitionOracle.findCounterExample(p));
        assertNull(PartitionOracle.findCounterExample(p));
    }

    @Test
    public void testFindCounterExampleWrong(){
        Partitioner p = new CopyFirstElementPartition();
        assertNotNull(PartitionOracle.findCounterExample(p));
        assertNotNull(PartitionOracle.findCounterExample(p));
        assertNotNull(PartitionOracle.findCounterExample(p));
        assertNotNull(PartitionOracle.findCounterExample(p));
        assertNotNull(PartitionOracle.findCounterExample(p));
        assertNotNull(PartitionOracle.findCounterExample(p));
    }
}
