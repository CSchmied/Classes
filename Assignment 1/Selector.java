import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Carlton Schmieder (YOU@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  9/1/2019
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a  
    * @return min value 
    * 
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) { 
         throw new IllegalArgumentException("Array needs to be"
            +  " at least 1 integer."); 
      } 
      int min = a[0]; 
      for (int i = 1; i < a.length; i++) {
         if (a[i] < min) {
            min = a[i]; 
         
         }
      }  
         
      return min;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a  
    * @return max value
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) { 
         throw new IllegalArgumentException("Array needs to be"
            +  " at least 1 integer."); 
      } 
      int max = a[0];
      for (int i = 1; i < a.length; i++) {
         if (a[i] > max) {
            max = a[i]; 
         }
      }
   
      return max;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @param a array
    * @param k int value
    * @return kmin
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0) { 
         throw new IllegalArgumentException("array needs to be"
            +  " at least 1 integer"); 
      } 
    
      if (k > a.length || k <= 0) { 
         throw new IllegalArgumentException("k needs to be a "
            + "value in the array");
      }
      
      int[] copy = Arrays.copyOf(a, a.length); 
      Arrays.sort(copy); 
      
      int distinctValues = 0; 
      int total = 0; 
      for (int i = 0; i < copy.length - 1; i++) { 
         if (copy[i] == copy[i + 1]) {
            distinctValues++; 
         }
      }
      total = copy.length - distinctValues; 
            
      if (k > total) { 
         throw new IllegalArgumentException(); 
      } 
    
      int[] copy2 = Arrays.copyOf(copy, copy.length); 
      int c = 0; 
      int i = 1;
      
      while (i < copy2.length) { 
         if (copy2[i] == copy2[c]) { 
            i++; 
         } 
         else { 
            c++; 
            copy2[c] = copy2[i];
            i++; 
         } 
      }
      int kmin = copy2[k - 1]; 
      return kmin; 
   
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @param a is an array
    * @param k 
    * @return kmax
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0) { 
         throw new IllegalArgumentException("array needs to be"
            +  " at least 1 integer"); 
      } 
   
      if (k > a.length || k <= 0) { 
         throw new IllegalArgumentException("k needs to be a "
            + "value in the array");
      }
     
      int[] copy = Arrays.copyOf(a, a.length); 
      Arrays.sort(copy); 
      
      int distinctValues = 0; 
      int total = 0; 
      for (int i = 0; i < copy.length - 1; i++) { 
         if (copy[i] == copy[i + 1]) {
            distinctValues++; 
         }
      }
      total = copy.length - distinctValues; 
            
      if (k > total) { 
         throw new IllegalArgumentException(); 
      } 
      
      int[] copy2 = Arrays.copyOf(copy, copy.length); 
      int c = 0; 
      int i = 1;
      
      while (i < copy2.length) { 
         if (copy2[i] == copy2[c]) { 
            i++; 
         } 
         else { 
            c++; 
            copy2[c] = copy2[i];
            i++; 
         } 
      }
      int kmax = copy2[total - k]; 
      return kmax;  
   
   
   }
   


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    * @param a  
    * @param low  
    * @param high  
    * @return copy2 and empty
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) { 
         throw new IllegalArgumentException("array needs to be"
            +  " at least 1 integer"); 
      } 
      int[] copy = Arrays.copyOf(a, a.length); 
      int c = 0; 
      
      for (int i = 0; i < a.length; i++) { 
         if (a[i] >= low && a[i] <= high) { 
            copy[c] = a[i];
            c++;
         }
      }
           
      if (c == 0) {
         int[] empty = {}; 
         return empty;
      } 
      else { 
         int[] copy2 = Arrays.copyOf(copy, c); 
         return copy2;
      } 
         
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a is an array
    * @param key  
    * @return ceil 
    */
   public static int ceiling(int[] a, int key) {
      int ceil = 0; 
      int change = 0; 
   
      if (a == null || a.length == 0) { 
         throw new IllegalArgumentException(); 
      }
      
      for (int i = 0; i < a.length; i++) { 
         ceil += Math.abs(a[i]);
      }
   
      for (int i = 0; i < a.length; i++) { 
         if (a[i] >= key && a[i] <= ceil) {
            ceil = a[i];
            change++;
         }
      } 
            
      if (change == 0) { 
         throw new IllegalArgumentException(); 
      } 
      return ceil;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a is an array
    * @param key  
    * @return floor 
    */
   public static int floor(int[] a, int key) {
      int floor = 0; 
      int change = 0; 
   
      if (a == null || a.length == 0) { 
         throw new IllegalArgumentException();
      } 
   
      for (int i = 0; i < a.length; i++) {
         floor -= Math.abs(a[i]);
      }
   
      for (int i = 0; i < a.length; i++) { 
         if (a[i] <= key && a[i] >= floor) {
            floor = a[i]; 
            change++; 
         }
      }
      if (change == 0) { 
         throw new IllegalArgumentException();
      }
      return floor;
   }

}
