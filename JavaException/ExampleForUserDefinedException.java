public class ExampleForUserDefinedException {

	public static void main(String[] args) {
		VoiterIDException.verifyAge(15);
	}

}
class VoiterIDException extends Exception{
	
	VoiterIDException(int age){
		System.out.println("Please Check You're Age "+age);
	}
	public static void verifyAge(int age) {
		try {
		
			if(age<18) {
			throw new VoiterIDException(age);
		    }
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
