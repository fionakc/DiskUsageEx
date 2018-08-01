import java.io.File;
import java.io.FilenameFilter;

import ecs100.*;

public class DiskUsage {

	String path="C:\\Users\\crookfion\\Documents\\Swen501 slides\\1_Inheritance2.pptx";
	String pathDir="C:\\Users\\crookfion\\Documents\\Swen501 slides";
	File file;
	long totalSize=0;
	
	public DiskUsage() {
		//this.path=UIFileChooser.open();
		//System.out.println(this.path);
		file=new File(path);
	}
	
	public long fileLength(String filePath) {
		//return file.length();
		return new File(filePath).length();
	}
		
	public File[] fileList(String filePath) {
	return new File(filePath).listFiles(); // returns an array of File objects 
		//representing the files in the directory named by path
		
	}
	
	public File[] fileFilter(String filePath, String ext) {
		return new File(filePath).listFiles(new Filter(ext));
	}
	
	public boolean hasDirectory(String filePath) {
		//return new File(this.pathDir).isDirectory(); //returns true if path names a directory
		return new File(filePath).isDirectory();
	}
	
	//Create a program to be given a directory path that calculates the total size, 
	//in bytes, of every file in that directory or in any depth of subdirectories. 
	//You will want to use a recursive method or methods to do this.
	public long totalDirSize(String filePath) {
		//totalSize=0;
		File[] fileArray=fileList(filePath);  //generate fileArray from passed path
		for(int i=0;i<fileArray.length;i++) {  //loop through array
			if(hasDirectory(fileArray[i].toString())) {  //if array element is directory
				totalDirSize(fileArray[i].toString());	//want to list file paths inside
			}else {
				//totalSize+=1;
				totalSize+=fileLength(fileArray[i].toString()); //add up file size
				System.out.println(fileArray[i].toString()+","+totalSize); //otherwise print path name
			} //end else
		} //end for
		
		return totalSize;
	} //end totalDirSize
	
	//Add another mode that reports the size of each subdirectory 
	//and all its children individually, showing the hierarchy of directories.
	
	//Add another mode that finds all files within a directory tree 
	//with a particular extension (e.g. .java or .class) and lists them.
	//use filenamefilter
	public void fileNameFilter(String filePath, String ext) {
			
		System.out.println("into fileNameFilter");
		//File[] fileArray=fileFilter(filePath,ext);       //creating array of size 0
		File[] fileArray = new File(filePath).listFiles(new Filter(ext));
		System.out.println("created array");
		System.out.println(fileArray.length);
		for(int i=0;i<fileArray.length;i++) { //loop through array
			if(hasDirectory(fileArray[i].toString())){	//if array element is directory
				fileNameFilter(fileArray[i].toString(),ext);	//access files inside
			} else {
				System.out.println(fileArray[i].toString());	//print out file path
			}
			//System.out.println("into array loop");
			//System.out.println(fileArray[i].toString());
		}
		System.out.println("passed loop");
	
		
//		File[] fileArray=fileList(filePath);  //generate fileArray from passed path
//		for(int i=0;i<fileArray.length;i++) {  //loop through array
//			if(hasDirectory(fileArray[i].toString())) {  //if array element is directory
//				totalDirSize(fileArray[i].toString());	//want to list file paths inside
//			}else {
//				//totalSize+=1;
//				totalSize+=fileLength(fileArray[i].toString()); //add up file size
//				System.out.println(fileArray[i].toString()+","+totalSize); //otherwise print path name
//			} //end else
//		} //end for
	}
	
	/**from the internet*/
	//this code works
	public void findFiles(String dir, String ext) {
		File file = new File(dir);
		if (!file.exists())
			System.out.println(dir + " Directory doesn't exists");
		File[] listFiles = file.listFiles(new Filter(ext));
		// File[] listFiles = file.listFiles((d, s) -> {
		// return s.toLowerCase().endsWith(ext);
		// });

		if (listFiles.length == 0) {
			System.out.println(dir + "doesn't have any file with extension " + ext);
		} else {
			for (File f : listFiles)
				System.out.println("File: " + dir + File.separator + f.getName());
		}
	}
	
	
	// FileNameFilter implementation
	public static class Filter implements FilenameFilter {
		//System.out.println("into Filter");
		private String ext;

		public Filter(String ext) {
			this.ext = ext.toLowerCase();
			System.out.println("into Filter constructor");
		}

		@Override
		public boolean accept(File fileName, String name) {
			//return name.toLowerCase().endsWith(ext);
			//System.out.println("into Filter accept");
			if (name.endsWith(ext)) {
	            return true;
	        } 				        
			return false;

		}

	}
	
	
}
