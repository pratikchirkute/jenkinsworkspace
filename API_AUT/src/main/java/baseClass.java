import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class baseClass {

    public String getProperty(String propertyName) throws IOException {
        String propValue = null;
        String rootDirectory=System.getProperty("user.dir");
        String resourceDirectory=rootDirectory+"/src/test/resources/api";

        File folder = new File(resourceDirectory);
        File[] listOfFiles = folder.listFiles();

        Properties properties = new Properties();
        for (int i = 0; i < listOfFiles.length; i++) {
            properties.load(new FileInputStream(listOfFiles[i]));
            properties.load(new FileInputStream(listOfFiles[i]));
        }
        propValue = properties.getProperty(propertyName);
        return propValue;

    }
}
