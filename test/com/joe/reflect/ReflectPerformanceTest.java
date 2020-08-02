package com.joe.reflect;
import java.lang.reflect.Method;
import org.junit.Test;

/**
 * @author Joe
 */
public class ReflectPerformanceTest {

    private Long testTimes = 1000000000L;

    @Test
    public void normalPerformance() {
        User user = new User();
        for (int i = 0; i < testTimes; i++) {
            user.hello();
        }
        System.out.println("普通方法调用完毕...");
    }

    @Test
    public void reflectPerformance() throws Exception {
        User user = new User();
        Method method = user.getClass().getDeclaredMethod("hello");
        for (int i = 0; i < testTimes; i++) {
            method.invoke(user);
        }
        System.out.println("没开启setAccessible方法的反射调用完毕...");
    }

    @Test
    public void reflectWithAccessPerformance() throws Exception {
        User user = new User();
        Method method = user.getClass().getDeclaredMethod("hello");
        method.setAccessible(true);
        for (int i = 0; i < testTimes; i++) {
            method.invoke(user);
        }
        System.out.println("开启了setAccessible方法的反射调用完毕...");
    }
}

class User {
    private int age;

    public void hello() {
        age++;
    }
}