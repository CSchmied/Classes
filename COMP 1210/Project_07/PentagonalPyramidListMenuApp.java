import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**  
* Program that reads the information from the other 
programs and prints the results. 
* 
* Project_06
* @author Carlton Schmieder
* @version 2-28-19
*/ 

public class PentagonalPyramidList2MenuApp 
{

/** 
* Main method that calls the info from the other 
programs and gives the input and prints results. 
* @param args command not used
* @throws FileNotFoundException  
*/
   public static void main(String[] args) throws FileNotFoundException {
      String pentlistName = ""; 
      ArrayList<PentagonalPyramid> objects = new ArrayList<PentagonalPyramid>();
      PentagonalPyramidList myPList = new PentagonalPyramidList(pentlistName,
          objects);
      String fileName = "no file name";
      String label; 
      double baseEdge = 0; 
      double height = 0; 
      String code = "";
   
      Scanner scan = new Scanner(System.in);
   
      System.out.println("PentagonalPyramid List System Menu\n"
                       + "R - Read File and Create PentagonalPyramid List\n"
                       + "P - Print PentagonalPyramid List\n" 
                       + "S - Print Summary\n"
                       + "A - Add PentagonalPyramid\n"   
                       + "D - Delete PentagonalPyramid\n"   
                       + "F - Find PentagonalPyramid\n"
                       + "E - Edit PentagonalPyramid\n"
                       + "Q - Quit");
                       
      do { 
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine(); 
         if (code.length() == 0) {
            continue; 
         } 
         
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R': //Read in File and Create PentagonalPyramid
               System.out.print("\tFile Name: ");
               fileName = scan.nextLine(); 
            
               myPList = myPList.readFile(fileName);
            
               System.out.println("\tFile read in and "
                  + "PentagonalPyramid List created\n"); 
               break; 
               
            case'P': //Prints the pentagonalpyramid list
               System.out.println(myPList); 
               break;
            
            case 'S': //Prints summary 
               System.out.println("\n" + myPList.summaryInfo()); 
               break; 
            
            case 'A': //Adds a pentagonal pyramid to the list
               System.out.print("\tLabel: "); 
               label = scan.nextLine().trim(); 
               System.out.print("\tBase Edge: "); 
               baseEdge = Double.parseDouble(scan.nextLine());
               System.out.print("\tHeight: "); 
               height = Double.parseDouble(scan.nextLine());
               myPList.addPentagonalPyramid(label, baseEdge, height);
               System.out.println("\t*** PentagonalPyramid added ***\n");
               break; 
            
            case 'D': //Deletes a pentagonal pyramid
               System.out.print("Label: "); 
               label = scan.nextLine().trim();
               PentagonalPyramid temp = myPList.findPentagonalPyramid(label);
               PentagonalPyramid delete = 
                  myPList.deletePentagonalPyramid(label);  
               if (delete != null) {
                  System.out.println("\t\"" + temp.getLabel() + "\" deleted\n");
               }
               else { 
                  System.out.println("\t\"" + temp.getLabel() + "\" not found\n"); 
               }
               break; 
                  
            case 'F': //Finds given pentagonal pyramid
               System.out.print("\tLabel: "); 
               label = scan.nextLine().trim(); 
               PentagonalPyramid find = myPList.findPentagonalPyramid(label);
               if (find != null) { 
                  System.out.println(find); 
               }
               else { 
                  System.out.println("\t\"" + label + "\" not found\n"); 
               }
               break; 
             
            case 'E': //Edits a given pentagonal pyramid
               System.out.print("\tLabel: ");
               label = scan.nextLine().trim();
               System.out.print("\tBase Edge: ");
               baseEdge = Double.parseDouble(scan.nextLine()); 
               System.out.print("\tHeight: "); 
               height = Double.parseDouble(scan.nextLine());
               if (myPList.editPentagonalPyramid(label, baseEdge, height)) {
                  System.out.println("\"" + label + "\" successfully edited\n");
               }
               else {
                  System.out.println("\"" + label + "\" not found\n");
               } 
               break;
                
            case 'Q': //Quits Program
               break; 
             
            default: //no match
               System.out.println("\t*** invalid code ***\n"); 
               break;
         }
             
      } while (!code.equalsIgnoreCase("Q")); 
      
        
      
   }
}

