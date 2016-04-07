package edu.oakland.helper;

import java.util.*;

public class StackExtended<E> extends Stack<E> {
	public StackExtended(){
		;
	}
	public StackExtended(E e){
		this.push(e);
	}
	public StackExtended(E[] e){
		this.push(e);
	}
	public void push(E[] e){
		for (E i: e){
			this.push(i);
		}
	}
}