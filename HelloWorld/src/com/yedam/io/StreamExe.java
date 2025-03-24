package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {
	public static void main(String[] args) {
		// 입력 + 출력 스트림 활용하여 복사 구현
		try {
			InputStream is = new FileInputStream("C:/temp/image.jpg");
			OutputStream os = new FileOutputStream("C:/temp/image3.jpg");
			
			byte[] buf = new byte[100];
			while(true) {
				int data = is.read(buf); // 한 바이트씩 작업하는 과정 -> 오래걸림 -> buf 배열을 이용
				if(data == -1) { // if end of file
					break;
				} // end of if
				os.write(buf);
				os.flush();
			} // end of while
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	} // end of main()
	
	static void write() {
		// 출력스트림 (바이트)
		try {
			OutputStream os = new FileOutputStream("C:/temp/data.bin");
			os.write(10);
			os.write(20);
			os.write(30);
			os.flush();
			os.close();
		} catch (IOException e) {
			// FileNotFoundException e의 상위 예외임
			e.printStackTrace();
		}
		System.out.println("end of prog");
	} // end of write
	
	static void read() {
		// 입력스트림(바이트)
		try {
			InputStream is = new FileInputStream("c:/temp/data.bin");
			while(true) {
				int data = is.read();
				if(data == -1) { // if end of file
					break;
				} // end of if
				System.out.println(data);
			} // end of while
			is.close(); // 읽기 작업이 끝나면 파일 닫기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of prog");
	} // end of read()
}