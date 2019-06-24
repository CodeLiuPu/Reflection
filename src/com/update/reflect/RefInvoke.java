package com.update.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : liupu
 * date   : 2019/6/19
 * desc   :
 */
public class RefInvoke {

    /**
     * 反射构造函数并调用 无参
     */
    public static Object createObject(String className) {
        Class[] c = {};
        Object[] v = {};
        return createObject(className, c, v);
    }

    /**
     * 反射构造函数并调用 无参
     */
    public static Object createObject(Class clazz) {
        Class[] c = {};
        Object[] v = {};
        return createObject(clazz, c, v);
    }


    /**
     * 反射构造函数并调用 一个参数
     */
    public static Object createObject(String className,
                                      Class pareType,
                                      Object pareValue) {
        try {
            Class clazz = Class.forName(className);
            return createObject(clazz, pareType, pareValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反射构造函数并调用 一个参数
     */
    public static Object createObject(Class clazz,
                                      Class pareType,
                                      Object pareValue) {
        Class[] pareTypes = new Class[]{pareType};
        Object[] pareValues = new Object[]{pareValue};
        return createObject(clazz, pareTypes, pareValues);
    }

    /**
     * 反射构造函数并调用 多个参数
     */
    public static Object createObject(String className,
                                      Class[] pareTypes,
                                      Object[] pareValues) {
        try {
            Class clazz = Class.forName(className);
            return createObject(clazz, pareTypes, pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反射构造函数并调用 多个参数
     */
    public static Object createObject(Class clazz,
                                      Class[] pareTypes,
                                      Object[] pareValues) {
        try {
            Constructor constructor = clazz.getDeclaredConstructor(pareTypes);
            constructor.setAccessible(true);
            return constructor.newInstance(pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用实例方法 无参
     */
    public static Object invokeInstanceMethod(Object object,
                                              String methodName) {
        Class[] pareTypes = {};
        Object[] pareValues = {};
        return invokeInstanceMethod(object, methodName, pareTypes, pareValues);
    }

    /**
     * 调用实例方法 一个参数
     */
    public static Object invokeInstanceMethod(Object object,
                                              String methodName,
                                              Class pareType,
                                              Object pareValue) {
        Class[] pareTypes = {pareType};
        Object[] pareValues = {pareValue};
        return invokeInstanceMethod(object, methodName, pareTypes, pareValues);
    }

    /**
     * 调用实例方法 多个参数
     */
    public static Object invokeInstanceMethod(Object object,
                                              String methodName,
                                              Class[] pareTypes,
                                              Object[] pareValues) {
        if (null == object) {
            return null;
        }

        try {
            Method method = object.getClass().getDeclaredMethod(methodName, pareTypes);
            method.setAccessible(true);
            return method.invoke(object, pareValues);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用静态方法 无参
     */
    public static Object invokeStaticMethod(String className,
                                            String methodName) {
        Class[] pareTypes = {};
        Object[] pareValues = {};
        return invokeStaticMethod(className, methodName, pareTypes, pareValues);
    }

    /**
     * 调用静态方法 一个参数
     */
    public static Object invokeStaticMethod(String className,
                                            String methodName,
                                            Class pareType,
                                            Object pareValue) {
        Class[] pareTypes = {pareType};
        Object[] pareValues = {pareValue};
        return invokeStaticMethod(className, methodName, pareTypes, pareValues);
    }

    /**
     * 调用静态方法 多个参数
     */
    public static Object invokeStaticMethod(String className,
                                            String methodName,
                                            Class[] pareTypes,
                                            Object[] pareValues) {
        try {
            Class clazz = Class.forName(className);
            return invokeStaticMethod(clazz, methodName, pareTypes, pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用静态方法 无参
     */
    public static Object invokeStaticMethod(Class clazz,
                                            String methodName) {
        Class[] pareTypes = {};
        Object[] pareValues = {};
        return invokeStaticMethod(clazz, methodName, pareTypes, pareValues);
    }

    /**
     * 调用静态方法 一个参数
     */
    public static Object invokeStaticMethod(Class clazz,
                                            String methodName,
                                            Class pareType,
                                            Object pareValue) {
        Class[] pareTypes = {pareType};
        Object[] pareValues = {pareValue};
        return invokeStaticMethod(clazz, methodName, pareTypes, pareValues);
    }

    /**
     * 调用静态方法 多个参数
     */
    public static Object invokeStaticMethod(Class clazz,
                                            String methodName,
                                            Class[] pareTypes,
                                            Object[] pareValues) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, pareTypes);
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
    public static Object getFieldObject(Object object,
                                        String fieldName) {
        return getFieldObject(object.getClass(), object, fieldName);
    }

    /**
     * 获取一个字段的值
     */
    public static Object getFieldObject(String className,
                                        Object object,
                                        String fieldName) {
        try {
            Class clazz = Class.forName(className);
            return getFieldObject(clazz, object, fieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取一个字段的值
     */
    public static Object getFieldObject(Class clazz,
                                        Object object,
                                        String fieldName) {
        try {
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
    public static void setFieldObject(Object object,
                                      String fieldName,
                                      Object fieldValue) {
        setFieldObject(object.getClass(), object, fieldName, fieldValue);
    }

    /**
     * 设置一个字段的值
     */
    public static void setFieldObject(String className,
                                      Object object,
                                      String fieldName,
                                      Object fieldValue) {
        try {
            Class clazz = Class.forName(className);
            setFieldObject(clazz, object, fieldName, fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置一个字段的值
     */
    public static void setFieldObject(Class clazz,
                                      Object object,
                                      String fieldName,
                                      Object fieldValue) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个静态字段的值
     */
    public static Object getStaticFieldObject(String className,
                                              String fieldName) {
        return getFieldObject(className, null, fieldName);
    }

    /**
     * 获取一个静态字段的值
     */
    public static Object getStaticFieldObject(Class clazz,
                                              String fieldName) {
        return getFieldObject(clazz, null, fieldName);
    }

    /**
     * 设置一个静态字段的值
     */
    public static void setStaticFieldObject(String className,
                                            String fieldName,
                                            Object fieldValue) {
        setFieldObject(className, null, fieldName, fieldValue);
    }

    /**
     * 设置一个静态字段的值
     */
    public static void setStaticFieldObject(Class clazz,
                                            String fieldName,
                                            Object fieldValue) {
        setFieldObject(clazz, null, fieldName, fieldValue);
    }
}
