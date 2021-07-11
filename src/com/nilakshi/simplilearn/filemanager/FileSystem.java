package com.nilakshi.simplilearn.filemanager;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileSystem {
	
	public List<String> list();
	
	public boolean addFile(String file);
	
	public boolean deleteFile(String file) throws FileNotFoundException;
	
	public boolean searchFile(String file);
}
