package edu.oakland.production;

public class IntStack {
	private int[] stack;

	public IntStack() {
	}
	public IntStack(int[] initialStack){
		this.stack = initialStack;
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
			if(this.stack.length > 0){
				return false;
			} else {
				return true;
			}
		} catch(NullPointerException e){
			return true;
		}
	}
	public int pop(){
		int i = this.stack[this.stack.length-1];

		//try - catch

		int[] temp = this.stack;
		this.stack = new int[temp.length-1];
		for(int j = 0; j < this.stack.length; j++){
			this.stack[j] = temp[j];
		}
		return i;
	}
	public int peek(){
		int i = this.stack[this.stack.length-1];
		// try - catch
		return i;
	}
	public IntStack search(int i){
		IntStack locations = new IntStack();

		for(int j = 0; j < this.stack.length; j++){
			if(i == this.stack[j]){
				locations.push(j);
			}
		}
		return locations;
	}
	public void push(int i){
		int[] temp = this.stack;
		int index;
		try {
			index = temp.length + 1;
			this.stack = new int[index--];
			for (int j = 0; j < temp.length; j++){
				this.stack[j] = temp[j];
			}
		} catch(NullPointerException e){
			index = 1;
			this.stack = new int[index--];
		}
		
		this.stack[index] = i;
	}
	public void push(int[] i){
		int[] temp = this.stack;
		int index, start;
		try{
			index = temp.length + i.length;
			start = temp.length;
			this.stack = new int[index];
			for (int j = 0; j < temp.length; j++){
				this.stack[j] = temp[j];
			}
		} catch(NullPointerException e){
			index = i.length;
			start = 0;
			this.stack = new int[index];
		}
		
		for(int j = start; j < index; j++){
			this.stack[j] = i[j-start];
		}	
	}
}