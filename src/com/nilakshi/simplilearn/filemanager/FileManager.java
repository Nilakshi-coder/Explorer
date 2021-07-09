package com.nilakshi.simplilearn.filemanager;

public abstract class FileManager{
	
	private static String filename = System.getProperty("user.dir");
	private static FileSystem fileSystem = null;
	
	public static FileSystem getFileOperation() {
		if(fileSystem == null)
			fileSystem = new FileOperations(filename);
		return fileSystem;
	}
}
