public class FileData {

    /**
     * 
     * @author Samanyu Parvathaneni
     */

    public String name;
    public String dir;
    public String lastModifiedDate;

    // TODO
    /**
     * A constructor that creates an instance of FileData object 
     * by intializing its instance variables with the given parameters. 
     * You may assume that the parameters passed in to the constructor will be non-null.
     * @param name The name of the given file in string format.
     * @param directory The directory of where the file is stored, represented in a string format.
     * @param modifiedDate The date of when the file is last modified, represented in a string format. Format: yyyy/mm/dd
     */
    public FileData(String name, String directory, String modifiedDate) {
        this.name = name;
        this.dir = directory;
        this.lastModifiedDate = modifiedDate;
    }

    // TODO
    /**
     * A method that returns the string representation of FileData 
     * by displaying the file information. 
     * It should strictly follow the format of 
     * {Name: file_name, Directory: dir_name, Modified Date: date}.
     */
    public String toString() {
        return "{Name: " + this.name + ", Directory: " + this.dir + ", Modified Date: " + this.lastModifiedDate + "}";
    }
}