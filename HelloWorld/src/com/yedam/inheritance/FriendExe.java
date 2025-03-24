
package com.yedam.inheritance;

import java.util.Iterator;

/*
 * 상속
 * 친구1 : 이름, 연락처
 * 친구2 : 이름, 연락처, 학교, 학과
 * 친구3 : 이름, 연락처, 회사, 부서	
 */
public class FriendExe {
	public static void main(String[] args) {
		Friend[] friends = new Friend[10];
		
		//instance
		Friend f1 = new Friend();
		f1.setName("홍길동");
		f1.setTel("010-1111-2222");
//		System.out.println(f1.toString());
		
		//Friend f2 = new UnivFriend();
		// 타입이 달라도 상속 관계라서 할당 가능
        UnivFriend f2 = new UnivFriend();
		f2.setName("김자식");
		f2.setTel("010-1111-1111");
		f2.setUnivName("우리학교");
		f2.setMajor("역사학과");
//		System.out.println(f2.toString());
		
		CompanyFriend f3 = new CompanyFriend("김영식", "010-2323-2323", "아마존", "개발팀");
//		System.out.println(f3.toString());
		// 부모 클래스의 변수에 자식인스턴스 대입 가능
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		
		// Friend[] => toString()
		for(int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
		/* 형변환
		int num = 20;
		double num2 = num; // 자동형변환 promotion
		num = (int) num2; // 강제형변환. casting
		*/
		
      	Friend f4 = new CompanyFriend("김무열", "010-1111-1111", "자회사", "인사팀");
		CompanyFriend cf = (CompanyFriend) f4; //부모 클래스 인스턴스를 자식 클래스 인스턴스에 대입
		
		// cf = new Friend("박성길", "010-1111-2222"); //형변환 예외 발생
		// 무턱대고 대입하지 말고 조건문을 통해 형변환 조건 확인 후 대입
		Friend f5 = new Friend("박성길", "010-1111-2222");
		if(f5 instanceof CompanyFriend) {
			cf = (CompanyFriend) f5;
			System.out.println(cf.getCompany());
		} else {
			System.out.println("Casting 할 수 없습니다");
		}
		
		System.out.println(cf.getCompany());
		
	} // end of main()
}
