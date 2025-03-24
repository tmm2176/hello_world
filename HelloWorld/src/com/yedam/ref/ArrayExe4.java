package com.yedam.ref;

public class ArrayExe4 {
	public static void main(String[] args) {
		 int[] intAry = { 8, 7, 6, 5, 4 , 3, 1, 2};
		 int temp = 0;
		 
		 for (int i = 0; i< intAry.length; i++) {
			 System.out.print(intAry[i] + " ");			 
		 }
		 System.out.println("\n\n");
		 for(int i = 0; i < intAry.length - 1; i++) {
			 for(int j = 0; j < intAry.length - 1; j++){
				 if(intAry[j] > intAry[j+1]) {
					 temp = intAry[j];
					 intAry[j] = intAry[j + 1];
					 intAry[j + 1] = temp;				 
				 }				 
			 }
		 }
		 for (int i = 0; i< intAry.length; i++) {
			 System.out.print(intAry[i] + " ");			 
		 }
	}
}