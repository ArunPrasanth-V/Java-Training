public class ExampleForWhyWeNeedMultiThreading {
  public static void main(String args[]) {
	  
	  System.out.println("Example for squential execution");
	  // For Example I want to print hi 5 times and Hello 5 times
	  for(int i=0;i<5;i++) {
		  System.out.println("HI");
	  }
	  for(int i=0;i<5;i++) {
		  System.out.println("Hello");
	  }
	  //From the above example the two loop have no relation
	  //then why we need to execute sequentially
	  
	  System.out.println("Example for parallel execution");
	  //now I will create another Thread that will print hello time
	  Excuter ex=new Excuter();
	  Thread thread2=new Thread(ex);
	  thread2.start();
	  
	  for(int i=0;i<5;i++) {
		  System.out.println(Thread.currentThread()+"Hello");
	  }
	 
	  
  }
}

class Excuter implements Runnable{
	public void run() {
		 for(int i=0;i<5;i++) {
			  System.out.println(Thread.currentThread()+"HI");
		  }
	}
}
