package com.update;

import com.update.reflect.Reflnvoke;

/**
 * @author : liupu
 * date   : 2019/6/20
 * desc   :
 */
public class Test {

    public static void main(String[] args) {
//        testCreateObject();
//        testInvokeInstanceMethod();
//        testInvokeStaticMethod();
        testGetFieldObject();
    }

    private static void testCreateObject() {
        String className = User.class.getName();
        Class[] c = {Integer.class, String.class};
        Object[] v = {1, "john"};
//        User user = (User) Reflnvoke.createObject(className, c, v);
        User user = (User) Reflnvoke.createObject(className, null, null);
        System.out.println(user);
    }

    private static void testInvokeInstanceMethod() {
        User user = new User();
        String methodName = "sayHello";
        Class[] c = {};
        Object[] v = {};

        Reflnvoke.invokeInstanceMethod(user, methodName, c, v);
    }

    private static void testInvokeStaticMethod() {
        String className = User.class.getName();
        String methodName = "sing";
        Class[] c = {};
        Object[] v = {};

        Reflnvoke.invokeStaticMethod(className, methodName, c, v);
    }

    private static void testGetFieldObject() {
        String className = User.class.getName();
        User user = new User();
        String fieldName = "name";
        System.out.println(Reflnvoke.getFieldObject(className,user,fieldName));
    }

}
