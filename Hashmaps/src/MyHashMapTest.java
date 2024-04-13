import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

public class MyHashMapTest {
	
	private DefaultMap<String, String> testMap; // use this for basic tests
	private DefaultMap<String, String> mapWithCap; // use for testing proper rehashing
	public static final String TEST_KEY = "Test Key";
	public static final String TEST_VAL = "Test Value";
	
	@Before
	public void setUp() {
		testMap = new MyHashMap<>();
		mapWithCap = new MyHashMap<>(4, MyHashMap.DEFAULT_LOAD_FACTOR);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPut_nullKey() {
		testMap.put(null, TEST_VAL);
	}

	@Test
	public void testKeys_nonEmptyMap() {
		// You don't have to use array list 
		// This test will work with any object that implements List
		List<String> expectedKeys = new ArrayList<>(5);
		for(int i = 0; i < 5; i++) {
			// key + i is used to differentiate keys since they must be unique
			testMap.put(TEST_KEY + i, TEST_VAL + i);
			expectedKeys.add(TEST_KEY + i);
		}
		List<String> resultKeys = testMap.keys();
		// we need to sort because hash map doesn't guarantee ordering
		Collections.sort(resultKeys);
		assertEquals(expectedKeys, resultKeys);
	}
	
	/* Add more of your tests below */
	@Test
	public void testAddDuplicateKey(){
		List<String> expectedKeys = new ArrayList<>(5);
		testMap.put("Thai", "99");
		testMap.put("Thai", "38");
		expectedKeys.add("Thai");

		List<String> resultKeys = testMap.keys();
		Collections.sort(resultKeys);
		assertEquals(expectedKeys, resultKeys);
	}

	@Test
	public void testRemoveKey(){
		List<String> expectedKeys = new ArrayList<>(5);
		testMap.put("Fan", "3883");
		testMap.put("Table", "3291");
		testMap.put("Chair", "e939");
		expectedKeys.add("Fan");
		expectedKeys.add("Chair");
		testMap.remove("Table");
		List<String> resultKeys = testMap.keys();
		Collections.sort(resultKeys);
		Collections.sort(expectedKeys);
		assertEquals(expectedKeys, resultKeys);
	}
	
}