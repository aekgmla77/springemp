package com.company.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamTest {
	public static void main(String[] args) throws Exception {
/*		
 * 		// 파일 읽기
		FileReader fr = new FileReader("D:\\temp\\sample.txt");
		int c;
		while( (c = fr.read()) != -1) {
			System.out.println((char)c);
		}
		fr.close();
*/
		// 파일 내용 복사해서 새 텍스트 파일 생성
//		BufferedReader br = new BufferedReader(new FileReader("D:\\temp\\sample.txt"));
//		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\temp\\sample2.txt"));
//		String line;
//		while(true) {
//			line = br.readLine();
//			if(line == null) 
//				break;
//			bw.write(line+"\n");
//		}
//		br.close();
//		bw.close();
		
		
		//image 복사
		BufferedInputStream br = new BufferedInputStream(new FileInputStream("D:\\temp\\5.jpg"));
		BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("D:\\temp\\5-1.jpg"));
		int cnt;
		byte[] b = new byte[100];
		while(true) {
			cnt = br.read(b);
			if(cnt == -1) 
				break;
			bw.write(b);
		}
		br.close();
		bw.close();
	}

}
