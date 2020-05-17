package factory.simpleFactory;


import org.junit.Test;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName UserController
 * @date 2020.05.11 13:25
 */
public class UserController {
    @Test
    public void register() {
        UserService userService = BeanFactiry.getUserService();
        userService.register();
    }
}
