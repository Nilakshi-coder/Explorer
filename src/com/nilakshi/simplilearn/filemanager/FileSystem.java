package com.nilakshi.simplilearn.filemanager;

import java.nio.file.Path;
import java.util.List;

public interface FileSystem {
	
	public List<String> list();
	
	public boolean addFile(String file);
	
	public boolean deleteFile(String file);
	
	public boolean searchFile(String file);
}
