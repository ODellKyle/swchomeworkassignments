/* Kyle O'Dell
 * Dr. Scarbnick
 * Math 140
 * Homework 3 -- Design a unique LinkedList which does not contain any duplicate objects,
 * and can identify and compare objects.
 */

package homework3;

public class Set<E extends Comparable> 
{
  private Node head;
  private Node last;
  private int size = 0;
  
  private class Node 
  {
    private E item;
    private Node next;
    private Node prev;
    
    private Node(E item) 
    {
      this.item = item;
    }
  }
  
  private boolean equals(Object target, Object element) 
  {
    boolean flag;
    if (target == null) 
    {
      flag = element == null;
    } 
    else 
    {
      flag = target.equals(element);
    }
    return flag;
  }
  
  public boolean contains(Object item) 
  {
    boolean found = false;
    Node ptr = head;
    while (ptr != null && !found) 
    {
      if (equals(ptr.item, item)) 
      {
        found = true;
      }
      ptr = ptr.next;
    }
    return found;
  }
  
  public int size() 
  {
    return size;
  }
  
  // Compares and identifies the "smaller" object
  private boolean less(E target, E element) 
  {
    boolean flag;
    
    if(target == null && element == null)
      flag = false;
    else if(target == null && element != null)
      flag = true;
    else if(target != null && element == null)
      flag = false;
    else
      flag = target.compareTo(element) < 0;
    
    return flag;
  }
  
  // Compares and identifies the "larger" object
  private boolean greater(E target, E element) 
  {
    boolean flag;
    
    if(target == null && element == null)
      flag = false;
    else if(target != null && element == null)
      flag = true;
    else if(target == null && element != null)
      flag = false;
    else
      flag = target.compareTo(element) > 0;
    
    return flag;
  }
  
  // Adds new object as long as not already contained within set
  public boolean add(E item) 
  {
    boolean flag = false;
    
    if(!contains(item)) 
    {
      Node node = new Node(item);
      
      if(size == 0)
        head = last = node;
      else 
      {
        last.next = node;
        node.prev = last;
        last = node;
      }
      size++;
      flag = true;
    }
    
    return flag;
  }
  
  // Finds "largest" object within set
  public E getLargest() 
  {
    Node ptr = head;
    E largest = head.item;
    
    for(int i = 0; i < size(); i++) 
    {
      if(greater(ptr.item, largest))
        largest = ptr.item;
      
      ptr = ptr.next;
    }
    
    return largest;
  }
  
  // Finds "smallest" object within set
  public E getSmallest() 
  {
    Node ptr = head;
    E smallest = head.item;
    
    for(int i = 0; i < size(); i++) 
    {
      if(less(ptr.item, smallest))
        smallest = ptr.item;
      
      ptr = ptr.next;
    }
    
    return smallest;
  }
  
  // Creates a set based off all of the objects in the original set that are
  // larger than the parameter object.
  public Set<E> greaterThan(E item)
  {
    Set<E> tmp = null;
    
    if(size != 0) 
    {
      tmp = new Set<>();
      
      Node ptr = head;
      
      for(int i = 0; i < size(); i++) 
      {
        if(greater(ptr.item, item))
          tmp.add(ptr.item);
        
        ptr = ptr.next;
      }
      
    }
    
    return tmp;
  }
  
  // Creates a set based off all of the objects in the original set that are
  // smaller than the parameter object.
  public Set<E> lessThan(E item)
  {
    Set<E> tmp = null;
    
    if(size != 0) 
    {
      tmp = new Set<>();
      
      Node ptr = head;
      
      for(int i = 0; i < size(); i++) 
      {
        if(less(ptr.item, item))
          tmp.add(ptr.item);
        
        ptr = ptr.next;
      }
    }
    
    return tmp;
  }
  
  // Creates a new string array with each set objects .toString()
  public String[] getStrings() 
  {
    String[] ra = new String[size];
    
    Node ptr = head;
    
    for(int i = 0; i < size(); i++) 
    {
      if(ptr.item == null)
        ra[i] = null;
      else
        ra[i] = ptr.item.toString();
      
      ptr = ptr.next;
    }
    
    return ra;
  }
}// end class