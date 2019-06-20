package com.update;

import com.update.reflect.Reflnvoke;

/**
 * @author : liupu
 * date   : 2019/6/20
 * desc   :
 */
public class Test {

    public static void main(String[] args) {
        testCreateObject();
    }

    private static void testCreateObject() {
        String className = User.class.getName();
        Class[] p = {Integer.class, String.class};
        Object[] v = {1, "john"};
        User user = (User) Reflnvoke.createObject(className, p, v);
        System.out.println(user);
    }

}
