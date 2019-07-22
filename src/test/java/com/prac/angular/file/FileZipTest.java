package com.prac.angular.file;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Test;
import org.springframework.util.FileCopyUtils;

public class FileZipTest {
	@Test
	public void test(){
		File file = new File("C:\\cams\\");
		List<File> fileList = Arrays.asList(file.listFiles());
		fileList = fileList.stream().filter(e -> !e.isDirectory()).collect(Collectors.toList());
		List<String> contents = new ArrayList<>();
		List<String> fileNames = new ArrayList<>();
		fileList.forEach(files -> {		
			try {
				contents.add(FileCopyUtils.copyToString(new FileReader(files)));
				fileNames.add(files.getName());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		BufferedWriter bw = null;
		String path = null;
		for(int i=0; contents.size()>i; i++) {
			path = "C:\\cams\\parkTest\\"+fileNames.get(i);
			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
				bw.write(contents.get(i));
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}finally {
				if(bw != null) {
					try {
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		makeZipFile(fileNames);
	}

	private void makeZipFile(List<String> fileNames) {
		ZipOutputStream zip = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		String path = null;
		int maxSize = 1024 *2;
		byte[] buffer = new byte[maxSize];
		
		try {
			zip = new ZipOutputStream(new FileOutputStream("C:\\cams\\parkTest\\result.zip"));
			
			for(String fileName : fileNames) {
				path = "C:\\cams\\parkTest\\"+fileName;
				fis = new FileInputStream(path);
				bis = new BufferedInputStream(fis);
				zip.putNextEntry(new ZipEntry(fileName));
				int length = 0;
				while( (length = bis.read()) > 0) {
					zip.write(buffer, 0, length);
				}
				zip.closeEntry();
				fis.close();
				bis.close();
			}
			zip.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(zip != null || fis != null || bis != null) {
					zip.closeEntry();
					zip.close();
					fis.close();
					bis.close();
				}
			}catch(Exception e) {
				
			}			
		}
	}


}
