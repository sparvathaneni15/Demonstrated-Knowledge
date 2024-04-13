import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.*;

public class FileDataTest {
    FileData tester = new FileData("test.txt", "root", "11/22/24");

    @Test
    public void testToString(){
        String toString = tester.toString();
        String expected = "{Name: test.txt, Directory: root, Modified Date: 11/22/24}";
        assertEquals(expected, toString);
    }

    @Test
    public void testIncorrectToString(){
        String toString = tester.toString();
        String incorrect = "";
        assertNotEquals(incorrect, toString);
    }
}
