package com.yedam.classes;

public class MethodExe3 {	
	// 구구단 출력 메소드
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
    
    // 별 출력 메소드
    void printStar(int cnt, String str) {
    	for(int i = 0; i < cnt ; i++) {
    		for(int j = 0; j <= i; j++) {
    			System.out.print(str);
    		} // end of for
    		System.out.println();
    	} // end of for
    } // end of printStar()
    
    // 난수 카드 출력 메소드
    void printCard() {
    	int[] intAry = new int[16];
    	
    	for (int i = 0; i < intAry.length; i++) {
    		// 1 ~ 16까지의 임의 수 생성
    		intAry[i] = (int) (Math.random() * 16) + 1;
    		int j = 0;
    		while(j < i) {
    			if(intAry[j] != intAry[i]) {
    				j++;
    			}
    			else if(intAry[j] == intAry[i]) {
//    				System.out.println("자리 : " + (i + 1));
//    				System.out.println("j : " + intAry[j] + " / 처음 i : " + intAry[i]);
    				intAry[i] = (int)(Math.random() * 16) + 1;		
//    				System.out.println("변경 i : " + intAry[i] + "\n");
    				j = 0;
    				// j값을 초기화 해줘야 다시 처음부터 탐색
    			} // end of if
    		} // end of while    				
    	} // end of for
    	
    	
    	
    	// print
    	for (int i = 0; i < intAry.length; i++) {
    		System.out.printf("%5d", intAry[i]);
    		if(i % 4 == 3) {
    			System.out.println();
    		}
    	}
    } // end of printCart()
}
