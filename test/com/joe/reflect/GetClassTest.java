package com.joe.reflect;

import org.junit.Test;
/**
 *         1. 实例.getClass()
 *         2. 类名.class
 *         3. Class.forName("类全名");   要抛异常
 * */
/**@author Joe*/
public class GetClassTest {


	@Test
	public void getClass01() {
		// A a = new A(); getClassTest是一个实例
		GetClassTest getClassTest = new GetClassTest();
		// 方法一：通过实例来获取类对象.getClass()
		Class<?> class01 = getClassTest.getClass();
		Class<?> class02 = getClassTest.getClass();
        System.out.println(class01.hashCode() + " : " + class02.hashCode());
	}


	@Test
	public void getClass02() {
		// 方法二： 用类名.class就可以了
		Class<?> class01 = GetClassTest.class;
		Class<?> class02 = GetClassTest.class;
        System.out.println(class01.hashCode() + " : " + class02.hashCode());
	}

	@Test
	public void getClass03() throws ClassNotFoundException {
		// 类全名（完全限定名）：包名+类名
        String qualifiedName = "com.joe.reflect.GetClassTest";
        // JDBC
		// 就是加载这个类
		Class<?> class01 = Class.forName(qualifiedName);
		Class<?> class02 = Class.forName(qualifiedName);
		System.out.println(class01.hashCode() + " : " + class02.hashCode());
	}
}