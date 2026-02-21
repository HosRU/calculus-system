package dev.artemounchik.calculus;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		int sourceNumber = 26545;
		
		translition(sourceNumber, 8);
	}
	
	private static void translition(int sourceNumber, int system) {
		List<Integer> arrayNumbersInteger = new ArrayList<Integer>(16);
		String stockViewString = String.valueOf(sourceNumber);
		
		System.out.println("Исходное значение: "+ stockViewString);
		int result = 0;
		
		for(int count = 0, size = stockViewString.length() - 1; count < stockViewString.length(); count++, size--) {
			String charString = String.valueOf(stockViewString.charAt(count));
			int number = Integer.parseInt(charString);
			arrayNumbersInteger.add(number);
			
			result += arrayNumbersInteger.get(count) * Math.pow(system, size);
		}
		
		System.out.println("Результат перевода числа: " + sourceNumber + " в 10 систему исчисления = " + result);
	}
}
