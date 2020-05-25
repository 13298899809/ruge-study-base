package proxy.jdkDynamicProxy;

import java.lang.reflect.Proxy;

public class JDK8ProxyFactory {

    public Object getProxyInstance(Object target) {
        /*
         * ClassLoader loader,   原始对象--指定当前目标对象使用的类加载器,获取类加载器的方法
         * Class<?>[] interfaces,额外功能--目标对象实现的接口类型,使用泛型的方式确认类型
         * InvocationHandler h   代理对象和原始对象实现相同的接口--事件处理 执行目标对象的方法时会去触发时间处理器的方法,会把
         *                       当前执行的目标对象方法作为参数
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                /*
                 * proxy 代理对象
                 * method 额外功能所增加给的原始方法
                 * args
                 */
                (proxy, method, args) -> {
                    Object result;
                    if (method.getName().equals("teach")) {
                        System.out.println("jdk8 open transaction");
                        result = method.invoke(target, args);
                        System.out.println("jdk8 close transaction");
                    } else {
                        result = method.invoke(target, args);
                    }
                    return result;
                });
    }
}
