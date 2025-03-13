package com.yedam.classes;

public class MethodExe3 {	
	// 구구단 출력 함수
    String gugudan(int num, int toNum){
	    String result = "";
    	int temp = 0;
		if(num > toNum) {
			temp = num;
			num = toNum;
			toNum = temp;
		}
		for (int i = num; i <= toNum; i++) {
			for(int j = 1; j <= 9 ; j++) {
				result = result + (i + " * " + j + " = " + i * j + "\n");
			} // end of for
			result = result + "\n";
		} //end of for
		return result;
	} // end of gugudan(int num, int toNum)
    
    void printStar(int cnt, String str) {
    	for(int i = 0; i < cnt ; i++) {
    		for(int j = 0; j <= i; j++) {
    			System.out.print(str);
    		} // end of for
    		System.out.println();
    	} // end of for
    } // end of printStar()
    
    void printCard() {
    	int[] intAry = new int[16];
    	int createNum = 0;
    	// 1 ~ 16까지의 임의 수 할당
    	for (int i = 0; i < intAry.length; i++) {
    		createNum = (int) (Math.random() * 16) + 1;
    		for(int j = 0; j < intAry.length; j++) {
    			if(createNum == intAry[j]) {
    				createNum = (int)(Math.random() * 16) + 1;
    				j--;
    		    } // end of if
    		} // end of for
    		intAry[i] = createNum;    				
    	} // end of for
    	// print
    	for (int i = 0; i < intAry.length; i++) {
    		System.out.printf("%3d", intAry[i]);
    		if(i % 4 == 3) {
    			System.out.println();
    		}
    	}
    } // end of printCart()
}
