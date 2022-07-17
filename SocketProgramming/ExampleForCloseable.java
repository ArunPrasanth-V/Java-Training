import java.io.Closeable;

public class ExampleForCloseable {

	public static void main(String[] args) {
		//if we trying to access the class that should close 
		//we can use try with Resource
		//but the  class which you're creating the object should implements autocloseable or closeable
		// we don't need to close explicitly in finally block.
		try(Resource obj=new Resource();
			Resource2 obj2=new Resource2();){
			int a=2/0;
			obj.access();
			obj2.access();
			
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
	}
}
class Resource implements Closeable{
	 public void access() {
		 System.out.println("Accessing the Resource1");
	 }
	public void close() {
		 System.out.println("Resource1 is closed");
	 }
}
class Resource2 implements Closeable{
	 public void access() {
		 System.out.println("Accessing the Resource2");
	 }
	public void close() {
		 System.out.println("Resource 2 is closed");

	 }
}
