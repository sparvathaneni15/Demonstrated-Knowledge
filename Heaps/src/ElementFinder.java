import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Samanyu Parvathaneni
 */

public class ElementFinder {

	/**
	 * Given a list of n non-negative integers in the form of a file, 
	 * the Kth_finder method would return the Kth largest/smallest number from the input file. 
	 * File name, value of K and the type of the task (“largest” or “smallest”) 
	 * are the arguments to the function.
	 * 
	 * @param filename the name of the file that we are using to get inputs from
	 * @param K the element whose index we must find
	 * @param operation from which direction we approach the sorted list from
	 * @return
	 */
	public static int Kth_finder(String filename, int K, String operation) {
		// Create a comparator depending upon the type of operation
		List<Integer> elements = new ArrayList<>();
		try {
			List<String> allLines = Files.readAllLines(Paths.get(filename));
			for (String line : allLines){
				String[] lineElements = line.split(" ");
				for (String element : lineElements){
					elements.add(Integer.parseInt(element));
				}
			}
		}
		catch (IOException e) {
			return -1;
		}
		if (operation.equals("largest")){ // operation is largest- create a min-heap
			Comparator<Integer> largeComparator = new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2){
					return o2-o1;
				}
			};
			Heap<Integer, String> heap = new Heap<>(largeComparator);
			if (!elements.isEmpty()){
				for (int i = 0; i < elements.size(); i++){
					heap.add(elements.get(i), "");
				}
				while (heap.size() > K){
					heap.poll();
				}
				return heap.peek().getKey();

			}
		}
		else{ // operation is smallest- create a max-heap
			Comparator<Integer> smallComparator = new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2){
					return o1-o2;
				}
			};
			Heap<Integer, String> heap = new Heap<>(smallComparator);
			if (!elements.isEmpty()){
				for (int i = 0; i < elements.size(); i++){
					heap.add(elements.get(i), "");
				}
				while (heap.size() > K){
					heap.poll();
				}
				return heap.peek().getKey();
			}
		}
		return -1;
	}
}
