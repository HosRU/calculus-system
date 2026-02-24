package dev.artemounchik.calculus;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Введите исходное число: ");
		String sourceNumber = scanner.nextLine();
		
		System.out.println("Введите исходную систему счисления: ");
		int sourceSystem = scanner.nextInt();
		
		System.out.println("Введите конечную систему счисления: ");
		int desiredSystem = scanner.nextInt();
		
		String resultCheckString = check(sourceNumber, sourceSystem);
		System.out.println(resultCheckString);

		//		int resultTranslition = translition(sourceNumber, 8);
//		System.out.println("Результат перевода в 10ю систему счисления: " + resultTranslition);
		
//		translitionReverse(resultTranslition, 9);
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
	
	private static String check(String sourceNumber, int system) {
		String correctString = sourceNumber.trim().toUpperCase();
		String validRangeString = "0123456789ABCDEF";
		
		for(int count = 0; count < sourceNumber.length(); count++) {
			char charElementString = sourceNumber.charAt(count);
			if(!validRangeString.contains(String.valueOf(charElementString))){
				System.err.println("Некорректный ввод данных");	
				return "";
			}
		}
		
		return correctString;
	}
}
