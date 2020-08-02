package com.joe.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**@author Joe*/
public class ConstructorTest {

	@Test
    public void getConstructorsOnlyPublic() {
	    // 类对象.getConstructors() 获取这个类中的所有public的构造器
        Constructor<?>[] constructors = Demo01.class.getConstructors();
        for (Constructor<?> e :constructors) {
            System.out.println(e);
        }
        //System.out.println(Arrays.toString(constructors));
    }

    // Declared 声明 宣告
    @Test
    public void getConstructors() {
        Constructor<?>[] constructors = Demo01.class.getDeclaredConstructors();
        for (Constructor<?> e :constructors) {
            System.out.println(e);
        }
    }

    @Test
	public void getConstructorOnlyPublic() throws Exception {
	    // public 无参构造！
		System.out.println(Demo01.class.getConstructor());
		// 用参数来控制到底反射哪一个构造器
		System.out.println(Demo01.class.getConstructor(int.class));
        System.out.println(Demo01.class.getConstructor(String.class,int.class,double.class));
	}

	@Test
	public void getConstructor() throws Exception {
		System.out.println(Demo01.class.getDeclaredConstructor(int.class));
		System.out.println(Demo01.class.getDeclaredConstructor());
		System.out.println(Demo01.class.getDeclaredConstructor(String.class));
		System.out.println(Demo01.class.getDeclaredConstructor(Double.class));
		System.out.println(Demo01.class.getDeclaredConstructor(Float.class));
	}

    @Test
    public void usePublicConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 通过反射的方式获取构造器
        Constructor<?> constructor = Demo01.class.getConstructor(String.class);

        // 通过你获取到的构造器来实例化一个对象：这个过程相当于 new Demo01("")
        // Demo01 demo01 = new Demo01("joe");
        Demo01 demo01 = (Demo01) constructor.newInstance("joe");

        // 使用这个实例
        demo01.sayHello();
    }

    @Test
    public void useConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 通过反射的方式获取构造器
        Constructor<?> constructor = Demo01.class.getDeclaredConstructor(int.class);

        // 开启私有访问权限
        constructor.setAccessible(true);

        // 通过你获取到的构造器来实例化一个对象：这个过程相当于 new Demo01("")
        Demo01 demo01 = (Demo01) constructor.newInstance(28);

        // 使用这个实例
        demo01.sayHello();
    }


}

class Demo01 {
    private Demo01(int a) {
        System.out.println("private Demo01(int a)..." + a);
    }
    public Demo01() {System.out.println("public Demo01()...");}
    public Demo01(String str) {System.out.println("public Demo01(String str)..." + str);}
    Demo01(Double dbl) {System.out.println("Demo01(Double dbl)..." + dbl);}
    protected Demo01(Float flt) {System.out.println("protected Demo01(Float flt)..." + flt);}
    
    public void sayHello() {
        System.out.println("hello!");
    }
}