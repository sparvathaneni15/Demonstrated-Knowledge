import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.*;

/**
 * 
 * @author Samanyu Parvathaneni
 */

public class BSTTest {
	
	/* TODO: Add your own tests */
	@Test
	public void testPut1(){
		BST tree = new BST<>();
		tree.put("m", "mirror");
		tree.put("c", "car");
		tree.put("z", "zebra");
		tree.put("d", "deer");
		tree.put("b", "black");
		assertEquals("deer", tree.get("d"));
	}

	@Test
	public void tetstPut2(){
		BST tree = new BST<>();
		tree.put(25, "");
		tree.put(29, "");
		tree.put(38, "");
		assertEquals(3, tree.size());

	}

	@Test
	public void testReplace1(){
		BST tree = new BST<>();
		tree.put("m", "mirror");
		tree.put("c", "car");
		tree.put("z", "zebra");
		tree.put("d", "deer");
		tree.put("b", "black");
		tree.replace("z", "zacari");
		assertEquals("zacari", tree.get("z"));
	}

	@Test
	public void testReplace2(){
		BST tree = new BST<>();
		tree.put("hello", "");
		tree.put("start", "");
		tree.put("fall", "");
		assertEquals(false, tree.replace("tree", ""));
	}

	@Test
	public void testRemove1(){
		BST tree = new BST<>();
		tree.put("m", "mirror");
		tree.put("c", "car");
		tree.put("z", "zebra");
		tree.put("d", "deer");
		tree.put("b", "black");
		assertEquals(true, tree.remove("c"));
	}

	@Test
	public void testRemove2(){
		BST tree = new BST<>();
		assertEquals(false ,tree.remove("ja"));
	}

	@Test
	public void testSet1(){
		BST tree = new BST<>();
		tree.set(34, "tree");
		assertEquals(1, tree.size());
	}

	@Test
	public void testSet2(){
		BST tree = new BST<>();
		tree.put(23, "");
		tree.set(23, "replaced");
		assertEquals("replaced", tree.get(23));
	}

	@Test
	public void testGet1(){
		BST tree = new BST<>();
		tree.put(45, "");
		tree.put(24, " ");
		assertEquals("", tree.get(45));
	}

	@Test
	public void testGet2(){
		BST tree = new BST<>();
		assertEquals(null, tree.get(""));
	}

	@Test
	public void testSize1(){
		BST tree = new BST<>();
		assertEquals(0, tree.size());
	}

	@Test
	public void testSize2(){
		BST tree = new BST<>();
		tree.put(45, " ");
		tree.put(84, "hello");
		tree.remove(56);
		assertEquals(2, tree.size());

	}

	@Test
	public void testIsEmpty1(){
		BST tree = new BST<>();
		assertEquals(true, tree.isEmpty());
	}

	@Test
	public void testIsEmpty2(){
		BST tree = new BST<>();
		tree.set("d3", " ");
		assertEquals(false, tree.isEmpty());
	}

	@Test
	public void testContainsKey1(){
		BST tree = new BST<>();
		tree.put(23, 53);
		tree.put(452, 23);
		assertEquals(true, tree.containsKey(23));
	}

	@Test
	public void testContainsKey2(){
		BST tree = new BST<>();
		tree.put("start", 34);
		tree.put("end", 31);
		assertEquals(false, tree.containsKey("middle"));
	}

	@Test
	public void testKeys1(){
		BST tree = new BST<>();
		assertEquals(Arrays.asList(), tree.keys());
	}

	@Test
	public void testKeys2(){
		BST tree = new BST<>();
		tree.put("start", 34);
		tree.put("middle", 534);
		tree.put("end", 52);
		assertEquals(Arrays.asList("end", "middle", "start"), tree.keys());
	}


	@Test
	public void testRemoveSubTreeLeft(){
		BST tree = new BST<>();
		tree.put(50, "");
		tree.put(49, "");
		tree.put(48, "");
		tree.put(21, "");
		tree.put(12, "");
		tree.remove(21);
		assertEquals(null, tree.get(21));
	}

}
