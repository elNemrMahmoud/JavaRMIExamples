package projects.EmployeeRMI.server.dao;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil {
    public enum DBProperties {
        USERNAME("DBUSER"),
        PASSWORD("DBPASS"),
        URL("DBURL");

        private final String value;

        DBProperties(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }


    public static Properties getPropertiesFromFile() {

        Properties props = new Properties();
        String currentDirectory = System.getProperty("user.dir");
        String outputPath = currentDirectory + "/src/main/resources/DBprop.properties";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(outputPath);
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Close file input stream in finally clause
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;

    }

}


