package configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {

    private static Properties propFileContent;
    public static void loadConfigurations() throws IOException{
        InputStream inputStream = null;
        Properties prop = new Properties();

        try {
            File initialFile = new File("config.properties");
            inputStream = new FileInputStream(initialFile);
            prop.load(inputStream);
        }catch (Exception e){
            System.out.println("Exception"+e);
        }finally {
            inputStream.close();
            propFileContent = prop;
        }
    }
    public static String readUserName(){
        return propFileContent.getProperty("username");
    }
    public static String readPass(){
        return propFileContent.getProperty("pass");
    }
    public static String readBaseUrl(){
        return propFileContent.getProperty("baseUrl");
    }
    public static String readFilesDirectory(){
        return propFileContent.getProperty("filesDirectory");
    }
    public static String readScreenshotDirectory() {
        return propFileContent.getProperty("screenshotDirectory");
    }
    public static String readBrowserType() {
        return propFileContent.getProperty("browserType");
    }
}
