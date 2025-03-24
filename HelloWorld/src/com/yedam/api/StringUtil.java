package com.yedam.api;

public class StringUtil {
	// 1. 성별
	static String getGender(String ssn) {
		char genNum = ' ';
		if (ssn.length() == 13) {
		// 주민번호 앞뒷자리 구분없이 적은 경우
			genNum = ssn.charAt(6);
			if(genNum == '1' || genNum == '3') {
				return "남";				
			}
			else if(genNum == '2' || genNum == '4') {
				return "여";
			} //end of if
		}else if (ssn.length() == 14) {
		// 공백 또는 - 등으로 주민번호 앞뒷자리를 구분한 경우
			genNum = ssn.charAt(7);
			if(genNum == '1' || genNum == '3') {
				return "남";				
			}
			else if(genNum == '2' || genNum == '4') {
				return "여";				
			} // end of if
		} //end of if
		return "정확한 주민번호를 입력해주세요"; // "남" or "여" 반환
	} // end of getGender()
	
	// 2. 파일명
	static String getFileName(String file) {
		int nameStart = 0;
		int nameEnd = 0;
		if(file.indexOf(".") != -1) {
			nameEnd = file.indexOf(".");
		} else if(file.indexOf(".") == -1){
			return "알 수 없음 ( 확장자 확인 불가 )";
		} // end of if
		// 뒤에서 for문 사용했는데 lastIndexOf라는 함수가 따로 있었음 ㅇㅅㅇ
		for (int i = nameEnd; i >= 0; i--) {
			if(file.indexOf("/") == -1 && file.indexOf(":") == -1){
				// 경로를 표시하기위한 : 또는 /가 없는 경우
				return file.substring(0, nameEnd);
			}else if(file.charAt(i) == '/') {
				nameStart = i + 1;
				break;
			} // end of if
	    } //end of for
		return file.substring(nameStart, nameEnd);
	} // end of getFileName()
	
	//3. 파일확장자
	static String getExtName(String file) {
		int pointIndex = 0;
		for (int i = 0; i < file.length(); i++) {
			if(file.indexOf(".") != -1) {
				pointIndex = file.indexOf(".");
			} else if(file.indexOf(".") == -1){
				return "알 수 없음 ( 확장자 확인 불가 )";
			} // end of if
		} // end of for
		
		return file.substring(pointIndex + 1);
	} // end of getExtName
}