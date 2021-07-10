package com.nilakshi.simplilearn.filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperations implements FileSystem{

	private File currentDir = null;
	
	protected FileOperations(String filePath) {
		this.currentDir = new File(filePath);
	}

	@Override
	public List<String> list() {
		String[] files = currentDir.list();
		List<String> sortedFiles = Stream.of(files).sorted(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		}).collect(Collectors.toList());
		return sortedFiles;
	}

	@Override
	public boolean addFile(String fileName) {
		File file = null;
		try {
			file = new File(fileName);
			return file.createNewFile();			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteFile(String fileName) {
		File file = null;
		try {
			file = new File(fileName);
			if(Files.exists(Paths.get(fileName))) {
				return file.delete();		
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean searchFile(String fileName){
		List<String> currentDirFiles = list();
		// Implement Binary Search for efficiency
		
		for(String file: currentDirFiles) {
			if(file.equals(fileName))
				return true;
		}
		return false;
	}
}
