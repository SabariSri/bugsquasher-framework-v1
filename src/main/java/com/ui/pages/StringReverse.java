package com.ui.pages;

public class StringReverse {

	public static void main(String[] args) {
		String input = "Welcome to IQVIA";
		System.out.println(reverseString(input));
	}

	private static String reverseString(String input) {
		char[] inpStr = input.toCharArray();
		String output = "";
		for (int i = inpStr.length - 1; i >= 0; i--) {
			output = output + inpStr[i];
		}
		return output;	
	}

}
