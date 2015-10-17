/* First, the array is sorted for its values. Then, one list 'secondaryList' is made containing values of array 'a' and
 * its positions. Now, one array of frequency 'f' is made whose values are frequencies of elements found using the 
 * method 'frequency'.
 * Ultimately, the array of frequency with their index maintained, is returned.
*/
import java.util.*;

public class Frequency
{
   private static class Element implements Comparable<Element>
   {
      public int value;
      public int position;

      public Element(int value, int position)
      {
         this.value = value;
         this.position = position;
      }

      public int compareTo(Element other) 
      {
         return Integer.compare(value, other.value);
      }
   }

   /**
      Returns an array of the frequencies of each element in a.
      That is, if the returned array is f, then a[i] occurs f[i]
      times in a.
 * @return 
   */
   public static int[] frequencyOfElements(int[] a)
   {
	  int ind[][]=new int[a.length][2];
      List<Element> secondaryList = new ArrayList<Element>(a.length);
	   for (int i = 0; i < a.length; ++i) {
	       secondaryList.add(new Element(a[i], i));
	   }
	   
	   Collections.sort(secondaryList);
	   
	   for (int i = 0; i < secondaryList.size(); ++i) {
		   ind[i][0] = secondaryList.get(i).value;
		   ind[i][1] = secondaryList.get(i).position;
	       
	   }
	   
	   int f[]=new int[a.length];
	   for(int j=0; j<a.length; j++)
	   f[ind[j][1]]=Frequency2.frequency(ind[j][0],a); 
		
		//System.out.print(Arrays.toString(f));   	Uncomment to print the array.
		
		return f;
   }
	public static int frequency(int i, int[] a)
	{
		int count=0;
		for(int k=0; k<a.length; k++)
		{
			if(a[k]==i)
				count++;
		}
			return count;
		
	}
		
   public static void main(String s[])
	 {
	  frequencyOfElements(new int[] {3,1,4,1,4,4}); 
	 }
}