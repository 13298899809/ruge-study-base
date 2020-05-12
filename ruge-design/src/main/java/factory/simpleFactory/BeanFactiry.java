package factory.simpleFactory;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName BeanFactiry
 * @date 2020.05.11 13:30
 */
public class BeanFactiry {
    public static UserService getUserService() {
        return new UserServiceImpl();
    }
}
