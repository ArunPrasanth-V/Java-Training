public class ExampleForThrows {
   //throws will given in method method signature.
	public int add(int a,int b) throws ArithmeticException{
		//Here the method is not handling the exception.
		//it simply says this method may throw an ArithmeticException
		//so,the calling object may or may not handle the exception.
		return a/b;
	}	
	public static void main(String[] args) {
		ExampleForThrows obj=new ExampleForThrows();
		// here we're handling the exception because in the method it mentioned it may throw 
		//  an ArithmeticException
		try {
			System.out.println(obj.add(1,0));
		}
		catch(ArithmeticException ae) {
			System.out.println(ae);
		}
	}

}
