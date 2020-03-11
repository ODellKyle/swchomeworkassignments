/* Kyle O'Dell
 * Dr. Carl Scarbnick
 * Math 140-06
 * 23 September 2018
 * Homework 2 - Develop a modified version of the ArrayList class.
 */

package homework;


public class StringArrayList 
{
  private String[] list;
  private int size = 0;
  
  public StringArrayList(int capacity) 
  {
    this.list = new String[capacity];
  }
  
  // Method guarantees instance array will have enough space to hold more elements
  private void ensureCapacity(int minCapacity) 
  {
    String[] newList = null;
    
    if(this.list != null) 
    {
      if(minCapacity > this.list.length) 
      {
        newList = new String[minCapacity];
        System.arraycopy(this.list, 0, newList, 0, this.list.length);
      }
    }
    
    this.list = newList;
  }
  
  // Method adds new element to instance array. If the logical size of the array is equivalent to it's length, ensureCapacity.
  public void add(String value) 
  {
    if(this.size >= this.list.length)
      ensureCapacity(this.list.length * 2);
    
    this.list[this.size] = value;
    this.size++;
  }
  
  // Method adds new element to instance array by element position. If the logical size is equivalent to it's length, ensureCapacity.
  public void add(int index, String value) 
  {
    if(index < 0 || index >= this.size)
      throw new IndexOutOfBoundsException();
    
    if(size >= this.list.length) 
      ensureCapacity(this.list.length * 2);
    
    System.arraycopy(this.list, index, this.list, index + 1, this.size - index + 1);
    
    this.list[index] = value;
    this.size++;
  }
  
  // Removes element from instance array by overwriting it.
  public String remove(int index) 
  {
    String removedItem;
    
    if(index < 0 || index >= this.size)
      throw new IndexOutOfBoundsException();
    
    removedItem = this.list[index];
    System.arraycopy(this.list, index + 1, this.list, index, this.size - index - 1);
    this.size--;
    
    return removedItem;
  }
  
  // Removes first occurring instance of parameter variable from instance array.
  public boolean remove(String s) 
  {
    boolean containsElement = false;
    int index = 0;
    
    while(!containsElement && index < this.size) 
    {
      if(this.list[index].equals(s)) 
      {
        System.arraycopy(this.list, index + 1, this.list, index, this.size - index - 1);
        containsElement = true;
        size--;
      }
      index++;
    }
    
    return containsElement;
  }
  
  // Returns element from instance array from parameter index.
  public String get(int index) 
  {
    if(index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    
    return this.list[index];
  }
  
  // Returns logical size of instance array.
  public int size() 
  {
    return this.size;
  }
  
  // Returns a string displaying all of the instance array's elements.
  public String toString() 
  {
    String listElements = "{";
    
    if(size != 0)
      for(int i = 0; i < this.size; i++) 
      {
        listElements += "\"";
        listElements += this.list[i];
        listElements += "\"";
        
        if(i != this.size - 1)
          listElements += ", ";
      }
    
    return listElements += "}";
  }
  
  // Returns a new StringArrayList with only elements that have the same prefix as the parameter.
  public StringArrayList containsPrefix(String pre) 
  {
    String letters = "";
    StringArrayList newList = this;
    
    for(int i = 0; i < newList.size; i++) 
    {
      for(int j = 0; j < pre.length(); j++)
        letters += newList.get(i).charAt(j);
      
      if(!pre.equals(letters)) 
      {
        newList.remove(i);
        i--;
      }
      
      letters = "";
    }
    
    return newList;
  }
}
