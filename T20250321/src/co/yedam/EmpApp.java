package co.yedam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	static EmpDAO dao = new EmpDAO(); //
	static Scanner scn = new Scanner(System.in); // scn 처리
	
	public static void addF() {		
		String empNum = "";
		String empName = "";
		String empPNum= "";
		String empHD = "";
		int empSal = 0;
		
		System.out.print("사번입력>>");
		empNum = scn.nextLine();
		System.out.print("이름입력>> ");
		empName = scn.nextLine();
		System.out.print("전화번호입력>> ");
		empPNum = scn.nextLine();
		System.out.print("입사일입력>>");
		empHD = scn.nextLine();
		System.out.print("급여입력>>");
		empSal = Integer.parseInt(scn.nextLine());
		
		Employee empInfo = new Employee(empNum, empName, empPNum, empHD, empSal);
		
		if(dao.addFunc(empInfo)) {
			System.out.println("등록성공\n");
		}else {
			System.out.println("등록실패\n");
		}
	} // end of addF()
	
	public static void listF() {		
		List<Employee> list = new ArrayList<Employee>();
		list = dao.listFunc();
		System.out.println("사번   이름   전화번호");
		for(Employee emp : list) {
			System.out.println(emp.getEmpNo() + " " + emp.getEmpName() + " " + emp.getEmpPhone());
		}
		System.out.println(); //한 줄 띄우기
	} // end of listF()
	
	public static void editF() {	
		System.out.print("사번 급여>>");
		String empNo = scn.nextLine();
		int empSal = Integer.parseInt(scn.nextLine());
		
		Employee emp = new Employee();
		emp.setEmpNo(empNo);
		emp.setEmpSalary(empSal);
		
		if(dao.editFunc(emp)) {
			System.out.println("수정성공\n");
		}else {
			System.out.println("수정실패\n");
		}
	} // end of editF()
	
	public static void deleteF() {		
		System.out.print("사번>> ");
		String eNo = scn.nextLine();
		Employee emp = new Employee();
		emp.setEmpNo(eNo);
		
		if (dao.deletdFunc(emp)) {
			System.out.println("삭제성공\n");
		}else {
			System.out.println("삭제실패\n");
		}
	} // end of deleteF()
	
	public static List<Employee> searchList(String keyword) {
		return dao.searchFunc(keyword);
	} // end of searchList(String keyword)
	public static void searchF() {		
		String hireDate = "";
        
		System.out.print("입사일자>> ");
		hireDate = scn.nextLine();
		List<Employee> list = searchList(hireDate);
		
		System.out.println("사번   이름   입사일자");
		for(Employee emp : list) {
			System.out.println(emp.getEmpNo() + " " + emp.getEmpName() + " " + emp.getEmpHireDate());
		}
	} // end of searchF()

	
	public static void main(String[] args) {
		//앱을 실행하는 클래스
		
    	boolean run = true;
    	int menu = 0;
    	//System.out.println("분기 체크");

		while(run) {
			System.out.println("1. 등록 2. 목록 3. 수정(급여) 4. 삭제 5.조회(조건:입사일자) 6. 종료");
			System.out.print("선택 >> ");
			
			//예외처리
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}
				catch (NumberFormatException e) {
					System.out.println("menu에 맞는 숫자를 입력해주세요\n");
					System.out.print("선택 >> ");
				}				
			}
			
			switch(menu) {
			case 1: // 1. 등록
				addF();
				break; // case 1 종료	
			case 2: // 2. 목록
				listF();
				break; // case 2 종료		
			case 3: // 3. 수정(급여)
				editF(); 
				break; // case 3 종료
			case 4: // 4. 삭제
				deleteF();
				break; // case 4 종료.
			case 5: // 5. 조회(입사일자)
				searchF();
				break; // case 5 종료.
			case 6: // 6. 종료
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요\n");
			}
		} 
	    System.out.println("end of prog");
	} // end of main()
}
