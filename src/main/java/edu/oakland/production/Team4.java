package edu.oakland.production;

import edu.oakland.helper.*;
import java.util.concurrent.TimeUnit;

public class Team4 {
	private StackExtended<Integer> stack;
	private IntStack stackInt;
	private SimpleStack<Integer> stackObj;

	private int[] values;
	private long time;
	
	public Team4(){
		this.stack = new StackExtended<Integer>();
		values = new int[2];
	}
	public Team4(int[] array){
		this.stack = new StackExtended<Integer>();
		this.stack.push(convertArray(array));
		values = new int[2];
	}
	private void evaluate(){
		long startTime, endTime, diff;
		startTime = System.nanoTime();
		this.values = findOdds(this.stack);
		endTime = System.nanoTime();
		diff = endTime - startTime;
		this.time = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
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
	public int[] findOdds(StackExtended<Integer> stack){
		int count = 0;
		int value;
		int[] odds = new int[] {-1, -1};
		boolean condition;

		while(!stack.empty() && count < 2) {
			value = stack.pop().intValue();
			condition = (value % 2 == 1) && (value > 600) && (value < 6000);
			if(condition){
				odds[count] = value;
				count++;
			}
		}
		return odds;
	}
	public int[] getValues(){
		return this.values;
	}
	public long getTime(){
		return this.time;
	}

	public static void main(String[] args) {
		ArrayGen arrayGen = new ArrayGen();
		int[] sizes = new int[] {20, 2000, 20000, 2000000};
		Team4 manager;

		for(int i: sizes){
			System.out.println("Testing array of size " +i);
			arrayGen.setArray(i);
			manager = new Team4(arrayGen.getArray());
			manager.evaluate();
			for(int j: manager.getValues()){
				System.out.println("Odds: " + j + ", ");
			}
			System.out.printf("Found Odds in %dms\n", manager.getTime());
		}
	}	
}