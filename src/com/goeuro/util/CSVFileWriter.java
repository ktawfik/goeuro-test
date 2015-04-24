package com.goeuro.util;
/**
 * @author Karim
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class CSVFileWriter {

	private final BufferedWriter br;
	private final String path;
	private static final String CSV = ".csv";
	/**
	 * Class constructor that takes the filepath as a parameter.
	 * this constructor deletes the file if exists, and create a new file, here I decided to delete as the data
	 * retrieved from the url will never be changed -unless a new city added or city is removed from the map which is 
	 * not typical behavior-
	 * on the other hand, I was able to avoid this, by creating versions of the file (e.g. Berlin_0.csv, Berlin_1.csv....), or even 
	 * by appending data -not make sense to me-
	 * 
	 * @param filePath
	 * @throws IOException 
	 */
	public CSVFileWriter(String filePath) throws IOException{
		if(filePath == null){
			throw new NullPointerException("invalid file name passed");
		}
		if(filePath.isEmpty()){
			
		}
		this.path = filePath;
		File f = new File(path + CSV);
		if(f.exists()){
			System.out.println("Already exists file with name:" + path);
			f.delete();
			System.out.println("Deleted the file and will create an empty file with name:" + path);
			f.createNewFile();
		}
		System.out.println("File created successfully with name:" + path);
		br = new BufferedWriter(new FileWriter(f));
	}
	/**
	 * This method used to write data to csv file with header, take list of objects and depends on the toString method,
	 * so to properly use this method, the Objects sent in the List should properly override toString method
	 * @param data, List of data to be written to the csv file
	 * @throws IOException 
	 */
	public void writeData(String header, List data) throws IOException{
		if(data == null || data.isEmpty()){
			System.out.println("No data sent to be written.");
			return;
		}
		System.out.println("will write list of size [" + data.size() +"] to " + path);
		if(header != null){
			System.out.println("Will write the file with header");
			br.write(header);
			br.newLine();
		}
		// writing the file
		for(Object o : data){
			br.write(o.toString());
			br.newLine();
		}
		br.flush();
		br.close();
		System.out.println("Finished writting the data to the file.");
	}
	
	/**
	 * This method used to write data to csv file without header.
	 * @param data
	 * @throws IOException 
	 */
	public void writeData(List data) throws IOException{
		writeData(null, data);
	}
	
}