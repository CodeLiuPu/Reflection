package com.update;

/**
 * @author : liupu
 * date   : 2019/6/20
 * desc   :
 */
public class User {
    public Integer id;
    public String name;

    public User() {
        this(-1, "default");
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
