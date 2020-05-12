package factory.ReflectionFactiry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName BeanFactiry
 * @date 2020.05.11 13:30
 */
public class BeanFactiry {
    private static Properties properties = new Properties();

    static {
        // 1 获取io流
        try {
            FileReader reader = new FileReader("src/main/resources/application.properties");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //properties.load();
        //
    }

    /**
     * 对象的创建
     * 1 直接调用 UserService userService = new UserServiceImpl();
     * 2 反射
     */
    public static UserService getUserService() {
        UserService userService = null;
        try {

            Class<?> aClass = Class.forName("factory.ReflectionFactiry.UserServiceImpl");
            userService = (UserService) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userService;
    }
}
