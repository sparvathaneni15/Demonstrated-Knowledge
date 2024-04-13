import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.*;

public class FileSystemTest {

    FileSystem tester = new FileSystem();

    @Test
    public void testRemoveByNameEmptyFileSystem(){
        assertEquals(false, tester.removeByName("hello"));
    }

    @Test
    public void testRemoveFileEmptyFileSystem(){
        assertEquals(false, tester.removeFile("Hello", "root"));
    }

}
