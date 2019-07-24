package com.prac.angular.file;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileNameTest {
//	@Test
//	public void test() {
//		File file = null;
//		BufferedReader br = null;
//		StringBuffer sb = new StringBuffer();
//		List<String> contentsList = new ArrayList<>(); 
//		List<String> fileNmList = new ArrayList<>();
//		String path = "C:\\cams\\";
//		file = new File(path);
//		List<File> fileList = searchDir(file);
//		
//		//파일 내용을 스트링으로 저장
//		for(File data : fileList) {
//			try {
//				String content = FileCopyUtils.copyToString(new FileReader(data));
//				contentsList.add(content);
//				
//				String name = data.getName();
//				fileNmList.add(name);
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		file = new File(path+"\\parkTest");
//		file.mkdir();
//		
//		writeNewDir(contentsList, fileNmList, file);
//		
//		
//	}
//	
//	public void writeNewDir(List<String> contentsList, List<String> fileNmList, File file) {
//		String filePath = file.getPath();
//		BufferedWriter bw = null;
//		for(int i=0; contentsList.size()>i; i++) {
//			String path = filePath+"\\JSTEST+"+fileNmList.get(i);
//			System.out.println("path 확인: "+path);
//			
//			try {
//				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
//				bw.write(contentsList.get(i));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					if(bw != null) {
//						bw.close();
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//				
//		
//	}
//
//	//path 내의 file 만 리스트로 반환
//	public List<File> searchDir(File file){
//		File[] list = file.listFiles();
//		List<Object> ls = Arrays.asList(list);
//		List<File> fileList = new ArrayList<>();
//		for(Object data : ls) {
//			File temp = (File) data;
//			if(!temp.isDirectory()) {
//				fileList.add(temp);
//			}			
//		}		
//		System.out.println("fileList 확인: "+fileList);
//		return fileList;
//	}
}
