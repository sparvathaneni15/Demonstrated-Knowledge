
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import javax.xml.transform.Transformer;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}

	@Test
	public void testTransformUpperCase(){
		UpperCaseTransformer mt = new UpperCaseTransformer();
		String[] string_input = {"hatian", "HATIAN", null, "swervin", "FASHION"};
		MyList<String> string_s1 = makeList(string_input);
		String[] string_expect1= {"HATIAN", "HATIAN", null, "SWERVIN", "FASHION"};
		string_s1.transformAll(mt);
		assertArrayEquals(string_expect1, string_s1.toArray());


	}

	@Test
	public void testTransformNegative(){
		NegativeTransformer mt = new NegativeTransformer();
		Integer[] integer_input = {3,4,35,null,5,-1,-45,5,2,1,2};
		MyList<Integer> integer_s = makeList(integer_input);
		Integer[] integer_expect = {-3,-4,-35,null,-5,1,45,-5,-2,-1,-2};
		integer_s.transformAll(mt);
		assertArrayEquals(integer_expect, integer_s.toArray());
	}

	@Test
	public void testTransformReverse(){
		ReverseStringTransform mt = new ReverseStringTransform();
		String[] string_input = {"racecar", "store", "23", "last", null};
		MyList<String> string_s = makeList(string_input);
		String[] string_expect = {"racecar", "erots", "32", "tsal", null};
		string_s.transformAll(mt);
		assertArrayEquals(string_expect, string_s.toArray());
	}

	@Test
	public void testChooseLongWord(){
		LongWordChooser mc = new LongWordChooser();
		String[] string_input = {null,"lost", "killstreaks", null, "program", "null", "sport"};
		MyList<String> string_s = makeList(string_input);
		String[] string_expect = {"killstreaks", "program"};
		string_s.chooseAll(mc);
		assertArrayEquals(string_expect, string_s.toArray());
	}

	@Test
	public void testChooseUpperCase(){
		UpperCaseChooser mc = new UpperCaseChooser();
		String[] string_input = {"Test", "test", "lower", "UPPER"};
		MyList<String> string_s = makeList(string_input);
		String[] string_expect = {"Test", "UPPER"};
		string_s.chooseAll(mc);
		assertArrayEquals(string_expect, string_s.toArray());
	}

	@Test
	public void testEvenNumber(){
		EvenChooser mc = new EvenChooser();
		Integer[] integer_input = {4,3,5,584,283,19320, 4892};
		MyList<Integer> integer_s = makeList(integer_input);
		Integer[] integer_expect = {4,584,19320,4892};
		integer_s.chooseAll(mc);
		assertArrayEquals(integer_expect, integer_s.toArray());
	}

	@Test
	public void testEmpty(){
		String[] string_input = {};
		MyList<String> string_s = makeList(string_input);
		String[] string_expect = {};
		string_s.chooseAll(new LongWordChooser());
		assertArrayEquals(string_expect, string_s.toArray());
	}

	@Test
	public void testRemoveOne(){
		String[] string_input = {"loss"};
		MyList<String> string_s = makeList(string_input);
		String[] string_expect = {};
		string_s.chooseAll(new LongWordChooser());
		assertArrayEquals(string_expect, string_s.toArray());
	}

	@Test
	public void isEmptyMoreThanThree(){
		String[] string_input = {"test", "computer", "number", "fourth"};
		MyList<String> string_s = makeList(string_input);
		assertEquals(false, string_s.isEmpty());
	}
}