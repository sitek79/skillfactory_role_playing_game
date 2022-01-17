import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProps {
    public String readProps(String property) {
        Properties prop = new Properties();
        //String fileName = "src/propertiesfile/app2.properties";
        String fileName = "src/app.properties";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            // FileNotFoundException catch is optional and can be collapsed
            System.out.println("Err1");
        } catch (IOException ex) {
            System.out.println("Err2");
        }
        //System.out.println(prop.getProperty("app.name"));
        //System.out.println(prop.getProperty("app.version"));

        return prop.getProperty(property);
    }
}
