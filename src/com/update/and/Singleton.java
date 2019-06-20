package com.update.and;

/**
 * @author : liupu.
 * date : 2019/06/20
 * desc :
 */
public abstract class Singleton<T> {
    private T instance;

    protected abstract T create();

    public final T get() {
        if (null == instance) {
            synchronized (this) {
                if (null == instance) {
                    instance = create();
                }
            }
        }
        return instance;
    }
}
