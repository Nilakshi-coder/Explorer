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
		List<String> currentDirFiles = Stream.of(currentDir.listFiles())
				.filter(f -> f.isFile())
					.sorted()
					.map(f->f.getName())
					.collect(Collectors.toList());
		return currentDirFiles;
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
		List<String> sortedFiles = list();
		
		return binarySearch(sortedFiles, fileName);
	}
	
	private boolean binarySearch(List<String> fileList, String fileName) {
		int start=0, end=fileList.size()-1;
		
		while(start<=end) {
			System.out.println("StartExploring: "+start+" End: "+end);

			int mid = (start+end)/2;
			
			System.out.println(fileList.get(mid));
			System.out.println(fileList.get(mid).toLowerCase().compareTo(fileName.toLowerCase()));
			System.out.println(fileName);
			System.out.println();

			if(fileList.get(mid).equals(fileName)) {
				return true;
			}else if(fileList.get(mid).equalsIgnoreCase(fileName)) {
				return false;
			}
			
			if(fileList.get(mid).toLowerCase().compareTo(fileName.toLowerCase())<0) {
				start = mid + 1;
			}
			
			if(fileList.get(mid).toLowerCase().compareTo(fileName.toLowerCase())>0) {
				end = mid -1;
			}
		}
		
		return false;
	}
}
