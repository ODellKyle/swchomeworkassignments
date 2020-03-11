/* Kyle O'Dell
 * Dr. Carl Scarbnick
 * Math 140
 * 11/27/2018
 * Homework 5 -- Utilizing the bucket source algorithm to sort 
 * an ArrayList of strings in alphabetical order.
 */

package homework5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BSort 
{
    public static void main(String[] args) 
    {
        try 
        {
            ArrayList<String> list = new ArrayList<>();
            File f = new File(args[0]);
            Scanner in = new Scanner(f);
            while (in.hasNext()) 
            {
                list.add(in.nextLine());
            }
            
            System.out.println("Number of Strings " + list.size());
            System.out.println("\nUnsorted List");
            
            for (String s : list) 
            {
                System.out.println(s);
            }
            
            bsort(list);
            System.out.println("\nSorted List");
            
            for (String s : list) 
            {
                System.out.println(s);
            }
        } 
        catch (IOException e) 
        {
            System.out.println("IO ERROR");
        }
    }
    
    /* 
     * Returns the ascii value of the char at the parameter position if
     * position is greater than the parameter string length. Otherwise,
     * returns zero.
     */
    public static int charAt(String str, int position)
    {
    	int asciiValue = 0;
    	
    	if(position < str.length())
    		asciiValue = str.charAt(position) - 96;
    	
    	return asciiValue;
    }
    
    /*
     * Bucket Sort algorithm sorts an ArrayList of strings
     * into alphabetical order.
     */
    public static void bsort(ArrayList<String> strings)
    {
    	Queue<String>[] buckets = (Queue<String>[])new Queue[27];
    	
    	for(int i = 0; i < buckets.length; i++)
    		buckets[i] = new Queue<>();
    	
    	int N = strings.get(0).length();
    	
    	for(int i = 1; i < strings.size(); i++)
    		if(strings.get(i).length() > N)
    			N = strings.get(i).length();
    	
    	int index = N-1;
    	
    	while(index >= 0)
    	{
    		for(String s: strings)
    		{
    			int charIndex = charAt(s, index);
    			buckets[charIndex].enqueue(s);
    		}
    		
    		int j = 0;
    		for(int bucketNumber = 0; bucketNumber < buckets.length; bucketNumber++) 
    		{
    			while(!buckets[bucketNumber].isEmpty())
    			{
    				strings.set(j, buckets[bucketNumber].dequeue());
    				j++;
    			}
    		}
    		
    		index--;
    	}// end loop
    }// end BSort
}// end class