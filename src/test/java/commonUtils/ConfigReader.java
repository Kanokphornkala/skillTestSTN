package commonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static String filePath = "src/test/resources/properties/configuration.properties";

    public static String readProperty(String property){
        Properties prop = null;

        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInput);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e1){
            e1.printStackTrace();
        }

        return prop.getProperty(property);
    }
}
