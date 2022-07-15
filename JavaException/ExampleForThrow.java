public class ExampleForThrow {

	// In throw unlike throws. It will call manually call the JVM to handle the Exception
	// throws-automatic calling , throw - manually calling
	// The throw will used in custom exception
	// by creating the object of the exception in back of throw key word.
	// here throw keyword will given in method body.
	// we can give one Object for one throw keyword.
	public static void main(String[] args) {
		Test obj=new Test();
		try {
	       obj.run();	
		}
		catch(Exception e) {
			System.out.println(e+"  caught in second ");
		}
		
	}

}

class Test{
	public void run() {
		try {
			// Here we are throwing manually NullPointerException.
			throw new NullPointerException();
		}
		catch(NullPointerException e) {
			System.out.println("Null Pointer Exception");
			// Here we are throwing manually NullPointerException.
			throw e;
		}
	}
}
