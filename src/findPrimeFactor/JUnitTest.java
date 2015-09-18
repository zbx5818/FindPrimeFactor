/* This program is the homework of Benxin Zuo on course SWE619 in GMU.
 * Please DO NOT COPY the code for your homework.
 */

package findPrimeFactor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {

	@Before
	public void setUp(){
		FindPrimeFactor.addToListA(4);
		FindPrimeFactor.addToListA(15);
		FindPrimeFactor.addToListA(22);
		FindPrimeFactor.addToListB(2);
		FindPrimeFactor.addToListB(1);
	}
	
	@After
	public void tearDown(){
		//FindPrimeFactor.clear();
	}
	
	@Test
	public void isPrime(){
		assertFalse("-2 is not a prime",FindPrimeFactor.isPrime(-2));
		assertFalse("1 is not prime",FindPrimeFactor.isPrime(1));
		assertFalse("0 is not prime",FindPrimeFactor.isPrime(0));
		assertTrue("2 is a prime",FindPrimeFactor.isPrime(2));
		//assertTrue("b[3] is a prime",FindPrimeFactor.isPrime(FindPrimeFactor.b.get(3)));
		assertFalse("4 is not a prime",FindPrimeFactor.isPrime(4));	
	}
	
	@Test
	public void isFactor(){
		assertTrue("2 is a factor of 'a'",FindPrimeFactor.isFactor(FindPrimeFactor.getListA(),2));
		//assertTrue("b[1] is a factor of 'a'",FindPrimeFactor.isFactor(FindPrimeFactor.a,FindPrimeFactor.b.get(1)));
		//assertFalse("7 is not a factor of 'a'",FindPrimeFactor.isFactor(FindPrimeFactor.getListA(),7));
	}
	
	@Test
	public void findPrimeFactor(){
		assertEquals("0 is the result of prime&factor",0,FindPrimeFactor.findPrimeFactor(FindPrimeFactor.getListA(),FindPrimeFactor.getListB()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// the main function is not useful
	}

}
