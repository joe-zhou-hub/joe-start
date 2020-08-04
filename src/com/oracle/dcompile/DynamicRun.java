package com.oracle.dcompile;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicRun {
    public static void main(String[] args) throws Exception {

        URL url = new URL("file:/E:/");

        // 类加载器：把加载到内存中
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});

        // 加载类名
        // 未知泛型
        Class<?> loadClass = urlClassLoader.loadClass("HelloWorld");

        // 获取方法：main方法
        // p1：调用的方法的名字
        // p2：当你调用这个方法的时候传进来的参数类型
        Method method = loadClass.getMethod("main", String[].class);

        // invoke 是真正的在调用这个方法
        // 这里必须强转成Object类型，否则String[]数组参数会被拆成"a"和"b",与main方法的参数个数不符合
        method.invoke(null, (Object) new String[]{"a", "b"});

        // 节省资源
        urlClassLoader.close();

    }
}