package com.joe.ann;

import org.junit.Test;

import java.util.Arrays;

/**
 * 研究自定义注解
 * <p>
 * 1. 自定义注解类
 * <p>
 * 格式: public @interface 注解名{}
 * 要求：
 *
 * @Target 指定注解生效的位置是哪里 (在类上，在方法上)
 * @Retenion 指定注解的声明周期 （整个运行时都有效）
 * <p>
 * 内容：
 * 类型 名字()
 * 如果需要设计默认值，default
 * 数组都是用{}
 * <p>
 * 2. 新建一个类Person 使用一下我们的注解
 * <p>
 * 3. 新建一个测试类，用反射的技术来得到Person类的指定注解
 * <p>
 * 获取Person的类对象
 * getDeclaredAnnotation获取到 注解类对象
 * 从注解类对象中 获取name age 和 course
 */

public class DefaultAnnTest {
    @Test
    public void reflectAnn() throws ClassNotFoundException {
        Class<?> c = Class.forName("com.joe.ann.Person");
        MyAnnotation a = c.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(a.age());
        System.out.println(a.name());
        System.out.println(Arrays.toString(a.course()));

    }
}
