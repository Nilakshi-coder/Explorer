package com.nilakshi.simplilearn.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class ProjectConfig {
	private Logger logger = Logger.getLogger(ProjectConfig.class.getName());
	private static ProjectConfig instance = null;
	private String configPath="./config/ProjectConfig.properties";
	private String rootDirectory="";
	private Properties prop;
	
	private ProjectConfig(){	
		BufferedReader reader=null;
		prop = null;
		try {
			 reader = new BufferedReader(new FileReader(configPath));
			 prop.load(reader);
			 
			 logger.info("Started reading ProjectConfig file");
			 
			 if(prop.containsKey("RootDirectory")) {
				 rootDirectory = prop.getProperty("RootDirectory").trim();
				 
				 /* If specified directory is not present, then current directory will be selected as root directory*/
				 if(!Files.exists(Paths.get(rootDirectory))) {
					 rootDirectory = System.getProperty("user.dir");
				 }
			 }else {
				 rootDirectory = System.getProperty("user.dir");
			 }
			 
		}catch(Exception e) {
			logger.warning("Error while reading ProjectConfig file");
			e.printStackTrace();
		}finally {
			prop.clear();
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.warning("Error caused while closing PropertyReader");
				}
			}
		}
	}
	
	public static ProjectConfig getInstance() {
		if(instance==null)
			instance = new ProjectConfig();
		return instance;
	}
	
	public String getRootDirectory() {
		return rootDirectory;
	}

}
