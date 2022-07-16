public class InterruptInThread {

	public static void main(String[] args) {
	
		A obj=new A();
		obj.start();
		obj.interrupt();
	}

}
class A extends Thread{
	public void run() {
		try {
			A.sleep(1000);
//			for(int i=0;i<10;i++) {
//				//A.sleep(1000);
//				//System.out.println("child Thread running"+i);
//			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
