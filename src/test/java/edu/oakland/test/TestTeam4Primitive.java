package edu.oakland.test;

import edu.oakland.helper.*;
import edu.oakland.production.*;

import junit.framework.*;

public class TestTeam4Primitive extends TestCase{
	private Team4Primitive testManager;
	private int[] testArray;

	public void setUp(){
		this.testArray = new int[] {697, 4, 231, 7968, 5653, 1457};
		this.testManager = new Team4Primitive(this.testArray);
	}
	public void testEvaluate(){
		assertEquals(1457, this.testManager.getValues()[0]);
		assertEquals(5653, this.testManager.getValues()[1]);
	}
}