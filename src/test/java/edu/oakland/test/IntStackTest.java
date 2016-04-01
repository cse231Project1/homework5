package edu.oakland.test;

import edu.oakland.helper.*;
import junit.framework.*;

public class IntStackTest extends TestCase{

	/**
	*	Private class values
	*/
	private IntStack stackTest;
	private int test1, test2, rand;
	
	/**
	*	setUp() creates necessary objects to test
	*/
	public void setUp(){
		stackTest = new IntStack();
		rand = (int)(100*Math.random());
		test1 = 4;
		test2 = 231;
	}

	/**
	*	simpleStack() test method tests...
	*
	*/
	public void testPush(){
		stackTest.push(test1);
		assertEquals(test1, stackTest.pop());
		stackTest.push(new int[] {1, 2, 3, 4, 5, 6});
		assertEquals(6, stackTest.pop());
	}
	public void testEmpty(){
		assertTrue(stackTest.empty());
		stackTest.push(rand);
		assertFalse(stackTest.empty());
		stackTest.push(new int[] {1, 2, 3, 4, 5, 6});
		while(!stackTest.empty()){
			stackTest.pop();
		}
		assertTrue(stackTest.empty());
	}
	public void testPop(){
		stackTest.push(test1);
		assertEquals(test1, stackTest.pop());
		stackTest.push(test2);
		assertEquals(test2, stackTest.pop());
		stackTest.push(rand);
		assertEquals(rand, stackTest.pop());
	}
	public void testPeek(){
		stackTest.push(test1);
		assertEquals(test1, stackTest.peek());
		stackTest.push(test2);
		assertEquals(test2, stackTest.peek());
		stackTest.push(rand);
		assertEquals(rand, stackTest.peek());
	}
	public void testSearch(){
		stackTest.push(new int[] {5, 10, 15, 20, rand, 30});
		assertEquals(4, stackTest.search(rand));
	}
}