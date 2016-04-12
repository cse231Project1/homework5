package edu.oakland.production;

import edu.oakland.helper.*;

/**
*	Team4 is a manager class to find the first two odd int's in a provided array,
*	which are odd and between 600 and 6000. It provides basic methods to accomplish
*	this task.
*
*	@author Chase Hulderman
*	@version version 1.0 - 160407
*	@since version 1.0
*/

public class Team4Generic {
	private SimpleStack<Integer> stack;  //The stack upon which operations are run.

	private int[] values;  //Holds the odds values found.
	private long time;     //Holds the time value, in nanoseconds, to find odds.
	
	/**
	*	Constructs an empty stack, sets up initial values
	*/
	public Team4Generic(){
		this.stack = new SimpleStack<Integer>();
		this.values = new int[] {-1, -1};
	}
	/**
	*	Constructs a stack with the int[] input, sets up initial values.
	*
	*	@param array	an int array to pass to the stack.
	*/
	public Team4Generic(int[] array){
		this.stack = new SimpleStack<Integer>();
		this.stack.push(convertArray(array));
		this.evaluate();
	}
	/**
	*	Evaluates the odds for the stack, and records the time taken.
	*/
	private void evaluate(){
		long startTime, endTime, diff;
		startTime = System.nanoTime();
		this.values = findOdds(this.stack);
		endTime = System.nanoTime();
		diff = endTime - startTime;
		this.time = diff;
	}
	/**
	*	Converts a primitive int[] array to an Integer[] array for working with
	*	SimpleStack.
	*
	*	@param	intArray		the input array
	*	@return	convertedArray	the output array.
	*/
	private Integer[] convertArray(int[] intArray){
		Integer[] convertedArray = new Integer[intArray.length];
		int j = 0;
		for(int i: intArray){
			convertedArray[j] = intArray[j];
			j++;
		}
		return convertedArray;
	}

	/**
	*	Finds the odds in a SimpleStack given a stack. Only finds the first two
	*	in LIFO order.
	*
	*	@param	stack	a stack to perform the operation on.
	*	@return	odds	the int array of two odds.
	*/
	private int[] findOdds(SimpleStack<Integer> stack){
		int count = 0;
		int value;
		int[] odds = new int[] {-1, -1};
		boolean condition;

		while(!stack.empty() && count < 2) {
			value = stack.pop().intValue();
			condition = (value % 2 == 1) && (value > 600) && (value < 6000);
			if(condition){
				odds[count] = value;
				count++;
			}
		}
		return odds;
	}
	/**
	*	Mutator method allows for after intialization change of the manager class
	*	working stack.
	*
	*	@param intArray	an integer array to push onto the stack
	*/
	public void setStack(int[] intArray){
		this.stack.push(convertArray(intArray));
		evaluate();
	}
	/**
	*	returns the odds values found
	*
	*	@return	the odds values found.
	*/
	public int[] getValues(){
		return this.values;
	}
	/**
	*	returns the time taken in nanoseconds
	*
	*	@return	the time taken in nanoseconds
	*/
	public long getTime(){
		try{
			return this.time;
		}catch(NullPointerException e){
			return -1L;
		}
	}	
}