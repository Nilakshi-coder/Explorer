package com.nilakshi.simplilearn.filemanager;

import com.nilakshi.simplilearn.config.ProjectConfig;

public abstract class FileManager{
	
	private static String filename = ProjectConfig.getInstance().getRootDirectory();
	private static FileSystem fileSystem = null;
	
	public static FileSystem getFileOperation() {
		if(fileSystem == null)
			fileSystem = new FileOperations(filename);
		return fileSystem;
	}
}
