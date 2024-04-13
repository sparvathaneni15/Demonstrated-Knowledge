/**
 * 
 * @author Samanyu Parvathaneni
 */
public class FileData {

    public String name;
    public String dir;
    public String lastModifiedDate;

    // TODO
    /**
     * 
     * @param name the name of the file
     * @param directory the directory the file is stored in
     * @param modifiedDate the most recent date the file was modified
     */
    public FileData(String name, String directory, String modifiedDate) {
        this.name = name;
        this.dir = directory;
        this.lastModifiedDate = modifiedDate;
    }

    // TODO
    /**
     * 
     * @return the information of the FileData in a String.
     */
    public String toString() {
        return "{Name: " + this.name + ", Directory: " + this.dir + ", Modified Date: " + this.lastModifiedDate + "}";
    }
}
