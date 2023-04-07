package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public static Properties configProperties;
    public static Properties orProperties;
    public static String url;

    public static Properties readConfigfile() throws IOException {
        configProperties = new Properties();
        FileReader reader = new FileReader(System.getProperty("user.dir")+Constants.configFilePath);
        configProperties.load(reader);
        url = configProperties.getProperty("url");
        return configProperties;
    }
public static Properties readOrPropertiesfile(){
        try{
            orProperties= new Properties();
            FileReader reader = new FileReader(System.getProperty("user.dir")+Constants.orFilePath);
            orProperties.load(reader);
}catch(Exception e){
            System.out.println(e);
        }
        return orProperties;
}}
