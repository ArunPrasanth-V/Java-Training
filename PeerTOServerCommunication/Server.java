//package Server_Listens_for_packet;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.*;

class Server {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        DatagramPacket packet = null;
        byte[] buf = new byte[102];
        try {
            socket = new DatagramSocket(8443);
           // InetAddress address = InetAddress.getByName ("127.0.0.1");
            while (true) {
                packet = new DatagramPacket(buf, buf.length);
                System.out.println("Waiting for packets");
             // System.out.println(socket.getPort());
                socket.receive(packet);
                byte[] receivedByte=packet.getData();
               // System.out.println(new String(receivedByte, "UTF-8"));
                for(byte i:receivedByte){
                    
                    System.out.print(String.format("%02X",i)+" ");
                }
                // byte[] responceByte={(byte)01,(byte)01,(byte)00,(byte)2,(byte)01};
                int port=packet.getPort();
                 String responce="0101002c2112a442574c745859497a48354d6f39002000080001"+Integer.toHexString(port)+"8d076cd3000800140ad5b7778e690891aa27d29b0322fd90bdb14b1f8028000439143175";
                 //String responce="0101002c2112a442574c745859497a48354d6f390020000800018d076cd3000800140ad5b7778e690891aa27d29b0322fd90bdb14b1f8028000439143175";
                
                 // String responce="0101002c2112a442574c745859497a48354d6f39002000080001fef38d076c";
                 byte[] responceByte=hexTOByte(responce);
                byte[] res=(packet.getAddress()+":"+packet.getPort()+" ").getBytes();//SocketAddress
                System.out.println(res.toString());
                DatagramPacket resoncepacket = new DatagramPacket(responceByte,responceByte.length,packet.getAddress(),packet.getPort());
                socket.send(resoncepacket);
            }
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
  public static byte[] hexTOByte(String s){
    byte[] ans = new byte[s.length() / 2];   
    //System.out.println("Hex String : "+s)
    for (int i = 0; i < ans.length; i++) {
        int index = i * 2;
       
          // Using parseInt() method of Integer class
        int val = Integer.parseInt(s.substring(index, index + 2), 16);
        ans[i] = (byte)val;
    }
        return ans;
  }
}
