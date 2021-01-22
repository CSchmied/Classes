import java.util.Iterator; 
import java.util.Random; 
import java.util.NoSuchElementException;

/** A class that implements the RandomList interface 
*   for List Factory.
* @author Carlton Schmieder (cgs0038@auburn.edu)
* @version 10 - 17 - 19 
**/ 

public class ArrayRandomizedList<T> implements RandomizedList<T> {
   private T[] elements;
   private int size; 
   private static final int DEFAULT_CAPACITY = 5;

/** 
* Constructor.
**/ 

   public ArrayRandomizedList() {
      this(DEFAULT_CAPACITY);
   }
   
   @SuppressWarnings("unchecked") 
   public ArrayRandomizedList(int capacity) {
      elements = (T[]) new Object[capacity]; 
      size = 0; 
   }
   
   /** Returns the number of elements in list. 
   */ 
   public int size() {
      return size; 
   }
      
   /** Returns true if there are no elements, false otherwise. 
   */ 
   public boolean isEmpty() {
      return size == 0;
   } 
      
   /** Adds the element to list. If null, throws IlleaglArgumentException. 
   */ 
   public void add(T element) {
      if (element == null) {
         throw new IllegalArgumentException(); 
      }
   
      if (size == elements.length) { 
         resize(elements.length * 2); 
      }
      
      elements[size] = element; 
      size++; 
   }
   
   /** Selects and removes an element from the list. 
   */ 
   public T remove() {
      if (this.isEmpty()) {
         return null; 
      }
         
      Random ran = new Random(); 
      int value = ran.nextInt(size); 
      T removed = elements[value]; 
      elements[value] = null;
         
      if (value != (size - 1)) {
         elements[value] = elements[size - 1];
         elements[size - 1] = null; 
      }
            
      size--; 
            
      if (size > 0 && size < elements.length / 4) {
         resize(elements.length / 2);
      }
      return removed;
   }
               
   public T sample() {
      if (this.isEmpty()) {
         return null; 
      } 
            
      Random ran = new Random(); 
      int value = ran.nextInt(size);
      return elements[value];
   } 
            
     /** Creates and returns an iterator. */ 
   public Iterator<T> iterator() {
      return new ArrayIterator(elements, size);
   }
      
     /** Resizes an array */
   private void resize(int capacity) {
      T[] a = (T[]) new Object[capacity]; 
      for (int i = 0; i < size(); i++) {
         a[i] = elements[i];
      }
      elements = a; 
   }
      
      /** Nested class to make an iterator. */ 
   public class ArrayIterator<T> implements Iterator<T> {
      private T[] items;
      private int length; 
         
      public ArrayIterator(T[] elements, int sizeIn) {
         items = elements;
         length = sizeIn; 
      } 
         
      public boolean hasNext() {
         return (length > 0); 
      }
         
      public void remove() {
         throw new UnsupportedOperationException(); 
      }
         
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         } 
         Random ran = new Random(); 
         int value = ran.nextInt(length); 
         T next = items[value];
        
         if (value != (length - 1)) {
            items[value] = items[length - 1];
            items[length - 1] = next; 
         }
         length--; 
         return next;
      }
   }
}
   
