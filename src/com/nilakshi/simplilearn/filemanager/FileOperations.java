package com.nilakshi.simplilearn.filemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileOperations {

	public static void main(String[] args) {
		try {
			Stream<Path> pathnames = Files.list(Paths.get("D:\\PlayGround\\Eclipse_Java_Projects\\Explorer\\root"));
			
			pathnames.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
