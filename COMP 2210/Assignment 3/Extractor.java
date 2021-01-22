import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Carlton Schmieder (you@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 10 - 3 - 19
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    */
   public Extractor(String filename) {
      try { 
         Scanner scan = new Scanner(new File(filename));
         int size = scan.nextInt(); 
         points = new Point[size]; 
         int x;
         int y;
         for (int i = 0; i < size; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            points[i] = new Point(x, y); 
         }
      }
      catch (java.io.IOException e) { 
         System.err.println("File not found."); 
      }
      catch (Exception e) {
         System.err.println("Another error."); 
      }
                 
                  
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      Line tem = new Line();
      lines = new TreeSet<Line>();
      for (int i = 0; i < points.length; i++) {
         for (int j = i + 1; j < points.length; j++) {
            for (int k = j + 1; k < points.length; k++) {
               for (int h = k + 1; h < points.length; h++) {
                  tem.add(points[i]);
                  tem.add(points[j]);
                  
                  if (tem.add(points[k]) && tem.add(points[h]) && tem.length() == 4) {
                     lines.add(tem); 
                  }
                  tem = new Line();
               }
            }
         }
      }   
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      Point [] copy = Arrays.copyOf(points, points.length); 
      lines = new TreeSet<Line>();
      Line tem = new Line(); 
      boolean canAdd = true;
      for (int i = 0; i <points.length; i++) {
         Arrays.sort(copy,points[i].slopeOrder);
         
         for (int j = 0; j < points.length; j++) {
            tem.add(copy[0]); 
            canAdd = tem.add(copy[j]);
            if (!canAdd) {
               if (tem.length() >= 4) {
                  lines.add(tem);
               }
               tem = new Line();
               tem.add(copy[j]); 
            }
         }
      }
      return lines;
   }
   
}
