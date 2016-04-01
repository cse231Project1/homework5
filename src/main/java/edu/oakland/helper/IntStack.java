package edu.oakland.helper;

public class IntStack {
	private int[] stack;
	private int stackCount;
	private int stackIncrement;

	public IntStack() {
		this.stackCount = 0;
		this.stackIncrement = 0;
	}
	public IntStack(int i){
		this.stackCount = 0;
		this.stack = new int[10];
		this.push(i);
		this.stackIncrement = 0;
	}
	public IntStack(int[] i){
		this.stackCount = 0;
		this.stack = i;
		this.stackIncrement = 0;

	}
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
	public int peek(){
		try{
			return this.stack[this.stackCount-1];
		} catch(NullPointerException e){
			return -1;
		}
	}
	public int search(int i){
		for(int j = 0; j < this.stackCount; j++){
			if(i == this.stack[j]){
				return j;
			}
		}
		return -1;
	}
	public IntStack searchAll(int i){
		IntStack locations = new IntStack();

		for(int j = 0; j < this.stackCount; j++){
			if(i == this.stack[j]){
				locations.push(j);
			}
		}
		return locations;
	}
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
	public void push(int[] i){
		int[] temp;
		int index, newLast, last, increment;

		try{
			index = this.stack.length;
			newLast = this.stackCount + i.length;
			last = this.stackCount;
		} catch(NullPointerException e){
			index = i.length*2;
			newLast = i.length;
			last = 0;
			this.stack = new int[index];
		}
		if(this.stackIncrement <= 0){
			increment = newLast;
		}else{
			increment = this.stackIncrement;
		}
		if(newLast >= index){
			temp = this.stack;
			this.stack = new int[newLast+increment];
			for(int j = 0; j < temp.length; j++){
				this.stack[j] = temp[j];
			}
		}

		for(int j = last; j < newLast; j++){
			this.stack[j] = i[j-last];
		}
		this.stackCount+=i.length;	
	}
	public void clear(){
		this.stack = new int[this.stackIncrement];
	}
}