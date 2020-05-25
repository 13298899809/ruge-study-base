package proxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDK7ProxyFactory {

    /**
     * 1 维护一个目标对象
     * 2 给目标对象 生成一个代理对象
     */
    public Object getProxyInstance(Object target) {
        /*
         * ClassLoader loader,   指定当前目标对象使用的类加载器,获取类加载器的方法
         * Class<?>[] interfaces,目标对象实现的接口类型,使用泛型的方式确认类型
         * InvocationHandler h   事件处理 执行目标对象的方法时会去触发时间处理器的方法,会把
         *                       当前执行的目标对象方法作为参数
         */
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("jdk7代理开始.......");
                        Object returnVal = method.invoke(target, args);
                        System.out.println("jdk7代理提交.......");
                        return returnVal;
                    }
                });
        return proxyInstance;
    }
}
