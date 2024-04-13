import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Samanyu Parvathaneni
 */
public class FileSystem {

    MyHashMap<String, ArrayList<FileData>> nameMap;
    MyHashMap<String, ArrayList<FileData>> dateMap;

    // TODO
    public FileSystem() {
        this.nameMap = new MyHashMap<String, ArrayList<FileData>>();
        this.dateMap = new MyHashMap<String, ArrayList<FileData>>();
    }

    // TODO
    public FileSystem(String inputFile) {
        // Add your code here
        ArrayList<FileData> list = new ArrayList<>();
        try {
            File f = new File(inputFile);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(", ");
                // Add your code here
                FileData file = new FileData(data[0], data[1], data[2]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // TODO
    public boolean add(String fileName, String directory, String modifiedDate) {
        if (fileName == null){
            fileName = "";
        }
        if (directory == null){
            directory = "/";
        }
        if (modifiedDate == null){
            modifiedDate = "01/01/2021";
        }

        ArrayList<FileData> nameList = new ArrayList<>();
        ArrayList<FileData> dateList = new ArrayList<>();
        
        if (nameMap.get(fileName) != null){
            nameList = nameMap.get(fileName);
        }
        if (dateMap.get(modifiedDate) != null){
            dateList = dateMap.get(modifiedDate);
        }

        for (FileData file : nameList){
            if (file.dir.equals(directory)){
                return false;
            }
        }

        for (FileData file : dateList){
            if (file.dir.equals(directory)){
                return false;
            }
        }

        FileData newFile = new FileData(fileName, directory, modifiedDate);
        nameList.add(newFile);
        dateList.add(newFile);
        return nameMap.put(fileName, nameList) && dateMap.put(modifiedDate, dateList);
    }

    // TODO
    public FileData findFile(String name, String directory) {
        ArrayList<FileData> list = new ArrayList<>();
        list = nameMap.get(name);
        if (list != null){
            for (FileData file : list){
                if (file.dir.equals(directory)){
                    return file;
                }
            }
            return null;
        }
        else{
            return null;
        }

    }

    // TODO
    public ArrayList<String> findAllFilesName() {
        List<String> list = nameMap.keys();
        ArrayList<String> result = new ArrayList<>();
        for (String file : list){
            result.add(file);
        }
        return result;
    }

    // TODO
    public ArrayList<FileData> findFilesByName(String name) {
        if (nameMap.get(name) != null){
            return nameMap.get(name);
        }
        else{
            return new ArrayList<>();
        }
    }

    // TODO
    public ArrayList<FileData> findFilesByDate(String modifiedDate) {
        if (dateMap.get(modifiedDate) != null){
            return dateMap.get(modifiedDate);
        }
        else{
            return new ArrayList<>();
        }
    }

    // TODO
    public ArrayList<FileData> findFilesInMultDir(String modifiedDate) {
        ArrayList<FileData> result = new ArrayList<>();
        if (!dateMap.containsKey(modifiedDate)){
            return result;
        }
        else{
            ArrayList<FileData> list = dateMap.get(modifiedDate);
            for (FileData file : list){
                for (FileData checkFile : list){
                    if (checkFile.name.equals(file.name) && !checkFile.dir.equals(file.dir)){
                        result.add(checkFile);
                    }
                }
            }
            return result;
        }
    }

    // TODO
    public boolean removeByName(String name) {
        if (!nameMap.containsKey(name)){
            return false;
        }
        else{
            ArrayList<FileData> nameList = nameMap.get(name);
            for (FileData file : nameList){
                dateMap.remove(file.lastModifiedDate);
            }
            nameMap.remove(name);
            return true;
        }
    }

    // TODO
    public boolean removeFile(String name, String directory) {
        if (!nameMap.containsKey(name)){
            return false;
        }
        else {
            ArrayList<FileData> nameList = nameMap.get(name);
            boolean hasDir = false;
            for (FileData file : nameList){
                if (file.dir.equals(directory)){
                    hasDir = nameList.remove(file);
                }
            }
            List<String> keys = dateMap.keys();
            for (String k : keys){
                ArrayList<FileData> dateList = dateMap.get(k);
                for (FileData file : dateList){
                    if (file.name.equals(name) && file.dir.equals(directory)){
                        hasDir = dateMap.remove(file.lastModifiedDate);
                    }
                }
            }
            return hasDir;
        }
    }

}
