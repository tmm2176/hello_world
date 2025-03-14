package com.yedam;

public class HelloExe {
	private String pName;
	private String pNum;
	private int pAge;
	HelloExe() {}
	HelloExe(String name, String num, int age){
		this.pName = name;
		this.pNum = num;
		this.pAge = age;
	}
    public String getpName() {
		return pName;
	}
	public String getpNum() {
		return pNum;
	}
	public int getpAge() {
		return pAge;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	public void setpAge(int pAge) {
		this.pAge = pAge;
	}
	// 기능 (함수) => main 메소드.
	public static void main(String[] args) {
    	// 1. 32000 변수 선언과 값 할당
		int num1 = 32000;
		System.out.println("1번 답");
		System.out.println(num1 + "\n");
		
		// 2. 배열 선언 후 34, 32, 88, 23 담기
		int [] numAry = {34, 32, 88, 23};
		System.out.println("2번 답");
		for(int i = 0; i < numAry.length; i++) {
			System.out.print(numAry[i] + " ");			
		}
		System.out.println("\n");
		
		// 3. 문자 선언 후 32 담기
		String str1 = "32";
		System.out.println("3번 답");
		System.out.println(str1 + " << String type\n");
		
		// 4. 3에 저장한 값을 정수 변수에 저장
		int num2 = Integer.parseInt(str1);
		System.out.println("4번 답");
		System.out.println(num2 + " << int type\n");
		
		// 5. 문자 배열 선언 후 Hello, Nice, Good 저장
		System.out.println("5번 답");
		String[] strAry = {"Hello", "Nice", "Good"};
		for(int i = 0; i < strAry.length; i++) {
			System.out.print(strAry[i] + " ");			
		}
		System.out.println("\n");
		
		// 6.  정수 5개 저장할 수 있는 변수를 선언
		// Math.random()을 사용하여 60 ~ 100 사이의 값을 저장
		System.out.println("6번 답");
		int[] randNumAry = new int [5];
		int maxNum = 0;
		int minNum = 101;
		for(int i = 0; i < randNumAry.length; i++) {
			randNumAry[i] = (int)(Math.random() * 41 + 60);
			System.out.print(randNumAry[i] + " ");
			
			//최소최대값 확인
			if(randNumAry[i] > maxNum) {
				maxNum = randNumAry[i];
			}
			if(randNumAry[i] < minNum) {
				minNum = randNumAry[i];
			}
		}
		System.out.println("\n최솟값 : " + minNum + " 최댓값 : " + maxNum + "\n");
		
		// 7. 이름, 연락처, 나이 선언
		System.out.println("7번 답");
		String nameInfo = "홍길동";
		String numInfo = "010-1234-1234";
		int ageInfo = 20;
		System.out.println("이름 : " + nameInfo +" | 번호 : " + numInfo +
				" | 나이 : " + ageInfo +  "\n");
    	// 8. 7 값을 3개 넣을 배열 생성
		// 홍길동, 010-1234-1234, 20
		// 김민식, 010-2222-2222, 22
		// 최문식, 010-3333-3333, 23
		System.out.println("8번 답");
		HelloExe[] infoAry = new HelloExe[3];
		infoAry[0] = new HelloExe(nameInfo, numInfo, ageInfo);
		infoAry[1] = new HelloExe("김민식", "010-2222-2222", 22);
		infoAry[2] = new HelloExe("최문식", "010-3333-3333", 23);
		for(int i = 0; i < infoAry.length; i++) {
			System.out.println("이름 : " + infoAry[i].getpName() +
					" | 번호 : " + infoAry[i].getpNum() +
					" | 나이 : " + infoAry[i].getpAge());
		}
		System.out.println("");
		
		// 9. 나이가 젤 많은 사람의 이름을 출력
		System.out.println("9번 답");
		String oldestName = "";
		int oldestAge = 0;
		for(int i = 0; i < infoAry.length ; i++) {
			if(infoAry[i].getpAge() > oldestAge) {
				oldestAge = infoAry[i].getpAge();
				oldestName = infoAry[i].getpName();
			}
		}
		System.out.println("최고령자는 " + oldestName + ", " + oldestAge +"세 입니다");
    } // end of main()
	
	void helloWorld() {
		System.out.println("Hello, World");
		// System.out.println =>. 콘솔에 출력
		
		String name;
		name = "김민수";
		
		System.out.println("이름은 " + name);
		// 문자열 사이의 + 연산자 => 두 문자열을 합치는 기능
		
		int score = 100;
		System.out.println("점수는 " + score + "점 입니다");
		// 두 개의 타입이 같도록 변환시켜 주기 때문에 int타입의 변수도 문자열 타입으로 변환시키게 된다.
		// 즉 +도 문자열을 합치는 기능으로 사용된다.
		System.out.println("수정된 부분");		
	}
}
