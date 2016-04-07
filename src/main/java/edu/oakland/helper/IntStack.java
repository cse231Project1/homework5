package edu.oakland.helper;


/**
*	IntStack is the implementation of a stack using a int array as the 
*	underlying data structure. A stores data using LIFO (last in first out).
*
*	@author Chase Hulderman
*	@author Miguel Millan
*	@version version 1.0 - 160405
*	@since version 1.0
*/
public class IntStack {
	private int[] stack;			//Contains the data of the stack
	private int stackCount;			//Keeps track of the top of the stack
	private int stackIncrement;		//Value used to resize the stack

	/**
	*	Constructs an empty stack with an initial size of ten.
	*/
	public IntStack() {
		this.stackCount = 0;
		this.stackIncrement = 0;
		this.stack = new int[10];
	}
	
	/**
	*	Constructs a stack and pushes the given integer onto it.
	*
	*	@param i the given integer to push onto the stack
	*/	
	public IntStack(int i){
		this.stackCount = 0;
		this.stack = new int[10];
		this.push(i);
		this.stackIncrement = 0;
	}
	
	/**
	*	Constructs a stack using a given array of integers.
	*
	*	@param i given integer array
	*/
	public IntStack(int[] i){
		this.stackCount = i.length;
		this.stack = i;
		this.stackIncrement = 0;

	}
	
	/**
	*	Prints out the values of the stack.
	*/
	public void printStack(){
		if(this.empty()){
			System.out.println("The Stack is empty");
		} else {
			for(int i: this.stack){
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}
	
	/**
	*	Verifies whether the stack is empty or not.
	* 	
	*	@return true if the stack is empty, false otherwise.
	*/
	public boolean empty(){
		try {
			if(this.stackCount <= 0){
				return true;
			} else {
				return false;
			}
		} catch(NullPointerException e){
			return true;
		}
	}
	
	/**
	*	Removes the element at the top of the stack and returns its value.
	*
	*	@return the value popped off the stack.
	*/
	public int pop(){
		try{
			int i = this.stack[this.stackCount-1];
			this.stack[this.stackCount-1] = -1;
			this.stackCount--;
			return i;
		} catch (NullPointerException e){
			return -1;
		}
	}
	
	/**
	*	Returns the element at the top of the stack without removing it.
	*
	*	@return the value at the top of the stack.
	*/
	public int peek(){
		try{
			return this.stack[this.stackCount-1];
		} catch(NullPointerException e){
			return -1;
		}
	}
	
	/**
	*	Searches the stack for a specified integer, and returns its index value.
	*
	*	@param i the value to search for
	*	@return the index value of i, or -1 if i is not in the stack. 
	*/
	public int search(int i){
		for(int j = 0; j < this.stackCount; j++){
			if(i == this.stack[j]){
				return j;
			}
		}
		return -1;
	}
	
	/**
	*	Searches the stack for all locations of the given integer, and returns
	*	an IntStack containing the indecies where the integer was found.
	*
	*	@param i the value to search for
	*	@return an IntStack containing all the indecies of i, or an empty IntStack.
	*/
	public IntStack searchAll(int i){
		IntStack locations = new IntStack();

		for(int j = 0; j < this.stackCount; j++){
			if(i == this.stack[j]){
				locations.push(j);
			}
		}
		return locations;
	}
	
	/**
	*	Pushes the given value onto the top of the stack.
	*
	*	@param i the value to push onto the stack.
	*/
	public void push(int i){
		int[] temp;
		int index;
		int increment;

		try {
			index = this.stack.length;
		} catch(NullPointerException e){
			index = 10;
			this.stack = new int[index];
		}
		if(this.stackIncrement <= 0){
			increment = this.stackCount;
		}else{
			increment = this.stackIncrement;
		}
		if(this.stackCount >= index){
			temp = this.stack;
			this.stack = new int[this.stackCount+increment];
			for (int j=0; j < temp.length; j++){
				this.stack[j] = temp[j];
			}
		}
		this.stack[this.stackCount] = i;
		this.stackCount++;
	}
	
	/**
	*	Pushes many integers onto the stack.
	*
	*	@param i an integer array to push on the stack.
	*/
	public void push(int[] i){
		for(int k =0; k < i.length; k++)
			this.push(i[k]);
	}
	
	/**
	*	Clears the stack.
	*/
	public void clear(){
		this.stack = new int[this.stackIncrement];
	}
}