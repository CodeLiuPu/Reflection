package com.update.and;

/**
 * @author : liupu.
 * date : 2019/06/20
 * desc : ActivityManagerNative
 */
public class AMN {
    private static final Singleton<ClassB2Interface> mDefault = new Singleton<ClassB2Interface>() {
        @Override
        protected ClassB2Interface create() {
            ClassB2 classB2 = new ClassB2();
            classB2.id = 3;
            return classB2;
        }
    };

    public static ClassB2Interface getDefault() {
        return mDefault.get();
    }
}
