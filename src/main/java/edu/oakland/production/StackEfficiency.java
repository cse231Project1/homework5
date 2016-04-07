package edu.oakland.production;

import edu.oakland.helper.*;

public class StackEfficiency {
	private IntStack stackInt;
	private SimpleStack<Integer> stackObj;
	private int[] array;
	private int time;
	
	public StackEfficiency(){
		stackInt = new IntStack();
		stackObj = new SimpleStack<Integer>();
	}

	private int[] generateArray(int size){
		int[] newArray =  new int[size];
		int max = 20000;
		for (int i = 0; i < size; i++){
			newArray[i] = (int)(max*Math.random() + 20);
		}
		return newArray;
	}
	private Integer[] convertArray(int[] intArray){
		Integer[] convertedArray = new Integer[intArray.length];
		int j = 0;
		for(int i: intArray){
			convertedArray[j] = intArray[j];
			j++;
		}
		return convertedArray;
	}
	public void createArray(int size){
		this.array = generateArray(size);
		stackInt.push(this.array);
		stackObj.push(convertArray(this.array));
	}
	public int[] findOdds(){
		int count = 0;
		int value;
		int[] odds = new int[2];

		while(!stackObj.empty()) {
			value = stackObj.pop().intValue();

			if((value % 2 == 1) && (value > 600) && (value < 6000)){
				if(count == 2){
					break;
				}
				odds[count] = value;
				count++;
			}
		}
		return odds;
	}
	public int[] findIntOdds(){
		int count = 0;
		int value;
		int[] odds = new int[2];
		
		while(!stackInt.empty()) {
			value = stackInt.pop();
			if((value % 2 == 1) && (value > 600) && (value < 6000)){
				if(count == 2){
					break;
				}
				odds[count] = value;
				count++;
			}
		}
		return odds;
	}

	public static void main(String[] args) {
		int[] sizes = new int[] {20, 2000, 20000, 2000000};
		StackEfficiency manager = new StackEfficiency();
		long startTime, endTime;

		for(int i: sizes){
			System.out.println("Testing array of size " +i);
			manager.createArray(i);
			startTime = System.nanoTime();
			for(int j: manager.findIntOdds()){
				System.out.println("Odds: " + j + ", ");
			}
			endTime = System.nanoTime();
			System.out.printf("Found Odds in %dns\n", (endTime-startTime));
			startTime = System.nanoTime();
			for(int j: manager.findOdds()){
				System.out.println("Odds: " + j + ", ");
			}
			endTime = System.nanoTime();
			System.out.printf("Found Integer Odds in %dns\n", (endTime-startTime));
		}
	}	
}