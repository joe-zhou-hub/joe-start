package com.joe.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Joe
 */
public class MethodTest {

    public static void fun01(String str, int a) {
        System.out.println("I am fun01..." + str + a);
    }

    private static void fun02() {
        System.out.println("I am fun02...");
    }

    @Test
    public void getMethodsOnlyPublic() {
        // 包括继承下来的public方法
        Method[] methods = MethodTest.class.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    @Test
    public void getMethods() {
        // 忽略继承下来的方法
        Method[] declaredMethods = MethodTest.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    @Test
    public void getMethodOnlyPublic() throws NoSuchMethodException, SecurityException {
        System.out.println(MethodTest.class.getMethod("fun01", String.class, int.class));
    }

    @Test
    public void getMethod() throws NoSuchMethodException, SecurityException {
        System.out.println(MethodTest.class.getDeclaredMethod("fun02"));
    }

	@Test
	public void usePublicMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Object instance01 = MethodTest.class.getConstructor().newInstance();
		Method fun01 = MethodTest.class.getMethod("fun01", String.class, int.class);
		// 回调
		// 方法对象.invoke(实例,参数)：调用哪个实例中的这个方法，并传入对应参数
		fun01.invoke(instance01, "赵四", 58);
	}

	@Test
	public void useMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Object instance01 = MethodTest.class.getConstructor().newInstance();
		Method fun02 = MethodTest.class.getDeclaredMethod("fun02");
		fun02.setAccessible(true);
		fun02.invoke(instance01);
	}

}