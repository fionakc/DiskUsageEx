
public class test {

	public static void main(String[] args) {
		String pathDir="C:\\Users\\crookfion\\Documents\\Swen501 slides\\smaller folder";
		String ext=".txt";
		
		DiskUsage disk=new DiskUsage();
		//System.out.println(disk.fileLength());
		//System.out.println(disk.hasDirectory());
		//long fileSizes=disk.totalDirSize(pathDir);
		//System.out.println("The total size of all files in "+pathDir+" is "+fileSizes+" bytes");
		//disk.fileNameFilter(pathDir,ext);
		disk.findFiles(pathDir,ext);
		
	}
	
}
