package com.zitasoroka.exampleone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenameFiles {
	
	private static final Map<String, String> testMap = new HashMap<String, String>();

	public static void main(String[] args) {
		
		RenameFiles test = new RenameFiles();
		try {
			String[] a = test.readLines("C:\\path\\list.txt");
				test.splitLines(a);
				test.renameFiles("C:\\path\\mp3s");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/*
	 * Reads lines from the file one by one and saves into array
	 */
	public String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }
	/*
	  * This method splits each line in a list using space deimiter into two;
	  * Puts each part into HashMap collection one as a key another as a value
	 */
	public Map<String, String> splitLines(String[] list) {
		for (int i=0; i< list.length; i++) { 
			String[] line = list[i].split("\\s{2,4}");
			String first = line[0];
			String second = line[1];
			testMap.put(first, second);
		}
		return testMap;	
	}
	
	/*
	 * This method will rename all files in a directory
	 */
	public String renameFiles (String folderName) {
        try {
        File folder=new File(folderName);
        File[] filesList=folder.listFiles();
        for (int i=0; i< filesList.length; i++) {
        	String fullName = filesList[i].getName();
        	String[] arrayName = fullName.split("\\.");
        	String currentName = arrayName[0];
        	if (testMap.containsKey(currentName)) {
        		String futureName = testMap.get(currentName);
        			String newName= (filesList[i].toString().replaceAll(currentName, futureName));
        			filesList[i].renameTo(new File(newName)); 
        			System.out.println(currentName + " -> " + futureName);
        		}
        	else {
        		System.out.println(currentName + " - doesn't exist");
        	}
        }        
        return "Successfully renamed "+filesList.length+" files.";
        }
        catch (Exception e){
            return (e.getMessage());    
        }         
    }
}
	
	
	
	