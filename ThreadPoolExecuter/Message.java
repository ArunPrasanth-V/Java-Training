public class Message implements Runnable {
    private int val;
    Message(int val){
        this.val=val;
    }
    public void run(){
    System.out.println("(Executing Thread Name : )"+Thread.currentThread().getName()+" message :"+val);   
    }
    
}
