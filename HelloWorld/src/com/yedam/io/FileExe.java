package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExe {
	public static void main(String[] args) {
		File file = new File("C:/temp/new.txt"); //파일을 만드는 것이 아닌 파일의 정보를 만드는 것임
		File file1 = new File("C:/temp/images/img1/new");
		try {
			if(!file.exists()){ // 파일의 존재를 확인해주는 메소드
			    file.createNewFile(); // 파일 생성
			    System.out.println("파일생성 성공");
			}
			if (!file1.exists()) {
				// file1.mkdir(); 폴더 생성 (단일 폴더만 생성)
				file1.mkdirs(); // 폴더 생성 (경로상의 없는 폴더까지 전부 만들어 줌)
				System.out.println("폴더생성 성공");
			}
			FileWriter fw = new FileWriter(file);
			//파일 객체를 생성자 매개값으로 바로 전달 가능(입출력스트림의 매개값)
			fw.write("Hello\n");
			fw.write("World\n");
			fw.flush();fw.close(); 
			if(file.exists()) {
				file.delete();
				System.out.println("deleted");
			}
		} catch (IOException e) {
		    e.printStackTrace();
		} // 파일 생성 과정
		
		System.out.println("end of prog");
	} // end of main()
} // end of FileExe
