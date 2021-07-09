package com.nilakshi.simplilearn.filemanager;

import java.io.File;
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
	public void addFile(String file) {
				
	}

	@Override
	public void deleteFile(String file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean searchFile(String file) {
		// TODO Auto-generated method stub
		return false;
	}

}
