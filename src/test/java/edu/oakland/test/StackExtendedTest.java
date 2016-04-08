package edu.oakland.test;

import edu.oakland.helper.*;
import junit.framework.*;

public class StackExtendedTest extends TestCase{

	/**
	*	Private class values
	*/
	private StackExtended<Integer> stackTest;
	private Integer test1, test2, rand;
	
	/**
	*	setUp() creates necessary objects to test
	*/
	public void setUp(){
		stackTest = new StackExtended<Integer>();
		rand = new Integer((int)(100*Math.random()));
		test1 = new Integer(4);
		test2 = new Integer(231);
	}

	public void testPush(){
		stackTest.push(test1);
		assertEquals(test1, stackTest.pop());
		stackTest.push(new Integer[] {1, 2, 3, 4, 5, 6});
		assertEquals(new Integer(6), stackTest.pop());
	}
	public void testEmpty(){
		assertTrue(stackTest.empty());
		stackTest.push(rand);
		assertFalse(stackTest.empty());
		stackTest.push(new Integer[] {1, 2, 3, 4, 5, 6});
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
}