package edu.oakland.production;

import edu.oakland.helper.*;
import java.util.concurrent.TimeUnit; //Needed to convert time.

/**
*	Team4 is a manager class to find the first two odd int's in a provided array,
*	which are odd and between 600 and 6000. It provides basic methods to accomplish
*	this task.
*
*	@author Chase Hulderman
*	@version version 1.0 - 160407
*	@since version 1.0
*/

public class Team4 {
	private StackExtended<Integer> stack;  //The stack upon which operations are run.

	private int[] values;  //Holds the odds values found.
	private long time;     //Holds the time value, in milliseconds, to find odds.
	
	/**
	*	Constructs an empty stack, sets up initial values
	*/
	public Team4(){
		this.stack = new StackExtended<Integer>();
		values = new int[2];
	}
	/**
	*	Constructs a stack with the int[] input, sets up initial values.
	*
	*	@param array	an int array to pass to the stack.
	*/
	public Team4(int[] array){
		this.stack = new StackExtended<Integer>();
		this.stack.push(convertArray(array));
		values = new int[2];
	}
	/**
	*	Evaluates the odds for the stack, and records the time taken.
	*/
	public void evaluate(){
		long startTime, endTime, diff;
		startTime = System.nanoTime();
		this.values = findOdds(this.stack);
		endTime = System.nanoTime();
		diff = endTime - startTime;
		this.time = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
	}
	/**
	*	Converts a primitive int[] array to an Integer[] array for working with
	*	StackExtended.
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
	*	Finds the odds in a StackExtended given a stack. Only finds the first two
	*	in LIFO order.
	*
	*	@param	stack	a stack to perform the operation on.
	*	@return	odds	the int array of two odds.
	*/
	private int[] findOdds(StackExtended<Integer> stack){
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
		this.stack.push(convertArray(array)); 
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
	*	returns the time taken
	*
	*	@return	the time taken.
	*/
	public long getTime(){
		return this.time;
	}	
}