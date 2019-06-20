package com.update;

/**
 * @author : liupu
 * date   : 2019/6/20
 * desc   :
 */
public class User {
    private Integer id;
    private String name;

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

    private static void sing() {
        System.out.println("sing");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
