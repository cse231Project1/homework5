package edu.oakland.production;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SimpleStack<E> {
	
	private int stackIncrement;
	private int stackCount;
	private E[] stackData;

	public SimpleStack(){
	}
	public static void main(String[] args) {
		SimpleStack<Integer> t = new SimpleStack<Integer>();
		t.printStack();
		for(int i=0; i<21;i++)
			t.push((int)(20*Math.random() + 1));
		t.push(10);
		t.printStack();
		t.searchAll(10).printStack();
		System.out.printf("First %d at %d\n", 10, t.search(10));
	}
	public void printStack(){
		if(this.empty()){
			System.out.println("The Stack is empty");
		} else {
			for(E e: this.stackData){
				System.out.print(e + ", ");
			}
			System.out.println();
		}
	}
	private E[] createArray(E e, int index){
		E[] genericArray = (E[]) Array.newInstance(e.getClass(), index);
		return genericArray;
	}
	private E[] createArray(E[] e, int index){
		E[] genericArray = (E[]) Array.newInstance(e.getClass().getComponentType(), index);
		return genericArray;
	}
	public boolean empty(){
		try {
			if(this.stackData.length > 0){
				return false;
			} else {
				return true;
			}
		} catch(NullPointerException e){
			return true;
		}
	}
	public E pop(){
		try{
			E e = this.stackData[this.stackData.length-1];

			E[] temp = this.stackData;
			this.stackData = createArray(e, temp.length-1);
			for(int j = 0; j < this.stackData.length; j++){
				this.stackData[j] = temp[j];
			}
			return e;
		} catch (NullPointerException ex){
			return null;
		}
	}
	public E peek()
	{
		try {
			return this.stackData[this.stackData.length-1];
		}
		catch(NullPointerException ex){
			return null;
		}
	}
	public int search(Object q){
		for(int j = 0; j < this.stackData.length; j++){
			if(q == this.stackData[j]){
				return j;
			}
		}
		return -1;
	}
	public SimpleStack<Integer> searchAll(Object q){
		SimpleStack<Integer> locations = new SimpleStack<Integer>();

		for(int j = 0; j < this.stackData.length; j++){
			if(q == this.stackData[j]){
				locations.push(j);
			}
		}
		return locations;
	}
	public void push(E e){
		E[] temp = this.stackData;
		int index;
		try {
			index = temp.length + 1;
			this.stackData = createArray(e, index--);
			for (int j = 0; j < temp.length; j++){
				this.stackData[j] = temp[j];
			}
		} catch(NullPointerException ex){
			index = 1;
			this.stackData = createArray(e, index--);
		}
		
		this.stackData[index] = e;
	}
	public void push(E[] e){
		E[] temp = this.stackData;
		int index, start;
		try{
			index = temp.length + e.length;
			start = temp.length;
			this.stackData = createArray(e, index);
			for (int j = 0; j < temp.length; j++){
				this.stackData[j] = temp[j];
			}
		} catch(NullPointerException ex){
			index = e.length;
			start = 0;
			this.stackData = createArray(e, index);
		}
		
		for(int j = start; j < index; j++){
			this.stackData[j] = e[j-start];
		}
	}
}