/* This program is the homework of Benxin Zuo on course SWE619 in GMU.
 * Please DO NOT COPY the code for your homework.
 */

package findPrimeFactor;


import java.util.ArrayList;
import java.util.List;

/**
 * This class is to find the least index at which b[i] is a prime factor of a[i].
 * It contains algorithms of finding prime number, finding factors in b[i] of a[i],
 * and finding the least index at which b[i] is a prime factor of a[i].
 * 
 * <p>The methods of this class will throw a NullPointerException if list 'a' or 'b' are null,
 * or a IllegalArgumentException if list 'a' or 'b' are empty or the index is not found.
 * 
 * @author Benxin Zuo
 * @version 2.0
 *
 */
public class FindPrimeFactor {
	
	private static List<Integer> a=new ArrayList<Integer>();
	private static List<Integer> b=new ArrayList<Integer>();
	public static List<Integer> getListA(){
		return a;
	}
	public static List<Integer> getListB(){
		return b;
	}
	public static void addToListA(int number){
		a.add(number);
	}
	public static void addToListB(int number){
		b.add(number);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// The main method is not useful. Reserved for your convenience :)
		a.add(-4);
		//a.add(null);
		a.add(15);
		//a.add(null);
		b.add(-2);
		//b.add(null);
		b.add(3);
		b.add(0);
		System.out.println(findPrimeFactor(a,b));
	}

	/**
	 * Find the least index at which b[i] is a prime factor of a[i].
	 * 
	 * @param a an integer list that is not null or empty.
	 * @param b an integer list that is not null or empty.
	 * @throws NullPointerException if a or b, or any element in a or b is null.
	 * @throws IllegalArgumentException if a or b is empty, or the index is not found.
	 * @return The least index at which b[i] is a prime factor of a[i]
	 */
	public static int findPrimeFactor (List<Integer> a, List<Integer> b){
		if(a==null || b==null)
			throw new NullPointerException("a and b should not be null");
		if(a.isEmpty() || b.isEmpty())
			throw new IllegalArgumentException("a and b should not be empty");
	   
		int record=Integer.MAX_VALUE;
		int recordIndex=b.size();
		boolean find=false;
	  
		for(int i=0;i<b.size();i++)
		{
			if(b.get(i)==null)
				throw new NullPointerException("All the element in list 'b' should not be null");
		   int number=b.get(i);
		   if(isPrime(number)==true && isFactor(a,number)==true)//not using '&' to make the judgment of isPrime first for better algorithms
		   {
			   find=true;
			   if(number<record)//choose the smallest number
			   {
				   record=number;
				   recordIndex=i;
			   }
		   }
		}
		if(find==true)
			return recordIndex;
		else
			throw new IllegalArgumentException("There is no index that matches the requirment");
	}
	   
	/**
	 * Judge if the input value is a prime.
	 * 
	 * @param number the number to judge.
	 * @return True if the number is a prime, otherwise False.
	 */
	public static boolean isPrime(int number){
		if(number<2)
			return false;
		double endOfEachTestDouble=0;
		endOfEachTestDouble=Math.sqrt(number);//to improve the speed of calculation for better algorithms
		int endOfEachTest=(int)endOfEachTestDouble+1;
		for(int i=2;i<=endOfEachTest;i++)//index larger than endOfEachTest is not necessary to calculate
		{
			if(number%i==0&&number!=i&&number!=1)
				return false;
		}
		return true;
	}
	
	/**
	 * Judge if the input number is a factor of the input list.
	 * 
	 * @param a an integer list that is not null or empty.
	 * @param number the number to judge.
	 * @throws NullPointerException if list 'a' , or any element in 'a' is null.
	 * @throws IllegalArgumentException if list 'a' is empty.
	 * @return True if the number is a factor of list 'a', otherwise False.
	 */
	public static boolean isFactor(List<Integer> a,int number){
		if(a==null)
			throw new NullPointerException("a should not be null");
		if(a.isEmpty())
			throw new IllegalArgumentException("a should not be empty");
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i)==null)
				throw new NullPointerException("All the element in list 'a' should not be null");
			if(a.get(i)%number==0)
				return true;
		}
		return false;
	}
}

