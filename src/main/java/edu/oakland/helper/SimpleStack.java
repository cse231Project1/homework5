package edu.oakland.helper;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SimpleStack<E> {
	
	private int stackIncrement;
	private int stackCount;
	private E[] stackData;

	public SimpleStack(){
		this.stackCount = 0;
		this.stackIncrement = 0;
	}
	public SimpleStack(E e){
		this.stackCount = 0;
		this.push(e);
		this.stackIncrement = 0;
	}
	public SimpleStack(E[] e){
		this.stackCount = 0;
		this.push(e);
		this.stackIncrement = 0;
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
			if(this.stackCount <= 0){
				return true;
			} else {
				return false;
			}
		} catch(NullPointerException e){
			return true;
		}
	}
	public E pop(){
		try{
			E e = this.stackData[this.stackCount-1];
			this.stackData[this.stackCount-1] = null;
			this.stackCount--;
			return e;
		} catch (NullPointerException ex){
			return null;
		}
	}
	public E peek()
	{
		try {
			return this.stackData[this.stackCount-1];
		}
		catch(NullPointerException ex){
			return null;
		}
	}
	public int searchByValue(Object q){
		int index;

		try{
			index = this.stackCount;
		} catch(NullPointerException ex){
			return -1;
		}

		for(int j = 0; j < index; j++){
			if(q.equals(this.stackData[j])){
				return j;
			}
		}
		return -1;
	}
	public SimpleStack<Integer> searchAllByValue(Object q){
		SimpleStack<Integer> locations = new SimpleStack<Integer>();
		int index;
		
		try{
			index = this.stackCount;
		} catch(NullPointerException ex){
			return null;
		}

		for(int j = 0; j < index; j++){
			if(q.equals(this.stackData[j])){
				locations.push(j);
			}
		}
		return locations;
	}
	public int search(Object q){
		int index;

		try{
			index = this.stackCount;
		} catch(NullPointerException ex){
			return -1;
		}

		for(int j = 0; j < index; j++){
			if(q == this.stackData[j]){
				return j;
			}
		}
		return -1;
	}
	public SimpleStack<Integer> searchAll(Object q){
		SimpleStack<Integer> locations = new SimpleStack<Integer>();
		int index;
		
		try{
			index = this.stackCount;
		} catch(NullPointerException ex){
			return null;
		}

		for(int j = 0; j < index; j++){
			if(q == this.stackData[j]){
				locations.push(j);
			}
		}
		return locations;
	}
	public void push(E e){
		E[] temp;
		int index;
		int increment;

		try {
			index = this.stackData.length;
		} catch(NullPointerException ex){
			index = 10;
			this.stackData = createArray(e, index);
		}

		if(this.stackIncrement <=0){
			increment = this.stackCount;
		}else{
			increment = this.stackIncrement;
		}

		if(this.stackCount >= index){
			temp = this.stackData;
			this.stackData = createArray(e, this.stackCount+increment);
			for (int j = 0; j < temp.length; j++){
				this.stackData[j] = temp[j];
			}
		}
		this.stackData[this.stackCount] = e;
		this.stackCount++;
	}
	public void push(E[] e){
		E[] temp;
		int index, newLast, last, increment;
		
		try{
			index = this.stackData.length;
			newLast = this.stackCount + e.length;
			last = this.stackCount;
		} catch(NullPointerException ex){
			index = e.length*2;
			newLast = e.length;
			last = 0;
			this.stackData = createArray(e, index);
		}

		if(this.stackIncrement <=0){
			increment = newLast;
		}else{
			increment = this.stackIncrement;
		}
		
		if(newLast >= index){
			temp = this.stackData;
			this.stackData = createArray(e, newLast+increment);
			for (int j = 0; j < temp.length; j++){
				this.stackData[j] = temp[j];
			}
		}

		for(int j = last; j < newLast; j++){
			this.stackData[j] = e[j-last];
		}
		this.stackCount+=e.length;
	}
	public void clear(){
		this.stackData = createArray(this.stackData[0],this.stackIncrement);
	}
}