package com.joe.reflect;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.junit.Test;

/**@author Joe*/
public class FieldTest {

	private String name;
	public int age = 26;
	double sal = 100;
	protected double bons = 20;

    @Test
	public void getFieldsOnlyPublic() {
		Field[] fields = FieldTest.class.getFields();
		System.out.println(Arrays.toString(fields));
	}
 
	@Test
	public void getFields() {
		Field[] fields = FieldTest.class.getDeclaredFields();
		System.out.println(Arrays.toString(fields));
	}

    @Test
	public void getFieldOnlyPublic() throws NoSuchFieldException, SecurityException {
		System.out.println(FieldTest.class.getField("age"));
	}

	@Test
	public void getField() throws NoSuchFieldException, SecurityException {
		System.out.println(FieldTest.class.getDeclaredField("age"));
		System.out.println(FieldTest.class.getDeclaredField("name"));
		System.out.println(FieldTest.class.getDeclaredField("sal"));
		System.out.println(FieldTest.class.getDeclaredField("bons"));
	}

	@Test
	public void usePublicField() throws Exception {
		Object instance01 = FieldTest.class.getDeclaredConstructor().newInstance();
		Object instance02 = FieldTest.class.getDeclaredConstructor().newInstance();

		// 属性对象.setInt(实例,值)：往哪个实例的对应属性中设置值
		Field ageField = FieldTest.class.getField("age");
		// p1：实例：instance01 往哪个实例中的age中赋值
		// p2：真正赋值
		// obj.set(值)
		// 属性对象.setInt(obj,值)
		ageField.setInt(instance01, 25);
		ageField.setInt(instance02, 26);

		// 属性对象.getInt(实例)：从哪个实例中取出对应属性的值
		System.out.println(ageField.get(instance01));
		System.out.println(ageField.get(instance02));
	}

	@Test
	public void useField() throws Exception {
		Object instance01 = FieldTest.class.getDeclaredConstructor().newInstance();
		Object instance02 = FieldTest.class.getDeclaredConstructor().newInstance();

		Field nameField = FieldTest.class.getDeclaredField("name");
		nameField.setAccessible(true);

		nameField.set(instance01, "赵四");
		nameField.set(instance02, "刘能");
		System.out.println(nameField.get(instance01));
		System.out.println(nameField.get(instance02));
	}


}