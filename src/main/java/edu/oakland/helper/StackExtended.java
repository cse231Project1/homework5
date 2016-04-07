package edu.oakland.helper;

import java.util.*;

/**
*	StackExtended is a wrapper class meant to extend and provide pushing or array 
*	values to the stack as opposed to inidividual elements.
*
*	@author Chase Hulderman
*	@version version 1.0 - 160407
*	@since version 1.0
*/

public class StackExtended<E> extends Stack<E> {
	public StackExtended(){
		super();
	}
	/**
	*	Constructor allows passing an element or element array
	*	to initialize the stack without calling a successive push().
	*
	*	@param	e	some element.
	*/
	public StackExtended(E e){
		this.push(e);
	}
	/**
	*	Overloaded constructor for element arrays.
	*
	*	@param	e	some element array.
	*/
	public StackExtended(E[] e){
		this.push(e);
	}

	/**
	*	Pushes many elements onto the stack.
	*
	*	@param e an object array to push on the stack.
	*/
	public void push(E[] e){
		for (E i: e){
			this.push(i);
		}
	}
}