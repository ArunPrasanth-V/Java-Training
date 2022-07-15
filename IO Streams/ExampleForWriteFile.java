import java.io.File;
import java.io.FileWriter;

public class ExampleForWriteFile {
	public static void main(String[] args) {
      File file=new File("/home//arun//Documents//Testing//part1//sec1//test1.txt");
   try {
	   file.createNewFile(); 
	   FileWriter fileWriter=new FileWriter(file);
	   fileWriter.write("Hello There This is here im/n");
	   fileWriter.write("Writing in the file");
	   fileWriter.flush();
	   fileWriter.close();
   }
   catch(Exception e) {
	   System.out.println(e);
   }
	}

}
