import java.beans.Transient;
import java.util.ArrayList;
import java.util.Queue;

import javax.management.QueryEval;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	
	/*@Test
	public void dummyTest() {
		assertEquals("TODO: Remove this dummy test after writing your own tests.", "This is a dummy test.");
	}*/

	@Test
	public void givenTestQL(){
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		QueueWorklist ql = new QueueWorklist();
		String[] expectQL = {"#___", "**F_", "S##_", "____"};
		checkMaze(ql, m, expectQL);
	}
	
	@Test
	public void givenTestSL(){
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		StackWorklist sl = new StackWorklist();
		String[] expectSL = {"#___", "__F*", "S##*", "****"};
		checkMaze(sl, m, expectSL);
	}

	@Test
	public void oneStepQL(){
		Maze m = new Maze(new String[] {"#F__", "____", "#S#_", "____"});
		QueueWorklist ql = new QueueWorklist();
		String[] expectQL = {"#F__", "_*__", "#S#_", "____"};
		checkMaze(ql, m, expectQL);
	}

	@Test
	public void oneStepSL(){
		Maze m = new Maze(new String[] {"#S_F", "____", "#_#_", "____"});
		StackWorklist sl = new StackWorklist();
		String[] expectSL = {"#S*F", "____", "#_#_", "____"};
		checkMaze(sl, m, expectSL);
	}

	@Test
	public void diagonalQL(){
		Maze m = new Maze(new String[] {"#__F","__#_","_##_","S___"});
		QueueWorklist ql = new QueueWorklist();
		String[] expectQL = {"#**F","**#_","*##_","S___"};
		checkMaze(ql, m, expectQL);
	}

	@Test
	public void diagonalSL(){
		Maze m = new Maze(new String[] {"#__F","__#_","_##_","S___"});
		StackWorklist sl = new StackWorklist();
		String[] expectSL = {"#__F","__#*","_##*","S***"};
		checkMaze(sl, m, expectSL);
	}

	@Test
	public void nullSL(){
		Maze m = new Maze(new String[] {"#__F", "_###", "_##_", "S___"});
		StackWorklist sl = new StackWorklist();
		checkMaze(sl, m, null);
	}

	@Test
	public void nullQL(){
		Maze m = new Maze(new String[] {"#__F", "_###", "_##_", "S___"});
		QueueWorklist ql = new QueueWorklist();
		checkMaze(ql, m, null);
	}

	@Test
	public void shortQL(){
		Maze m = new Maze(new String[] {"____", "_S__","_#__","F___"});
		QueueWorklist ql = new QueueWorklist();
		String[] expectQL = {"____", "*S__", "*#__", "F___"};
		checkMaze(ql, m, expectQL);
	}

	@Test
	public void shortSL(){
		Maze m = new Maze(new String[] {"____", "__S_","_#__","F___"});
		StackWorklist sl = new StackWorklist();
		String[] expectSL = {"____", "**S_","*#__","F___"};
		checkMaze(sl, m, expectSL);
	}
}



