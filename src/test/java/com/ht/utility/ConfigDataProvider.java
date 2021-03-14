package com.ht.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		File  src = new File("./Config/config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
		} 
		catch (Exception e) {

			System.out.println("Unable to read Config File "+ e.getMessage());
		}

	}

	public String getDataFromConfig(String keyToSearch) {

		return pro.getProperty(keyToSearch)
				;
	}

	public String getBrowser() {
		return pro.getProperty("browser");

	}

	public String getUrl() {
		return pro.getProperty("url");

	}



}
