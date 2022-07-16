public class CreateAndExecutingMultipleThreads {

	public static void main(String[] args) {
		Car obj=new Car();
		obj.start();
		System.out.println("Thread ID"+obj.getId());
	    obj.setName("Child Thread of Main Thread");
	   
	    
	    Bike bikeObj=new Bike();
		Thread thread2=new Thread(bikeObj);
		thread2.start();
	  
		for(int i=0;i<10;i++) {
			System.out.println("Main thread "+i);
		}
	   System.out.println("Thread Name"+obj.getName());
	  System.out.println("Thread Priority "+obj.getPriority());  
	 
	}

}

//we can create new thread in two ways
 // i)By extending Thread class
//  ii)Implementing Runnable Interface
class Car extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("exetended thread "+i);
		}
		System.out.println("this class is executed by new Thread");  
	
	}
}

//Creating the Thread by implementing runnable inteface

class Bike implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("interface thread "+i);
		}
		System.out.println("Another thread created by Implementing Runnable interface!");
	}
}
