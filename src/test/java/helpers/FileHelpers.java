package helpers;

import configurations.Configurations;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.module.Configuration;
import java.nio.file.Path;
import java.time.Instant;

public class FileHelpers {
    public static void takeScreenshot(WebDriver driver, ITestResult result) throws IOException{
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String testName = result.getMethod().getMethodName();
        long timestamp = Instant.now().getEpochSecond();
        FileUtils.copyFile(file,new File(Configurations.readScreenshotDirectory()+testName+"_"+timestamp+".png"));
    }
    public static void cleanUpDirectory() throws IOException{
        Path path = Path.of(Configurations.readScreenshotDirectory());
        FileUtils.cleanDirectory(path.toFile());
    }
}
