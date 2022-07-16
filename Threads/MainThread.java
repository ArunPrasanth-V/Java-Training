import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {

	public static void main(String[] args) {
		
		BlockingQueue<String> bq=new ArrayBlockingQueue<>(5);
		bq.add("Arun");
		bq.add("is an passionate Java");
		bq.add("Developer");
		System.out.println(Thread.currentThread());
		Product product=new Product(bq);
	      product.start();
	      
	    
	     BlockingQueue<String> lq=new LinkedBlockingQueue<>();
	     lq.add("Learn");
	     lq.add("and");
	     lq.add("Grow");
	     Product product2=new Product(lq);
	      product2.start();
	     
	}

}
