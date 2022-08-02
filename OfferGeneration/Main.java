import java.util.Scanner;
public class Main {
       public static void main(String args[]){
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter how many Audio :");
      int audioNo=scan.nextInt();
    System.out.println("Enter how many Video :");
      int videoNo=scan.nextInt();
    System.out.println("Enter the IP Address :(ifconfig)");
      String  ip=scan.next();
    System.out.println("Enter the port Number");
      String port=scan.next();
      String offer="";
     
      String pwd=getAlphaNumericString(25);
      String uFrag=getAlphaNumericString(6);
      String msIDFixed=getAlphaNumericString(30);
      Main obj=new Main();
      String cname=getAlphaNumericString(16);
      
      offer+=obj.writeSession(msIDFixed,audioNo+videoNo);
       int mid=0;
      for(int i=0;i<audioNo;i++){
        System.out.println("Enter the SSRC for Media Stream Audio NO. "+(i+1));
          String ssrc=scan.next();
          String msid=getAlphaNumericString(30);
         offer+=obj.Writeaudio(ip,ssrc,uFrag,pwd,msid,port,mid++,cname,msIDFixed);
      }
      for(int i=0;i<videoNo;i++){
        System.out.println("Enter the SSRC for Media Stream Video NO. "+(i+1));
          String ssrc=scan.next();
          String msid=getAlphaNumericString(30);
         offer+=obj.Writevideo(ip,ssrc,uFrag,pwd,msid,port,mid++,cname,msIDFixed);
      }
       
     System.out.println( obj.toString(offer));
    }
    private String writeSession(String msId,int count){
        String template=Data.sessionDes;
        template=template.replace("{REPLACE_MSID}",msId);
        String c="";
        for(int i=0;i<count;i++)
        {
            c=c+i+" ";
        }
        template=template.replace("{REPLACE_BUNDLE_ID}",c.substring(0,c.length()-1));
        return template;
    }
    private String Writeaudio(String ip,String ssrc,String ufrag,String pwd,String msid,String port,int mid,String cname,String msIDFixed){
        String template=Data.audioM;
        template=template.replace("{REPLACE_URAG}", ufrag);
        template=template.replace("{REPLACE_PWD}", pwd);
        template=template.replace("{REPLACE_MSID}", msid);
        template=template.replace("{REPLACE_PORT}", port);
        template=template.replace("{REPLACE_SSRC}", ssrc);
        template=template.replace("{REPLACE_MID}", mid+"");
        template=template.replace("{REPLACE_IPADDRESS}", ip);
        template=template.replace("{REPLACE_CNAME}", cname);
        return template;
    }
    private String Writevideo(String ip,String ssrc,String ufrag,String pwd,String msid,String port,int mid,String cname,String msIDFixed){
        String template=Data.videoM;
        template=template.replace("{REPLACE_URAG}", ufrag);
        template=template.replace("{REPLACE_PWD}", pwd);
        template=template.replace("{REPLACE_MSID}", msid);
        template=template.replace("{REPLACE_PORT}", port);
        template=template.replace("{REPLACE_SSRC}", ssrc);
        template=template.replace("{REPLACE_MID}", mid+"");
        template=template.replace("{REPLACE_IPADDRESS}", ip);
        template=template.replace("{REPLACE_CNAME}", cname);
        return template;
    }
    public String toString(String offer){
        offer=("{\"type\":\"offer\",\"sdp\":\""+offer+"\"}").replaceAll("\\r\\n","\\\\r\\\\n");
    return offer;
    }


    static String getAlphaNumericString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length()* Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}
