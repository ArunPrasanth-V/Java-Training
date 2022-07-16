import java.util.concurrent.BlockingQueue;

public class Product extends Thread {
    BlockingQueue<String> blockingqueue=null;
    Product(BlockingQueue<String> queue){
    	this.blockingqueue=queue;
    }
	public void run() {
		for(String i:blockingqueue) {
			System.out.println(Thread.currentThread()+"  "+i);
		}
	}

}
