package com.oracle.dcompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class DynamicCompile {
    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "E:\\HelloWorld.java");
        System.out.println(result);
    }


}
