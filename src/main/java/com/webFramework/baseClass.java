package com.webFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class baseClass {

    public String getProperty(String propertyName) throws IOException {
        String propValue = null;
        String rootDirectory=System.getProperty("user.dir");
        String resourceDirectory=rootDirectory+"/src/test/resources/webUI";

        File folder = new File(resourceDirectory);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

        Properties properties = new Properties();
        for (int i = 0; i < listOfFiles.length; i++) {
            properties.load(new FileInputStream(listOfFiles[i]));
            properties.load(new FileInputStream(listOfFiles[i]));
        }
//        properties.load(new FileInputStream(resourceDirectory));
        propValue = properties.getProperty(propertyName);
        return propValue;

    }
}
