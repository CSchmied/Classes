import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException
import java.util.Scanner;

public class myFirstUDPClient {

   private static final int TIMEOUT = 3000;   // Resend timeout (milliseconds)
   private static final int MAXTRIES = 5;     // Maximum retransmissions

   public static void main(String[] args) throws IOException {
   
      if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
         throw new IllegalArgumentException("Parameter(s): <Server> [<Port>]");
   
      InetAddress serverAddress = InetAddress.getByName(args[0]);  // Server address
      // Convert input String to bytes using the default character encoding
      
      Scanner scan = new Scanner(System.in);
      String input = ""; 
      System.out.print("Enter sentence S: ");
      input = scan.nextLine();
      
      byte[] bytesToSend = input.getBytes();
   
      int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
   
      DatagramSocket socket = new DatagramSocket();
   
      socket.setSoTimeout(TIMEOUT);  // Maximum receive blocking time (milliseconds)
   
      DatagramPacket sendPacket = new DatagramPacket(bytesToSend,  // Sending packet
           bytesToSend.length, serverAddress, servPort);
   
      DatagramPacket receivePacket =                              // Receiving packet
           new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);
           
      long timeSent = System.currentTimeMillis();
   
      int tries = 0;      // Packets may be lost, so we have to keep trying
      boolean receivedResponse = false;
      do {
         socket.send(sendPacket);          // Send the echo string
         try {
            socket.receive(receivePacket);  // Attempt echo reply reception
         
            if (!receivePacket.getAddress().equals(serverAddress))  // Check source
               throw new IOException("Received packet from an unknown source");
         
            receivedResponse = true;
         } catch (InterruptedIOException e) {  // We did not get anything
            tries += 1;
            System.out.println("Timed out, " + (MAXTRIES-tries) + " more tries...");
         }
      } while ((!receivedResponse) && (tries < MAXTRIES));
   
      long timeReceived = System.currentTimeMillis();
      long duration = timeReceived - timeSent;
   
      if (receivedResponse) {
         System.out.println("Received: " + new String(receivePacket.getData()));
         System.out.println("Duration between time sent and time recieved is " + duration + "milliseconds");
      }
      else {
         System.out.println("No response -- giving up.");
      }
      socket.close();
   }
}
