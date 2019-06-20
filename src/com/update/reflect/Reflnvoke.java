package com.update.reflect;

import java.lang.reflect.Constructor;

/**
 * @author : liupu
 * date   : 2019/6/19
 * desc   :
 */
public class Reflnvoke {

    /**
     * 反射一个构造函数并调用
     */
    public static Object createObject(String className,
                                      Class[] pareTyples,
                                      Object[] pareValues) {
        try {
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getDeclaredConstructor(pareTyples);
            constructor.setAccessible(true);
            return constructor.newInstance(pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
