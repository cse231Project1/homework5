package edu.oakland.helper;

public class ArrayGen{
	private int[] array;

	public void ArrayGen(int size){
		this.array = generateArray(size);
	}
	private int[] generateArray(int size){
		int[] newArray =  new int[size];
		int max = 20000;
		for (int i = 0; i < size; i++){
			newArray[i] = (int)(max*Math.random() + 20);
		}
		return newArray;
	}
	public void setArray(int size){
		this.array = generateArray(size);
	}
	public int[] getArray(){
		return this.array;
	}
}