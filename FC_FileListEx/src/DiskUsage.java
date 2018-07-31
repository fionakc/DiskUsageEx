import java.io.File;
import ecs100.*;

public class DiskUsage {

	String path="C:\\Users\\crookfion\\Documents\\Swen501 slides\\1_Inheritance2.pptx";
	String pathDir="C:\\Users\\crookfion\\Documents\\Swen501 slides";
	File file;
	long totalSize=0;
	//returns the size of the ordinary file named by path as an int
	//new File(path).length()    
	//File f=new File(C:/Users/crookfion/Documents/Swen501_slides);
	
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
	
}
