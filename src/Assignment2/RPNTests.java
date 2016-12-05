package Assignment2;
/*
 * Andrew Chow
 * CSC 103
 * 10/16/16
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class RPNTests
{

	@Test
	public void EvaluateRPN1()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("5.0 1.0  2  4  3 - - - - "), 5.0, .00000001);
	}
	@Test
	public void EvaluateRPN2()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("5.0 1.0  2  4  3 + + + +"), 15.0, .00000001);
	}
	@Test
	public void EvaluateRPN3()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("5 1 2 + 4 * + 3.0 -"), 14.0, .00000001);
	}
	@Test
	public void EvaluateRPN4()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("2 3 + 7 9 / -"), 4.22222222, .00000001);
	}
	@Test
	public void EvaluateRPN5()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("2.0 3 4 + * 6.0 -"), 8.0, .00000001);
	}
	@Test
	public void EvaluateRPN6()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("4 1 - 2 * 9 + 7 *"), 105, .00000001);
	}
	@Test
	public void EvaluateRPN7()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("5.0 2.0 / 4 + 100 *"), 650, .00000001);
	}
	
	@Test
	public void EvaluateRPN8()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("2 3 + 8.0 5.0 * *"), 200, .00000001);
	}
	
	@Test
	public void EvaluateRPN9()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("2 3 + 8.0 5.0 * * 9 /"), 22.22222222, .00000001);
		
	}
	
	@Test
	public void EvaluateRPN10()
	{
		RPN rpn = new RPN();		
		assertEquals(rpn.evaluateRPN("5 1 2 + 4 3.0 - * +"), 8.0, .00000001);		
	}	
	@Test
	public void toRPN1()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.toRPN( "5 + ( 1 + 2 ) * 4 - 3.0"), "5 1 2 + 4 * + 3.0 -");
	}
	@Test
	public void toRPN2()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.toRPN("16.1 * ( 5.5 + 3.5 ) / 20"), "16.1 5.5 3.5 + * 20 /");
	}
	@Test
	public void toRPN3()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.toRPN( "5 + ( 1 + 2 ) * ( 4 - 3.0 )"), "5 1 2 + 4 3.0 - * +");
	}
	@Test
	public void toRPN4()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.toRPN( "5 + ( 5 + ( 5 + 1 + 2 ) ) * ( 4 - 3.0 )"), "5 5 5 1 + 2 + + 4 3.0 - * +");
	}
	@Test
	public void toRPN5()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.toRPN( "5 + ( ( 5 + 1 + 2 ) ) * ( 4 - 3.0 )"), "5 5 1 + 2 + 4 3.0 - * +");
	}
	@Test
	public void toRPN6()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.toRPN( "5 + ( ( ( 5 + 1 + 2 ) ) * ( 4 - 3.0 ) )"), "5 5 1 + 2 + 4 3.0 - * +");
	}
	@Test
	public void toRPN7()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.toRPN( "5 + 3 - ( 1 / 2 * 2 + 1 )"), "5 3 + 1 2 / 2 * 1 + -");
	}
	@Test
	public void evaluateInfix1()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.evaluateInfix("5 + 3 - ( 1 / 2 * 2 + 1 )" ), 6.0 , .00000001);
	}
	@Test
	public void evaluateInfix2()
	{
		RPN rpn = new RPN();
		assertEquals(rpn.evaluateInfix("5 + 3 - ( 1 / 2 * 2 + 1 ) * 6" ), -4.0 , .00000001);
	}	
	   @Test
	   public void test18_toRPNPrecedenceSub() {
	      assertEquals("2 3 - 4 - 5 -", RPN.toRPN("2 - 3 - 4 - 5"));
	      assertEquals("2 3 4 5 - - -", RPN.toRPN("2 - ( 3 - ( 4 - 5 ) )"));
	      assertEquals("2 3 4 5 - - -", RPN.toRPN("( 2 - ( 3 - ( 4 - 5 ) ) )"));
	      assertEquals("2 3 4 - - 5 -", RPN.toRPN("2 - ( 3 - 4 ) - 5"));
	      
	   }
	   @Test
	   public void test17_toRPNPrecedenceDiv() {
	      assertEquals("2 3 / 4 / 5 /", RPN.toRPN("2 / 3 / 4 / 5"));
	      assertEquals("2 3 4 5 / / /", RPN.toRPN("2 / ( 3 / ( 4 / 5 ) )"));
	      assertEquals("2 3 4 5 / / /", RPN.toRPN("( 2 / ( 3 / ( 4 / 5 ) ) )"));
	      assertEquals("2 3 4 / / 5 /", RPN.toRPN("2 / ( 3 / 4 ) / 5"));
	   }
	   @Test
	   public void test21_toRPNComplex() {
	      assertEquals("5 4 + 3 - 6 *", RPN.toRPN("( ( ( 5 + 4 ) - 3 ) * 6 )"));
	      assertEquals("5 4 + 3 - 6 *", RPN.toRPN("( ( 5 + 4 ) - 3 ) * 6"));
	      assertEquals("5 4 3 + 7 - * 6 /", RPN.toRPN("( 5 * ( 4 + 3 - 7 ) / 6 )"));
	      assertEquals("5 4 3 + 7 - * 6 /", RPN.toRPN("5 * ( 4 + 3 - 7 ) / 6"));
	   }
}
