package base;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class loader {
	public static String loadProperty(String propertyName) throws IOException {

        InputStream inputStream = new FileInputStream("src/test/resources/Config/config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.getProperty(propertyName);
    }
}
