/* Kyle O'Dell
 * Dr. Carl Scarbnick
 * Math 140
 * November 16, 2018
 * Homework 4 - further develop LinkedList data structure
 * to become much more versatile.
 */

package homework4;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class LinkedList<E> implements Iterable<E>
{
    private Node head;
    private Node last;
    private int size;

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

    public E remove(int i) 
    {
        if (i < 0 || i >= size) 
            throw new IndexOutOfBoundsException();
        
        E tmp;
        if (i == 0) 
        {
            tmp = head.item;
            if (size == 1) 
                head = last = null;
            else 
            {
                head = head.next;
                head.prev = null;
            }
        } 
        else if (i == size - 1) 
        {
            tmp = last.item;
            last = last.prev;
            last.next = null;
        } 
        else 
        {
            Node ptr = head;
            // The loop moves ptr to the Node at position i
            for (int index = 0; index < i; index++) 
            {  
                ptr = ptr.next;
            }
            tmp = ptr.item;
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
        }
        size--;
        return tmp;
    }

    public boolean contains(Object item) 
    {
        boolean found = false;
        Node ptr = head;
        while (ptr != null && !found) 
        {
            if (equals(ptr.item, item)) 
                found = true;
            
            ptr = ptr.next;
        }
        return found;
    }

    private boolean equals(Object target, Object element) 
    {
        boolean flag;
        if (target == null) 
            flag = element == null;
        else
            flag = target.equals(element);
        
        return flag;
    }

    public E get(int i) 
    {
        if (i < 0 || i >= size) 
            throw new IndexOutOfBoundsException();
        
        Node ptr = head;
        for (int index = 0; index < i; index++) 
            ptr = ptr.next;
        
        return ptr.item;
    }

    public void add(int i, E item) 
    {
        if (i < 0 || i > size) 
            throw new IndexOutOfBoundsException();

        Node node = new Node(item);
        if (i == 0) 
        {// place the new Node at the head of the list
            if (size == 0)  // head = null
                head = last = node;
            else 
            {
                head.prev = node;
                node.next = head;
                head = node;
            }
        }
        else if (i == size) 
        {
            last.next = node;
            node.prev = last;
            last = node;
        }
        else 
        {
            Node ptr = head;
            for (int index = 0; index < i; index++)   // place ptr at position i
                ptr = ptr.next;
            
            node.next = ptr;
            node.prev = ptr.prev;
            ptr.prev.next = node;
            ptr.prev = node;
        }
        size++;
    }

    public boolean add(E item) 
    {
        Node node = new Node(item);
        if (head == null) 
        { // size equals zero
            head = last = node;
        } 
        else 
        {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
        return true;
    }

    public int size() 
    {
        return size;
    }
    
    public Iterator<E> iterator()
    {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<E>
    {
        private Node ptr = head;
        
        public E next()
        {
            E tmp = ptr.item;
            ptr = ptr.next;
            return tmp;
        }
        
        public boolean hasNext()
        {
            return ptr != null;
        }
    }

    // Returns true if target is greater than element
    private boolean greater(E target, E element, Comparator<E> c) 
    {
      boolean flag;
      
      if(target == null)
        flag = false;
      else if(target != null && element == null)
        flag = true;
      else
        flag = c.compare(target, element) > 0;
        
      return flag;
    }
    
    // Returns true if target is less than element
    private boolean less(E target, E element, Comparator<E> c) 
    {
      boolean flag;
      
      if(element == null)
        flag = false;
      else if(target == null && element != null)
        flag = true;
      else
        flag = c.compare(target, element) < 0;
      
      return flag;
    }
    
    // Removes first occurrence of parameter object
    public boolean remove(Object o) 
    {
      boolean itemRemoved = false;
      
      int i = 0;
      Node ptr = head;
      
      while(!itemRemoved && ptr != null) 
      {
        if(equals(o, ptr.item)) 
        {
          if(i == 0 || i == size - 1)
            remove(i);
          else 
          {
            ptr.next.prev = ptr.prev;
            ptr.prev.next = ptr.next;
            size--;
          }
          
          itemRemoved = true;
        }
          
        i++;
        ptr = ptr.next;
      }// end loop
      
      return itemRemoved;
    }
    
    // Adds all items from the parameter list to the end of this.list
    public boolean addAll(LinkedList<E> list) 
    {
      if(list != null) 
      {
        Node ptr = list.head;
        for(int i = 0; i < list.size(); i++) 
        {
          this.add(ptr.item);
          ptr = ptr.next;
        }
      }
      
      return true;
    }
    
    // Checks if all items within the parameter list are contained within this.list
    public boolean containsAll(LinkedList<E> list) 
    {
      boolean flag = false;
      
      if(list != null) 
      {
        flag = true;
        Node ptr = list.head;
        while(flag && ptr != null) 
        {
          flag = contains(ptr.item);
          ptr = ptr.next;
        }
      }
      
      return flag;
    }
    
    // Removes all occurrences of the elements in the parameter list, from this.list
    public boolean removeAll(LinkedList<E> list) 
    {
      boolean flag = false;
      
      if(list != null) 
      {
        Node ptr = list.head;
        
        while(ptr != null) 
        {
          if(!contains(ptr.item)) 
            ptr = ptr.next;
          else 
          {
            remove(ptr.item);
            flag = true;
          }
        }
      }
      
      return flag;
    }
    
    // Fills and returns new LinkedList based off the specific lambda expression
    public LinkedList<E> filter(Predicate<E> p)
    {
      LinkedList<E> list = null;
      
      if(this != null) 
      {
        Node ptr = head;
        list = new LinkedList<>();
        
        for(int i = 0; i < size(); i++) 
        {
          if(p.test(ptr.item))
            list.add(ptr.item);
          
          ptr = ptr.next;
        }
      }
      
      return list;
    }
    
    // Fills and returns a new LinkedList with only objects greater than the parameter item
    public LinkedList<E> greaterThan(E item, Comparator<E> c)
    {
      LinkedList<E> list = null;
      
      if(this != null) 
      {
        Node ptr = head;
        list = new LinkedList<>();
        
        for(int i = 0; i < size(); i++) 
        {
          if(greater(ptr.item, item, c))
            list.add(ptr.item);
          
          ptr = ptr.next;
        }
      }
      
      return list;
    }
    
    // Fills and returns a new LinkedList with only objects less than the parameter item
    public LinkedList<E> lessThan(E item, Comparator<E> c)
    {
      LinkedList<E> list = null;
      
      if(this != null) 
      {
        Node ptr = head;
        list = new LinkedList<>();
        
        for(int i = 0; i < size(); i++) 
        {
          if(less(ptr.item, item, c))
            list.add(ptr.item);
          
          ptr = ptr.next;
        }
      }
      
      return list;
    }
}// end class
