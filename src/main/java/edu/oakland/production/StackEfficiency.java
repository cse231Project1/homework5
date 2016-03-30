package edu.oakland.production;

import edu.oakland.helper.*;

public class StackEfficiency {
	private IntStack stackInt;
	private SimpleStack<Integer> stackObj;
	private int[] array;
	
	public StackEfficiency(){
		stackInt = new IntStack();
		stackObj = new SimpleStack<Integer>();
	}

	private int[] generateArray(int size){
		int[] newArray =  new int[size];
		for (int i = 0; i < size; i++){
			newArray[i] = (int)(size*Math.random() + 20);
		}
		return newArray;
	}
	public void createArray(int size){
		this.array = generateArray(size);
		stackInt.push(this.array);
		//stackObj.push(this.array);
	}
	public int[] findOdds(){
		int count = 0;
		int value;
		int[] odds = new int[2];

		while(!stackObj.empty()) {
			value = stackObj.pop().intValue();
			if((value % 2 == 1)){
				if(count == 2){
					break;
				}
				switch(count){
					case 0:
						odds[0] = value;
					case 1: 
						odds[1] = value;
					default:
						;
				}
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
			if((value % 2 == 1)){
				if(count == 2){
					break;
				}
				switch(count){
					case 0:
						odds[0] = value;
					case 1: 
						odds[1] = value;
					default:
						;
				}
				count++;
			}
		}
		return odds;
	}

	public static void main(String[] args) {
		int[] sizes = new int[] {20, 2000, 20000, 20000000};
		StackEfficiency manager = new StackEfficiency();
		long startTime, endTime;

		for(int i: sizes){
			manager.createArray(i);
			startTime = System.currentTimeMillis();
			for(int j: manager.findIntOdds()){
				System.out.println("Odds: " + j + ", ");
			}
			endTime = System.currentTimeMillis();
			System.out.printf("Found Odds in %d\n", (endTime-startTime));
			// startTime = System.currentTimeMillis();
			// manager.findOdds();
			// endTime = System.currentTimeMillis();
			// System.out.printf("Found Odds in %d\n", (endTime-startTime));
		}
	}	
}