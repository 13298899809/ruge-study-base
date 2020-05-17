package factory.ReflectionFactiry;


import java.io.*;
import java.util.Properties;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName BeanFactiry
 * @date 2020.05.11 13:30
 */
public class BeanFactiry {
    public static final Properties properties = new Properties();

    static {
        InputStream inputStream = BeanFactiry.class.getResourceAsStream("/application.propreties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static UserService getUserService() {
        return new UserServiceImpl();
    }

    public static Object getUserBean(String key) {
        return properties.get(key);
    }
}
