import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.beans.Transient;
import java.util.Comparator;

import org.junit.Test;

/**
 * HeapTest class implements tester that will test the methods from heap file
 */
public class HeapTest  {
	
	@Test
	public void testAdd() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(19, "");
		heap.add(50, "10");
		heap.add(30, "10");
		heap.add(15, "10");
		heap.add(20, "10");
		heap.add(10, "10");
		heap.add(5, "");
		heap.add(2, "");
		heap.toString();
		assertEquals(8, heap.entries.size());
	}
	
	@Test
	public void testElementFinderLargest(){
		assertEquals(13, ElementFinder.Kth_finder("input.txt", 4, "largest"));
	}

	
	@Test
	public void testElementFinderSmallest(){
		assertEquals(2, ElementFinder.Kth_finder("input.txt", 4, "smallest"));
	}

	
	@Test
	public void testElementFinderEmptyFile(){
		assertEquals(-1, ElementFinder.Kth_finder("empty.txt", 4, "largest"));
	}
	

	
	@Test
	public void testPoll() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(19, "");
		heap.add(50, "10");
		heap.add(30, "10");
		heap.add(15, "10");
		heap.add(20, "10");
		heap.add(10, "10");
		heap.add(5, "");
		heap.add(2, "");
		
		System.out.println(heap.toString());
		heap.poll();
		System.out.println(heap.toString());
		assertEquals(7, heap.entries.size());
	}
	
}