package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CharacterExe {
	public static void main(String[] args) {
		Scanner scn = null;
		try {
			scn = new Scanner(new FileInputStream("C:/temp/message.txt"));
			while(true) {
				String msg = scn.nextLine();
				String[] msgAry = msg.split(" "); // 공백을 기준으로 문자열 나누기, split의 반환값은 String[]
//				if(msg == null || msg.equals("")) { // 더 읽을 값이 없으면 반복문을 종료
//					break; //하려고 했으나 아래 2번째 예외처리를 추가하면 필요없어짐
//				} 
				System.out.println("코드 : " + msgAry[0]
						+ ", 이름 : " + msgAry[1]
						+ ", 가격 : " + msgAry[2]);
			} // end of loop
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// 파일을 다 읽어서 더 읽을게 없는 경우 아무 동작없이 그냥 넘어감
			// System.out.println("end of file");
		}
		scn.close();
		System.out.println("end of prog");
	}// end of main
	
	static void read() {
		//입력스트림(문자)
		try {
//			Reader reader = new FileReader("c:/temp/data.txt");
			Reader reader = new FileReader("D:/Dev/git/hello_world/HelloWorld/src/com/yedam/io/StreamExe.java");
			while (true) {
				int data = reader.read();
				if(data == -1) { // if end of file
					break;
				}
				//System.out.println((char)data); //형변환 안하면 해당하는 코드값이 나옴
				System.out.print((char)data);
			} // end of loop
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	} // end of read()
	
	static void write() {
		try {
			Writer writer = new FileWriter("c:/temp/data.txt");
			writer.write('a');
			writer.write('b');
			writer.write('c');
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	} // end of write()
	
	static void write2() {
		Scanner scn = new Scanner(System.in);
		// 입력값을 파일출력
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			while(true) {
				System.out.print("입력>> ");
				String msg = scn.nextLine();
				if (msg.equals("quit"))
					break;
				writer.write(msg + "\n"); //"공백" 넣어서 저장
				writer.flush();
			} // end of loop
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scn.close();
		System.out.println("end of prog");
	} // end of write()
} //end of CharacterExe


