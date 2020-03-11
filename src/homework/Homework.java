/* Kyle O'Dell
 * Dr. Scarbnick
 * Math 140-06
 * Homework 1:
 * Assignment provides experience in returning the number
 * of pairs that add up to zero within an array, and utilizing
 * critical thinking skills to store the elements of a 2D array
 * into a 1D array.
 */

package homework;

public class Homework 
{ 
  
  public static void main(String[] args) 
  {
    int[] ra = {-13, -11, -9, -4, -3, -2, -1, 0, 1, 2, 4, 9, 11, 14, 15, 16, 17, 18};
    int[][] twoD = { {9, 0, 8},
                     {4, 5, -2, 6},
                     {3, 4, 2} };
    
    // Part 1:
    System.out.println("The number of pairs that add up to zero in ra is: " + twoSum(ra));
    
    
    // Part 2:
    ra = convertToOneD(twoD);
    
    System.out.println();
    for(int x:ra) 
    {
      System.out.print(x + " ");
    }
  }// end main
  
  
  // Part 1:
  // Array is checked from each end for pairs of elements that add up to zero. Increments numPairs each time a pair is found.
  public static int twoSum(int[] arr) 
  {
    int numPairs = 0;
    int left = 0;
    int right = arr.length - 1;
    
    while(arr[left] < 0 && arr[right] > 0) 
    {
      if(arr[left] + arr[right] == 0) 
      {
        numPairs++;
        left++;
        right--;
      }
      else if(Math.abs(arr[left]) > arr[right])
        left++;
      else
        right--;
    }// end loop
    
    return numPairs;
  }// end twoSum
  
  
  // Part 2:
  // Copies all elements from 2D array into the new 1D array
  public static int[] convertToOneD(int[][] arr) 
  {
    int num = 0;
    int itemsCopied = 0;
    int[] newRa;
    
    // Adds up total elements within 2D array
    for(int[] oneD:arr)
      num += oneD.length;
    
    newRa = new int[num];
    
    // Copies all elements from 2D array into the new 1D array
    for(int[] oneD:arr) 
    {
      System.arraycopy(oneD, 0, newRa, itemsCopied, oneD.length);
      itemsCopied += oneD.length;
    }
    
    return newRa;
  }// end convertToOneD
}// end class
