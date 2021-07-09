package com.nilakshi.simplilearn.filemanager;

import java.util.logging.Logger;

import com.nilakshi.simplilearn.config.ProjectConfig;

public class FileManager {
	
	String filename = System.getProperty("user.dir");
	private Logger logger = Logger.getLogger(FileManager.class.getName());
	
	public FileManager() {
		//ProjectConfig.getInstance();
		logger.info("Current Working Directory: "+filename);
	}
}
