package com.nilakshi.simplilearn.filemanager;

import java.nio.file.Path;
import java.util.List;

public interface FileSystem {
	
	public List<String> list();
	
	public void addFile(String file);
	
	public void deleteFile(String file);
	
	public void searchFile(String file);
}
