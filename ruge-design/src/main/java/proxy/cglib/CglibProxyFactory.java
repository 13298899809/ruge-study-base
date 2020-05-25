package proxy.cglib;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@AllArgsConstructor
@NoArgsConstructor
public class CglibProxyFactory implements MethodInterceptor {
    private Object target;

    /*
     *
     * @return 返回一个代理对象 是target对象的代理对象
     */
    public Object getProxyInstance() {
        /*
         * 1 创建工具类
         */
        Enhancer enhancer = new Enhancer();
        /*
         * 2 设置父类
         */
        enhancer.setSuperclass(target.getClass());
        /*
         * 3 设置回调函数
         */
        enhancer.setCallback(this);
        /*
         * 4 创建子类对象及代理对象
         */
        Object o = enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib开始....");
        Object return_Val = method.invoke(target, objects);
        System.out.println("cglib提交....");
        return return_Val;
    }
}
