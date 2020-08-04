package com.joe.innerClass;

public class 内部类 {
	public static void main(String[] args) {
		Outer.Inner inner = new Outer.Inner();// 获取静态内部类
		inner.aMethod();// 用内部类实例访问内部类成员方法
		Outer.Inner.aStaticMethod();// 可以直接使用内部类的名字调用内部类的静态方法
	}
}

class Outer {
	private int field = 1;// 非静态属性
	private static int staticField = 2;// 静态属性

	static class Inner {
		private int field = 3;// 非静态属性
		private static int staticField = 4;// 静态属性

		public void aMethod() {
			System.out.println(field);// 访问自己的非静态属性
			System.out.println(staticField);// 访问自己的静态属性
            // System.out.println(Outer.this.field);// 无法直接访问外部类非静态属性
			System.out.println(new Outer().field);// 间接访问外部类非静态属性
			System.out.println(Outer.staticField);// 访问外部类静态属性
		}

		public static void aStaticMethod() {
			//System.out.println(field);// 静态方法无法访问非静态属性
			System.out.println(staticField);// 访问自己的静态属性
            // System.out.println(Outer.this.field);// 无法直接访问外部类非静态属性
			System.out.println(new Outer().field);// 间接访问外部类非静态属性
			System.out.println(Outer.staticField);// 访问外部类静态属性
		}
	}
}