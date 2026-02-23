package dev.artemounchik.calculus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class main {

	public static void main(String[] args) {
		int sourceNumber = 26545;
		
		int resultTranslition = translition(sourceNumber, 8);
		System.out.println("Результат перевода в 10ю систему счисления: " + resultTranslition);
		
		translitionReverse(resultTranslition, 9);
	}
	
	private static int translition(int sourceNumber, int system) {
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
		
		return result;
	}
	
	private static int translitionReverse(int sourceNumber, int system) {
		List<Integer> arrayNumbersInteger = new ArrayList<Integer>(16);
		String resultString = "";
		int result = 0;
		do {
			
			result = sourceNumber % 8;
			sourceNumber = sourceNumber / 8;
			resultString += result;
			arrayNumbersInteger.add(result);
		} while (sourceNumber > 0);
		
		System.out.println("Результат перевода из 10ю систему исчисления: " + resultString);
		return result;
	}
}
