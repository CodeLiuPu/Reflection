package com.update.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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

    /**
     * 调用实例方法
     */
    public static Object invokeInstanceMethod(Object object,
                                              String methodName,
                                              Class[] pareTyples,
                                              Object[] pareValues) {
        if (null == object) {
            return null;
        }

        try {
            Method method = object.getClass().getDeclaredMethod(methodName, pareTyples);
            method.setAccessible(true);
            return method.invoke(object, pareValues);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用静态方法
     */
    public static Object invokeStaticMethod(String className,
                                            String methodName,
                                            Class[] pareTyples,
                                            Object[] pareValues) {
        try {
            Class clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName, pareTyples);
            method.setAccessible(true);
            return method.invoke(null, pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取一个字段的值
     */
    public static Object getFieldObject(String className,
                                        Object object,
                                        String fieldName) {
        try {
            Class clazz = Class.forName(className);
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置一个字段的值
     */
    public static void setFieldObject(String className,
                                      Object object,
                                      String fieldName,
                                      String fieldValue) {
        try {
            Class clazz = Class.forName(className);
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
