package dev.artemounchik.calculus;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		int sourceNumber = 56327;
		
		translition(sourceNumber, 9);
	}
	
	private static void translition(int sourceNumber, int system) {
		List<Integer> arrayNumbersInteger = new ArrayList<Integer>(16);
		List<Integer> resultArrayNumbersIntegers = new Arraylist<Integer>();
		
		String stockViewString = String.valueOf(sourceNumber);
		System.out.println("Исходное значение: "+ stockViewString);
		
		for(int count = 0; count < stockViewString.length(); count++) {
			String charString = String.valueOf(stockViewString.charAt(count));
			int number = Integer.parseInt(charString);
			arrayNumbersInteger.add(number);
			
			for(int internalCounter = 0; internalCounter < arrayNumbersInteger.length(); internalCounter++) {
				
			}
		}

		for(int number : arrayNumbersInteger) {
			System.out.println("Число: " + number);
		}
	}
}
