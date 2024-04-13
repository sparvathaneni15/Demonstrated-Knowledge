import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Samanyu Parvathaneni
 * @author Ella Sampson
 * @author Ivor Myers
 */

public class FileSystem {

    BST<String, FileData> nameTree;
    BST<String, ArrayList<FileData>> dateTree;
    
    // TODO
    public FileSystem() {
        this.nameTree = new BST<String, FileData>();
    	this.dateTree = new BST<String, ArrayList<FileData>>();
    }


    // TODO
    public FileSystem(String inputFile) {
    	// Add your code here
        try {
            File f = new File(inputFile);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(", ");
                // Add your code here
                this.add(data[0], data[1], data[2]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);

        }
    }


    // TODO
    public void add(String name, String dir, String date) {
        if (name == null || dir == null || date == null){
            return;
        }

        FileData file = new FileData(name, dir, date);
    	ArrayList<FileData> dateData = new ArrayList<>();
    	boolean nameExists = false;
    	if (dateTree.get(date) != null) {
    		for (int i = 0; i < dateTree.get(date).size(); i++) {
    			if (dateTree.get(date).get(i).name.equals(name)) {
    				nameExists = true;
    			}
    		}
    		if (!nameExists) {
    			dateData = dateTree.get(date);
    		}
    	}
		
    	dateData.add(file);
    	
    	if (nameTree.isEmpty() || !nameTree.containsKey(name)) {
    		nameTree.put(name, file);
    		dateTree.put(date, dateData);
    		return;
    	}
    	
		if (date.compareTo(nameTree.get(name).lastModifiedDate) > 0) {
			if (dateTree.containsKey(nameTree.get(name).lastModifiedDate)) {
				dateTree.remove(nameTree.get(name).lastModifiedDate);
			}
			nameTree.replace(name, file);
			dateTree.put(date, dateData);
			return;
		}
		
		return;
    	
    }


    // TODO
    public ArrayList<String> findFileNamesByDate(String date) {
    	if (date == null) {
    		return null;
    	}
    	
    	ArrayList<String> names = new ArrayList<String>();
    	ArrayList<FileData> nameFD = dateTree.get(date);
        for (FileData file : nameFD){
            names.add(file.name);
        }
    	return names;
    }


    // TODO
    public FileSystem filter(String startDate, String endDate) {
    	FileSystem result = new FileSystem();

    	List<String> keys = dateTree.keys();
        for (String s : keys){
            if (s.compareTo(startDate) >= 0 && s.compareTo(endDate) < 0){
                String date = s;
                ArrayList<FileData> data = dateTree.get(s);
                for (FileData file : data){
                    String name = file.name;
                    String dir = file.dir;
                    result.add(name, dir, date);
                }
            }
        }
        return result;
    }
    
    
    // TODO
    public FileSystem filter(String wildCard) {
    	FileSystem result = new FileSystem();
    	
    	List<String> keys = nameTree.keys();
        for (String key : keys){
            if (key.contains(wildCard)){
                String name = key;
                String dir = nameTree.get(key).dir;
                String date = nameTree.get(key).lastModifiedDate;
                result.add(name, dir, date);
            }
        }
    	return result;
    }
    
    
    // TODO
    public List<String> outputNameTree(){
    	List<String> result = new ArrayList<>();

    	List<String> keys = nameTree.keys();
        for (String key : keys){
            String s = key + ": " + nameTree.get(key).toString();
            result.add(s);
        }
        return result;
    }
    
    
    // TODO
    public List<String> outputDateTree(){
    	List<String> result = new ArrayList<>();

    	List<String> keys = dateTree.keys();
    	List<String> reversed = new ArrayList<>();
        for (String key : keys){
            reversed.add(0, key);
        }
    	
        for (String key : reversed){
            ArrayList<FileData> data = dateTree.get(key);
            if (data.size() == 1){
                String s = key + ": " + data.get(0).toString();
                result.add(s);
            }
            else {
                for (int i = data.size()-1; i >= 0; i--){
                    String s = key + ": " + data.get(i).toString();
                    result.add(s);
                }
            }
        }
    	return result;
    }
    

}

