import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException

public class myFirstUDPServer {

   private static final int ECHOMAX = 255;  // Maximum size of echo datagram

   public static void main(String[] args) throws IOException {
   
      if (args.length != 1)  // Test for correct argument list
         throw new IllegalArgumentException("Parameter(s): <Port>");
   
      int servPort = Integer.parseInt(args[0]);
   
      DatagramSocket socket = new DatagramSocket(servPort);
      DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
   
      for (;;) {  // Run forever, receiving and echoing datagrams
         socket.receive(packet);     // Receive packet from client
         System.out.println("Handling client at " +
            packet.getAddress().getHostAddress() + " on port " + packet.getPort());
            
         String input = new String(packet.getData());
         String[] temp = input.split("\\s");
         String result = "";
      
         for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1) {
               result = temp[i] + result;
            }
            else {
               result = " " + temp[i] + result;
            }
         }
         System.out.println("Reversed Order: " + result);
         socket.send(packet);       // Send the same packet back to client
         packet.setLength(ECHOMAX); // Reset length to avoid shrinking buffer
      }
      /* NOT REACHED */
   }
}
