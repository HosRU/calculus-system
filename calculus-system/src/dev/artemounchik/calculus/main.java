package dev.artemounchik.calculus;

import java.lang.management.OperatingSystemMXBean;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
		System.out.println("Результат проверки: " + resultCheckString);
		
		int resultTranslition = translition(resultCheckString, sourceSystem);
		System.out.println("Результат 1: " + resultTranslition);
		
		int resultTranslitionReverse = translitionReverse(resultCheckString, sourceSystem, desiredSystem);
		System.out.println("Результат 2: " + resultTranslitionReverse);
	}
	
	private static int translition(String sourceNumber, int sourceSystem) {
		List<Integer> arrayNumbersInteger = new ArrayList<Integer>(16);
		int result = 0;
		
		for(int count = 0, size = sourceNumber.length() - 1; count < sourceNumber.length(); count++, size--) {
			String charString = String.valueOf(sourceNumber.charAt(count));
			int number = 0;
			
			switch (charString) {
				case "A": {
					number = 10;
					break;
				}
				case "B": {
					number = 11;
					break;
				}
				case "C": {
					number = 12;
					break;
				}
				case "D": {
					number = 13;
					break;
				}
				case "E": {
					number = 14;
					break;
				}
				case "F": {
					number = 15;
					break;
				}
				default: {
					number = Integer.parseInt(charString);
				}
			}
			
			arrayNumbersInteger.add(number);
			result += arrayNumbersInteger.get(count) * Math.pow(sourceSystem, size);
			System.out.println("Результатик: " + arrayNumbersInteger.get(count) * Math.pow(sourceSystem, size));
		}
		
		return result;
	}
	
	private static int translitionReverse(String sourceNumber, int sourceSystem, int desiredSystem) {
		List<Integer> arrayNumberList = new ArrayList<>();
		int resultTranslition = translition(sourceNumber, sourceSystem);
		
		String resultString = "";
		int result = 0;
		do {
			result = resultTranslition % desiredSystem;
			resultTranslition = resultTranslition / desiredSystem;
			arrayNumberList.add(result);
			
		} while (resultTranslition > 0);		
		
		Collections.reverse(arrayNumberList);
		for(int itemList : arrayNumberList) {
			resultString += itemList;
		}
		
		return Integer.parseInt(resultString);
	}
	
	private static String check(String sourceNumber, int system) {
		String correctString = sourceNumber.trim().toUpperCase();
		String validRangeString = "0123456789ABCDEF";
		
		for(int count = 0; count < correctString.length(); count++) {
			char charElementString = correctString.charAt(count);
			if(!validRangeString.contains(String.valueOf(charElementString))){
				System.err.println("Некорректный ввод данных");	
				return "";
			}
		}
		
		return correctString;
	}
}
