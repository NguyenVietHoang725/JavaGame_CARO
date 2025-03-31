package com.caro.utils;

import java.util.Scanner;

public class InputHandler {
	private Scanner scn = new Scanner(System.in);

	public int[] getInput() {
		int row = scn.nextInt();
		int col = scn.nextInt();
		
		return new int[] {row - 1, col - 1};
		
	}

	public void close() {
		scn.close();
	}
}
