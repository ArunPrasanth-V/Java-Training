public class ServerPojo {
    byte[] data;
    ServerPojo(byte[] data){
        this.data=data;
        System.out.println("Message Recived from the client side");
        System.out.println("Message length : "+data.length);
        System.out.println(data[0]+" first no.");
    }
}
