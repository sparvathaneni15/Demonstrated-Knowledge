// You can (and should) add "implements Partitioner" below once you have the implementation ready
import java.util.*;
public class FirstElePivotPartitioner implements Partitioner{
       
    public int partition(String[] array, int low, int high) {  
        int pivotIndex = low;
        String pivot = array[pivotIndex];
        List<String> lesser = new ArrayList<>();
        List<String> greater = new ArrayList<>();

        for (int i = low; i < pivotIndex; i++){
            if (array[i].compareTo(pivot) <= 0){
                lesser.add(array[i]);
            }
            else {
                greater.add(array[i]);
            }
        }

        for (int i = pivotIndex + 1; i < high; i++){
            if (array[i].compareTo(pivot) <= 0){
                lesser.add(array[i]);
            }
            else {
                greater.add(array[i]);
            }
        }
        Collections.sort(lesser);
        Collections.sort(greater);

        int pivotEnd = low + lesser.size();

        for (int i = 0; i < lesser.size(); i++){
            array[i + low] = lesser.get(i);
        }

        array[pivotEnd] = pivot;

        for (int i = 0; i < greater.size(); i++){
            array[pivotEnd + i +1] = greater.get(i);
        }

        return pivotEnd;
    }
}
