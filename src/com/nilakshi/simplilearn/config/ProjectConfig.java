package com.nilakshi.simplilearn.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Logger;

import com.nilakshi.simplilearn.exceptions.PropertyNotFound;

public class ProjectConfig {
	private Logger logger = Logger.getLogger(ProjectConfig.class.getName());
	private static ProjectConfig instance = null;
	private String configPath="./config/ProjectConfig.properties";
	private String rootDirectory="";
	
	private ProjectConfig(){	
		BufferedReader reader=null;
		Properties prop = null;
		try {
			 reader = new BufferedReader(new InputStreamReader(System.in));
			 prop.load(reader);
			 
			 logger.info("Started reading ProjectConfig file");
			 
			 if(prop.containsKey("RootDirectory")) {
				 rootDirectory = prop.getProperty("RootDirectory").trim();
			 }else {
				 throw new PropertyNotFound("RootDirectory");
			 }
			 
		}catch(Exception e) {
			logger.warning("Error while reading ProjectConfig file");
			e.printStackTrace();
		}finally {
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

}
