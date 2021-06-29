package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
public  static Properties pro;

public static Properties getProperties() throws IOException {
File prosFile=new File(".\\Environment\\environment.properties");

    FileInputStream fis = new FileInputStream(prosFile);

            pro=new Properties();

    pro.load(fis);

    fis.close();
    return pro;

}

public static String getProperty(String key) throws IOException {
return getProperties().getProperty(key);
}
}
