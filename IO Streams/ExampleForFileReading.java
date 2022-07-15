import java.io.File;

public class ExampleForFileReading {

	public static void main(String[] args) {
		File file=new File("//home//arun//Documents//Testing//part1//sec1//demo.txt");
		boolean present=file.exists();
		System.out.println(present);
		if(!present) {
		  //folder Creation 
		//	file.mkdir();
			
			//creating subFolder
		//	file.mkdirs();
			
			
			// to delete the file.
		//file.delete();
		}
		System.out.println(file.exists());
	}
	public static void renameFile() {
		//file used to rename the file.
		File file=new File("/home/arun/Documents/Testing/part1/sec1");
		//new name that to be replaced
		File newName=new File("/home/arun/Documents/Testing/part1/sec1/demo.txt");
		boolean isRenamed= file.renameTo(newName);
		System.out.println(isRenamed);
		
	}
	public static void fileCreation(File file) {
		
		//creating file
		try {
			file.createNewFile();
		}
		catch(Exception e) {
			System.out.println("Error "+e);
		}
	}

}
